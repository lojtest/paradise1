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

import static l1j.server.server.model.skill.L1SkillId.STATUS_CURSE_PARALYZED;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CURSE_PARALYZING;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.model.Instance.L1MonsterInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_Paralysis;
import l1j.server.server.serverpackets.S_ServerMessage;

/*
 * L1ParalysisPoison的大量代码。尤其是定时器。想要的东西很难共通化。
 */
public class L1CurseParalysis extends L1Paralysis {

	private final L1Character _target;

	private final int _delay;

	private final int _time;

	private Thread _timer;

	private class ParalysisDelayTimer extends Thread {
		@Override
		public void run() {
			_target.setSkillEffect(STATUS_CURSE_PARALYZING, 0);

			try {
				Thread.sleep(_delay); // 麻痹毒瘫痪前的等待时间。
			}
			catch (InterruptedException e) {
				_target.killSkillEffectTimer(STATUS_CURSE_PARALYZING);
				return;
			}

			if (_target instanceof L1PcInstance) {
				L1PcInstance player = (L1PcInstance) _target;
				if (!player.isDead()) {
					player.sendPackets(new S_Paralysis(1, true)); // 麻痹状态
				}
			}
			_target.setParalyzed(true);
			_timer = new ParalysisTimer();
			GeneralThreadPool.getInstance().execute(_timer); // 启动麻痹定时器
			if (isInterrupted()) {
				_timer.interrupt();
			}
		}
	}

	private class ParalysisTimer extends Thread {
		@Override
		public void run() {
			_target.killSkillEffectTimer(STATUS_CURSE_PARALYZING);
			_target.setSkillEffect(STATUS_CURSE_PARALYZED, 0);
			try {
				Thread.sleep(_time);
			}
			catch (InterruptedException e) {}

			_target.killSkillEffectTimer(STATUS_CURSE_PARALYZED);
			if (_target instanceof L1PcInstance) {
				L1PcInstance player = (L1PcInstance) _target;
				if (!player.isDead()) {
					player.sendPackets(new S_Paralysis(1, false)); // 解除麻痹状态
				}
			}
			_target.setParalyzed(false);
			cure(); // 解除诅咒
		}
	}

	private L1CurseParalysis(L1Character cha, int delay, int time) {
		_target = cha;
		_delay = delay;
		_time = time;

		curse();
	}

	private void curse() {
		if (_target instanceof L1PcInstance) {
			L1PcInstance player = (L1PcInstance) _target;
			player.sendPackets(new S_ServerMessage(212)); // \f1你的身体渐渐麻痹。
		}

		_target.setPoisonEffect(2);

		_timer = new ParalysisDelayTimer();
		GeneralThreadPool.getInstance().execute(_timer);
	}

	public static boolean curse(L1Character cha, int delay, int time) {
		if (!((cha instanceof L1PcInstance) || (cha instanceof L1MonsterInstance))) {
			return false;
		}
		if (cha.hasSkillEffect(STATUS_CURSE_PARALYZING) || cha.hasSkillEffect(STATUS_CURSE_PARALYZED)) {
			return false; // 已经麻痹或瘫痪
		}

		cha.setParalaysis(new L1CurseParalysis(cha, delay, time));
		return true;
	}

	@Override
	public int getEffectId() {
		return 2;
	}

	@Override
	public void cure() {
		if (_timer != null) {
			_timer.interrupt(); // 清除瘫痪定时器
		}

		_target.setPoisonEffect(0);
		_target.setParalaysis(null);
	}
}