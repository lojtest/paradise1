package lineage.item.etcitem.potion.speed2;

import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ServerMessage;
import lineage.console.connector.UniversalUseItem;
import lineage.console.connector.cite.UseSpeedPotion_2_Brave;
import lineage.console.executor.ItemExecutor;

/**
 * 福利勇敢药水 - 49305
 * 
 * @author jrwz
 */
public class WelfareBravePotion extends ItemExecutor {

	private WelfareBravePotion() {
	}

	public static ItemExecutor get() {
		return new WelfareBravePotion();
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
			final UniversalUseItem b = new UseSpeedPotion_2_Brave();
			b.useItem(pc, item, 0, 0, 1200, 751);
			// 效果时间 (秒)与动画ID
			// Factory.getPotion().useBravePotion(pc, 1200, 751);
		}
		else {
			pc.sendPackets(new S_ServerMessage(79)); // \f1没有任何事情发生。
		}

		// 删除道具
		pc.getInventory().removeItem(item, 1);
	}
}
