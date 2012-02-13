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
package l1j.server.server.model.Instance;

import l1j.server.server.datatables.HouseTable;
import l1j.server.server.datatables.NPCTalkDataTable;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1NpcTalkData;
import l1j.server.server.model.L1World;
import l1j.server.server.serverpackets.S_NPCTalkReturn;
import l1j.server.server.templates.L1House;
import l1j.server.server.templates.L1Npc;

/**
 * 盟屋管家控制项
 */
public class L1HousekeeperInstance extends L1NpcInstance {

	private static final long serialVersionUID = 1L;

	/**
	 * @param template
	 */
	public L1HousekeeperInstance(final L1Npc template) {
		super(template);
	}

	public void doFinalAction(final L1PcInstance pc) {
	}

	@Override
	public void onAction(final L1PcInstance pc) {
		onAction(pc, 0);
	}

	@Override
	public void onAction(final L1PcInstance pc, final int skillId) {
		final L1Attack attack = new L1Attack(pc, this, skillId);
		attack.calcHit();
		attack.action();
		attack.addChaserAttack();
		attack.calcDamage();
		attack.calcStaffOfMana();
		attack.addPcPoisonAttack(pc, this);
		attack.commit();
	}

	@Override
	public void onFinalAction(final L1PcInstance pc, final String action) {
	}

	@Override
	public void onTalkAction(final L1PcInstance pc) {
		final int objid = getId();
		final L1NpcTalkData talking = NPCTalkDataTable.getInstance().getTemplate(getNpcTemplate().get_npcId());
		final int npcid = getNpcTemplate().get_npcId();
		String htmlid = null;
		String[] htmldata = null;
		boolean isOwner = false;

		if (talking != null) {
			// 确定交谈的PC是否血盟的所有者
			final L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan != null) {
				final int houseId = clan.getHouseId();
				if (houseId != 0) {
					final L1House house = HouseTable.getInstance().getHouseTable(houseId);
					if (npcid == house.getKeeperId()) {
						isOwner = true;
					}
				}
			}

			// 如果不是血盟的所有者谈话内容会改变
			if (!isOwner) {
				// Housekeeperが属するアジトを取得する
				L1House targetHouse = null;
				for (final L1House house : HouseTable.getInstance().getHouseTableList()) {
					if (npcid == house.getKeeperId()) {
						targetHouse = house;
						break;
					}
				}

				// アジトがに所有者が居るかどうか調べる
				boolean isOccupy = false;
				String clanName = null;
				String leaderName = null;
				for (final L1Clan targetClan : L1World.getInstance().getAllClans()) {
					if (targetHouse.getHouseId() == targetClan.getHouseId()) {
						isOccupy = true;
						clanName = targetClan.getClanName();
						leaderName = targetClan.getLeaderName();
						break;
					}
				}

				// 会話内容を設定する
				if (isOccupy) { // 所有者あり
					htmlid = "agname";
					htmldata = new String[] { clanName, leaderName, targetHouse.getHouseName() };
				}
				else { // 所有者なし(競売中)
					htmlid = "agnoname";
					htmldata = new String[] { targetHouse.getHouseName() };
				}
			}

			// html表示パケット送信
			if (htmlid != null) { // htmlidが指定されている場合
				if (htmldata != null) { // html指定がある場合は表示
					pc.sendPackets(new S_NPCTalkReturn(objid, htmlid, htmldata));
				}
				else {
					pc.sendPackets(new S_NPCTalkReturn(objid, htmlid));
				}
			}
			else {
				if (pc.getLawful() < -1000) { // プレイヤーがカオティック
					pc.sendPackets(new S_NPCTalkReturn(talking, objid, 2));
				}
				else {
					pc.sendPackets(new S_NPCTalkReturn(talking, objid, 1));
				}
			}
		}
	}

}
