package l1j.server.server.model.item.etcitem.other;

import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.item.executor.ItemExecutor;
import l1j.server.server.serverpackets.S_ServerMessage;

/**
 * 火龙之精致魔眼 - 47044
 * 
 * @author jrwz
 */
public class DragonEye_Fine_Fire extends ItemExecutor {

	public static ItemExecutor get() {
		return new DragonEye_Fine_Fire();
	}

	private DragonEye_Fine_Fire() {
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

		final int itemobj = data[0];
		final L1ItemInstance l1iteminstance1 = pc.getInventory().getItem(itemobj);

		if (l1iteminstance1.getItem().getItemId() == 47046) {
			pc.getInventory().consumeItem(47044, 1);
			pc.getInventory().consumeItem(47046, 1);
			pc.createNewItem(pc, 47023, 1); // 生命之魔眼
		}
		else {
			pc.sendPackets(new S_ServerMessage(79)); // 没有任何事情发生。
		}
	}
}
