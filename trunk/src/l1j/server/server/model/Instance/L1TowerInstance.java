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
package l1j.server.server.model.Instance;

import l1j.server.server.ActionCodes;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.WarTimeController;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1War;
import l1j.server.server.model.L1WarSpawn;
import l1j.server.server.model.L1World;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_NPCPack;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.templates.L1Npc;

/**
 * 守护塔控制项
 */
public class L1TowerInstance extends L1NpcInstance {

	class Death implements Runnable {
		L1Character lastAttacker = _lastattacker;

		L1Object object = L1World.getInstance().findObject(getId());

		L1TowerInstance npc = (L1TowerInstance) object;

		@Override
		public void run() {
			setCurrentHpDirect(0);
			setDead(true);
			setStatus(ActionCodes.ACTION_TowerDie);
			final int targetobjid = npc.getId();

			npc.getMap().setPassable(npc.getLocation(), true);

			npc.broadcastPacket(new S_DoActionGFX(targetobjid, ActionCodes.ACTION_TowerDie));

			// クラウンをspawnする
			if (!isSubTower()) {
				final L1WarSpawn warspawn = new L1WarSpawn();
				warspawn.SpawnCrown(_castle_id);
			}
		}
	}

	private static final long serialVersionUID = 1L;

	private L1Character _lastattacker;

	private int _castle_id;

	private int _crackStatus;

	public L1TowerInstance(final L1Npc template) {
		super(template);
	}

	@Override
	public void deleteMe() {
		_destroyed = true;
		if (getInventory() != null) {
			getInventory().clearItems();
		}
		allTargetClear();
		_master = null;
		L1World.getInstance().removeVisibleObject(this);
		L1World.getInstance().removeObject(this);
		for (final L1PcInstance pc : L1World.getInstance().getRecognizePlayer(this)) {
			pc.removeKnownObject(this);
			pc.sendPackets(new S_RemoveObject(this));
		}
		removeAllKnownObjects();
	}

	public boolean isSubTower() {
		return ((getNpcTemplate().get_npcId() == 81190 // 守护塔:伊娃
				)
				|| (getNpcTemplate().get_npcId() == 81191 // 守护塔:帕格里奥
				) || (getNpcTemplate().get_npcId() == 81192 // 守护塔:马普勒
				) || (getNpcTemplate().get_npcId() == 81193 // 守护塔:沙哈
		));
	}

	@Override
	public void onAction(final L1PcInstance pc) {
		onAction(pc, 0);
	}

	@Override
	public void onAction(final L1PcInstance pc, final int skillId) {
		if ((getCurrentHp() > 0) && !isDead()) {
			final L1Attack attack = new L1Attack(pc, this, skillId);
			if (attack.calcHit()) {
				attack.calcDamage();
				attack.addPcPoisonAttack(pc, this);
				attack.addChaserAttack();
			}
			attack.action();
			attack.commit();
		}
	}

	@Override
	public void onPerceive(final L1PcInstance perceivedFrom) {
		perceivedFrom.addKnownObject(this);
		perceivedFrom.sendPackets(new S_NPCPack(this));
	}

	@Override
	public void receiveDamage(final L1Character attacker, final int damage) { // 攻撃でＨＰを減らすときはここを使用
		if (_castle_id == 0) { // 初期設定で良いがいい場所がない
			if (isSubTower()) {
				_castle_id = L1CastleLocation.ADEN_CASTLE_ID;
			}
			else {
				_castle_id = L1CastleLocation.getCastleId(getX(), getY(), getMapId());
			}
		}

		if ((_castle_id > 0) && WarTimeController.getInstance().isNowWar(_castle_id)) { // 战争时间内

			// アデン城のメインタワーはサブタワーが3つ以上破壊されている場合のみ攻撃可能
			if ((_castle_id == L1CastleLocation.ADEN_CASTLE_ID) && !isSubTower()) {
				int subTowerDeadCount = 0;
				for (final L1Object l1object : L1World.getInstance().getObject()) {
					if (l1object instanceof L1TowerInstance) {
						final L1TowerInstance tower = (L1TowerInstance) l1object;
						if (tower.isSubTower() && tower.isDead()) {
							subTowerDeadCount++;
							if (subTowerDeadCount == 4) {
								break;
							}
						}
					}
				}
				if (subTowerDeadCount < 3) {
					return;
				}
			}

			L1PcInstance pc = null;
			if (attacker instanceof L1PcInstance) {
				pc = (L1PcInstance) attacker;
			}
			else if (attacker instanceof L1PetInstance) {
				pc = (L1PcInstance) ((L1PetInstance) attacker).getMaster();
			}
			else if (attacker instanceof L1SummonInstance) {
				pc = (L1PcInstance) ((L1SummonInstance) attacker).getMaster();
			}
			if (pc == null) {
				return;
			}

			// 布告しているかチェック。但し、城主が居ない場合は布告不要
			boolean existDefenseClan = false;
			for (final L1Clan clan : L1World.getInstance().getAllClans()) {
				final int clanCastleId = clan.getCastleId();
				if (clanCastleId == _castle_id) {
					existDefenseClan = true;
					break;
				}
			}
			boolean isProclamation = false;
			// 取得全部战争列表
			for (final L1War war : L1World.getInstance().getWarList()) {
				if (_castle_id == war.GetCastleId()) { // 今居る城の戦争
					isProclamation = war.CheckClanInWar(pc.getClanname());
					break;
				}
			}
			if ((existDefenseClan == true) && (isProclamation == false)) { // 城主が居て、布告していない場合
				return;
			}

			if ((getCurrentHp() > 0) && !isDead()) {
				final int newHp = getCurrentHp() - damage;
				if ((newHp <= 0) && !isDead()) {
					setCurrentHpDirect(0);
					setDead(true);
					setStatus(ActionCodes.ACTION_TowerDie);
					_lastattacker = attacker;
					_crackStatus = 0;
					final Death death = new Death();
					GeneralThreadPool.getInstance().execute(death);
					// Death(attacker);
				}
				if (newHp > 0) {
					setCurrentHp(newHp);
					if ((getMaxHp() * 1 / 4) > getCurrentHp()) {
						if (_crackStatus != 3) {
							broadcastPacket(new S_DoActionGFX(getId(), ActionCodes.ACTION_TowerCrack3));
							setStatus(ActionCodes.ACTION_TowerCrack3);
							_crackStatus = 3;
						}
					}
					else if ((getMaxHp() * 2 / 4) > getCurrentHp()) {
						if (_crackStatus != 2) {
							broadcastPacket(new S_DoActionGFX(getId(), ActionCodes.ACTION_TowerCrack2));
							setStatus(ActionCodes.ACTION_TowerCrack2);
							_crackStatus = 2;
						}
					}
					else if ((getMaxHp() * 3 / 4) > getCurrentHp()) {
						if (_crackStatus != 1) {
							broadcastPacket(new S_DoActionGFX(getId(), ActionCodes.ACTION_TowerCrack1));
							setStatus(ActionCodes.ACTION_TowerCrack1);
							_crackStatus = 1;
						}
					}
				}
			}
			else if (!isDead()) { // 念のため
				setDead(true);
				setStatus(ActionCodes.ACTION_TowerDie);
				_lastattacker = attacker;
				final Death death = new Death();
				GeneralThreadPool.getInstance().execute(death);
				// Death(attacker);
			}
		}
	}

	@Override
	public void setCurrentHp(final int i) {
		int currentHp = i;
		if (currentHp >= getMaxHp()) {
			currentHp = getMaxHp();
		}
		setCurrentHpDirect(currentHp);
	}

}
