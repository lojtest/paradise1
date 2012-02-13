/**
 *                            License
 * THE WORK (AS DEFINED BELOW) IS PROVIDED UNDER THE TERMS OF THIS  
 * CREATIVE COMMONS PUBLIC LICENSE ("CCPL" OR "LICENSE"). 
 * THE WORK IS PROTECTED BY COPYRIGHT AND/OR OTHER APPLICABLE LAW.  
 * ANY USE OF THE WORK OTHER THAN AS AUTHORIZED UNDER THIS LICENSE OR  
 * COPYRIGHT LAW IS PROHIBITED.
 * 
 * BY EXERCISING ANY RIGHTS TO THE WORK PROVIDED HERE, YOU ACCEPT AND  
 * AGREE TO BE BOUND BY THE TERMS OF THIS LICENSE. TO THE EXTENT THIS LICENSE  
 * MAY BE CONSIDERED TO BE A CONTRACT, THE LICENSOR GRANTS YOU THE RIGHTS CONTAINED 
 * HERE IN CONSIDERATION OF YOUR ACCEPTANCE OF SUCH TERMS AND CONDITIONS.
 * 
 */
package l1j.server.server.model;

import static l1j.server.server.model.skill.L1SkillId.ABSOLUTE_BARRIER;
import static l1j.server.server.model.skill.L1SkillId.EARTH_BIND;
import static l1j.server.server.model.skill.L1SkillId.FREEZING_BLIZZARD;
import static l1j.server.server.model.skill.L1SkillId.FREEZING_BREATH;
import static l1j.server.server.model.skill.L1SkillId.ICE_LANCE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CUBE_BALANCE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CUBE_IGNITION_TO_ENEMY;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CUBE_QUAKE_TO_ENEMY;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CUBE_SHOCK_TO_ENEMY;
import static l1j.server.server.model.skill.L1SkillId.STATUS_FREEZE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_MR_REDUCTION_BY_CUBE_SHOCK;

import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.server.ActionCodes;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_Paralysis;

/**
 * 幻术立方魔法
 */
public class L1Cube extends TimerTask {

	private static Logger _log = Logger.getLogger(L1Cube.class.getName());

	private ScheduledFuture<?> _future = null;

	private int _timeCounter = 0;

	private final L1Character _effect;

	private final L1Character _cha;

	private final int _skillId;

	public L1Cube(final L1Character effect, final L1Character cha, final int skillId) {
		_effect = effect;
		_cha = cha;
		_skillId = skillId;
	}

	public void begin() {
		// 效果时间持续8秒、事实上，在考虑每4秒技能效果处理时间只出现一次
		// 设置0.9秒的启动时间
		_future = GeneralThreadPool.getInstance().scheduleAtFixedRate(this, 900, 1000);
	}

	/** 给予效果 */
	public void giveEffect() {
		if (_skillId == STATUS_CUBE_IGNITION_TO_ENEMY) {
			if (_timeCounter % 4 != 0) {
				return;
			}
			if (_cha.hasSkillEffect(STATUS_FREEZE)) {
				return;
			}
			if (_cha.hasSkillEffect(ABSOLUTE_BARRIER)) {
				return;
			}
			if (_cha.hasSkillEffect(ICE_LANCE)) {
				return;
			}
			if (_cha.hasSkillEffect(FREEZING_BLIZZARD)) {
				return;
			}
			if (_cha.hasSkillEffect(FREEZING_BREATH)) {
				return;
			}
			if (_cha.hasSkillEffect(EARTH_BIND)) {
				return;
			}

			if (_cha instanceof L1PcInstance) {
				final L1PcInstance pc = (L1PcInstance) _cha;
				pc.sendPackets(new S_DoActionGFX(pc.getId(), ActionCodes.ACTION_Damage));
				pc.broadcastPacket(new S_DoActionGFX(pc.getId(), ActionCodes.ACTION_Damage));
				pc.receiveDamage(_effect, 10, false);
			}
			else if (_cha instanceof L1MonsterInstance) {
				final L1MonsterInstance mob = (L1MonsterInstance) _cha;
				mob.broadcastPacket(new S_DoActionGFX(mob.getId(), ActionCodes.ACTION_Damage));
				mob.receiveDamage(_effect, 10);
			}
		}
		else if (_skillId == STATUS_CUBE_QUAKE_TO_ENEMY) {
			if (_timeCounter % 4 != 0) {
				return;
			}
			if (_cha.hasSkillEffect(STATUS_FREEZE)) {
				return;
			}
			if (_cha.hasSkillEffect(ABSOLUTE_BARRIER)) {
				return;
			}
			if (_cha.hasSkillEffect(ICE_LANCE)) {
				return;
			}
			if (_cha.hasSkillEffect(FREEZING_BLIZZARD)) {
				return;
			}
			if (_cha.hasSkillEffect(FREEZING_BREATH)) {
				return;
			}
			if (_cha.hasSkillEffect(EARTH_BIND)) {
				return;
			}

			if (_cha instanceof L1PcInstance) {
				final L1PcInstance pc = (L1PcInstance) _cha;
				pc.setSkillEffect(STATUS_FREEZE, 1000);
				pc.sendPackets(new S_Paralysis(S_Paralysis.TYPE_BIND, true));
			}
			else if (_cha instanceof L1MonsterInstance) {
				final L1MonsterInstance mob = (L1MonsterInstance) _cha;
				mob.setSkillEffect(STATUS_FREEZE, 1000);
				mob.setParalyzed(true);
			}
		}
		else if (_skillId == STATUS_CUBE_SHOCK_TO_ENEMY) {
			// if (_timeCounter % 5 != 0) {
			// return;
			// }
			// _cha.addMr(-10);
			// if (_cha instanceof L1PcInstance) {
			// L1PcInstance pc = (L1PcInstance) _cha;
			// pc.sendPackets(new S_SPMR(pc));
			// }
			_cha.setSkillEffect(STATUS_MR_REDUCTION_BY_CUBE_SHOCK, 4000);
		}
		else if (_skillId == STATUS_CUBE_BALANCE) {
			if (_timeCounter % 4 == 0) {
				int newMp = _cha.getCurrentMp() + 5;
				if (newMp < 0) {
					newMp = 0;
				}
				_cha.setCurrentMp(newMp);
			}
			if (_timeCounter % 5 == 0) {
				if (_cha instanceof L1PcInstance) {
					final L1PcInstance pc = (L1PcInstance) _cha;
					pc.receiveDamage(_effect, 25, false);
				}
				else if (_cha instanceof L1MonsterInstance) {
					final L1MonsterInstance mob = (L1MonsterInstance) _cha;
					mob.receiveDamage(_effect, 25);
				}
			}
		}
	}

	@Override
	public void run() {
		try {
			if (_cha.isDead()) {
				stop();
				return;
			}
			if (!_cha.hasSkillEffect(_skillId)) {
				stop();
				return;
			}
			_timeCounter++;
			giveEffect();
		}
		catch (final Throwable e) {
			_log.log(Level.WARNING, e.getLocalizedMessage(), e);
		}
	}

	public void stop() {
		if (_future != null) {
			_future.cancel(false);
		}
	}

}
