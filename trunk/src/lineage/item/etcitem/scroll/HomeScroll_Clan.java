package lineage.item.etcitem.scroll;

import l1j.server.server.model.Getback;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1HouseLocation;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1TownLocation;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ServerMessage;
import lineage.console.executor.ItemExecutor;

/**
 * 血盟传送卷轴 - 40124
 * 
 * @author jrwz
 */
public class HomeScroll_Clan extends ItemExecutor {

	private HomeScroll_Clan() {
	}

	public static ItemExecutor get() {
		return new HomeScroll_Clan();
	}

	/**
	 * 道具执行
	 * 
	 * @param data
	 *            参数
	 * @param pc
	 *            对象
	 * @param item
	 *            道具
	 */
	@Override
	public void execute(final int[] data, final L1PcInstance pc, final L1ItemInstance item) {

		if (pc.getMap().isEscapable() || pc.isGm()) {
			int castle_id = 0;
			int house_id = 0;

			// 有血盟
			if (pc.getClanid() != 0) {
				final L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
				if (clan != null) {
					castle_id = clan.getCastleId(); // 城堡ID
					house_id = clan.getHouseId(); // 盟屋ID
				}
			}

			// 有城堡回城堡
			if (castle_id != 0) {
				if (pc.getMap().isEscapable() || pc.isGm()) {
					int[] loc = new int[3];
					loc = L1CastleLocation.getCastleLoc(castle_id);
					int locx = loc[0];
					int locy = loc[1];
					short mapid = (short) (loc[2]);
					L1Teleport.teleport(pc, locx, locy, mapid, 5, true);
					pc.getInventory().removeItem(item, 1);
				}
				else {
					pc.sendPackets(new S_ServerMessage(647));
				}
			}

			// 有盟屋回盟屋
			else if (house_id != 0) {
				if (pc.getMap().isEscapable() || pc.isGm()) {
					int[] loc = new int[3];
					loc = L1HouseLocation.getHouseLoc(house_id);
					int locx = loc[0];
					int locy = loc[1];
					short mapid = (short) (loc[2]);
					L1Teleport.teleport(pc, locx, locy, mapid, 5, true);
					pc.getInventory().removeItem(item, 1);
				}
				else {
					pc.sendPackets(new S_ServerMessage(647));
				}
			}

			// 都没有就回村庄
			else {

				// 有登记村庄
				if (pc.getHomeTownId() > 0) {
					int[] loc = L1TownLocation.getGetBackLoc(pc.getHomeTownId());
					int locx = loc[0];
					int locy = loc[1];
					short mapid = (short) (loc[2]);
					L1Teleport.teleport(pc, locx, locy, mapid, 5, true);
					pc.getInventory().removeItem(item, 1);
				} // 无登记村庄
				else {
					int[] loc = Getback.GetBack_Location(pc, true);
					L1Teleport.teleport(pc, loc[0], loc[1], (short) loc[2], 5, true);
					pc.getInventory().removeItem(item, 1);
				}
			}
		}
		else {
			pc.sendPackets(new S_ServerMessage(647)); // 这附近的能量影响到瞬间移动。在此地无法使用瞬间移动。
		}
	}
}
