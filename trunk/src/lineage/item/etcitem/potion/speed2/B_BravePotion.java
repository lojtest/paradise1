package lineage.item.etcitem.potion.speed2;

import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ServerMessage;
import lineage.console.Factory;
import lineage.console.executor.ItemExecutor;

/**
 * 受祝福的 勇敢药水 - 140014
 * 
 * @author jrwz
 */
public class B_BravePotion extends ItemExecutor {

	private B_BravePotion() {
	}

	public static ItemExecutor get() {
		return new B_BravePotion();
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

		// 骑士
		if (pc.isKnight()) {
			// 效果时间 (秒)与动画ID
			Factory.getPotion().useBravePotion(pc, 350, 751);
		}
		else {
			pc.sendPackets(new S_ServerMessage(79)); // \f1没有任何事情发生。
		}

		// 删除道具
		pc.getInventory().removeItem(item, 1);
	}
}