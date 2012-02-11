package lineage.item.etcitem.potion.blessofeva;

import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import lineage.console.connector.UniversalUseItem;
import lineage.console.connector.cite.UsePotion_BlessOfEva;
import lineage.console.executor.ItemExecutor;

/**
 * 伊娃的祝福 - 40032
 * 
 * @author jrwz
 */
public class BlessOfEva extends ItemExecutor {

	private BlessOfEva() {
	}

	public static ItemExecutor get() {
		return new BlessOfEva();
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

		final UniversalUseItem a = new UsePotion_BlessOfEva();
		a.useItem(pc, item, 0, 0, 1800, 190);
		// 效果时间 (秒)与动画ID
		// Factory.getPotion().useBlessOfEvaPotion(pc, 1800, 190);

		// 删除道具
		pc.getInventory().removeItem(item, 1);
	}
}