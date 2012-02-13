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
package l1j.server.server;

import java.util.Calendar;
import java.util.TimeZone;

import l1j.server.Config;
import l1j.server.server.datatables.CastleTable;
import l1j.server.server.datatables.DoorTable;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1WarSpawn;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1CrownInstance;
import l1j.server.server.model.Instance.L1DoorInstance;
import l1j.server.server.model.Instance.L1FieldObjectInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.Instance.L1TowerInstance;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.templates.L1Castle;

/**
 * 攻城战时间控制器
 */
public class WarTimeController implements Runnable {

	private static WarTimeController _instance;

	public static WarTimeController getInstance() {
		if (_instance == null) {
			_instance = new WarTimeController();
		}
		return _instance;
	}

	/** 城堡 */
	private final L1Castle[] _l1castle = new L1Castle[8];

	/** 攻城战开始时间 */
	private final Calendar[] _war_start_time = new Calendar[8];

	/** 攻城战结束时间 */
	private final Calendar[] _war_end_time = new Calendar[8];

	/** 攻城战中 */
	private final boolean[] _is_now_war = new boolean[8];

	/** 攻城战时间控制器 */
	private WarTimeController() {
		for (int i = 0; i < _l1castle.length; i++) {
			_l1castle[i] = CastleTable.getInstance().getCastleTable(i + 1);
			_war_start_time[i] = _l1castle[i].getWarTime();
			_war_end_time[i] = (Calendar) _l1castle[i].getWarTime().clone();
			_war_end_time[i].add(Config.ALT_WAR_TIME_UNIT, Config.ALT_WAR_TIME);
		}
	}

	/** 检查城堡战争 */
	public void checkCastleWar(final L1PcInstance player) {
		for (int i = 0; i < 8; i++) {
			if (_is_now_war[i]) {
				player.sendPackets(new S_PacketBox(S_PacketBox.MSG_WAR_GOING, i + 1)); // %s的攻城战正在进行中。
			}
		}
	}

	/** 取得现实时间 */
	public Calendar getRealTime() {
		final TimeZone _tz = TimeZone.getTimeZone(Config.TIME_ZONE);
		final Calendar cal = Calendar.getInstance(_tz);
		return cal;
	}

	/** 是攻城战区域 */
	public boolean isNowWar(final int castle_id) {
		return _is_now_war[castle_id - 1];
	}

	@Override
	public void run() {
		try {
			while (true) {
				checkWarTime(); // 检查攻城时间
				Thread.sleep(1000);
			}
		}
		catch (final Exception e1) {
		}
	}

	/** 检查攻城时间 */
	private void checkWarTime() {
		for (int i = 0; i < 8; i++) {
			if (_war_start_time[i].before(getRealTime()) // 攻城开始
					&& _war_end_time[i].after(getRealTime())) {
				if (_is_now_war[i] == false) {
					_is_now_war[i] = true;
					// 招出攻城的旗子
					final L1WarSpawn warspawn = new L1WarSpawn();
					warspawn.SpawnFlag(i + 1);
					// 修理城门并设定为关闭
					for (final L1DoorInstance door : DoorTable.getInstance().getDoorList()) {
						if (L1CastleLocation.checkInWarArea(i + 1, door)) {
							door.repairGate();
						}
					}

					L1World.getInstance().broadcastPacketToAll(new S_PacketBox(S_PacketBox.MSG_WAR_BEGIN, i + 1)); // %s的攻城战开始。
					int[] loc = new int[3];
					for (final L1PcInstance pc : L1World.getInstance().getAllPlayers()) {
						final int castleId = i + 1;
						if (L1CastleLocation.checkInWarArea(castleId, pc) && !pc.isGm()) { // 刚好在攻城范围内
							final L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
							if (clan != null) {
								if (clan.getCastleId() == castleId) { // 如果是有城血盟
									continue;
								}
							}
							loc = L1CastleLocation.getGetBackLoc(castleId);
							L1Teleport.teleport(pc, loc[0], loc[1], (short) loc[2], 5, true);
						}
					}
				}
			}
			else if (_war_end_time[i].before(getRealTime())) { // 攻城结束
				if (_is_now_war[i] == true) {
					_is_now_war[i] = false;
					L1World.getInstance().broadcastPacketToAll(new S_PacketBox(S_PacketBox.MSG_WAR_END, i + 1)); // %s的攻城战结束。
					// 更新攻城时间
					WarUpdate(i);

					final int castle_id = i + 1;
					for (final L1Object l1object : L1World.getInstance().getObject()) {
						// 取消攻城的旗子
						if (l1object instanceof L1FieldObjectInstance) {
							final L1FieldObjectInstance flag = (L1FieldObjectInstance) l1object;
							if (L1CastleLocation.checkInWarArea(castle_id, flag)) {
								flag.deleteMe();
							}
						}
						// 移除皇冠
						if (l1object instanceof L1CrownInstance) {
							final L1CrownInstance crown = (L1CrownInstance) l1object;
							if (L1CastleLocation.checkInWarArea(castle_id, crown)) {
								crown.deleteMe();
							}
						}
						// 移除守护塔
						if (l1object instanceof L1TowerInstance) {
							final L1TowerInstance tower = (L1TowerInstance) l1object;
							if (L1CastleLocation.checkInWarArea(castle_id, tower)) {
								tower.deleteMe();
							}
						}
					}
					// 塔重新出现
					final L1WarSpawn warspawn = new L1WarSpawn();
					warspawn.SpawnTower(castle_id);

					// 移除城门
					for (final L1DoorInstance door : DoorTable.getInstance().getDoorList()) {
						if (L1CastleLocation.checkInWarArea(castle_id, door)) {
							door.repairGate();
						}
					}
				}
				else { // 更新过期的攻城时间
					_war_start_time[i] = getRealTime();
					_war_end_time[i] = (Calendar) _war_start_time[i].clone();
					WarUpdate(i);
				}
			}

		}
	}

	/** 更新攻城战时间 */
	private void WarUpdate(final int i) {
		_war_start_time[i].add(Config.ALT_WAR_INTERVAL_UNIT, Config.ALT_WAR_INTERVAL);
		_war_end_time[i].add(Config.ALT_WAR_INTERVAL_UNIT, Config.ALT_WAR_INTERVAL);
		_l1castle[i].setWarTime(_war_start_time[i]);
		_l1castle[i].setTaxRate(10); // 税率10%
		_l1castle[i].setPublicMoney(0); // 清除城堡税收
		CastleTable.getInstance().updateCastle(_l1castle[i]);
	}
}
