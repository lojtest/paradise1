package lineage.item.etcitem.potion.speed;

import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import lineage.console.connector.UniversalUseItem;
import lineage.item.etcitem.UseSpeedPotion_1;
import lineage.item.etcitem.executor.ItemExecutor;

/**
 * 威士忌 - 40040
 * 
 * @author jrwz
 */
public class Whisky extends ItemExecutor {

	public static ItemExecutor get() {
		return new Whisky();
	}

	private Whisky() {
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

		final UniversalUseItem a = new UseSpeedPotion_1();
		a.useItem(pc, item, 0, 0, 900, 191);

		// 效果时间 (秒)与动画ID
		// Factory.getPotion().useGreenPotion(pc, 900, 191);

		// 删除道具
		pc.getInventory().removeItem(item, 1);
	}
}
