/**
 *                            License
 * THE WORK (AS DEFINED BELOW) IS PROVIDED UNDER THE TERMS OF THIS  
 * CREATIVE COMMONS PUBLIC LICENSE ("CCPL" OR "LICENSE"). 
 * THE WORK IS PROTECTED BY COPYRIGHT AND/OR OTHER APPLICABLE LAW.  
 * ANY USE OF THE WORK OTHER THAN AS AUTHORIZED UNDER THIS LICENSE OR  
 * COPYRIGHT LAW IS PROHIBITED.
 * 
 * BY EXERCISING ANY RIGHTS TO THE WORK PROVIDED HERE, YOU ACCEPT AND  
 * AGREE TO BE BOUND BY THE TERMS OF THIS LICENSE. TO THE EXTENT THIS LICENSE  
 * MAY BE CONSIDERED TO BE A CONTRACT, THE LICENSOR GRANTS YOU THE RIGHTS CONTAINED 
 * HERE IN CONSIDERATION OF YOUR ACCEPTANCE OF SUCH TERMS AND CONDITIONS.
 * 
 */
package l1j.server.server.clientpackets;

import l1j.server.server.ClientThread;
import l1j.server.server.datatables.PetItemTable;
import l1j.server.server.datatables.PetTable;
import l1j.server.server.datatables.PetTypeTable;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1PcInventory;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1DollInstance;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.model.Instance.L1SummonInstance;
import l1j.server.server.serverpackets.S_ItemName;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Npc;
import l1j.server.server.templates.L1Pet;
import l1j.server.server.templates.L1PetItem;
import l1j.server.server.templates.L1PetType;
import l1j.server.server.utils.Random;

/**
 * 处理收到由客户端传来给道具的封包
 */
public class C_GiveItem extends ClientBasePacket {
	private static final String C_GIVE_ITEM = "[C] C_GiveItem";

	private final static String receivableImpls[] = new String[] { "L1Npc", // NPC
			"L1Monster", // 怪物
			"L1Guardian", // 妖精森林的守护者
			"L1Teleporter", // 传送师
			"L1Guard" }; // 警卫

	public C_GiveItem(final byte decrypt[], final ClientThread client) {
		super(decrypt);
		final int targetId = this.readD();
		this.readH();
		this.readH();
		final int itemId = this.readD();
		final int count = this.readD();

		final L1PcInstance pc = client.getActiveChar();
		if (pc.isGhost()) {
			return;
		}

		final L1Object object = L1World.getInstance().findObject(targetId);
		if ((object == null) || !(object instanceof L1NpcInstance)) {
			return;
		}
		final L1NpcInstance target = (L1NpcInstance) object;
		if (!this.isNpcItemReceivable(target.getNpcTemplate())) {
			return;
		}
		final L1Inventory targetInv = target.getInventory();

		final L1Inventory inv = pc.getInventory();
		L1ItemInstance item = inv.getItem(itemId);
		if (item == null) {
			return;
		}
		// 已经装备中的道具
		if (item.isEquipped()) {
			pc.sendPackets(new S_ServerMessage(141)); // \f1你不能够将转移已经装备的物品。
			return;
		}
		if (!item.getItem().isTradable()) {
			pc.sendPackets(new S_ServerMessage(210, item.getItem().getName())); // \f1%0%d是不可转移的…
			return;
		}
		// 封印的装备
		if (item.getBless() >= 128) {
			// \f1%0%d是不可转移的…
			pc.sendPackets(new S_ServerMessage(210, item.getItem().getName()));
			return;
		}
		// 使用中的宠物项链 - 无法给予
		for (final L1NpcInstance petNpc : pc.getPetList().values()) {
			if (petNpc instanceof L1PetInstance) {
				final L1PetInstance pet = (L1PetInstance) petNpc;
				if (item.getId() == pet.getItemObjId()) {
					pc.sendPackets(new S_ServerMessage(1187)); // 宠物项链正在使用中。
					return;
				}
			}
		}
		// 使用中的魔法娃娃 - 无法给予
		for (final L1DollInstance doll : pc.getDollList().values()) {
			if (doll.getItemObjId() == item.getId()) {
				pc.sendPackets(new S_ServerMessage(1181)); // 这个魔法娃娃目前正在使用中。
				return;
			}
		}
		if (targetInv.checkAddItem(item, count) != L1Inventory.OK) {
			pc.sendPackets(new S_ServerMessage(942)); // 对方的负重太重，无法再给予。
			return;
		}
		item = inv.tradeItem(item, count, targetInv);
		target.onGetItem(item);
		target.turnOnOffLight();
		pc.turnOnOffLight();

		final L1PetType petType = PetTypeTable.getInstance().get(target.getNpcTemplate().get_npcId());
		if ((petType == null) || target.isDead()) {
			return;
		}

		// 捕抓宠物
		if (item.getItemId() == petType.getItemIdForTaming()) {
			this.tamePet(pc, target);
		}
		// 进化宠物
		else if (item.getItemId() == petType.getEvolvItemId()) {
			this.evolvePet(pc, target, item.getItemId());
		}

		if (item.getItem().getType2() == 0) { // 道具类
			// 食物类
			if (item.getItem().getType() == 7) {
				this.eatFood(pc, target, item, count);
			}
			// 宠物装备类
			else if ((item.getItem().getType() == 11) && (petType.canUseEquipment())) { // 判断是否可用宠物装备
				this.usePetWeaponArmor(target, item);
			}
		}

	}

	@Override
	public String getType() {
		return C_GIVE_ITEM;
	}

	/** 吃食物 */
	private void eatFood(final L1PcInstance pc, final L1NpcInstance target, final L1ItemInstance item, final int count) {

		if (!(target instanceof L1PetInstance)) {
			return;
		}
		final L1PetInstance pet = (L1PetInstance) target;
		final L1Pet _l1pet = PetTable.getInstance().getTemplate(item.getId());
		int food = 0;
		int foodCount = 0;
		boolean isFull = false;

		if (pet.get_food() == 100) { // 非常饱
			return;
		}
		// 食物营养度判断
		if (item.getItem().getFoodVolume() != 0) {
			// 吃掉食物的数量判断
			for (int i = 0; i < count; i++) {
				food = item.getItem().getFoodVolume() / 10;
				food += pet.get_food();
				if (!isFull) {
					if (food >= 100) {
						isFull = true;
						pet.set_food(100);
						foodCount++;
					}
					else {
						pet.set_food(food);
						foodCount++;
					}
				}
				else {
					break;
				}
			}
			if (foodCount != 0) {
				pet.getInventory().consumeItem(item.getItemId(), foodCount); // 吃掉食物
				// 纪录宠物饱食度
				_l1pet.set_food(pet.get_food());
				PetTable.getInstance().storePetFood(_l1pet);
			}
		}
	}

	/** 进化宠物 */
	private void evolvePet(final L1PcInstance pc, final L1NpcInstance target, final int itemId) {
		if (!(target instanceof L1PetInstance)) {
			return;
		}
		final L1PcInventory inv = pc.getInventory();
		final L1PetInstance pet = (L1PetInstance) target;
		final L1ItemInstance petamu = inv.getItem(pet.getItemObjId());
		if (((pet.getLevel() >= 30) || (itemId == 41310)) && // Lv30以上或是使用胜利果实
				(pc == pet.getMaster()) && // 自己的宠物
				(petamu != null)) {
			final L1ItemInstance highpetamu = inv.storeItem(40316, 1);
			if (highpetamu != null) {
				pet.evolvePet( // 宠物进化
				highpetamu.getId());
				pc.sendPackets(new S_ItemName(highpetamu));
				inv.removeItem(petamu, 1);
			}
		}
	}

	private boolean isNpcItemReceivable(final L1Npc npc) {
		for (final String impl : receivableImpls) {
			if (npc.getImpl().equals(impl)) {
				return true;
			}
		}
		return false;
	}

	/** 驯服宠物几率 */
	private boolean isTamePet(final L1NpcInstance npc) {
		boolean isSuccess = false;
		final int npcId = npc.getNpcTemplate().get_npcId();

		// 老虎
		if (npcId == 45313) {
			if ((npc.getMaxHp() / 3 > npc.getCurrentHp() // HP 1/3未满 1/16确率
					)
					&& (Random.nextInt(16) == 15)) {
				isSuccess = true;
			}
		}
		else {
			if (npc.getMaxHp() / 3 > npc.getCurrentHp()) {
				isSuccess = true;
			}
		}

		// 老虎、浣熊、高丽幼犬
		if ((npcId == 45313) || (npcId == 45044) || (npcId == 45711)) {
			if (npc.isResurrect()) { // RES(复活)后不能驯服
				isSuccess = false;
			}
		}

		return isSuccess;
	}

	/** 驯服宠物 */
	private void tamePet(final L1PcInstance pc, final L1NpcInstance target) {
		if ((target instanceof L1PetInstance) || (target instanceof L1SummonInstance)) {
			return;
		}

		int petcost = 0;
		for (final L1NpcInstance petNpc : pc.getPetList().values()) {
			petcost += petNpc.getPetcost();
		}
		int charisma = pc.getCha();
		if (pc.isCrown()) { // 王族
			charisma += 6;
		}
		else if (pc.isElf()) { // 妖精
			charisma += 12;
		}
		else if (pc.isWizard()) { // 法师
			charisma += 6;
		}
		else if (pc.isDarkelf()) { // 黑暗妖精
			charisma += 6;
		}
		else if (pc.isDragonKnight()) { // 龙骑士
			charisma += 6;
		}
		else if (pc.isIllusionist()) { // 幻术师
			charisma += 6;
		}
		charisma -= petcost;

		final L1PcInventory inv = pc.getInventory();
		if ((charisma >= 6) && (inv.getSize() < 180)) {
			if (this.isTamePet(target)) {
				final L1ItemInstance petamu = inv.storeItem(40314, 1); // 漂浮之眼的肉
				if (petamu != null) {
					new L1PetInstance(target, pc, petamu.getId());
					pc.sendPackets(new S_ItemName(petamu));
				}
			}
			else {
				pc.sendPackets(new S_ServerMessage(324)); // 驯养失败。
			}
		}
	}

	/** 使用宠物武器防具 */
	private void usePetWeaponArmor(final L1NpcInstance target, final L1ItemInstance item) {
		if (!(target instanceof L1PetInstance)) {
			return;
		}
		final L1PetInstance pet = (L1PetInstance) target;
		final L1PetItem petItem = PetItemTable.getInstance().getTemplate(item.getItemId());
		if (petItem.getUseType() == 1) { // 牙齿
			pet.usePetWeapon(pet, item);
		}
		else if (petItem.getUseType() == 0) { // 盔甲
			pet.usePetArmor(pet, item);
		}
	}
}
