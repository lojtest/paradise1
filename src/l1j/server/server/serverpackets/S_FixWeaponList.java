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
package l1j.server.server.serverpackets;

import java.util.List;

import l1j.server.server.Opcodes;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.utils.collections.Lists;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket, S_SystemMessage

/**
 * 损坏武器清单
 */
public class S_FixWeaponList extends ServerBasePacket {

	private static final String S_FIX_WEAPON_LIST = "[S] S_FixWeaponList";

	/**
	 * 损坏武器清单
	 * 
	 * @param pc
	 *            该角色
	 */
	public S_FixWeaponList(final L1PcInstance pc) {
		this.buildPacket(pc);
	}

	@Override
	public byte[] getContent() {
		return this.getBytes();
	}

	@Override
	public String getType() {
		return S_FIX_WEAPON_LIST;
	}

	private void buildPacket(final L1PcInstance pc) {
		this.writeC(Opcodes.S_OPCODE_SELECTLIST);
		this.writeD(0x000000c8); // Price

		final List<L1ItemInstance> weaponList = Lists.newList();
		final List<L1ItemInstance> itemList = pc.getInventory().getItems();
		for (final L1ItemInstance item : itemList) {

			// Find Weapon
			switch (item.getItem().getType2()) {
				case 1:
					if (item.get_durability() > 0) {
						weaponList.add(item);
					}
					break;
			}
		}

		this.writeH(weaponList.size()); // Weapon Amount

		for (final L1ItemInstance weapon : weaponList) {

			this.writeD(weapon.getId()); // Item ID
			this.writeC(weapon.get_durability()); // Fix Level
		}
	}
}