package lineage.console.connector.cite;

import static l1j.server.server.model.skill.L1SkillId.ENTANGLE;
import static l1j.server.server.model.skill.L1SkillId.GREATER_HASTE;
import static l1j.server.server.model.skill.L1SkillId.HASTE;
import static l1j.server.server.model.skill.L1SkillId.MASS_SLOW;
import static l1j.server.server.model.skill.L1SkillId.SLOW;
import static l1j.server.server.model.skill.L1SkillId.STATUS_HASTE;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SkillHaste;
import l1j.server.server.serverpackets.S_SkillSound;
import lineage.console.connector.UniversalUseItem;
import lineage.console.delete.DeleteSkillEffect;

/**
 * 加速药水效果 (一段)
 * 
 * @author jrwz
 */
public class UseSpeedPotion_1 implements UniversalUseItem {

	@Override
	public void useItem(L1PcInstance pc, L1ItemInstance item, int itemId, int effect, int time, int gfxid) {

		// 如果正在使用加速装备时停止
		if (pc.getHasteItemEquipped() > 0) {
			return;
		}

		// 解除醉酒状态
		pc.setDrink(false);

		// 删除重复的一段加速状态
		DeleteSkillEffect.DeleteEffectOfGreenPotion(pc, STATUS_HASTE); // 一段加速
		DeleteSkillEffect.DeleteEffectOfGreenPotion(pc, HASTE); // 加速术
		DeleteSkillEffect.DeleteEffectOfGreenPotion(pc, GREATER_HASTE); // // 强力加速术
		pc.sendPackets(new S_SkillSound(pc.getId(), gfxid)); // 效果动画 (自己看得到)
		pc.broadcastPacket(new S_SkillSound(pc.getId(), gfxid)); // 效果动画 (同画面的其他人看得到)

		// 删除重复的缓速状态 (相互抵消、不加速)
		if (pc.getMoveSpeed() == 2) {
			DeleteSkillEffect.DeleteEffectOfSlow(pc, SLOW); // 缓速术
			DeleteSkillEffect.DeleteEffectOfSlow(pc, MASS_SLOW); // 集体缓速术
			DeleteSkillEffect.DeleteEffectOfSlow(pc, ENTANGLE); // 地面障碍
		}
		else {
			pc.sendPackets(new S_SkillHaste(pc.getId(), 1, time)); // 加速效果与时间 (自己看得到)
			pc.broadcastPacket(new S_SkillHaste(pc.getId(), 1, 0)); // 加速效果与时间 (同画面的其他人看得到)
			pc.setSkillEffect(STATUS_HASTE, time * 1000); // 给予一段加速时间 (秒)
			pc.setMoveSpeed(1); // 设置为加速状态
		}
	}

}