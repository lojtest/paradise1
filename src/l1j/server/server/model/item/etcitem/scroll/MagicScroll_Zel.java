package l1j.server.server.model.item.etcitem.scroll;

import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.model.item.executor.ItemExecutor;
import l1j.server.server.model.skill.L1SkillUse;
import l1j.server.server.serverpackets.S_ServerMessage;

/**
 * 魔法卷轴 (铠甲护持) - 40879
 * 
 * @author jrwz
 */
public class MagicScroll_Zel extends ItemExecutor {

	public static ItemExecutor get() {
		return new MagicScroll_Zel();
	}

	private MagicScroll_Zel() {
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

		final int targetID = data[0];

		final L1ItemInstance tgItem = pc.getInventory().getItem(targetID);

		// 不是防具
		if (tgItem.getItem().getType2() != 2) {
			pc.sendPackets(new S_ServerMessage(281)); // \f1施咒取消。
			return;
		}

		final int useCount = 1;
		if (pc.getInventory().removeItem(item, useCount) >= useCount) {

			final int itemId = item.getItemId();
			final int skillid = itemId - 40858;

			final L1SkillUse l1skilluse = new L1SkillUse();
			l1skilluse.handleCommands(pc, skillid, targetID, 0, 0, null, 0, L1SkillUse.TYPE_SPELLSC);
		}
	}
}
