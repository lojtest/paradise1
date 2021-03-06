package l1j.server.server.model.item.etcitem.potion.speed;

import l1j.server.console.UniversalUseItem;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.item.etcitem.UseSpeedPotion_1;
import l1j.server.server.model.item.executor.ItemExecutor;

/**
 * 受祝福的 绿色药水 - 140013
 * 
 * @author jrwz
 */
public class B_GreenPotion extends ItemExecutor {

	public static ItemExecutor get() {
		return new B_GreenPotion();
	}

	private B_GreenPotion() {
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
		a.useItem(pc, item, 0, 0, 350, 191);
		// 效果时间 (秒)与动画ID
		// Factory.getPotion().useGreenPotion(pc, 350, 191);

		// 删除道具
		pc.getInventory().removeItem(item, 1);
	}
}
