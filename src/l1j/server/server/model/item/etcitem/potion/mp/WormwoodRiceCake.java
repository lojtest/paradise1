package l1j.server.server.model.item.etcitem.potion.mp;

import l1j.server.console.UniversalUseItem;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.item.etcitem.UsePotion_AddMp;
import l1j.server.server.model.item.executor.ItemExecutor;

/**
 * 艾草年糕 - 40067
 * 
 * @author jrwz
 */
public class WormwoodRiceCake extends ItemExecutor {

	public static ItemExecutor get() {
		return new WormwoodRiceCake();
	}

	private WormwoodRiceCake() {
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

		final UniversalUseItem b = new UsePotion_AddMp();
		b.useItem(pc, item, 0, 15, 0, 190);
		// 基本加魔量与动画ID
		// Factory.getPotion().useAddMpPotion(pc, 15, 190);

		// 删除道具
		pc.getInventory().removeItem(item, 1);
	}
}
