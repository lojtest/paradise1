package lineage.item.etcitem.potion;

import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.poison.L1DamagePoison;
import lineage.console.executor.ItemExecutor;

/**
 * 酸性液体 - 41345
 * 
 * @author jrwz
 */
public class AcidicLiquids extends ItemExecutor {

	private AcidicLiquids() {
	}

	public static ItemExecutor get() {
		return new AcidicLiquids();
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

		// 中毒
		L1DamagePoison.doInfection(pc, pc, 3000, 5);

		// 删除道具
		pc.getInventory().removeItem(item, 1);
	}
}
