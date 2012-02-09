package lineage.item.etcitem.quest;

import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_Sound;
import l1j.server.server.utils.L1SpawnUtil;
import lineage.console.executor.ItemExecutor;

/**
 * 银笛 - 40700
 * 
 * @author jrwz
 */
public class SilverWhistle extends ItemExecutor {

	private SilverWhistle() {
	}

	public static ItemExecutor get() {
		return new SilverWhistle();
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

		pc.sendPackets(new S_Sound(10));
		pc.broadcastPacket(new S_Sound(10));

		// 海贼岛前半部魔法阵坐标
		if (((pc.getX() >= 32619) && (pc.getX() <= 32623)) && ((pc.getY() >= 33120) && (pc.getY() <= 33124)) && (pc.getMapId() == 440)) {
			boolean found = false;
			for (final L1Object obj : L1World.getInstance().getObject()) {
				if (obj instanceof L1MonsterInstance) {
					final L1MonsterInstance mob = (L1MonsterInstance) obj;
					if (mob != null) {
						if (mob.getNpcTemplate().get_npcId() == 45875) {
							found = true;
							break;
						}
					}
				}
			}
			if (found) {
			}
			else {
				L1SpawnUtil.spawn(pc, 45875, 0, 0); // 海贼骷髅首领
			}
		}
	}
}
