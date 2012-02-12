package lineage.item.etcitem.other;

import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ServerMessage;
import lineage.console.executor.ItemExecutor;

/**
 * 进化果实 - 40070
 * 
 * @author jrwz
 */
public class EvolutionFruit extends ItemExecutor {

	private EvolutionFruit() {
	}

	public static ItemExecutor get() {
		return new EvolutionFruit();
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

		pc.sendPackets(new S_ServerMessage(76, item.getLogName()));
		pc.getInventory().removeItem(item, 1);
	}
}