package lineage.item.etcitem.poly;

import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import lineage.console.connector.UniversalUseItem;
import lineage.console.connector.cite.UsePolyScroll;
import lineage.console.executor.ItemExecutor;

/**
 * 变形卷轴 - 40088
 * 
 * @author jrwz
 */
public class PolyScroll extends ItemExecutor {

	private PolyScroll() {
	}

	public static ItemExecutor get() {
		return new PolyScroll();
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

		final UniversalUseItem a = new UsePolyScroll();
		a.useItem(pc, item, 0, 0, 1800, 0);
		// 变身时间 (秒)
		// Factory.getPoly().usePolyScroll(pc, item, 1800);
	}
}