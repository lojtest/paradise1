package l1j.server.server.model.item.etcitem.quest;

import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.item.executor.ItemExecutor;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.utils.L1SpawnUtil;

/**
 * 暗杀名单(奇岩村) - 40558
 * 
 * @author jrwz
 */
public class Hitlist_Rocks extends ItemExecutor {

	public static ItemExecutor get() {
		return new Hitlist_Rocks();
	}

	private Hitlist_Rocks() {
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

		if ((pc.getX() == 33513) && (pc.getY() == 32890) && (pc.getMapId() == 4)) {
			for (final L1Object object : L1World.getInstance().getObject()) {
				if (object instanceof L1NpcInstance) {
					final L1NpcInstance npc = (L1NpcInstance) object;
					if (npc.getNpcTemplate().get_npcId() == 45889) {
						pc.sendPackets(new S_ServerMessage(79));
						return;
					}
				}
			}
			L1SpawnUtil.spawn(pc, 45889, 0, 300000);
		}
		else {
			pc.sendPackets(new S_ServerMessage(79)); // \f1没有任何事情发生。
		}
	}
}
