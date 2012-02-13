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

import static l1j.server.server.model.skill.L1SkillId.ABSOLUTE_BARRIER;
import static l1j.server.server.model.skill.L1SkillId.BLIND_HIDING;
import static l1j.server.server.model.skill.L1SkillId.BURNING_WEAPON;
import static l1j.server.server.model.skill.L1SkillId.CANCELLATION;
import static l1j.server.server.model.skill.L1SkillId.COOKING_WONDER_DRUG;
import static l1j.server.server.model.skill.L1SkillId.COUNTER_BARRIER;
import static l1j.server.server.model.skill.L1SkillId.DECREASE_WEIGHT;
import static l1j.server.server.model.skill.L1SkillId.DRESS_EVASION;
import static l1j.server.server.model.skill.L1SkillId.EARTH_BIND;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_BLESS_OF_MAZU;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_ENCHANTING_BATTLE;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_EYE_OF_AHTHARTS;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_EYE_OF_BIRTH;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_EYE_OF_FAFURION;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_EYE_OF_FIGURE;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_EYE_OF_LIFE;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_EYE_OF_LINDVIOR;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_EYE_OF_VALAKAS;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_A_1;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_A_2;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_A_3;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_A_4;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_A_5;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_A_6;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_A_7;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_A_8;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_A_9;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_B_1;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_B_2;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_B_3;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_B_4;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_B_5;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_B_6;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_B_7;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_B_8;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_B_9;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_C_1;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_C_2;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_C_3;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_C_4;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_C_5;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_C_6;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_C_7;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_C_8;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_C_9;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_D_1;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_D_2;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_D_3;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_D_4;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_D_5;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_D_6;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_D_7;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_D_8;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_MAGIC_STONE_D_9;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_POTION_OF_BATTLE;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_POTION_OF_EXP_150;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_POTION_OF_EXP_175;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_POTION_OF_EXP_200;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_POTION_OF_EXP_225;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_POTION_OF_EXP_250;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_STRENGTHENING_HP;
import static l1j.server.server.model.skill.L1SkillId.EFFECT_STRENGTHENING_MP;
import static l1j.server.server.model.skill.L1SkillId.ENTANGLE;
import static l1j.server.server.model.skill.L1SkillId.FIRE_BLESS;
import static l1j.server.server.model.skill.L1SkillId.FIRE_WEAPON;
import static l1j.server.server.model.skill.L1SkillId.FOG_OF_SLEEPING;
import static l1j.server.server.model.skill.L1SkillId.FREEZING_BLIZZARD;
import static l1j.server.server.model.skill.L1SkillId.FREEZING_BREATH;
import static l1j.server.server.model.skill.L1SkillId.GMSTATUS_FINDINVIS;
import static l1j.server.server.model.skill.L1SkillId.GMSTATUS_HPBAR;
import static l1j.server.server.model.skill.L1SkillId.GREATER_HASTE;
import static l1j.server.server.model.skill.L1SkillId.HASTE;
import static l1j.server.server.model.skill.L1SkillId.ICE_LANCE;
import static l1j.server.server.model.skill.L1SkillId.ICE_LANCE_BASILISK;
import static l1j.server.server.model.skill.L1SkillId.ICE_LANCE_COCKATRICE;
import static l1j.server.server.model.skill.L1SkillId.ILLUSION_AVATAR;
import static l1j.server.server.model.skill.L1SkillId.INVISIBILITY;
import static l1j.server.server.model.skill.L1SkillId.MASS_SLOW;
import static l1j.server.server.model.skill.L1SkillId.MEDITATION;
import static l1j.server.server.model.skill.L1SkillId.MORTAL_BODY;
import static l1j.server.server.model.skill.L1SkillId.SHAPE_CHANGE;
import static l1j.server.server.model.skill.L1SkillId.SHOCK_SKIN;
import static l1j.server.server.model.skill.L1SkillId.SHOCK_STUN;
import static l1j.server.server.model.skill.L1SkillId.SLOW;
import static l1j.server.server.model.skill.L1SkillId.SOLID_CARRIAGE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CHAT_PROHIBITED;
import static l1j.server.server.model.skill.L1SkillId.STATUS_CURSE_PARALYZED;
import static l1j.server.server.model.skill.L1SkillId.STATUS_HASTE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_RIBRAVE;
import static l1j.server.server.model.skill.L1SkillId.STATUS_THIRD_SPEED;
import static l1j.server.server.model.skill.L1SkillId.STORM_EYE;
import static l1j.server.server.model.skill.L1SkillId.STORM_SHOT;
import static l1j.server.server.model.skill.L1SkillId.STRIKER_GALE;
import static l1j.server.server.model.skill.L1SkillId.WIND_SHACKLE;
import static l1j.server.server.model.skill.L1SkillId.WIND_SHOT;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ScheduledFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.ActionCodes;
import l1j.server.server.ClientThread;
import l1j.server.server.GeneralThreadPool;
import l1j.server.server.PacketOutput;
import l1j.server.server.WarTimeController;
import l1j.server.server.command.executor.L1HpBar;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.datatables.ExpTable;
import l1j.server.server.datatables.ItemTable;
import l1j.server.server.model.AcceleratorChecker;
import l1j.server.server.model.HpRegeneration;
import l1j.server.server.model.HpRegenerationByDoll;
import l1j.server.server.model.ItemMakeByDoll;
import l1j.server.server.model.L1Attack;
import l1j.server.server.model.L1CastleLocation;
import l1j.server.server.model.L1Character;
import l1j.server.server.model.L1ChatParty;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1DwarfForElfInventory;
import l1j.server.server.model.L1DwarfInventory;
import l1j.server.server.model.L1EquipmentSlot;
import l1j.server.server.model.L1ExcludingList;
import l1j.server.server.model.L1Inventory;
import l1j.server.server.model.L1Karma;
import l1j.server.server.model.L1Magic;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1Party;
import l1j.server.server.model.L1PartyRefresh;
import l1j.server.server.model.L1PcDeleteTimer;
import l1j.server.server.model.L1PcInventory;
import l1j.server.server.model.L1PinkName;
import l1j.server.server.model.L1PolyMorph;
import l1j.server.server.model.L1Quest;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1TownLocation;
import l1j.server.server.model.L1War;
import l1j.server.server.model.L1World;
import l1j.server.server.model.MpReductionByAwake;
import l1j.server.server.model.MpRegeneration;
import l1j.server.server.model.MpRegenerationByDoll;
import l1j.server.server.model.classes.L1ClassFeature;
import l1j.server.server.model.gametime.L1GameTimeCarrier;
import l1j.server.server.model.monitor.L1PcAutoUpdate;
import l1j.server.server.model.monitor.L1PcExpMonitor;
import l1j.server.server.model.monitor.L1PcGhostMonitor;
import l1j.server.server.model.monitor.L1PcHellMonitor;
import l1j.server.server.model.monitor.L1PcInvisDelay;
import l1j.server.server.model.skill.L1SkillId;
import l1j.server.server.model.skill.L1SkillUse;
import l1j.server.server.serverpackets.S_BlueMessage;
import l1j.server.server.serverpackets.S_CastleMaster;
import l1j.server.server.serverpackets.S_Disconnect;
import l1j.server.server.serverpackets.S_DoActionGFX;
import l1j.server.server.serverpackets.S_DoActionShop;
import l1j.server.server.serverpackets.S_Exp;
import l1j.server.server.serverpackets.S_Fight;
import l1j.server.server.serverpackets.S_Fishing;
import l1j.server.server.serverpackets.S_HPMeter;
import l1j.server.server.serverpackets.S_HPUpdate;
import l1j.server.server.serverpackets.S_Invis;
import l1j.server.server.serverpackets.S_Lawful;
import l1j.server.server.serverpackets.S_Liquor;
import l1j.server.server.serverpackets.S_MPUpdate;
import l1j.server.server.serverpackets.S_OtherCharPacks;
import l1j.server.server.serverpackets.S_OwnCharAttrDef;
import l1j.server.server.serverpackets.S_OwnCharStatus;
import l1j.server.server.serverpackets.S_OwnCharStatus2;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.serverpackets.S_Poison;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.serverpackets.S_SPMR;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.serverpackets.S_SkillHaste;
import l1j.server.server.serverpackets.S_SkillIconGFX;
import l1j.server.server.serverpackets.S_SystemMessage;
import l1j.server.server.serverpackets.S_bonusstats;
import l1j.server.server.serverpackets.ServerBasePacket;
import l1j.server.server.templates.L1BookMark;
import l1j.server.server.templates.L1Item;
import l1j.server.server.templates.L1MagicDoll;
import l1j.server.server.templates.L1PrivateShopBuyList;
import l1j.server.server.templates.L1PrivateShopSellList;
import l1j.server.server.utils.CalcStat;
import l1j.server.server.utils.Random;
import l1j.server.server.utils.collections.Lists;

// Referenced classes of package l1j.server.server.model:
// L1Character, L1DropTable, L1Object, L1ItemInstance,
// L1World
//

/**
 * 对象:PC 控制项
 */
public class L1PcInstance extends L1Character {
	/**
	 * 角色死亡的处理
	 */
	private class Death implements Runnable {
		L1Character _lastAttacker;

		Death(final L1Character cha) {
			_lastAttacker = cha;
		}

		@Override
		public void run() {
			final L1Character lastAttacker = _lastAttacker;
			_lastAttacker = null;
			setCurrentHp(0);
			setGresValid(false); // EXPロストするまでG-RES无效

			while (isTeleport()) { // 正在传送中等待传送结束
				try {
					Thread.sleep(300);
				}
				catch (final Exception e) {
				}
			}

			stopHpRegeneration();
			stopMpRegeneration();

			final int targetobjid = getId();
			getMap().setPassable(getLocation(), true);

			// 死亡时解除变身
			int tempchargfx = 0;
			if (hasSkillEffect(SHAPE_CHANGE)) {
				tempchargfx = getTempCharGfx();
				setTempCharGfxAtDead(tempchargfx);
			}
			else {
				setTempCharGfxAtDead(getClassId());
			}

			// 死亡时解除现有技能效果
			final L1SkillUse l1skilluse = new L1SkillUse();
			l1skilluse.handleCommands(L1PcInstance.this, CANCELLATION, getId(), getX(), getY(), null, 0, L1SkillUse.TYPE_LOGIN);

			// 战斗药水
			if (hasSkillEffect(EFFECT_POTION_OF_BATTLE)) {
				removeSkillEffect(EFFECT_POTION_OF_BATTLE);
			}
			// 象牙塔妙药
			if (hasSkillEffect(COOKING_WONDER_DRUG)) {
				removeSkillEffect(COOKING_WONDER_DRUG);
			}

			sendPackets(new S_DoActionGFX(targetobjid, ActionCodes.ACTION_Die));
			broadcastPacket(new S_DoActionGFX(targetobjid, ActionCodes.ACTION_Die));

			if (lastAttacker != L1PcInstance.this) {
				// セーフティーゾーン、コンバットゾーンで最后に杀したキャラが
				// プレイヤーorペットだったら、ペナルティなし
				if (getZoneType() != 0) {
					L1PcInstance player = null;
					if (lastAttacker instanceof L1PcInstance) {
						player = (L1PcInstance) lastAttacker;
					}
					else if (lastAttacker instanceof L1PetInstance) {
						player = (L1PcInstance) ((L1PetInstance) lastAttacker).getMaster();
					}
					else if (lastAttacker instanceof L1SummonInstance) {
						player = (L1PcInstance) ((L1SummonInstance) lastAttacker).getMaster();
					}
					if (player != null) {
						// 战争中に战争エリアに居る场合は例外
						if (!isInWarAreaAndWarTime(L1PcInstance.this, player)) {
							return;
						}
					}
				}

				final boolean sim_ret = simWarResult(lastAttacker); // 模拟战
				if (sim_ret == true) { // 模拟战中ならペナルティなし
					return;
				}
			}

			if (!getMap().isEnabledDeathPenalty()) {
				return;
			}

			// 决斗中ならペナルティなし
			L1PcInstance fightPc = null;
			if (lastAttacker instanceof L1PcInstance) {
				fightPc = (L1PcInstance) lastAttacker;
			}

			// 判断是否属于新手保护阶段, 并且是被其他玩家所杀死
			boolean isNovice = false;
			if (hasSkillEffect(L1SkillId.STATUS_NOVICE) && (fightPc != null)) {

				// 判断是否在新手等级保护范围内
				if (fightPc.getLevel() > (getLevel() + Config.NOVICE_PROTECTION_LEVEL_RANGE)) {
					isNovice = true;
				}
			}

			if (fightPc != null) {
				if ((getFightId() == fightPc.getId()) && (fightPc.getFightId() == getId())) { // 决斗中
					setFightId(0);
					sendPackets(new S_PacketBox(S_PacketBox.MSG_DUEL, 0, 0));
					fightPc.setFightId(0);
					fightPc.sendPackets(new S_PacketBox(S_PacketBox.MSG_DUEL, 0, 0));
					return;
				}
			}

			/*
			 * deathPenalty(); // EXPロスト
			 * 
			 * setGresValid(true); // EXPロストしたらG-RES有效
			 * 
			 * if (getExpRes() == 0) { setExpRes(1); }
			 */

			// 减少PK次数
			if (lastAttacker instanceof L1GuardInstance) {
				if (get_PKcount() > 0) {
					set_PKcount(get_PKcount() - 1);
				}
				setLastPk(null);
			}

			/** 妖精杀死同族PK值另外计算 */
			if (lastAttacker instanceof L1GuardianInstance) {
				if (getPkCountForElf() > 0) {
					setPkCountForElf(getPkCountForElf() - 1);
				}
				setLastPkForElf(null);
			}

			// 增加新手保护阶段, 将不会损失道具(不会喷装)
			if (!isNovice) {
				// 一定の确率でアイテムをDROP
				// アライメント32000以上で0%、以降-1000每に0.4%
				// アライメントが0未满の场合は-1000每に0.8%
				// アライメント-32000以下で最高51.2%のDROP率
				int lostRate = (int) (((getLawful() + 32768D) / 1000D - 65D) * 4D);
				if (lostRate < 0) {
					lostRate *= -1;
					if (getLawful() < 0) {
						lostRate *= 2;
					}
					final int rnd = Random.nextInt(1000) + 1;
					if (rnd <= lostRate) {
						int count = 1;
						if (getLawful() <= -30000) {
							count = Random.nextInt(4) + 1;
						}
						else if (getLawful() <= -20000) {
							count = Random.nextInt(3) + 1;
						}
						else if (getLawful() <= -10000) {
							count = Random.nextInt(2) + 1;
						}
						else if (getLawful() < 0) {
							count = Random.nextInt(1) + 1;
						}
						caoPenaltyResult(count);
					}
				}
			}

			final boolean castle_ret = castleWarResult(); // 攻城战
			if (castle_ret == true) { // 攻城战中で旗内なら赤ネームペナルティなし
				return;
			}

			if (!getMap().isEnabledDeathPenalty()) {
				return;
			}

			// 增加新手保护阶段, 将不会损失经验值
			if (!isNovice) {
				deathPenalty(); // EXPロスト
				setGresValid(true); // EXPロストしたらG-RES有效
			}

			if (get_PKcount() > 0) {
				set_PKcount(get_PKcount() - 1);
			}
			setLastPk(null);

			// 最后に杀したキャラがプレイヤーだったら、赤ネームにする
			L1PcInstance player = null;
			if (lastAttacker instanceof L1PcInstance) {
				player = (L1PcInstance) lastAttacker;
			}
			if (player != null) {
				if ((getLawful() >= 0) && (isPinkName() == false)) {
					boolean isChangePkCount = false;
					// アライメントが30000未满の场合はPKカウント增加
					if (player.getLawful() < 30000) {
						player.set_PKcount(player.get_PKcount() + 1);
						isChangePkCount = true;
						if (player.isElf() && isElf()) {
							player.setPkCountForElf(player.getPkCountForElf() + 1);
						}
					}
					player.setLastPk();
					/** 正义值满不会被警卫追杀 */
					if (player.getLawful() == 32767) {
						player.setLastPk(null);
					}
					if (player.isElf() && isElf()) {
						player.setLastPkForElf();
					}

					// アライメント处理
					// 公式の発表および各LVでのPKからつじつまの合うように变更
					// （PK侧のLVに依存し、高LVほどリスクも高い）
					// 48あたりで-8kほど DKの时点で10k强
					// 60で约20k强 65で30k弱
					int lawful;

					if (player.getLevel() < 50) {
						lawful = -1 * (int) ((Math.pow(player.getLevel(), 2) * 4));
					}
					else {
						lawful = -1 * (int) ((Math.pow(player.getLevel(), 3) * 0.08));
					}
					// もし(元々のアライメント-1000)が计算后より低い场合
					// 元々のアライメント-1000をアライメント值とする
					// （连续でPKしたときにほとんど值が变わらなかった记忆より）
					// これは上の式よりも自信度が低いうろ觉えですので
					// 明らかにこうならない！という场合は修正お愿いします
					if ((player.getLawful() - 1000) < lawful) {
						lawful = player.getLawful() - 1000;
					}

					if (lawful <= -32768) {
						lawful = -32768;
					}
					player.setLawful(lawful);

					final S_Lawful s_lawful = new S_Lawful(player.getId(), player.getLawful());
					player.sendPackets(s_lawful);
					player.broadcastPacket(s_lawful);

					if (isChangePkCount && (player.get_PKcount() >= 5) && (player.get_PKcount() < 10)) {
						// 你已经杀了 %0 人。 如果你PK的次数达到 %1， 你将会被打入地狱。
						player.sendPackets(new S_BlueMessage(551, String.valueOf(player.get_PKcount()), "10"));
					}
					else if (isChangePkCount && (player.get_PKcount() >= 10)) {
						player.beginHell(true);
					}
				}
				else {
					setPinkName(false);
				}
			}
			_pcDeleteTimer = new L1PcDeleteTimer(L1PcInstance.this);
			_pcDeleteTimer.begin();
		}
	}

	private static final long serialVersionUID = 1L;
	/** 王子 */
	public static final int CLASSID_PRINCE = 0;
	/** 公主 */
	public static final int CLASSID_PRINCESS = 1;
	/** 男骑士 */
	public static final int CLASSID_KNIGHT_MALE = 61;
	/** 女骑士 */
	public static final int CLASSID_KNIGHT_FEMALE = 48;
	/** 男精灵 */
	public static final int CLASSID_ELF_MALE = 138;
	/** 女精灵 */
	public static final int CLASSID_ELF_FEMALE = 37;
	/** 男法师 */
	public static final int CLASSID_WIZARD_MALE = 734;
	/** 女法师 */
	public static final int CLASSID_WIZARD_FEMALE = 1186;
	/** 男黑暗精灵 */
	public static final int CLASSID_DARK_ELF_MALE = 2786;
	/** 女黑暗精灵 */
	public static final int CLASSID_DARK_ELF_FEMALE = 2796;
	/** 男龙骑士 */
	public static final int CLASSID_DRAGON_KNIGHT_MALE = 6658;
	/** 女龙骑士 */
	public static final int CLASSID_DRAGON_KNIGHT_FEMALE = 6661;
	/** 男幻术师 */
	public static final int CLASSID_ILLUSIONIST_MALE = 6671;
	/** 女幻术师 */
	public static final int CLASSID_ILLUSIONIST_FEMALE = 6650;

	/**
	 * 加载指定PC资料
	 * 
	 * @param charName
	 *            PC名称
	 * @return
	 */
	public static L1PcInstance load(final String charName) {
		L1PcInstance result = null;
		try {
			result = CharacterTable.getInstance().loadCharacter(charName);
		}
		catch (final Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		return result;
	}

	/** 3.3C组队系统 */
	boolean _rpActive = false;

	/** 标准的 */
	private L1PartyRefresh _rp;
	/** 组队类型 */
	private int _partyType;

	/** 回血 */
	private short _hpr = 0;

	/** 真正的回血 */
	private short _trueHpr = 0;

	/** 回魔 */
	private short _mpr = 0;
	/** 真正的回魔 */
	private short _trueMpr = 0;

	/** 原始 CON HPR */
	public short _originalHpr = 0; // ● 原始CON HPR

	/** 原始 WIS MPR */
	public short _originalMpr = 0; // ● 原始WIS MPR

	/** 自动更新间隔 */
	private static final long INTERVAL_AUTO_UPDATE = 300;

	/**  */
	private ScheduledFuture<?> _autoUpdateFuture;

	/**  */
	private static final long INTERVAL_EXP_MONITOR = 500;

	/**  */
	private ScheduledFuture<?> _expMonitorFuture;

	/** 技能清单 */
	private final List<Integer> skillList = Lists.newList();

	/** 宠物竞速圈数 */
	private int _lap = 1;

	/** 检查宠物竞速圈数 */
	private int _lapCheck = 0;

	// 补充
	private boolean _order_list = false;

	/**  */
	private L1ClassFeature _classFeature = null;

	/** PK次数 */
	private int _PKcount;

	/** PK次数 (精灵用) */
	private int _PkCountForElf;

	/** 血盟 ID */
	private int _clanid;

	/** 血盟名称 */
	private String clanname;

	/** 血盟内的阶级(联盟君主、守护骑士、一般、见习) */
	private int _clanRank;

	/** 角色生日 */
	private Timestamp _birthday;

	/** 性别 */
	private byte _sex; // ● 性别

	/** 贩卖清单 */
	private final List<L1PrivateShopSellList> _sellList = Lists.newList();

	/** 购买清单 */
	private final List<L1PrivateShopBuyList> _buyList = Lists.newList();

	/** 商店聊天 */
	private byte[] _shopChat;
	/** 商店模式 */
	private boolean _isPrivateShop = false;
	/** 正在进行个人商店交易 */
	private boolean _isTradingInPrivateShop = false;
	/** 出售物品种类数量 */
	private int _partnersPrivateShopItemCount = 0;

	/** 封包加密管理 */
	private PacketOutput _out;

	public double _oldTime = 0; // 连续魔法伤害の轻减に使用する

	/** 原始DEX ER补正 */
	private int _originalEr = 0; // ● 原始DEX ER补正

	private static Logger _log = Logger.getLogger(L1PcInstance.class.getName());

	/**  */
	private ClientThread _netConnection;

	/**  */
	private int _classId;

	/**  */
	private int _type;

	/**  */
	private long _exp;

	/**  */
	private final L1Karma _karma = new L1Karma();

	/**  */
	private boolean _gm;

	/**  */
	private boolean _monitor;

	/**  */
	private boolean _gmInvis;

	/**  */
	private short _accessLevel;

	/**  */
	private int _currentWeapon;

	/**  */
	private final L1PcInventory _inventory;

	/**  */
	private final L1DwarfInventory _dwarf;

	/**  */
	private final L1DwarfForElfInventory _dwarfForElf;

	/**  */
	private final L1Inventory _tradewindow;

	/**  */
	private L1ItemInstance _weapon;

	/**  */
	private L1Party _party;

	/**  */
	private L1ChatParty _chatParty;

	/**  */
	private int _partyID;

	/**  */
	private int _tradeID;

	/**  */
	private boolean _tradeOk;

	/**  */
	private int _tempID;

	/**  */
	private boolean _isTeleport = false;

	/**  */
	private boolean _isDrink = false;

	/**  */
	private boolean _isGres = false;

	/**  */
	private boolean _isPinkName = false;

	/**  */
	private final List<L1BookMark> _bookmarks;

	/**  */
	private final L1Quest _quest;

	/**  */
	private MpRegeneration _mpRegen;

	/**  */
	private MpRegenerationByDoll _mpRegenByDoll;

	/**  */
	private MpReductionByAwake _mpReductionByAwake;

	/**  */
	private HpRegeneration _hpRegen;

	/**  */
	private HpRegenerationByDoll _hpRegenByDoll;

	/**  */
	private ItemMakeByDoll _itemMakeByDoll;

	/**  */
	private static Timer _regenTimer = new Timer(true);

	/**  */
	private boolean _mpRegenActive;

	/**  */
	private boolean _mpRegenActiveByDoll;

	/**  */
	private boolean _mpReductionActiveByAwake;

	/**  */
	private boolean _hpRegenActive;

	/**  */
	private boolean _hpRegenActiveByDoll;

	/**  */
	private boolean _ItemMakeActiveByDoll;

	/**  */
	private final L1EquipmentSlot _equipSlot;

	/**  */
	private L1PcDeleteTimer _pcDeleteTimer;

	/** 账号名称 */
	private String _accountName;

	/** 基本MaxHp */
	private short _baseMaxHp = 0; // ● ＭＡＸＨＰ基本（1～32767）

	/** 基本MaxMp */
	private short _baseMaxMp = 0; // ● ＭＡＸＭＰ基本（0～32767）

	/** 基本Ac */
	private int _baseAc = 0; // ● ＡＣ基本（-128～127）

	/** 原始DEX ＡＣ补正 */
	private int _originalAc = 0; // ● 原始DEX ＡＣ补正

	/** 基本的力量值 */
	private short _baseStr = 0; // ● 基本ＳＴＲ（1～255）

	/** 基本的体质值 */
	private short _baseCon = 0; // ● 基本ＣＯＮ（1～255）

	/** 基本的敏捷值 */
	private short _baseDex = 0; // ● 基本ＤＥＸ（1～255）

	/** 基本的魅力值 */
	private short _baseCha = 0; // ● 基本ＣＨＡ（1～255）

	/** 基本的智力值 */
	private short _baseInt = 0; // ● 基本ＩＮＴ（1～255）

	/** 基本的精神值 */
	private short _baseWis = 0; // ● 基本ＷＩＳ（1～255）

	/** 原始的力量值 */
	private int _originalStr = 0; // ● 原始 STR

	/** 原始的体质值 */
	private int _originalCon = 0; // ● 原始 CON

	/** 原始的敏捷值 */
	private int _originalDex = 0; // ● 原始 DEX

	/** 原始的魅力值 */
	private int _originalCha = 0; // ● 原始 CHA

	/** 原始的智力值 */
	private int _originalInt = 0; // ● 原始 INT

	/** 原始的精神值 */
	private int _originalWis = 0; // ● 原始 WIS

	/** 原始STR 伤害补正 */
	private int _originalDmgup = 0; // ● 原始STR 伤害补正

	/** 原始DEX 弓伤害补正 */
	private int _originalBowDmgup = 0; // ● 原始DEX 弓伤害补正

	/** 原始STR 命中补正 */
	private int _originalHitup = 0; // ● 原始STR 命中补正

	/** 原始DEX 命中补正 */
	private int _originalBowHitup = 0; // ● 原始DEX 命中补正

	/** 原始WIS 魔法防御 */
	private int _originalMr = 0; // ● 原始WIS 魔法防御

	/** 原始INT 魔法命中 */
	private int _originalMagicHit = 0; // ● 原始INT 魔法命中

	/**  */
	private int _originalMagicCritical = 0; // ● 原始INT 魔法クリティカル

	/** 原始INT 消费MP轻减 */
	private int _originalMagicConsumeReduction = 0; // ● 原始INT 消费MP轻减

	/** 原始INT的魔法伤害 */
	private int _originalMagicDamage = 0;

	/** 原始CON HP上升值补正 */
	private int _originalHpup = 0;

	/** 原始WIS MP上升值补正 */
	private int _originalMpup = 0;

	/** 基本伤害补正 */
	private int _baseDmgup = 0; // ● 基本伤害补正（-128～127）

	/** 弓类基本伤害补正 */
	private int _baseBowDmgup = 0; // ● 弓类基本伤害补正（-128～127）

	/** 基本命中补正 */
	private int _baseHitup = 0; // ● 基本命中补正（-128～127）

	/** 弓基本命中补正 */
	private int _baseBowHitup = 0; // ● 弓基本命中补正（-128～127）

	/** 基本魔法防御 */
	private int _baseMr = 0; // ● 基本魔法防御（0～）

	/** 灵魂升华增加的HP */
	private int _advenHp; // ● // アドバンスド スピリッツで增加しているＨＰ

	/** 灵魂升华增加的MP */
	private int _advenMp; // ● // アドバンスド スピリッツで增加しているＭＰ

	/** 过去最高等级 */
	private int _highLevel;

	/** 奖励点分配状况 */
	private int _bonusStats;

	/**
	 * 万能药使用状况
	 * 
	 * @return
	 */
	private int _elixirStats;

	/** 精灵属性 */
	private int _elfAttr;

	/** 恢复EXP */
	private int _expRes; // ● EXP复旧

	/** 结婚伴侣ID */
	private int _partnerId; // ● 结婚相手

	/** 在线状态 */
	private int _onlineStatus;

	/** 所住村镇ID */
	private int _homeTownId; // ● ホームタウン

	/** 贡献度 */
	private int _contribution;

	/** 村庄福利金 */
	private int _pay; // 村庄福利金 此栏位由 HomeTownTimeController 处理 update

	/** 地狱停留时间 (秒) */
	private int _hellTime;

	/** 角色封锁 */
	private boolean _banned; // ● 冻结

	public static final int REGENSTATE_NONE = 4;

	public static final int REGENSTATE_MOVE = 2;

	public static final int REGENSTATE_ATTACK = 1;

	/** 隐身延迟计时器 */
	private int invisDelayCounter = 0;

	/** 隐身计时器监视器 */
	private final Object _invisTimerMonitor = new Object();

	/** 隐身延迟 */
	private static final long DELAY_INVIS = 3000L;

	/** 幽灵状态 */
	private boolean _ghost = false;

	/** 幽灵状态可以与NPC对话 */
	private boolean _ghostCanTalk = true;

	/** 准备解除幽灵状态 */
	private boolean _isReserveGhost = false;

	private ScheduledFuture<?> _ghostFuture;

	private int _ghostSaveLocX = 0;

	private int _ghostSaveLocY = 0;

	private short _ghostSaveMapId = 0;

	private int _ghostSaveHeading = 0;

	private ScheduledFuture<?> _hellFuture;

	/** 最终PK时间 */
	private Timestamp _lastPk;

	// 妖精杀死同族 PK值另外计算
	private Timestamp _lastPkForElf;

	/** 角色删除时间 */
	private Timestamp _deleteTime;

	/**  */
	private int _weightReduction = 0;

	/** 原始STR 重量轻减 */
	private int _originalStrWeightReduction = 0;

	/** 原始CON 重量轻减 */
	private int _originalConWeightReduction = 0;

	/** 装备加速道具 */
	private int _hasteItemEquipped = 0;

	/** 防具的伤害减免 */
	private int _damageReductionByArmor = 0;

	/** 防具的命中率补正 */
	private int _hitModifierByArmor = 0;

	/** 防具的伤害补正 */
	private int _dmgModifierByArmor = 0;

	/** 防具对弓的命中率补正 */
	private int _bowHitModifierByArmor = 0;

	/** 防具对损坏的弓的补正 */
	private int _bowDmgModifierByArmor = 0;

	/** G-RES有效 */
	private boolean _gresValid;

	/** 钓鱼时间 */
	private long _fishingTime = 0;

	/** 钓鱼中 */
	private boolean _isFishing = false;

	/** 准备好钓鱼 */
	private boolean _isFishingReady = false;

	/** 烹饪ID */
	private int _cookingId = 0;

	/** 点心ID */
	private int _dessertId = 0;

	/** 角色讯息拒绝名单 */
	private final L1ExcludingList _excludingList = new L1ExcludingList();

	/** -- 加速器检知机能 -- */
	private final AcceleratorChecker _acceleratorChecker = new AcceleratorChecker(this);

	/** 使用屠宰者判断 */
	private boolean _FoeSlayer = false;

	/**
	 * 传送目的地坐标X
	 */
	private int _teleportX = 0;

	/** 传送目的地坐标Y */
	private int _teleportY = 0;

	/** 传送目的地地图ID */
	private short _teleportMapId = 0;

	/** 传送目的地面向 */
	private int _teleportHeading = 0;

	/** 角色死亡时的临时GFX图像 */
	private int _tempCharGfxAtDead;

	/** 是可以密语 */
	private boolean _isCanWhisper = true;

	/** 是显示交易聊天 */
	private boolean _isShowTradeChat = true;

	/** 是显示血盟聊天 */
	private boolean _isShowClanChat = true;

	/** 是显示组队聊天 */
	private boolean _isShowPartyChat = true;

	/** 是显示世界聊天 */
	private boolean _isShowWorldChat = true;

	/** 战斗ID */
	private int _fightId;

	/** 钓鱼坐标X */
	private int _fishX;

	/** 钓鱼坐标Y */
	private int _fishY;

	/** 聊天数量 */
	private byte _chatCount = 0;

	/** 旧的聊天时间在Millis？ */
	private long _oldChatTimeInMillis = 0L;

	/** 呼叫血盟ID */
	private int _callClanId;

	/** 呼叫血盟名称 */
	private int _callClanHeading;

	/** 角色重新开始 */
	private boolean _isInCharReset = false;

	/** 临时等级 */
	private int _tempLevel = 1;

	/** 临时最高等级 */
	private int _tempMaxLevel = 1;

	/** 觉醒技能ID */
	private int _awakeSkillId = 0;

	/** 判断是否无道具施法(召戒清单、变身清单) */
	private boolean _isSummonMonster = false;

	/** 变身 */
	private boolean _isShapeChange = false;

	/**
	 * 暂存字符串
	 */
	private String _text;

	/**
	 * 暂存byte[]阵列
	 */
	private byte[] _textByte = null;

	public L1PcInstance() {
		_accessLevel = 0;
		_currentWeapon = 0;
		_inventory = new L1PcInventory(this);
		_dwarf = new L1DwarfInventory(this);
		_dwarfForElf = new L1DwarfForElfInventory(this);
		_tradewindow = new L1Inventory();
		_bookmarks = Lists.newList();
		_quest = new L1Quest(this);
		_equipSlot = new L1EquipmentSlot(this); // コンストラクタでthisポインタを渡すのは安全だろうか・・・
	}

	/** 增加基本的魅力值 */
	public void addBaseCha(short i) {
		i += _baseCha;
		if (i >= 255) {
			i = 255;
		}
		else if (i < 1) {
			i = 1;
		}
		addCha((short) (i - _baseCha));
		_baseCha = i;
	}

	/** 增加基本的体质值 */
	public void addBaseCon(short i) {
		i += _baseCon;
		if (i >= 255) {
			i = 255;
		}
		else if (i < 1) {
			i = 1;
		}
		addCon((short) (i - _baseCon));
		_baseCon = i;
	}

	/** 增加基本的敏捷值 */
	public void addBaseDex(short i) {
		i += _baseDex;
		if (i >= 255) {
			i = 255;
		}
		else if (i < 1) {
			i = 1;
		}
		addDex((short) (i - _baseDex));
		_baseDex = i;
	}

	/** 增加基本的智力值 */
	public void addBaseInt(short i) {
		i += _baseInt;
		if (i >= 255) {
			i = 255;
		}
		else if (i < 1) {
			i = 1;
		}
		addInt((short) (i - _baseInt));
		_baseInt = i;
	}

	/** 增加基本MaxHp */
	public void addBaseMaxHp(short i) {
		i += _baseMaxHp;
		if (i >= 32767) {
			i = 32767;
		}
		else if (i < 1) {
			i = 1;
		}
		addMaxHp(i - _baseMaxHp);
		_baseMaxHp = i;
	}

	/** 增加基本MaxMp */
	public void addBaseMaxMp(short i) {
		i += _baseMaxMp;
		if (i >= 32767) {
			i = 32767;
		}
		else if (i < 0) {
			i = 0;
		}
		addMaxMp(i - _baseMaxMp);
		_baseMaxMp = i;
	}

	/** 增加基本的力量值 */
	public void addBaseStr(short s) {
		s += _baseStr;
		if (s >= 255) {
			s = 255;
		}
		else if (s < 1) {
			s = 1;
		}
		addStr((short) (s - _baseStr));
		_baseStr = s;
	}

	/** 增加基本的精神值 */
	public void addBaseWis(short i) {
		i += _baseWis;
		if (i >= 255) {
			i = 255;
		}
		else if (i < 1) {
			i = 1;
		}
		addWis((short) (i - _baseWis));
		_baseWis = i;
	}

	/** 增加书签 */
	public void addBookMark(final L1BookMark book) {
		_bookmarks.add(book);
	}

	/** 增加防具对损坏的弓的补正 */
	public void addBowDmgModifierByArmor(final int i) {
		_bowDmgModifierByArmor += i;
	}

	/** 增加防具对弓的命中率补正 */
	public void addBowHitModifierByArmor(final int i) {
		_bowHitModifierByArmor += i;
	}

	/**
	 * 增加贡献度
	 * 
	 * @param contribution
	 */
	public synchronized void addContribution(final int contribution) {
		_contribution += contribution;
	}

	/** 增加防具的伤害减免 */
	public void addDamageReductionByArmor(final int i) {
		_damageReductionByArmor += i;
	}

	/** 增加防具的伤害补正 */
	public void addDmgModifierByArmor(final int i) {
		_dmgModifierByArmor += i;
	}

	/** 增加经验值 */
	public synchronized void addExp(final long exp) {
		_exp += exp;
		if (_exp > ExpTable.MAX_EXP) {
			_exp = ExpTable.MAX_EXP;
		}
	}

	/** 增加装备加速道具 */
	public void addHasteItemEquipped(final int i) {
		_hasteItemEquipped += i;
	}

	/** 增加防具的命中率补正 */
	public void addHitModifierByArmor(final int i) {
		_hitModifierByArmor += i;
	}

	/** 增加回血 */
	public void addHpr(final int i) {
		_trueHpr += i;
		_hpr = (short) Math.max(0, _trueHpr);
	}

	/** 增加隐身延迟计时器 */
	public void addInvisDelayCounter(final int counter) {
		synchronized (_invisTimerMonitor) {
			invisDelayCounter += counter;
		}
	}

	/** 增加友好度 */
	public void addKarma(final int i) {
		synchronized (_karma) {
			_karma.add(i);
		}
	}

	/** 增加回魔 */
	public void addMpr(final int i) {
		_trueMpr += i;
		_mpr = (short) Math.max(0, _trueMpr);
	}

	/**  */
	public void addWeightReduction(final int i) {
		_weightReduction += i;
	}

	/** 开始经验值监视器 */
	public void beginExpMonitor() {
		_expMonitorFuture = GeneralThreadPool.getInstance().pcScheduleAtFixedRate(new L1PcExpMonitor(getId()), 0L, INTERVAL_EXP_MONITOR);
	}

	/**  */
	public void beginGameTimeCarrier() {
		new L1GameTimeCarrier(this).start();
	}

	/**
	 * 幽灵状态传送
	 * 
	 * @param locx
	 * @param locy
	 * @param mapid
	 * @param canTalk
	 */
	public void beginGhost(final int locx, final int locy, final short mapid, final boolean canTalk) {
		beginGhost(locx, locy, mapid, canTalk, 0);
	}

	/**
	 * 幽灵状态传送
	 * 
	 * @param locx
	 * @param locy
	 * @param mapid
	 * @param canTalk
	 * @param sec
	 */
	public void beginGhost(final int locx, final int locy, final short mapid, final boolean canTalk, final int sec) {
		if (isGhost()) {
			return;
		}
		setGhost(true);
		_ghostSaveLocX = getX();
		_ghostSaveLocY = getY();
		_ghostSaveMapId = getMapId();
		_ghostSaveHeading = getHeading();
		setGhostCanTalk(canTalk);
		L1Teleport.teleport(this, locx, locy, mapid, 5, true);
		if (sec > 0) {
			_ghostFuture = GeneralThreadPool.getInstance().pcSchedule(new L1PcGhostMonitor(getId()), sec * 1000);
		}
	}

	/** PK 值过高传送到地狱 */
	public void beginHell(final boolean isFirst) {
		// 坐标非地狱则强制传送到地狱地图
		if (getMapId() != 666) {
			final int locx = 32701;
			final int locy = 32777;
			final short mapid = 666;
			L1Teleport.teleport(this, locx, locy, mapid, 5, false);
		}

		if (isFirst) {
			if (get_PKcount() <= 10) {
				setHellTime(300);
			}
			else {
				setHellTime(300 * (get_PKcount() - 10) + 300);
			}
			// 因为你已经杀了 %0 人所以被打入地狱。 你将在这里停留 %1 分钟。
			sendPackets(new S_BlueMessage(552, String.valueOf(get_PKcount()), String.valueOf(getHellTime() / 60)));
		}
		else {
			// 你必须在此地停留 %0 秒。
			sendPackets(new S_BlueMessage(637, String.valueOf(getHellTime())));
		}
		if (_hellFuture == null) {
			_hellFuture = GeneralThreadPool.getInstance().pcScheduleAtFixedRate(new L1PcHellMonitor(getId()), 0L, 1000L);
		}
	}

	/** 开始隐身计时器 */
	public void beginInvisTimer() {
		addInvisDelayCounter(1);
		GeneralThreadPool.getInstance().pcSchedule(new L1PcInvisDelay(getId()), DELAY_INVIS);
	}

	/**
	 * 什么都不能做的状态 (无法离线、无法移动、无法使用道具等)
	 * 
	 * @return
	 */
	public boolean CanNotDoAnything() {
		return (/*
				 * hasSkillEffect(IMMUNE_TO_HARM) // 法师魔法 (圣结界) 测试用
				 * ||
				 */
		hasSkillEffect(STATUS_CURSE_PARALYZED) // 麻痹毒(木乃伊诅咒)后
				|| hasSkillEffect(ICE_LANCE) // 法师魔法 (冰矛围篱)
				|| hasSkillEffect(FREEZING_BLIZZARD) // 法师魔法 (冰雪飓风)
				|| hasSkillEffect(ICE_LANCE_COCKATRICE) // 亚力安冰矛围篱
				|| hasSkillEffect(ICE_LANCE_BASILISK) // 邪恶蜥蜴冰矛围篱
				|| hasSkillEffect(FOG_OF_SLEEPING) // 法师魔法 (沉睡之雾)
				|| hasSkillEffect(SHOCK_STUN) // 骑士魔法 (冲击之晕)
				|| hasSkillEffect(EARTH_BIND) // 妖精魔法 (大地屏障)
				|| hasSkillEffect(SHOCK_SKIN) // 龙骑士魔法 (冲击之肤) 冲晕效果
		|| hasSkillEffect(FREEZING_BREATH)); // 龙骑士魔法 (寒冰喷吐)
	}

	/**
	 * 是否在參加攻城战中
	 * 
	 * @return true:是 false:不是
	 */
	public boolean castleWarResult() {
		if ((getClanid() != 0) && isCrown()) { // 有血盟并且是王族
			final L1Clan clan = L1World.getInstance().getClan(getClanname());
			// 取得全部战争列表
			for (final L1War war : L1World.getInstance().getWarList()) {
				final int warType = war.GetWarType();
				final boolean isInWar = war.CheckClanInWar(getClanname());
				final boolean isAttackClan = war.CheckAttackClan(getClanname());
				if ((getId() == clan.getLeaderId()) && // 血盟主で攻击侧で攻城战中
						(warType == 1) && isInWar && isAttackClan) {
					final String enemyClanName = war.GetEnemyClanName(getClanname());
					if (enemyClanName != null) {
						war.CeaseWar(getClanname(), enemyClanName); // 终结
					}
					break;
				}
			}
		}

		int castleId = 0;
		boolean isNowWar = false;
		castleId = L1CastleLocation.getCastleIdByArea(this);
		if (castleId != 0) { // 旗内に居る
			isNowWar = WarTimeController.getInstance().isNowWar(castleId);
		}
		return isNowWar;
	}

	/****************************** 战斗特化系统 ******************************/
	// 改变战斗特化状态
	public void changeFightType(final int oldType, final int newType) {
		// 消除既有的战斗特化状态
		switch (oldType) {
			case 1:
				addAc(2);
				addMr(-3);
				sendPackets(new S_OwnCharStatus2(this)); // 更新六项能力值
				sendPackets(new S_OwnCharAttrDef(this)); // 更新物理防显示
				sendPackets(new S_SPMR(this)); // 更新魔防及魔攻显示
				sendPackets(new S_Fight(S_Fight.TYPE_JUSTICE_LEVEL1, S_Fight.FLAG_OFF));
				break;

			case 2:
				addAc(4);
				addMr(-6);
				sendPackets(new S_OwnCharStatus2(this)); // 更新六项能力值
				sendPackets(new S_OwnCharAttrDef(this)); // 更新物理防显示
				sendPackets(new S_SPMR(this)); // 更新魔防及魔攻显示
				sendPackets(new S_Fight(S_Fight.TYPE_JUSTICE_LEVEL2, S_Fight.FLAG_OFF));
				break;

			case 3:
				addAc(6);
				addMr(-9);
				sendPackets(new S_OwnCharStatus2(this)); // 更新六项能力值
				sendPackets(new S_OwnCharAttrDef(this)); // 更新物理防显示
				sendPackets(new S_SPMR(this)); // 更新魔防及魔攻显示
				sendPackets(new S_Fight(S_Fight.TYPE_JUSTICE_LEVEL3, S_Fight.FLAG_OFF));
				break;

			case -1:
				addDmgup(-1);
				addBowDmgup(-1);
				addSp(-1);
				sendPackets(new S_OwnCharStatus2(this)); // 更新六项能力值
				sendPackets(new S_OwnCharAttrDef(this)); // 更新物理防显示
				sendPackets(new S_SPMR(this)); // 更新魔防及魔攻显示
				sendPackets(new S_Fight(S_Fight.TYPE_EVIL_LEVEL1, S_Fight.FLAG_OFF));
				break;

			case -2:
				addDmgup(-3);
				addBowDmgup(-3);
				addSp(-2);
				sendPackets(new S_OwnCharStatus2(this)); // 更新六项能力值
				sendPackets(new S_OwnCharAttrDef(this)); // 更新物理防显示
				sendPackets(new S_SPMR(this)); // 更新魔防及魔攻显示
				sendPackets(new S_Fight(S_Fight.TYPE_EVIL_LEVEL2, S_Fight.FLAG_OFF));
				break;

			case -3:
				addDmgup(-5);
				addBowDmgup(-5);
				addSp(-3);
				sendPackets(new S_OwnCharStatus2(this)); // 更新六项能力值
				sendPackets(new S_OwnCharAttrDef(this)); // 更新物理防显示
				sendPackets(new S_SPMR(this)); // 更新魔防及魔攻显示
				sendPackets(new S_Fight(S_Fight.TYPE_EVIL_LEVEL3, S_Fight.FLAG_OFF));
				break;
		}

		// 增加新的战斗特化状态
		switch (newType) {
			case 1:
				addAc(-2);
				addMr(3);
				sendPackets(new S_OwnCharStatus2(this)); // 更新六项能力值
				sendPackets(new S_OwnCharAttrDef(this)); // 更新物理防显示
				sendPackets(new S_SPMR(this)); // 更新魔防及魔攻显示
				sendPackets(new S_Fight(S_Fight.TYPE_JUSTICE_LEVEL1, S_Fight.FLAG_ON));
				break;

			case 2:
				addAc(-4);
				addMr(6);
				sendPackets(new S_OwnCharStatus2(this)); // 更新六项能力值
				sendPackets(new S_OwnCharAttrDef(this)); // 更新物理防显示
				sendPackets(new S_SPMR(this)); // 更新魔防及魔攻显示
				sendPackets(new S_Fight(S_Fight.TYPE_JUSTICE_LEVEL2, S_Fight.FLAG_ON));
				break;

			case 3:
				addAc(-6);
				addMr(9);
				sendPackets(new S_OwnCharStatus2(this)); // 更新六项能力值
				sendPackets(new S_OwnCharAttrDef(this)); // 更新物理防显示
				sendPackets(new S_SPMR(this)); // 更新魔防及魔攻显示
				sendPackets(new S_Fight(S_Fight.TYPE_JUSTICE_LEVEL3, S_Fight.FLAG_ON));
				break;

			case -1:
				addDmgup(1);
				addBowDmgup(1);
				addSp(1);
				sendPackets(new S_OwnCharStatus2(this)); // 更新六项能力值
				sendPackets(new S_OwnCharAttrDef(this)); // 更新物理防显示
				sendPackets(new S_SPMR(this)); // 更新魔防及魔攻显示
				sendPackets(new S_Fight(S_Fight.TYPE_EVIL_LEVEL1, S_Fight.FLAG_ON));
				break;

			case -2:
				addDmgup(3);
				addBowDmgup(3);
				addSp(2);
				sendPackets(new S_OwnCharStatus2(this)); // 更新六项能力值
				sendPackets(new S_OwnCharAttrDef(this)); // 更新物理防显示
				sendPackets(new S_SPMR(this)); // 更新魔防及魔攻显示
				sendPackets(new S_Fight(S_Fight.TYPE_EVIL_LEVEL2, S_Fight.FLAG_ON));
				break;

			case -3:
				addDmgup(5);
				addBowDmgup(5);
				addSp(3);
				sendPackets(new S_OwnCharStatus2(this)); // 更新六项能力值
				sendPackets(new S_OwnCharAttrDef(this)); // 更新物理防显示
				sendPackets(new S_SPMR(this)); // 更新魔防及魔攻显示
				sendPackets(new S_Fight(S_Fight.TYPE_EVIL_LEVEL3, S_Fight.FLAG_ON));
				break;
		}
	}

	/** 检查聊天间隔 */
	public void checkChatInterval() {
		final long nowChatTimeInMillis = System.currentTimeMillis();
		if (_chatCount == 0) {
			_chatCount++;
			_oldChatTimeInMillis = nowChatTimeInMillis;
			return;
		}

		final long chatInterval = nowChatTimeInMillis - _oldChatTimeInMillis;
		if (chatInterval > 2000) {
			_chatCount = 0;
			_oldChatTimeInMillis = 0;
		}
		else {
			if (_chatCount >= 3) {
				setSkillEffect(STATUS_CHAT_PROHIBITED, 120 * 1000);
				sendPackets(new S_SkillIconGFX(36, 120));
				sendPackets(new S_ServerMessage(153)); // \f3因洗画面的关系，2分钟之内无法聊天。
				_chatCount = 0;
				_oldChatTimeInMillis = 0;
			}
			_chatCount++;
		}
	}

	/**
	 * 检查武器与防具该职业能否使用
	 * 
	 * @param useItem
	 *            使用的装备
	 * @return 如果该职业可用、true
	 */
	public boolean checkEquipped(final L1ItemInstance useItem) {

		// 是否能装备
		boolean isEquipped = false;

		// 王族
		if (isCrown()) {
			if (useItem.getItem().isUseRoyal()) {
				isEquipped = true;
			}
		}

		// 骑士
		else if (isKnight()) {
			if (useItem.getItem().isUseKnight()) {
				isEquipped = true;
			}
		}

		// 精灵
		else if (isElf()) {
			if (useItem.getItem().isUseElf()) {
				isEquipped = true;
			}
		}

		// 法师
		else if (isWizard()) {
			if (useItem.getItem().isUseMage()) {
				isEquipped = true;
			}
		}

		// 黑暗精灵
		else if (isDarkelf()) {
			if (useItem.getItem().isUseDarkelf()) {
				isEquipped = true;
			}
		}

		// 龙骑士
		else if (isDragonKnight()) {
			if (useItem.getItem().isUseDragonknight()) {
				isEquipped = true;
			}
		}

		// 幻术师
		else if (isIllusionist()) {
			if (useItem.getItem().isUseIllusionist()) {
				isEquipped = true;
			}
		}

		// 该职业不可用
		if (!isEquipped) {
			sendPackets(new S_ServerMessage(264)); // \f1你的职业无法使用此装备。
		}

		return isEquipped;
	}

	/**
	 * 检查是否可以攻击
	 * 
	 * @param pc
	 * @param target
	 * @return
	 */
	public boolean checkNonPvP(final L1PcInstance pc, final L1Character target) {
		L1PcInstance targetpc = null;
		if (target instanceof L1PcInstance) {
			targetpc = (L1PcInstance) target;
		}
		else if (target instanceof L1PetInstance) {
			targetpc = (L1PcInstance) ((L1PetInstance) target).getMaster();
		}
		else if (target instanceof L1SummonInstance) {
			targetpc = (L1PcInstance) ((L1SummonInstance) target).getMaster();
		}
		if (targetpc == null) {
			return false; // 组队的PC、召唤、宠物以外
		}
		if (!Config.ALT_NONPVP) { // Non-PvP设定
			if (getMap().isCombatZone(getLocation())) {
				return false;
			}

			// 取得所有战争列表
			for (final L1War war : L1World.getInstance().getWarList()) {
				if ((pc.getClanid() != 0) && (targetpc.getClanid() != 0)) { // 两方都有血盟
					final boolean same_war = war.CheckClanInSameWar(pc.getClanname(), targetpc.getClanname());
					if (same_war == true) { // 参加同一场战争中
						return false;
					}
				}
			}
			// Non-PvP设定でも战争中は布告なしで攻击可能
			if (target instanceof L1PcInstance) {
				final L1PcInstance targetPc = (L1PcInstance) target;
				if (isInWarAreaAndWarTime(pc, targetPc)) {
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
	}

	/** 确认是否属于新手, 并设定相关状态 */
	public void checkNoviceType() {
		// 判断是否启动新手保护系统(遭遇的守护)
		if (!Config.NOVICE_PROTECTION_IS_ACTIVE) {
			return;
		}

		// 判断目前等级是否已超过新手阶段
		if (getLevel() > Config.NOVICE_MAX_LEVEL) {
			// 判断之前是否具有新手保护状态
			if (hasSkillEffect(L1SkillId.STATUS_NOVICE)) {
				// 移除新手保护状态
				removeSkillEffect(L1SkillId.STATUS_NOVICE);

				// 关闭遭遇的守护图示
				sendPackets(new S_Fight(S_Fight.TYPE_ENCOUNTER, S_Fight.FLAG_OFF));
			}
		}
		else {
			// 判断是否未具有新手保护状态
			if (!hasSkillEffect(L1SkillId.STATUS_NOVICE)) {
				// 增加新手保护状态
				setSkillEffect(L1SkillId.STATUS_NOVICE, 0);

				// 开启遭遇的守护图示
				sendPackets(new S_Fight(S_Fight.TYPE_ENCOUNTER, S_Fight.FLAG_ON));
			}
		}
	}

	/**  */
	public void clearSkillMastery() {
		skillList.clear();
	}

	/**
	 * 产生新道具
	 * 
	 * @param pc
	 *            对象
	 * @param item_id
	 *            道具ID
	 * @param count
	 *            道具数量
	 */
	public boolean createNewItem(final L1PcInstance pc, final int item_id, final int count) {
		final L1ItemInstance item = ItemTable.getInstance().createItem(item_id);
		if (item != null) {
			item.setCount(count);
			if (pc.getInventory().checkAddItem(item, count) == L1Inventory.OK) {
				pc.getInventory().storeItem(item);
			}
			else { // 背包道具满掉落地面（不正防止）
				L1World.getInstance().getInventory(pc.getX(), pc.getY(), pc.getMapId()).storeItem(item);
			}
			pc.sendPackets(new S_ServerMessage(403, item.getLogName())); // 获得%0%o 。
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 死亡处理
	 * 
	 * @param lastAttacker
	 *            攻击致死的攻击者
	 */
	public void death(final L1Character lastAttacker) {
		synchronized (this) {
			if (isDead()) {
				return;
			}
			setDead(true);
			setStatus(ActionCodes.ACTION_Die); // 死亡动作
		}
		GeneralThreadPool.getInstance().execute(new Death(lastAttacker));

	}

	/**
	 * 角色死亡经验值处罚
	 */
	public void deathPenalty() {
		final int oldLevel = getLevel();
		final long needExp = ExpTable.getNeedExpNextLevel(oldLevel);
		long exp = 0;
		if ((oldLevel >= 1) && (oldLevel < 11)) {
			exp = 0;
		}
		else if ((oldLevel >= 11) && (oldLevel < 45)) {
			exp = (long) (needExp * 0.1);
		}
		else if (oldLevel == 45) {
			exp = (long) (needExp * 0.09);
		}
		else if (oldLevel == 46) {
			exp = (long) (needExp * 0.08);
		}
		else if (oldLevel == 47) {
			exp = (long) (needExp * 0.07);
		}
		else if (oldLevel == 48) {
			exp = (long) (needExp * 0.06);
		}
		else if (oldLevel >= 49) {
			exp = (long) (needExp * 0.05);
		}

		if (exp == 0) {
			return;
		}

		if (getExpRes() >= 0) {
			setExpRes(getExpRes() + 1);
		}
		addExp(-exp);
	}

	/**
	 * 解除绝对屏障状态
	 */
	public void delAbsoluteBarrier() {
		if (hasSkillEffect(ABSOLUTE_BARRIER)) {
			killSkillEffectTimer(ABSOLUTE_BARRIER);
			startHpRegeneration(); // 开始角色回血
			startMpRegeneration(); // 开始角色回魔
			startHpRegenerationByDoll(); // 开始魔法娃娃对角色的回血
			startMpRegenerationByDoll(); // 开始魔法娃娃对角色的回魔
		}
	}

	/**
	 * 解除暗隐术
	 */
	public void delBlindHiding() {
		// 魔法接续时间终了はこちら
		killSkillEffectTimer(BLIND_HIDING); // 黑暗妖精魔法 (暗隐术)
		sendPackets(new S_Invis(getId(), 0));
		broadcastPacket(new S_OtherCharPacks(this));
	}

	/**
	 * 删除重复的一段加速效果 (绿色药水)
	 * 
	 * @param skill_id
	 *            技能ID
	 */
	public void delEffectOfGreenPotion(final int skill_id) {
		if (hasSkillEffect(skill_id)) {
			killSkillEffectTimer(skill_id);
			sendPackets(new S_SkillHaste(getId(), 0, 0));
			broadcastPacket(new S_SkillHaste(getId(), 0, 0));
			setMoveSpeed(0);
		}
	}

	/**
	 * 删除重复的缓速效果
	 * 
	 * @param skill_id
	 *            技能ID
	 */
	public void delEffectOfSlow(final int skill_id) {
		if (hasSkillEffect(skill_id)) {
			killSkillEffectTimer(skill_id);
			sendPackets(new S_SkillHaste(getId(), 0, 0));
			broadcastPacket(new S_SkillHaste(getId(), 0, 0));
		}
	}

	/**
	 * 设定不可重复的魔法状态 (经验药水、魔眼等等)
	 * 
	 * @param skillId
	 *            技能ID
	 */
	public void deleteRepeatedSkills(final int skillId) {
		final int[][] repeatedSkills = {
				// 经验加成状态
				{ EFFECT_POTION_OF_EXP_150, EFFECT_POTION_OF_EXP_175, EFFECT_POTION_OF_EXP_200, EFFECT_POTION_OF_EXP_225, EFFECT_POTION_OF_EXP_250, EFFECT_POTION_OF_BATTLE },
				// 体力增强卷轴、魔力增强卷轴、强化战斗卷
				{ EFFECT_STRENGTHENING_HP, EFFECT_STRENGTHENING_MP, EFFECT_ENCHANTING_BATTLE },
				// 火焰武器、风之神射、烈炎气息、暴风之眼、烈炎武器、暴风神射、妈祖的祝福
				{ FIRE_WEAPON, WIND_SHOT, FIRE_BLESS, STORM_EYE, BURNING_WEAPON, STORM_SHOT, EFFECT_BLESS_OF_MAZU },
				// 1 ~ 9 阶附魔石(近战)(远攻)(恢复)(防御)
				{ EFFECT_MAGIC_STONE_A_1, EFFECT_MAGIC_STONE_A_2, EFFECT_MAGIC_STONE_A_3, EFFECT_MAGIC_STONE_A_4, EFFECT_MAGIC_STONE_A_5, EFFECT_MAGIC_STONE_A_6, EFFECT_MAGIC_STONE_A_7, EFFECT_MAGIC_STONE_A_8, EFFECT_MAGIC_STONE_A_9, EFFECT_MAGIC_STONE_B_1,
						EFFECT_MAGIC_STONE_B_2, EFFECT_MAGIC_STONE_B_3, EFFECT_MAGIC_STONE_B_4, EFFECT_MAGIC_STONE_B_5, EFFECT_MAGIC_STONE_B_6, EFFECT_MAGIC_STONE_B_7, EFFECT_MAGIC_STONE_B_8, EFFECT_MAGIC_STONE_B_9, EFFECT_MAGIC_STONE_C_1, EFFECT_MAGIC_STONE_C_2,
						EFFECT_MAGIC_STONE_C_3, EFFECT_MAGIC_STONE_C_4, EFFECT_MAGIC_STONE_C_5, EFFECT_MAGIC_STONE_C_6, EFFECT_MAGIC_STONE_C_7, EFFECT_MAGIC_STONE_C_8, EFFECT_MAGIC_STONE_C_9, EFFECT_MAGIC_STONE_D_1, EFFECT_MAGIC_STONE_D_2, EFFECT_MAGIC_STONE_D_3,
						EFFECT_MAGIC_STONE_D_4, EFFECT_MAGIC_STONE_D_5, EFFECT_MAGIC_STONE_D_6, EFFECT_MAGIC_STONE_D_7, EFFECT_MAGIC_STONE_D_8, EFFECT_MAGIC_STONE_D_9 },
				// 魔眼
				{ EFFECT_MAGIC_EYE_OF_AHTHARTS, EFFECT_MAGIC_EYE_OF_FAFURION, EFFECT_MAGIC_EYE_OF_LINDVIOR, EFFECT_MAGIC_EYE_OF_VALAKAS, EFFECT_MAGIC_EYE_OF_BIRTH, EFFECT_MAGIC_EYE_OF_FIGURE, EFFECT_MAGIC_EYE_OF_LIFE } };

		for (final int[] skills : repeatedSkills) {
			for (final int id : skills) {
				if (id == skillId) {
					stopSkillList(skillId, skills);
				}
			}
		}
	}

	/**
	 * 解除隐形状态
	 */
	public void delInvis() {
		// 魔法接续时间内はこちらを利用
		if (hasSkillEffect(INVISIBILITY)) { // 法师魔法 (隐身术)
			killSkillEffectTimer(INVISIBILITY);
			sendPackets(new S_Invis(getId(), 0));
			broadcastPacket(new S_OtherCharPacks(this));
		}
		if (hasSkillEffect(BLIND_HIDING)) { // 黑暗妖精魔法 (暗隐术)
			killSkillEffectTimer(BLIND_HIDING);
			sendPackets(new S_Invis(getId(), 0));
			broadcastPacket(new S_OtherCharPacks(this));
		}
	}

	/**
	 * 取消冥想效果
	 */
	public void delMeditation() {
		if (hasSkillEffect(MEDITATION)) {
			removeSkillEffect(MEDITATION);
		}
	}

	/**
	 * 删除重复的技能效果
	 * 
	 * @param skill_id
	 *            要删除的技能编号
	 */
	public void delRepeatSkillEffect(final int skill_id) {
		if (hasSkillEffect(skill_id)) {
			killSkillEffectTimer(skill_id);
		}
	}

	/**
	 * 结束幽灵状态
	 */
	public void endGhost() {
		setGhost(false);
		setGhostCanTalk(true);
		setReserveGhost(false);
	}

	/** 传送出地狱 */
	public void endHell() {
		if (_hellFuture != null) {
			_hellFuture.cancel(false);
			_hellFuture = null;
		}
		// 从地狱出来后传送到燃柳村。
		final int[] loc = L1TownLocation.getGetBackLoc(L1TownLocation.TOWNID_ORCISH_FOREST);
		L1Teleport.teleport(this, loc[0], loc[1], (short) loc[2], 5, true);
		try {
			save();
		}
		catch (final Exception ignore) {
			// ignore
		}
	}

	/** 取得PK次数 */
	public int get_PKcount() {
		return _PKcount;
	}

	/** 取得性别 */
	public byte get_sex() {
		return _sex;
	}

	/** 取得 -- 加速器检知机能 -- */
	public AcceleratorChecker getAcceleratorChecker() {
		return _acceleratorChecker;
	}

	/** 取得账号等级 */
	public short getAccessLevel() {
		return _accessLevel;
	}

	/** 取得账号名称 */
	public String getAccountName() {
		return _accountName;
	}

	/** 取得灵魂升华增加的HP */
	public int getAdvenHp() {
		return _advenHp;
	}

	/** 取得灵魂升华增加的MP */
	public int getAdvenMp() {
		return _advenMp;
	}

	/** 取得觉醒技能ID */
	public int getAwakeSkillId() {
		return _awakeSkillId;
	}

	/** 取得基本Ac */
	public int getBaseAc() {
		return _baseAc;
	}

	/** 取得弓类基本伤害补正 */
	public int getBaseBowDmgup() {
		return _baseBowDmgup;
	}

	/** 取得弓基本命中补正 */
	public int getBaseBowHitup() {
		return _baseBowHitup;
	}

	/** 取得基本的魅力值 */
	public short getBaseCha() {
		return _baseCha;
	}

	/** 取得基本的体质值 */
	public short getBaseCon() {
		return _baseCon;
	}

	/** 取得基本的敏捷值 */
	public short getBaseDex() {
		return _baseDex;
	}

	/** 取得基本伤害补正 */
	public int getBaseDmgup() {
		return _baseDmgup;
	}

	/** 取得基本命中补正 */
	public int getBaseHitup() {
		return _baseHitup;
	}

	/** 取得基本的智力值 */
	public short getBaseInt() {
		return _baseInt;
	}

	/** 取得基本MaxHp */
	public short getBaseMaxHp() {
		return _baseMaxHp;
	}

	/** 取得基本MaxMp */
	public short getBaseMaxMp() {
		return _baseMaxMp;
	}

	/** 取得基本魔法防御 */
	public int getBaseMr() {
		return _baseMr;
	}

	/** 取得基本的力量值 */
	public short getBaseStr() {
		return _baseStr;
	}

	/** 取得基本的精神值 */
	public short getBaseWis() {
		return _baseWis;
	}

	/** 取得角色生日 */
	public Timestamp getBirthday() {
		return _birthday;
	}

	/** 取得奖励点分配状况 */
	public int getBonusStats() {
		return _bonusStats;
	}

	/** 取得书签ID */
	public L1BookMark getBookMark(final int id) {
		for (int i = 0; i < _bookmarks.size(); i++) {
			final L1BookMark element = _bookmarks.get(i);
			if (element.getId() == id) {
				return element;
			}

		}
		return null;
	}

	/** 取得书签名字 */
	public L1BookMark getBookMark(final String name) {
		for (int i = 0; i < _bookmarks.size(); i++) {
			final L1BookMark element = _bookmarks.get(i);
			if (element.getName().equalsIgnoreCase(name)) {
				return element;
			}

		}
		return null;
	}

	/** 取得书签大小 */
	public int getBookMarkSize() {
		return _bookmarks.size();
	}

	/** 取得防具对损坏的弓的补正 */
	public int getBowDmgModifierByArmor() {
		return _bowDmgModifierByArmor;
	}

	/** 取得防具对弓的命中率补正 */
	public int getBowHitModifierByArmor() {
		return _bowHitModifierByArmor;
	}

	/** 取得购买清单 */
	public List<L1PrivateShopBuyList> getBuyList() {
		return _buyList;
	}

	/** 取得呼叫血盟名称 */
	public int getCallClanHeading() {
		return _callClanHeading;
	}

	/** 取得呼叫血盟ID */
	public int getCallClanId() {
		return _callClanId;
	}

	/** 取得聊天组队 */
	public L1ChatParty getChatParty() {
		return _chatParty;
	}

	// 参照を持つようにしたほうがいいかもしれない
	public L1Clan getClan() {
		return L1World.getInstance().getClan(getClanname());
	}

	/** 取得血盟 ID */
	public int getClanid() {
		return _clanid;
	}

	/** 取得血盟名称 */
	public String getClanname() {
		return clanname;
	}

	/** 取得血盟内的阶级(联盟君主、守护骑士、一般、见习) */
	public int getClanRank() {
		return _clanRank;
	}

	public L1ClassFeature getClassFeature() {
		return _classFeature;
	}

	/** 取得角色的ClassId */
	public int getClassId() {
		return _classId;
	}

	/** 取得贡献度 */
	public int getContribution() {
		return _contribution;
	}

	/** 取得烹饪ID */
	public int getCookingId() {
		return _cookingId;
	}

	/** 取得当前武器 */
	public int getCurrentWeapon() {
		return _currentWeapon;
	}

	/** 取得防具的伤害减免 */
	public int getDamageReductionByArmor() {
		return _damageReductionByArmor;
	}

	/** 取得角色删除时间 */
	public Timestamp getDeleteTime() {
		return _deleteTime;
	}

	/** 取得点心ID */
	public int getDessertId() {
		return _dessertId;
	}

	/** 取得防具的伤害补正 */
	public int getDmgModifierByArmor() {
		return _dmgModifierByArmor;
	}

	/**  */
	public L1DwarfForElfInventory getDwarfForElfInventory() {
		return _dwarfForElf;
	}

	/**  */
	public L1DwarfInventory getDwarfInventory() {
		return _dwarf;
	}

	/** 取得精灵属性 */
	public int getElfAttr() {
		return _elfAttr;
	}

	/**
	 * 取得万能药使用状况
	 */
	public int getElixirStats() {
		return _elixirStats;
	}

	public L1EquipmentSlot getEquipSlot() {
		return _equipSlot;
	}

	/** 回避率变化 */
	public int getEr() {
		if (hasSkillEffect(STRIKER_GALE)) { // 精准射击
			return 0;
		}

		int er = 0;
		if (isKnight()) {
			er = getLevel() / 4; // 骑士
		}
		else if (isCrown() || isElf()) {
			er = getLevel() / 8; // 王族・精灵
		}
		else if (isDarkelf()) {
			er = getLevel() / 6; // 黑暗精灵
		}
		else if (isWizard()) {
			er = getLevel() / 10; // 魔法师
		}
		else if (isDragonKnight()) {
			er = getLevel() / 7; // 龙骑士
		}
		else if (isIllusionist()) {
			er = getLevel() / 9; // 幻术师
		}

		er += (getDex() - 8) / 2;

		er += getOriginalEr();

		if (hasSkillEffect(DRESS_EVASION)) { // 闪避提升
			er += 12;
		}
		if (hasSkillEffect(SOLID_CARRIAGE)) { // 坚固防护
			er += 15;
		}
		return er;
	}

	/**
	 * 取得角色讯息拒绝名单
	 * 
	 * @return
	 */
	public L1ExcludingList getExcludingList() {
		return _excludingList;
	}

	@Override
	public synchronized long getExp() {
		return _exp;
	}

	/** 取得恢复EXP */
	public int getExpRes() {
		return _expRes;
	}

	/** 取得战斗ID */
	public int getFightId() {
		return _fightId;
	}

	/** 取得钓鱼时间 */
	public long getFishingTime() {
		return _fishingTime;
	}

	/** 取得钓鱼坐标X */
	public int getFishX() {
		return _fishX;
	}

	/** 取得钓鱼坐标Y */
	public int getFishY() {
		return _fishY;
	}

	/** 取得装备加速道具 */
	public int getHasteItemEquipped() {
		return _hasteItemEquipped;
	}

	/** 取得地狱停留时间 (秒) */
	public int getHellTime() {
		return _hellTime;
	}

	/** 取得过去最高等级 */
	public int getHighLevel() {
		return _highLevel;
	}

	/** 取得防具的命中率补正 */
	public int getHitModifierByArmor() {
		return _hitModifierByArmor;
	}

	/** 取得所住村镇ID */
	public int getHomeTownId() {
		return _homeTownId;
	}

	/** 取得回血 */
	public short getHpr() {
		return _hpr;
	}

	@Override
	public L1PcInventory getInventory() {
		return _inventory;
	}

	@Override
	public int getKarma() {
		return _karma.get();
	}

	/** 取得友好度级别 */
	public int getKarmaLevel() {
		return _karma.getLevel();
	}

	/** 取得友好度的百分比 */
	public int getKarmaPercent() {
		return _karma.getPercent();
	}

	/** 取得宠物竞速圈数 */
	public int getLap() {
		return _lap;
	}

	/** 取得检查宠物竞速圈数 */
	public int getLapCheck() {
		return _lapCheck;
	}

	/**
	 * 只是将总圈数的完程度数量化
	 */
	public int getLapScore() {
		return _lap * 29 + _lapCheck;
	}

	/**
	 * 取得玩家的最后PK时间。
	 * 
	 * @return _lastPk
	 * 
	 */
	public Timestamp getLastPk() {
		return _lastPk;
	}

	public Timestamp getLastPkForElf() {
		return _lastPkForElf;
	}

	@Override
	public int getMagicLevel() {
		return getClassFeature().getMagicLevel(getLevel());
	}

	/** 取得最高负重 */
	public double getMaxWeight() {
		final int str = getStr();
		final int con = getCon();
		double maxWeight = 150 * (Math.floor(0.6 * str + 0.4 * con + 1));

		double weightReductionByArmor = getWeightReduction(); // 防具的负重减轻
		weightReductionByArmor /= 100;

		double weightReductionByDoll = 0; // 魔法娃娃负重减轻
		weightReductionByDoll += L1MagicDoll.getWeightReductionByDoll(this);
		weightReductionByDoll /= 100;

		int weightReductionByMagic = 0;
		if (hasSkillEffect(DECREASE_WEIGHT)) { // 负重强化
			weightReductionByMagic = 180;
		}

		double originalWeightReduction = 0; // 原始状态的负重减轻
		originalWeightReduction += 0.04 * (getOriginalStrWeightReduction() + getOriginalConWeightReduction());

		final double weightReduction = 1 + weightReductionByArmor + weightReductionByDoll + originalWeightReduction;

		maxWeight *= weightReduction;

		maxWeight += weightReductionByMagic;

		maxWeight *= Config.RATE_WEIGHT_LIMIT; // 最大负重倍率

		return maxWeight;
	}

	/** 取得回魔 */
	public short getMpr() {
		return _mpr;
	}

	/** 网络连接状态 */
	public ClientThread getNetConnection() {
		return _netConnection;
	}

	/** 取得在线状态 */
	public int getOnlineStatus() {
		return _onlineStatus;
	}

	/** 取得原始DEX ＡＣ补正 */
	public int getOriginalAc() {

		return _originalAc;
	}

	/** 取得原始DEX 弓伤害补正 */
	public int getOriginalBowDmgup() {
		return _originalBowDmgup;
	}

	/** 取得原始DEX 命中补正 */
	public int getOriginalBowHitup() {
		return _originalBowHitup;
	}

	/** 取得原始的魅力值 */
	public int getOriginalCha() {
		return _originalCha;
	}

	/** 取得原始的体质值 */
	public int getOriginalCon() {
		return _originalCon;
	}

	/** 取得原始CON 重量轻减 */
	public int getOriginalConWeightReduction() {
		return _originalConWeightReduction;
	}

	/** 取得原始的敏捷值 */
	public int getOriginalDex() {
		return _originalDex;
	}

	/** 取得原始STR 伤害补正 */
	public int getOriginalDmgup() {
		return _originalDmgup;
	}

	/** 取得原始DEX ER补正 */
	public int getOriginalEr() {
		return _originalEr;
	}

	/** 取得原始STR 命中补正 */
	public int getOriginalHitup() {
		return _originalHitup;
	}

	/** 取得原始 CON HPR */
	public short getOriginalHpr() {
		return _originalHpr;
	}

	/** 取得原始CON HP上升值补正 */
	public int getOriginalHpup() {
		return _originalHpup;
	}

	/** 取得原始的智力值 */
	public int getOriginalInt() {
		return _originalInt;
	}

	/** 取得原始INT 消费MP轻减 */
	public int getOriginalMagicConsumeReduction() {
		return _originalMagicConsumeReduction;
	}

	/**  */
	public int getOriginalMagicCritical() {
		return _originalMagicCritical;
	}

	/** 取得原始INT的魔法伤害 */
	public int getOriginalMagicDamage() {
		return _originalMagicDamage;
	}

	/** 取得原始INT 魔法命中 */
	public int getOriginalMagicHit() {
		return _originalMagicHit;
	}

	/** 取得原始 WIS MPR */
	public short getOriginalMpr() {
		return _originalMpr;
	}

	/** 取得原始WIS MP上升值补正 */
	public int getOriginalMpup() {
		return _originalMpup;
	}

	/** 取得原始WIS 魔法防御 */
	public int getOriginalMr() {
		return _originalMr;
	}

	/** 取得原始的力量值 */
	public int getOriginalStr() {
		return _originalStr;
	}

	/** 取得原始STR 重量轻减 */
	public int getOriginalStrWeightReduction() {
		return _originalStrWeightReduction;
	}

	/** 取得原始的精神值 */
	public int getOriginalWis() {
		return _originalWis;
	}

	/** 取得结婚伴侣ID */
	public int getPartnerId() {
		return _partnerId;
	}

	/**
	 * 取得出售物品种类数量
	 */
	public int getPartnersPrivateShopItemCount() {
		return _partnersPrivateShopItemCount;
	}

	/** 取得组队 */
	public L1Party getParty() {
		return _party;
	}

	/** 取得组队ID */
	public int getPartyID() {
		return _partyID;
	}

	/** 取得组队类型 */
	public int getPartyType() {
		return _partyType;
	}

	/** 取得村庄福利金 */
	public int getPay() {
		return _pay;
	}

	/** 取得PK次数 (精灵用) */
	public int getPkCountForElf() {
		return _PkCountForElf;
	}

	/** 取得任务 */
	public L1Quest getQuest() {
		return _quest;
	}

	/** 取得贩卖清单 */
	public List<L1PrivateShopSellList> getSellList() {
		return _sellList;
	}

	/** 取得商店聊天 */
	public byte[] getShopChat() {
		return _shopChat;
	}

	/** 取得简单的角色生日 */
	public int getSimpleBirthday() {
		if (_birthday != null) {
			final SimpleDateFormat SimpleDate = new SimpleDateFormat("yyyyMMdd");
			final int BornTime = Integer.parseInt(SimpleDate.format(_birthday.getTime()));
			return BornTime;
		}
		else {
			return 0;
		}
	}

	/** 取得传送目的地面向 */
	public int getTeleportHeading() {
		return _teleportHeading;
	}

	/** 取得传送目的地地图ID */
	public short getTeleportMapId() {
		return _teleportMapId;
	}

	/**
	 * 取得传送目的地坐标X
	 */
	public int getTeleportX() {
		return _teleportX;
	}

	/**
	 * 取得传送目的地坐标Y
	 */
	public int getTeleportY() {
		return _teleportY;
	}

	/** 取得角色死亡时的临时GFX图像 */
	public int getTempCharGfxAtDead() {
		return _tempCharGfxAtDead;
	}

	/** 取得临时ID */
	public int getTempID() {
		return _tempID;
	}

	/** 取得临时等级 */
	public int getTempLevel() {
		return _tempLevel;
	}

	/** 取得临时最高等级 */
	public int getTempMaxLevel() {
		return _tempMaxLevel;
	}

	/**
	 * 取得暂存字符串(收件者)
	 * 
	 * @return
	 */
	public String getText() {
		return _text;
	}

	/**
	 * 取得暂存byte[]阵列
	 * 
	 * @return
	 */
	public byte[] getTextByte() {
		return _textByte;
	}

	/** 取得交易ID */
	public int getTradeID() {
		return _tradeID;
	}

	/** 取得交易OK */
	public boolean getTradeOk() {
		return _tradeOk;
	}

	/** 取得交易窗口的库存 */
	public L1Inventory getTradeWindowInventory() {
		return _tradewindow;
	}

	/**
	 * 取得类型 <b> 0:王族 1:骑士 2:精灵 3:法师 4:黑妖 5:龙骑 6:幻术
	 * 
	 * @return
	 */
	public int getType() {
		return _type;
	}

	/**
	 * 取得使用的武器
	 * 
	 * @return
	 */
	public L1ItemInstance getWeapon() {
		return _weapon;
	}

	/**  */
	public int getWeightReduction() {
		return _weightReduction;
	}

	@Override
	public void healHp(final int pt) {
		super.healHp(pt);

		sendPackets(new S_HPUpdate(this));
	}

	/** 角色封锁中 */
	public boolean isBanned() {
		return _banned;
	}

	/** 是可以密语 */
	public boolean isCanWhisper() {
		return _isCanWhisper;
	}

	/**
	 * 是王族
	 * 
	 * @return
	 */
	public boolean isCrown() {
		return ((getClassId() == CLASSID_PRINCE) || (getClassId() == CLASSID_PRINCESS));
	}

	/**
	 * 是黑暗精灵
	 * 
	 * @return
	 */
	public boolean isDarkelf() {
		return ((getClassId() == CLASSID_DARK_ELF_MALE) || (getClassId() == CLASSID_DARK_ELF_FEMALE));
	}

	/**
	 * 是龙骑士
	 * 
	 * @return
	 */
	public boolean isDragonKnight() {
		return ((getClassId() == CLASSID_DRAGON_KNIGHT_MALE) || (getClassId() == CLASSID_DRAGON_KNIGHT_FEMALE));
	}

	/** 醉酒状态 */
	public boolean isDrink() {
		return _isDrink;
	}

	/**
	 * 是精灵
	 * 
	 * @return
	 */
	public boolean isElf() {
		return ((getClassId() == CLASSID_ELF_MALE) || (getClassId() == CLASSID_ELF_FEMALE));
	}

	/** 钓鱼中 */
	public boolean isFishing() {
		return _isFishing;
	}

	/** 准备好钓鱼 */
	public boolean isFishingReady() {
		return _isFishingReady;
	}

	/** 使用屠宰者判断 */
	public boolean isFoeSlayer() {
		return _FoeSlayer;
	}

	/** 是幽灵状态 */
	public boolean isGhost() {
		return _ghost;
	}

	/** 幽灵状态可以与NPC对话 */
	public boolean isGhostCanTalk() {
		return _ghostCanTalk;
	}

	/** 是GM */
	public boolean isGm() {
		return _gm;
	}

	/** GM隐身中 */
	public boolean isGmInvis() {
		return _gmInvis;
	}

	/**  */
	public boolean isGres() {
		return _isGres;
	}

	/** 是G-RES有效 */
	public boolean isGresValid() {
		return _gresValid;
	}

	/**
	 * 是幻术师
	 * 
	 * @return
	 */
	public boolean isIllusionist() {
		return ((getClassId() == CLASSID_ILLUSIONIST_MALE) || (getClassId() == CLASSID_ILLUSIONIST_FEMALE));
	}

	/** 角色重新开始 */
	public boolean isInCharReset() {
		return _isInCharReset;
	}

	/** 在聊天组队 */
	public boolean isInChatParty() {
		return getChatParty() != null;
	}

	public boolean isInOrderList() {
		return _order_list;
	}

	/** 在组队中 */
	public boolean isInParty() {
		return getParty() != null;
	}

	/** 隐身延迟中 */
	public boolean isInvisDelay() {
		return (invisDelayCounter > 0);
	}

	/**
	 * 是骑士
	 * 
	 * @return
	 */
	public boolean isKnight() {
		return ((getClassId() == CLASSID_KNIGHT_MALE) || (getClassId() == CLASSID_KNIGHT_FEMALE));
	}

	/** 是管理者 */
	public boolean isMonitor() {
		return _monitor;
	}

	/** 粉名 */
	public boolean isPinkName() {
		return _isPinkName;
	}

	/** 商店模式 */
	public boolean isPrivateShop() {
		return _isPrivateShop;
	}

	/** 准备解除幽灵状态 */
	public boolean isReserveGhost() {
		return _isReserveGhost;
	}

	/** 生命之树果实 移速 * 1.15 */
	public boolean isRibrave() {
		return hasSkillEffect(STATUS_RIBRAVE);
	}

	/** 变身中 */
	public boolean isShapeChange() {
		return _isShapeChange;
	}

	/** 是显示血盟聊天 */
	public boolean isShowClanChat() {
		return _isShowClanChat;
	}

	/** 是显示组队聊天 */
	public boolean isShowPartyChat() {
		return _isShowPartyChat;
	}

	/** 是显示交易聊天 */
	public boolean isShowTradeChat() {
		return _isShowTradeChat;
	}

	/** 是显示世界聊天 */
	public boolean isShowWorldChat() {
		return _isShowWorldChat;
	}

	/** 在学习技能 */
	public boolean isSkillMastery(final int skillid) {
		return skillList.contains(skillid);
	}

	/** 判断是否无道具施法(召戒清单、变身清单) */
	public boolean isSummonMonster() {
		return _isSummonMonster;
	}

	/** 瞬移中 */
	public boolean isTeleport() {
		return _isTeleport;
	}

	/** 三段加速 * 1.15 */
	public boolean isThirdSpeed() {
		return hasSkillEffect(STATUS_THIRD_SPEED);
	}

	/**
	 * 正在进行个人商店交易
	 * 
	 * @return
	 */
	public boolean isTradingInPrivateShop() {
		return _isTradingInPrivateShop;
	}

	/**
	 * 返回角色正在被通缉中。
	 * 
	 * @return 角色正在被通缉、true
	 */
	public boolean isWanted() {
		if (_lastPk == null) {
			return false;
		}
		else if (System.currentTimeMillis() - _lastPk.getTime() > 24 * 3600 * 1000) {
			setLastPk(null);
			return false;
		}
		return true;
	}

	public boolean isWantedForElf() {
		if (_lastPkForElf == null) {
			return false;
		}
		else if (System.currentTimeMillis() - _lastPkForElf.getTime() > 24 * 3600 * 1000) {
			setLastPkForElf(null);
			return false;
		}
		return true;
	}

	/** 风之枷锁 攻速 / 2 */
	public boolean isWindShackle() {
		return hasSkillEffect(WIND_SHACKLE);
	}

	/**
	 * 是法师
	 * 
	 * @return
	 */
	public boolean isWizard() {
		return ((getClassId() == CLASSID_WIZARD_MALE) || (getClassId() == CLASSID_WIZARD_FEMALE));
	}

	/** 登出 */
	public void logout() {
		final L1World world = L1World.getInstance();
		if (getClanid() != 0) // 有血盟
		{
			final L1Clan clan = world.getClan(getClanname());
			if (clan != null) {
				if (clan.getWarehouseUsingChar() == getId()) // 使用自身的血盟仓库中
				{
					clan.setWarehouseUsingChar(0); // 解锁血盟仓库
				}
			}
		}
		notifyPlayersLogout(getKnownPlayers());
		world.removeVisibleObject(this);
		world.removeObject(this);
		notifyPlayersLogout(world.getRecognizePlayer(this));
		_inventory.clearItems();
		_dwarf.clearItems();
		removeAllKnownObjects();
		stopHpRegeneration();
		stopMpRegeneration();
		setDead(true); // 使い方おかしいかもしれないけど、删除ＮＰＣ
		setNetConnection(null);
		setPacketOutput(null);
	}

	/**
	 * 离开幽灵状态 (传送回出发点)
	 */
	public void makeReadyEndGhost() {
		setReserveGhost(true);
		L1Teleport.teleport(this, _ghostSaveLocX, _ghostSaveLocY, _ghostSaveMapId, _ghostSaveHeading, true);
	}

	/**
	 * 对该物件攻击的调用
	 * 
	 * @param attacker
	 *            攻击方
	 */
	@Override
	public void onAction(final L1PcInstance attacker) {
		onAction(attacker, 0);
	}

	/**
	 * 对该物件攻击的调用
	 * 
	 * @param attacker
	 *            攻击方
	 * @param skillId
	 *            技能ID
	 */
	@Override
	public void onAction(final L1PcInstance attacker, final int skillId) {
		// XXX:NullPointerException回避。onActionの引数の型はL1Characterのほうが良い？
		if (attacker == null) {
			return;
		}
		// 在瞬移中
		if (isTeleport()) {
			return;
		}

		// 攻击或攻击方在安全区 仅送出动作资讯
		if ((getZoneType() == 1) || (attacker.getZoneType() == 1)) {
			// 发送攻击动作
			final L1Attack attack_mortion = new L1Attack(attacker, this, skillId);
			attack_mortion.action();
			return;
		}

		// 禁止PK服务器 仅送出动作资讯
		if (checkNonPvP(this, attacker) == true) {
			// 发送攻击动作
			final L1Attack attack_mortion = new L1Attack(attacker, this, skillId);
			attack_mortion.action();
			return;
		}

		// 攻击解除隐身
		if ((getCurrentHp() > 0) && !isDead()) {
			attacker.delInvis();

			boolean isCounterBarrier = false;

			// 开始计算攻击
			final L1Attack attack = new L1Attack(attacker, this, skillId);
			if (attack.calcHit()) {
				if (hasSkillEffect(COUNTER_BARRIER)) {
					final L1Magic magic = new L1Magic(this, attacker);
					final boolean isProbability = magic.calcProbabilityMagic(COUNTER_BARRIER);
					final boolean isShortDistance = attack.isShortDistance();
					if (isProbability && isShortDistance) {
						isCounterBarrier = true;
					}
				}
				if (!isCounterBarrier) {
					attacker.setPetTarget(this);

					attack.calcDamage();
					attack.calcStaffOfMana();
					attack.addPcPoisonAttack(attacker, this);
					attack.addChaserAttack();
				}
			}
			if (isCounterBarrier) {
				attack.actionCounterBarrier();
				attack.commitCounterBarrier();
			}
			else {
				attack.action();
				attack.commit();
			}
		}
	}

	/** 改变经验值 */
	public void onChangeExp() {
		final int level = ExpTable.getLevelByExp(getExp());
		final int char_level = getLevel();
		final int gap = level - char_level;
		if (gap == 0) {
			// sendPackets(new S_OwnCharStatus(this));
			sendPackets(new S_Exp(this));
			return;
		}

		// 等级变化的场合
		if (gap > 0) {
			levelUp(gap);
		}
		else if (gap < 0) {
			levelDown(gap);
		}
	}

	@Override
	public void onPerceive(final L1PcInstance perceivedFrom) {
		// 判断旅馆内是否使用相同钥匙
		if ((perceivedFrom.getMapId() >= 16384) && (perceivedFrom.getMapId() <= 25088 // 旅馆内判断
				) && (perceivedFrom.getInnKeyId() != getInnKeyId())) {
			return;
		}
		if (isGmInvis() || isGhost()) {
			return;
		}
		if (isInvisble() && !perceivedFrom.hasSkillEffect(GMSTATUS_FINDINVIS)) {
			return;
		}

		perceivedFrom.addKnownObject(this);
		perceivedFrom.sendPackets(new S_OtherCharPacks(this, perceivedFrom.hasSkillEffect(GMSTATUS_FINDINVIS))); // 自分の情报を送る
		if (isInParty() && getParty().isMember(perceivedFrom)) { // PTメンバーならHPメーターも送る
			perceivedFrom.sendPackets(new S_HPMeter(this));
		}

		if (isPrivateShop()) { // 开个人商店中
			perceivedFrom.sendPackets(new S_DoActionShop(getId(), ActionCodes.ACTION_Shop, getShopChat()));
		}
		else if (isFishing()) { // 钓鱼中
			perceivedFrom.sendPackets(new S_Fishing(getId(), ActionCodes.ACTION_Fishing, getFishX(), getFishY()));
		}

		if (isCrown()) { // 君主
			final L1Clan clan = L1World.getInstance().getClan(getClanname());
			if (clan != null) {
				if ((getId() == clan.getLeaderId() // 血盟主で城主クラン
						)
						&& (clan.getCastleId() != 0)) {
					perceivedFrom.sendPackets(new S_CastleMaster(clan.getCastleId(), getId()));
				}
			}
		}
	}

	/**
	 * 处理受到攻击HP减少
	 * 
	 * @param attacker
	 * @param Damage
	 * @param isMagicDamage
	 */
	public void receiveDamage(final L1Character attacker, double damage, final boolean isMagicDamage) { // 攻击でＨＰを减らすときはここを使用
		if ((getCurrentHp() > 0) && !isDead()) {
			if (attacker != this) {
				if (!(attacker instanceof L1EffectInstance) && !knownsObject(attacker) && (attacker.getMapId() == getMapId())) {
					attacker.onPerceive(this);
				}
			}

			if (isMagicDamage == true) { // 连续魔法伤害による轻减
				final double nowTime = System.currentTimeMillis();
				final double interval = (20D - (nowTime - _oldTime) / 100D) % 20D;

				if (damage > 0) {
					if (interval > 0) {
						damage *= (1D - interval / 30D);
					}

					if (damage < 1) {
						damage = 0;
					}

					_oldTime = nowTime; // 次回のために时间を保存
				}
			}
			if (damage > 0) {
				delInvis();
				if (attacker instanceof L1PcInstance) {
					L1PinkName.onAction(this, attacker);
				}
				if ((attacker instanceof L1PcInstance) && ((L1PcInstance) attacker).isPinkName()) {
					// ガードが画面内にいれば、攻击者をガードのターゲットに设定する
					final Iterator<L1Object> itr = L1World.getInstance().getVisibleObjects(attacker).iterator();
					while (itr.hasNext()) {
						final L1Object object = itr.next();
						/* for (L1Object object : L1World.getInstance().getVisibleObjects(attacker)) { */
						if (object instanceof L1GuardInstance) {
							final L1GuardInstance guard = (L1GuardInstance) object;
							guard.setTarget(((L1PcInstance) attacker));
						}
					}
				}
				removeSkillEffect(FOG_OF_SLEEPING); // 法师魔法 (沉睡之雾)
			}

			if (hasSkillEffect(MORTAL_BODY) && (getId() != attacker.getId())) {
				final int rnd = Random.nextInt(100) + 1;
				if ((damage > 0) && (rnd <= 10)) {
					if (attacker instanceof L1PcInstance) {
						final L1PcInstance attackPc = (L1PcInstance) attacker;
						attackPc.sendPackets(new S_DoActionGFX(attackPc.getId(), ActionCodes.ACTION_Damage));
						attackPc.broadcastPacket(new S_DoActionGFX(attackPc.getId(), ActionCodes.ACTION_Damage));
						attackPc.receiveDamage(this, 30, false);
					}
					else if (attacker instanceof L1NpcInstance) {
						final L1NpcInstance attackNpc = (L1NpcInstance) attacker;
						attackNpc.broadcastPacket(new S_DoActionGFX(attackNpc.getId(), ActionCodes.ACTION_Damage));
						attackNpc.receiveDamage(this, 30);
					}
				}
			}
			if (getInventory().checkEquipped(145) // 狂战士斧
					|| getInventory().checkEquipped(149)) { // 牛人斧头
				damage *= 1.5; // 伤害提高1.5倍
			}
			if (hasSkillEffect(ILLUSION_AVATAR)) {// 幻术师魔法 (幻觉：化身)
				damage *= 1.2; // 伤害提高1.2倍
			}
			if (attacker instanceof L1PetInstance) {
				final L1PetInstance pet = (L1PetInstance) attacker;
				// 目标在安区、攻击者在安区、NOPVP
				if ((getZoneType() == 1) || (pet.getZoneType() == 1) || (checkNonPvP(this, pet))) {
					damage = 0;
				}
			}
			else if (attacker instanceof L1SummonInstance) {
				final L1SummonInstance summon = (L1SummonInstance) attacker;
				// 目标在安区、攻击者在安区、NOPVP
				if ((getZoneType() == 1) || (summon.getZoneType() == 1) || (checkNonPvP(this, summon))) {
					damage = 0;
				}
			}
			int newHp = getCurrentHp() - (int) (damage);
			if (newHp > getMaxHp()) {
				newHp = getMaxHp();
			}
			if (newHp <= 0) {
				if (isGm()) {
					setCurrentHp(getMaxHp());
				}
				else {
					death(attacker);
				}
			}
			if (newHp > 0) {
				setCurrentHp(newHp);
			}
		}
		else if (!isDead()) { // 不是死亡状态
			System.out.println("警告∶PC的hp减少的运算出现错误。※将视为hp=0作处理");
			death(attacker);
		}
	}

	/**
	 * 魔法具有属性傷害使用 (ここで魔法伤害轻减处理) attr:0.无属性魔法,1.地魔法,2.火魔法,3.水魔法,4.风魔法
	 * 
	 * @param attacker
	 *            攻击者
	 * @param damage
	 *            伤害
	 * @param attr
	 *            属性
	 * */
	public void receiveDamage(final L1Character attacker, int damage, final int attr) {
		final int player_mr = getMr();
		final int rnd = Random.nextInt(100) + 1;
		if (player_mr >= rnd) {
			damage /= 2;
		}
		receiveDamage(attacker, damage, false);
	}

	/**
	 * 处理受到攻击MP减少
	 * 
	 * @param attacker
	 * @param mpDamage
	 */
	public void receiveManaDamage(final L1Character attacker, final int mpDamage) { // 攻击でＭＰを减らすときはここを使用
		if ((mpDamage > 0) && !isDead()) {
			delInvis();
			if (attacker instanceof L1PcInstance) {
				L1PinkName.onAction(this, attacker);
			}
			if ((attacker instanceof L1PcInstance) && ((L1PcInstance) attacker).isPinkName()) {
				// ガードが画面内にいれば、攻击者をガードのターゲットに设定する
				for (final L1Object object : L1World.getInstance().getVisibleObjects(attacker)) {
					if (object instanceof L1GuardInstance) {
						final L1GuardInstance guard = (L1GuardInstance) object;
						guard.setTarget(((L1PcInstance) attacker));
					}
				}
			}

			int newMp = getCurrentMp() - mpDamage;
			if (newMp > getMaxMp()) {
				newMp = getMaxMp();
			}

			if (newMp <= 0) {
				newMp = 0;
			}
			setCurrentMp(newMp);
		}
	}

	/** 减少当前的HP */
	public void reduceCurrentHp(final double d, final L1Character l1character) {
		getStat().reduceCurrentHp(d, l1character);
	}

	/**
	 * 全属性重置
	 */
	public void refresh() {
		resetLevel(); // 重置等级
		resetBaseHitup(); // 重置基本命中率
		resetBaseDmgup(); // 重置基本伤害值
		resetBaseMr(); // 重置基本魔防
		resetBaseAc(); // 重置基本防御
		resetOriginalHpup(); // 重置原本的最高 HP
		resetOriginalMpup(); // 重置原本的最高 MP
		resetOriginalDmgup(); // 重置原本的最高伤害值
		resetOriginalBowDmgup(); // 重置原本的最高弓箭伤害值
		resetOriginalHitup(); // 重置原本的最高命中率
		resetOriginalBowHitup(); // 重置原本弓箭的最高命中率
		resetOriginalMr(); // 重置原本的魔防
		resetOriginalMagicHit(); // 重置原本的魔法命中率
		resetOriginalMagicCritical();
		resetOriginalMagicConsumeReduction(); // 重置原始魔法消耗减少
		resetOriginalMagicDamage(); // 重置原始的魔法伤害值
		resetOriginalAc(); // 重置原始的防御
		resetOriginalEr(); // 重置原始的回避率
		resetOriginalHpr(); // 重置原始的回血量
		resetOriginalMpr(); // 重置原始的回魔量
		resetOriginalStrWeightReduction(); // 重置原始的 STR 减轻负重
		resetOriginalConWeightReduction(); // 重置原始的 CON 减轻负重
	}

	/** 删除书签 */
	public void removeBookMark(final L1BookMark book) {
		_bookmarks.remove(book);
	}

	/** 删除重复的魔法状态 */
	public void removeHasteSkillEffect() {
		if (hasSkillEffect(SLOW)) {
			removeSkillEffect(SLOW);
		}
		if (hasSkillEffect(MASS_SLOW)) {
			removeSkillEffect(MASS_SLOW);
		}
		if (hasSkillEffect(ENTANGLE)) {
			removeSkillEffect(ENTANGLE);
		}
		if (hasSkillEffect(HASTE)) {
			removeSkillEffect(HASTE);
		}
		if (hasSkillEffect(GREATER_HASTE)) {
			removeSkillEffect(GREATER_HASTE);
		}
		if (hasSkillEffect(STATUS_HASTE)) {
			removeSkillEffect(STATUS_HASTE);
		}
	}

	/** 删除学习的技能 */
	public void removeSkillMastery(final int skillid) {
		if (skillList.contains(skillid)) {
			skillList.remove((Object) skillid);
		}
	}

	/**
	 * 角色AC状态的初始设定、LVUP,LVDown时呼出
	 */
	public void resetBaseAc() {
		final int newAc = CalcStat.calcAc(getLevel(), getBaseDex());
		addAc(newAc - _baseAc);
		_baseAc = newAc;
	}

	/**
	 * LV伤害奖励设定 LV变动的场合重新再计算
	 * 
	 * @return
	 */
	public void resetBaseDmgup() {
		int newBaseDmgup = 0;
		int newBaseBowDmgup = 0;
		if (isKnight() || isDarkelf() || isDragonKnight()) { // 骑士、精灵、龙骑士
			newBaseDmgup = getLevel() / 10;
			newBaseBowDmgup = 0;
		}
		else if (isElf()) { // 精灵
			newBaseDmgup = 0;
			newBaseBowDmgup = getLevel() / 10;
		}
		addDmgup(newBaseDmgup - _baseDmgup);
		addBowDmgup(newBaseBowDmgup - _baseBowDmgup);
		_baseDmgup = newBaseDmgup;
		_baseBowDmgup = newBaseBowDmgup;
	}

	/**
	 * LV命中奖励设定 LV变动的场合重新再计算
	 * 
	 * @return
	 */
	public void resetBaseHitup() {
		int newBaseHitup = 0;
		int newBaseBowHitup = 0;
		if (isCrown()) { // 王族
			newBaseHitup = getLevel() / 5;
			newBaseBowHitup = getLevel() / 5;
		}
		else if (isKnight()) { // 骑士
			newBaseHitup = getLevel() / 3;
			newBaseBowHitup = getLevel() / 3;
		}
		else if (isElf()) { // 精灵
			newBaseHitup = getLevel() / 5;
			newBaseBowHitup = getLevel() / 5;
		}
		else if (isDarkelf()) { // 黑暗精灵
			newBaseHitup = getLevel() / 3;
			newBaseBowHitup = getLevel() / 3;
		}
		else if (isDragonKnight()) { // 龙骑士
			newBaseHitup = getLevel() / 3;
			newBaseBowHitup = getLevel() / 3;
		}
		else if (isIllusionist()) { // 幻术师
			newBaseHitup = getLevel() / 5;
			newBaseBowHitup = getLevel() / 5;
		}
		addHitup(newBaseHitup - _baseHitup);
		addBowHitup(newBaseBowHitup - _baseBowHitup);
		_baseHitup = newBaseHitup;
		_baseBowHitup = newBaseBowHitup;
	}

	/**
	 * 重新计算角色的MR初始设定、使用技能和LVUP,LVDown时呼出
	 */
	public void resetBaseMr() {
		int newMr = 0;
		if (isCrown()) { // 王族
			newMr = 10;
		}
		else if (isElf()) { // 精灵
			newMr = 25;
		}
		else if (isWizard()) { // 魔法师
			newMr = 15;
		}
		else if (isDarkelf()) { // 黑暗精灵
			newMr = 10;
		}
		else if (isDragonKnight()) { // 龙骑士
			newMr = 18;
		}
		else if (isIllusionist()) { // 幻术师
			newMr = 20;
		}
		newMr += CalcStat.calcStatMr(getWis()); // 精神对魔防的加成
		newMr += getLevel() / 2; // LVの半分だけ追加
		addMr(newMr - _baseMr);
		_baseMr = newMr;
	}

	/**
	 * 重新设定等级与目前的经验值匹配
	 */
	public void resetLevel() {
		setLevel(ExpTable.getLevelByExp(_exp));

		if (_hpRegen != null) {
			_hpRegen.updateLevel();
		}
	}

	/** 重置原始的防御 */
	public void resetOriginalAc() {
		final int originalDex = getOriginalDex();
		if (isCrown()) {
			if ((originalDex >= 12) && (originalDex <= 14)) {
				_originalAc = 1;
			}
			else if ((originalDex == 15) || (originalDex == 16)) {
				_originalAc = 2;
			}
			else if (originalDex >= 17) {
				_originalAc = 3;
			}
			else {
				_originalAc = 0;
			}
		}
		else if (isKnight()) {
			if ((originalDex == 13) || (originalDex == 14)) {
				_originalAc = 1;
			}
			else if (originalDex >= 15) {
				_originalAc = 3;
			}
			else {
				_originalAc = 0;
			}
		}
		else if (isElf()) {
			if ((originalDex >= 15) && (originalDex <= 17)) {
				_originalAc = 1;
			}
			else if (originalDex == 18) {
				_originalAc = 2;
			}
			else {
				_originalAc = 0;
			}
		}
		else if (isDarkelf()) {
			if (originalDex >= 17) {
				_originalAc = 1;
			}
			else {
				_originalAc = 0;
			}
		}
		else if (isWizard()) {
			if ((originalDex == 8) || (originalDex == 9)) {
				_originalAc = 1;
			}
			else if (originalDex >= 10) {
				_originalAc = 2;
			}
			else {
				_originalAc = 0;
			}
		}
		else if (isDragonKnight()) {
			if ((originalDex == 12) || (originalDex == 13)) {
				_originalAc = 1;
			}
			else if (originalDex >= 14) {
				_originalAc = 2;
			}
			else {
				_originalAc = 0;
			}
		}
		else if (isIllusionist()) {
			if ((originalDex == 11) || (originalDex == 12)) {
				_originalAc = 1;
			}
			else if (originalDex >= 13) {
				_originalAc = 2;
			}
			else {
				_originalAc = 0;
			}
		}

		addAc(0 - _originalAc);
	}

	/** 重置原始的弓的最大伤害 */
	public void resetOriginalBowDmgup() {
		final int originalDex = getOriginalDex();
		if (isCrown()) {
			if (originalDex >= 13) {
				_originalBowDmgup = 1;
			}
			else {
				_originalBowDmgup = 0;
			}
		}
		else if (isKnight()) {
			_originalBowDmgup = 0;
		}
		else if (isElf()) {
			if ((originalDex >= 14) && (originalDex <= 16)) {
				_originalBowDmgup = 2;
			}
			else if (originalDex >= 17) {
				_originalBowDmgup = 3;
			}
			else {
				_originalBowDmgup = 0;
			}
		}
		else if (isDarkelf()) {
			if (originalDex == 18) {
				_originalBowDmgup = 2;
			}
			else {
				_originalBowDmgup = 0;
			}
		}
		else if (isWizard()) {
			_originalBowDmgup = 0;
		}
		else if (isDragonKnight()) {
			_originalBowDmgup = 0;
		}
		else if (isIllusionist()) {
			_originalBowDmgup = 0;
		}
	}

	/** 重置原始的弓的最大命中率 */
	public void resetOriginalBowHitup() {
		final int originalDex = getOriginalDex();
		if (isCrown()) {
			_originalBowHitup = 0;
		}
		else if (isKnight()) {
			_originalBowHitup = 0;
		}
		else if (isElf()) {
			if ((originalDex >= 13) && (originalDex <= 15)) {
				_originalBowHitup = 2;
			}
			else if (originalDex >= 16) {
				_originalBowHitup = 3;
			}
			else {
				_originalBowHitup = 0;
			}
		}
		else if (isDarkelf()) {
			if (originalDex == 17) {
				_originalBowHitup = 1;
			}
			else if (originalDex == 18) {
				_originalBowHitup = 2;
			}
			else {
				_originalBowHitup = 0;
			}
		}
		else if (isWizard()) {
			_originalBowHitup = 0;
		}
		else if (isDragonKnight()) {
			_originalBowHitup = 0;
		}
		else if (isIllusionist()) {
			_originalBowHitup = 0;
		}
	}

	/** 重置原始的 CON 负重减轻 */
	public void resetOriginalConWeightReduction() {
		final int originalCon = getOriginalCon();
		if (isCrown()) {
			if (originalCon >= 11) {
				_originalConWeightReduction = 1;
			}
			else {
				_originalConWeightReduction = 0;
			}
		}
		else if (isKnight()) {
			if (originalCon >= 15) {
				_originalConWeightReduction = 1;
			}
			else {
				_originalConWeightReduction = 0;
			}
		}
		else if (isElf()) {
			if (originalCon >= 15) {
				_originalConWeightReduction = 2;
			}
			else {
				_originalConWeightReduction = 0;
			}
		}
		else if (isDarkelf()) {
			if (originalCon >= 9) {
				_originalConWeightReduction = 1;
			}
			else {
				_originalConWeightReduction = 0;
			}
		}
		else if (isWizard()) {
			if ((originalCon == 13) || (originalCon == 14)) {
				_originalConWeightReduction = 1;
			}
			else if (originalCon >= 15) {
				_originalConWeightReduction = 2;
			}
			else {
				_originalConWeightReduction = 0;
			}
		}
		else if (isDragonKnight()) {
			_originalConWeightReduction = 0;
		}
		else if (isIllusionist()) {
			if (originalCon == 17) {
				_originalConWeightReduction = 1;
			}
			else if (originalCon == 18) {
				_originalConWeightReduction = 2;
			}
			else {
				_originalConWeightReduction = 0;
			}
		}
	}

	/** 重置原始的最大伤害 */
	public void resetOriginalDmgup() {
		final int originalStr = getOriginalStr();
		if (isCrown()) {
			if ((originalStr >= 15) && (originalStr <= 17)) {
				_originalDmgup = 1;
			}
			else if (originalStr >= 18) {
				_originalDmgup = 2;
			}
			else {
				_originalDmgup = 0;
			}
		}
		else if (isKnight()) {
			if ((originalStr == 18) || (originalStr == 19)) {
				_originalDmgup = 2;
			}
			else if (originalStr == 20) {
				_originalDmgup = 4;
			}
			else {
				_originalDmgup = 0;
			}
		}
		else if (isElf()) {
			if ((originalStr == 12) || (originalStr == 13)) {
				_originalDmgup = 1;
			}
			else if (originalStr >= 14) {
				_originalDmgup = 2;
			}
			else {
				_originalDmgup = 0;
			}
		}
		else if (isDarkelf()) {
			if ((originalStr >= 14) && (originalStr <= 17)) {
				_originalDmgup = 1;
			}
			else if (originalStr == 18) {
				_originalDmgup = 2;
			}
			else {
				_originalDmgup = 0;
			}
		}
		else if (isWizard()) {
			if ((originalStr == 10) || (originalStr == 11)) {
				_originalDmgup = 1;
			}
			else if (originalStr >= 12) {
				_originalDmgup = 2;
			}
			else {
				_originalDmgup = 0;
			}
		}
		else if (isDragonKnight()) {
			if ((originalStr >= 15) && (originalStr <= 17)) {
				_originalDmgup = 1;
			}
			else if (originalStr >= 18) {
				_originalDmgup = 3;
			}
			else {
				_originalDmgup = 0;
			}
		}
		else if (isIllusionist()) {
			if ((originalStr == 13) || (originalStr == 14)) {
				_originalDmgup = 1;
			}
			else if (originalStr >= 15) {
				_originalDmgup = 2;
			}
			else {
				_originalDmgup = 0;
			}
		}
	}

	/** 重置原始的回避率 */
	public void resetOriginalEr() {
		final int originalDex = getOriginalDex();
		if (isCrown()) {
			if ((originalDex == 14) || (originalDex == 15)) {
				_originalEr = 1;
			}
			else if ((originalDex == 16) || (originalDex == 17)) {
				_originalEr = 2;
			}
			else if (originalDex == 18) {
				_originalEr = 3;
			}
			else {
				_originalEr = 0;
			}
		}
		else if (isKnight()) {
			if ((originalDex == 14) || (originalDex == 15)) {
				_originalEr = 1;
			}
			else if (originalDex == 16) {
				_originalEr = 3;
			}
			else {
				_originalEr = 0;
			}
		}
		else if (isElf()) {
			_originalEr = 0;
		}
		else if (isDarkelf()) {
			if (originalDex >= 16) {
				_originalEr = 2;
			}
			else {
				_originalEr = 0;
			}
		}
		else if (isWizard()) {
			if ((originalDex == 9) || (originalDex == 10)) {
				_originalEr = 1;
			}
			else if (originalDex == 11) {
				_originalEr = 2;
			}
			else {
				_originalEr = 0;
			}
		}
		else if (isDragonKnight()) {
			if ((originalDex == 13) || (originalDex == 14)) {
				_originalEr = 1;
			}
			else if (originalDex >= 15) {
				_originalEr = 2;
			}
			else {
				_originalEr = 0;
			}
		}
		else if (isIllusionist()) {
			if ((originalDex == 12) || (originalDex == 13)) {
				_originalEr = 1;
			}
			else if (originalDex >= 14) {
				_originalEr = 2;
			}
			else {
				_originalEr = 0;
			}
		}
	}

	/** 重置原始的最大命中率 */
	public void resetOriginalHitup() {
		final int originalStr = getOriginalStr();
		if (isCrown()) {
			if ((originalStr >= 16) && (originalStr <= 18)) {
				_originalHitup = 1;
			}
			else if (originalStr >= 19) {
				_originalHitup = 2;
			}
			else {
				_originalHitup = 0;
			}
		}
		else if (isKnight()) {
			if ((originalStr == 17) || (originalStr == 18)) {
				_originalHitup = 2;
			}
			else if (originalStr >= 19) {
				_originalHitup = 4;
			}
			else {
				_originalHitup = 0;
			}
		}
		else if (isElf()) {
			if ((originalStr == 13) || (originalStr == 14)) {
				_originalHitup = 1;
			}
			else if (originalStr >= 15) {
				_originalHitup = 2;
			}
			else {
				_originalHitup = 0;
			}
		}
		else if (isDarkelf()) {
			if ((originalStr >= 15) && (originalStr <= 17)) {
				_originalHitup = 1;
			}
			else if (originalStr == 18) {
				_originalHitup = 2;
			}
			else {
				_originalHitup = 0;
			}
		}
		else if (isWizard()) {
			if ((originalStr == 11) || (originalStr == 12)) {
				_originalHitup = 1;
			}
			else if (originalStr >= 13) {
				_originalHitup = 2;
			}
			else {
				_originalHitup = 0;
			}
		}
		else if (isDragonKnight()) {
			if ((originalStr >= 14) && (originalStr <= 16)) {
				_originalHitup = 1;
			}
			else if (originalStr >= 17) {
				_originalHitup = 3;
			}
			else {
				_originalHitup = 0;
			}
		}
		else if (isIllusionist()) {
			if ((originalStr == 12) || (originalStr == 13)) {
				_originalHitup = 1;
			}
			else if ((originalStr == 14) || (originalStr == 15)) {
				_originalHitup = 2;
			}
			else if (originalStr == 16) {
				_originalHitup = 3;
			}
			else if (originalStr >= 17) {
				_originalHitup = 4;
			}
			else {
				_originalHitup = 0;
			}
		}
	}

	/** 重置原始的回血 */
	public void resetOriginalHpr() {
		final int originalCon = getOriginalCon();
		if (isCrown()) {
			if ((originalCon == 13) || (originalCon == 14)) {
				_originalHpr = 1;
			}
			else if ((originalCon == 15) || (originalCon == 16)) {
				_originalHpr = 2;
			}
			else if (originalCon == 17) {
				_originalHpr = 3;
			}
			else if (originalCon == 18) {
				_originalHpr = 4;
			}
			else {
				_originalHpr = 0;
			}
		}
		else if (isKnight()) {
			if ((originalCon == 16) || (originalCon == 17)) {
				_originalHpr = 2;
			}
			else if (originalCon == 18) {
				_originalHpr = 4;
			}
			else {
				_originalHpr = 0;
			}
		}
		else if (isElf()) {
			if ((originalCon == 14) || (originalCon == 15)) {
				_originalHpr = 1;
			}
			else if (originalCon == 16) {
				_originalHpr = 2;
			}
			else if (originalCon >= 17) {
				_originalHpr = 3;
			}
			else {
				_originalHpr = 0;
			}
		}
		else if (isDarkelf()) {
			if ((originalCon == 11) || (originalCon == 12)) {
				_originalHpr = 1;
			}
			else if (originalCon >= 13) {
				_originalHpr = 2;
			}
			else {
				_originalHpr = 0;
			}
		}
		else if (isWizard()) {
			if (originalCon == 17) {
				_originalHpr = 1;
			}
			else if (originalCon == 18) {
				_originalHpr = 2;
			}
			else {
				_originalHpr = 0;
			}
		}
		else if (isDragonKnight()) {
			if ((originalCon == 16) || (originalCon == 17)) {
				_originalHpr = 1;
			}
			else if (originalCon == 18) {
				_originalHpr = 3;
			}
			else {
				_originalHpr = 0;
			}
		}
		else if (isIllusionist()) {
			if ((originalCon == 14) || (originalCon == 15)) {
				_originalHpr = 1;
			}
			else if (originalCon >= 16) {
				_originalHpr = 2;
			}
			else {
				_originalHpr = 0;
			}
		}
	}

	/**
	 * 设定时的初始点数和计算现在再次从初始状态，重新分配时调用
	 */
	/** 重置原始的最大 HP */
	public void resetOriginalHpup() {
		final int originalCon = getOriginalCon();
		if (isCrown()) {
			if ((originalCon == 12) || (originalCon == 13)) {
				_originalHpup = 1;
			}
			else if ((originalCon == 14) || (originalCon == 15)) {
				_originalHpup = 2;
			}
			else if (originalCon >= 16) {
				_originalHpup = 3;
			}
			else {
				_originalHpup = 0;
			}
		}
		else if (isKnight()) {
			if ((originalCon == 15) || (originalCon == 16)) {
				_originalHpup = 1;
			}
			else if (originalCon >= 17) {
				_originalHpup = 3;
			}
			else {
				_originalHpup = 0;
			}
		}
		else if (isElf()) {
			if ((originalCon >= 13) && (originalCon <= 17)) {
				_originalHpup = 1;
			}
			else if (originalCon == 18) {
				_originalHpup = 2;
			}
			else {
				_originalHpup = 0;
			}
		}
		else if (isDarkelf()) {
			if ((originalCon == 10) || (originalCon == 11)) {
				_originalHpup = 1;
			}
			else if (originalCon >= 12) {
				_originalHpup = 2;
			}
			else {
				_originalHpup = 0;
			}
		}
		else if (isWizard()) {
			if ((originalCon == 14) || (originalCon == 15)) {
				_originalHpup = 1;
			}
			else if (originalCon >= 16) {
				_originalHpup = 2;
			}
			else {
				_originalHpup = 0;
			}
		}
		else if (isDragonKnight()) {
			if ((originalCon == 15) || (originalCon == 16)) {
				_originalHpup = 1;
			}
			else if (originalCon >= 17) {
				_originalHpup = 3;
			}
			else {
				_originalHpup = 0;
			}
		}
		else if (isIllusionist()) {
			if ((originalCon == 13) || (originalCon == 14)) {
				_originalHpup = 1;
			}
			else if (originalCon >= 15) {
				_originalHpup = 2;
			}
			else {
				_originalHpup = 0;
			}
		}
	}

	/** 重置原始的魔力减免 */
	public void resetOriginalMagicConsumeReduction() {
		final int originalInt = getOriginalInt();
		if (isCrown()) {
			if ((originalInt == 11) || (originalInt == 12)) {
				_originalMagicConsumeReduction = 1;
			}
			else if (originalInt >= 13) {
				_originalMagicConsumeReduction = 2;
			}
			else {
				_originalMagicConsumeReduction = 0;
			}
		}
		else if (isKnight()) {
			if ((originalInt == 9) || (originalInt == 10)) {
				_originalMagicConsumeReduction = 1;
			}
			else if (originalInt >= 11) {
				_originalMagicConsumeReduction = 2;
			}
			else {
				_originalMagicConsumeReduction = 0;
			}
		}
		else if (isElf()) {
			_originalMagicConsumeReduction = 0;
		}
		else if (isDarkelf()) {
			if ((originalInt == 13) || (originalInt == 14)) {
				_originalMagicConsumeReduction = 1;
			}
			else if (originalInt >= 15) {
				_originalMagicConsumeReduction = 2;
			}
			else {
				_originalMagicConsumeReduction = 0;
			}
		}
		else if (isWizard()) {
			_originalMagicConsumeReduction = 0;
		}
		else if (isDragonKnight()) {
			_originalMagicConsumeReduction = 0;
		}
		else if (isIllusionist()) {
			if (originalInt == 14) {
				_originalMagicConsumeReduction = 1;
			}
			else if (originalInt >= 15) {
				_originalMagicConsumeReduction = 2;
			}
			else {
				_originalMagicConsumeReduction = 0;
			}
		}
	}

	public void resetOriginalMagicCritical() {
		final int originalInt = getOriginalInt();
		if (isCrown()) {
			_originalMagicCritical = 0;
		}
		else if (isKnight()) {
			_originalMagicCritical = 0;
		}
		else if (isElf()) {
			if ((originalInt == 14) || (originalInt == 15)) {
				_originalMagicCritical = 2;
			}
			else if (originalInt >= 16) {
				_originalMagicCritical = 4;
			}
			else {
				_originalMagicCritical = 0;
			}
		}
		else if (isDarkelf()) {
			_originalMagicCritical = 0;
		}
		else if (isWizard()) {
			if (originalInt == 15) {
				_originalMagicCritical = 2;
			}
			else if (originalInt == 16) {
				_originalMagicCritical = 4;
			}
			else if (originalInt == 17) {
				_originalMagicCritical = 6;
			}
			else if (originalInt == 18) {
				_originalMagicCritical = 8;
			}
			else {
				_originalMagicCritical = 0;
			}
		}
		else if (isDragonKnight()) {
			_originalMagicCritical = 0;
		}
		else if (isIllusionist()) {
			_originalMagicCritical = 0;
		}
	}

	/** 重置原始的魔法伤害 */
	public void resetOriginalMagicDamage() {
		final int originalInt = getOriginalInt();
		if (isCrown()) {
			_originalMagicDamage = 0;
		}
		else if (isKnight()) {
			_originalMagicDamage = 0;
		}
		else if (isElf()) {
			_originalMagicDamage = 0;
		}
		else if (isDarkelf()) {
			_originalMagicDamage = 0;
		}
		else if (isWizard()) {
			if (originalInt >= 13) {
				_originalMagicDamage = 1;
			}
			else {
				_originalMagicDamage = 0;
			}
		}
		else if (isDragonKnight()) {
			if ((originalInt == 13) || (originalInt == 14)) {
				_originalMagicDamage = 1;
			}
			else if ((originalInt == 15) || (originalInt == 16)) {
				_originalMagicDamage = 2;
			}
			else if (originalInt == 17) {
				_originalMagicDamage = 3;
			}
			else {
				_originalMagicDamage = 0;
			}
		}
		else if (isIllusionist()) {
			if (originalInt == 16) {
				_originalMagicDamage = 1;
			}
			else if (originalInt == 17) {
				_originalMagicDamage = 2;
			}
			else {
				_originalMagicDamage = 0;
			}
		}
	}

	/** 重置原始的魔法命中率 */
	public void resetOriginalMagicHit() {
		final int originalInt = getOriginalInt();
		if (isCrown()) {
			if ((originalInt == 12) || (originalInt == 13)) {
				_originalMagicHit = 1;
			}
			else if (originalInt >= 14) {
				_originalMagicHit = 2;
			}
			else {
				_originalMagicHit = 0;
			}
		}
		else if (isKnight()) {
			if ((originalInt == 10) || (originalInt == 11)) {
				_originalMagicHit = 1;
			}
			else if (originalInt == 12) {
				_originalMagicHit = 2;
			}
			else {
				_originalMagicHit = 0;
			}
		}
		else if (isElf()) {
			if ((originalInt == 13) || (originalInt == 14)) {
				_originalMagicHit = 1;
			}
			else if (originalInt >= 15) {
				_originalMagicHit = 2;
			}
			else {
				_originalMagicHit = 0;
			}
		}
		else if (isDarkelf()) {
			if ((originalInt == 12) || (originalInt == 13)) {
				_originalMagicHit = 1;
			}
			else if (originalInt >= 14) {
				_originalMagicHit = 2;
			}
			else {
				_originalMagicHit = 0;
			}
		}
		else if (isWizard()) {
			if (originalInt >= 14) {
				_originalMagicHit = 1;
			}
			else {
				_originalMagicHit = 0;
			}
		}
		else if (isDragonKnight()) {
			if ((originalInt == 12) || (originalInt == 13)) {
				_originalMagicHit = 2;
			}
			else if ((originalInt == 14) || (originalInt == 15)) {
				_originalMagicHit = 3;
			}
			else if (originalInt >= 16) {
				_originalMagicHit = 4;
			}
			else {
				_originalMagicHit = 0;
			}
		}
		else if (isIllusionist()) {
			if (originalInt >= 13) {
				_originalMagicHit = 1;
			}
			else {
				_originalMagicHit = 0;
			}
		}
	}

	/** 重置原始的回魔 */
	public void resetOriginalMpr() {
		final int originalWis = getOriginalWis();
		if (isCrown()) {
			if ((originalWis == 13) || (originalWis == 14)) {
				_originalMpr = 1;
			}
			else if (originalWis >= 15) {
				_originalMpr = 2;
			}
			else {
				_originalMpr = 0;
			}
		}
		else if (isKnight()) {
			if ((originalWis == 11) || (originalWis == 12)) {
				_originalMpr = 1;
			}
			else if (originalWis == 13) {
				_originalMpr = 2;
			}
			else {
				_originalMpr = 0;
			}
		}
		else if (isElf()) {
			if ((originalWis >= 15) && (originalWis <= 17)) {
				_originalMpr = 1;
			}
			else if (originalWis == 18) {
				_originalMpr = 2;
			}
			else {
				_originalMpr = 0;
			}
		}
		else if (isDarkelf()) {
			if (originalWis >= 13) {
				_originalMpr = 1;
			}
			else {
				_originalMpr = 0;
			}
		}
		else if (isWizard()) {
			if ((originalWis == 14) || (originalWis == 15)) {
				_originalMpr = 1;
			}
			else if ((originalWis == 16) || (originalWis == 17)) {
				_originalMpr = 2;
			}
			else if (originalWis == 18) {
				_originalMpr = 3;
			}
			else {
				_originalMpr = 0;
			}
		}
		else if (isDragonKnight()) {
			if ((originalWis == 15) || (originalWis == 16)) {
				_originalMpr = 1;
			}
			else if (originalWis >= 17) {
				_originalMpr = 2;
			}
			else {
				_originalMpr = 0;
			}
		}
		else if (isIllusionist()) {
			if ((originalWis >= 14) && (originalWis <= 16)) {
				_originalMpr = 1;
			}
			else if (originalWis >= 17) {
				_originalMpr = 2;
			}
			else {
				_originalMpr = 0;
			}
		}
	}

	/** 重置原始的最大 MP */
	public void resetOriginalMpup() {
		final int originalWis = getOriginalWis();
		{
			if (isCrown()) {
				if (originalWis >= 16) {
					_originalMpup = 1;
				}
				else {
					_originalMpup = 0;
				}
			}
			else if (isKnight()) {
				_originalMpup = 0;
			}
			else if (isElf()) {
				if ((originalWis >= 14) && (originalWis <= 16)) {
					_originalMpup = 1;
				}
				else if (originalWis >= 17) {
					_originalMpup = 2;
				}
				else {
					_originalMpup = 0;
				}
			}
			else if (isDarkelf()) {
				if (originalWis >= 12) {
					_originalMpup = 1;
				}
				else {
					_originalMpup = 0;
				}
			}
			else if (isWizard()) {
				if ((originalWis >= 13) && (originalWis <= 16)) {
					_originalMpup = 1;
				}
				else if (originalWis >= 17) {
					_originalMpup = 2;
				}
				else {
					_originalMpup = 0;
				}
			}
			else if (isDragonKnight()) {
				if ((originalWis >= 13) && (originalWis <= 15)) {
					_originalMpup = 1;
				}
				else if (originalWis >= 16) {
					_originalMpup = 2;
				}
				else {
					_originalMpup = 0;
				}
			}
			else if (isIllusionist()) {
				if ((originalWis >= 13) && (originalWis <= 15)) {
					_originalMpup = 1;
				}
				else if (originalWis >= 16) {
					_originalMpup = 2;
				}
				else {
					_originalMpup = 0;
				}
			}
		}
	}

	/** 重置原始的魔防 */
	public void resetOriginalMr() {
		final int originalWis = getOriginalWis();
		if (isCrown()) {
			if ((originalWis == 12) || (originalWis == 13)) {
				_originalMr = 1;
			}
			else if (originalWis >= 14) {
				_originalMr = 2;
			}
			else {
				_originalMr = 0;
			}
		}
		else if (isKnight()) {
			if ((originalWis == 10) || (originalWis == 11)) {
				_originalMr = 1;
			}
			else if (originalWis >= 12) {
				_originalMr = 2;
			}
			else {
				_originalMr = 0;
			}
		}
		else if (isElf()) {
			if ((originalWis >= 13) && (originalWis <= 15)) {
				_originalMr = 1;
			}
			else if (originalWis >= 16) {
				_originalMr = 2;
			}
			else {
				_originalMr = 0;
			}
		}
		else if (isDarkelf()) {
			if ((originalWis >= 11) && (originalWis <= 13)) {
				_originalMr = 1;
			}
			else if (originalWis == 14) {
				_originalMr = 2;
			}
			else if (originalWis == 15) {
				_originalMr = 3;
			}
			else if (originalWis >= 16) {
				_originalMr = 4;
			}
			else {
				_originalMr = 0;
			}
		}
		else if (isWizard()) {
			if (originalWis >= 15) {
				_originalMr = 1;
			}
			else {
				_originalMr = 0;
			}
		}
		else if (isDragonKnight()) {
			if (originalWis >= 14) {
				_originalMr = 2;
			}
			else {
				_originalMr = 0;
			}
		}
		else if (isIllusionist()) {
			if ((originalWis >= 15) && (originalWis <= 17)) {
				_originalMr = 2;
			}
			else if (originalWis == 18) {
				_originalMr = 4;
			}
			else {
				_originalMr = 0;
			}
		}

		addMr(_originalMr);
	}

	/** 重置原始的 STR 负重减轻 */
	public void resetOriginalStrWeightReduction() {
		final int originalStr = getOriginalStr();
		if (isCrown()) {
			if ((originalStr >= 14) && (originalStr <= 16)) {
				_originalStrWeightReduction = 1;
			}
			else if ((originalStr >= 17) && (originalStr <= 19)) {
				_originalStrWeightReduction = 2;
			}
			else if (originalStr == 20) {
				_originalStrWeightReduction = 3;
			}
			else {
				_originalStrWeightReduction = 0;
			}
		}
		else if (isKnight()) {
			_originalStrWeightReduction = 0;
		}
		else if (isElf()) {
			if (originalStr >= 16) {
				_originalStrWeightReduction = 2;
			}
			else {
				_originalStrWeightReduction = 0;
			}
		}
		else if (isDarkelf()) {
			if ((originalStr >= 13) && (originalStr <= 15)) {
				_originalStrWeightReduction = 2;
			}
			else if (originalStr >= 16) {
				_originalStrWeightReduction = 3;
			}
			else {
				_originalStrWeightReduction = 0;
			}
		}
		else if (isWizard()) {
			if (originalStr >= 9) {
				_originalStrWeightReduction = 1;
			}
			else {
				_originalStrWeightReduction = 0;
			}
		}
		else if (isDragonKnight()) {
			if (originalStr >= 16) {
				_originalStrWeightReduction = 1;
			}
			else {
				_originalStrWeightReduction = 0;
			}
		}
		else if (isIllusionist()) {
			if (originalStr == 18) {
				_originalStrWeightReduction = 1;
			}
			else {
				_originalStrWeightReduction = 0;
			}
		}
	}

	/**
	 * 恢复经验值
	 */
	public void resExp() {
		final int oldLevel = getLevel();
		final long needExp = ExpTable.getNeedExpNextLevel(oldLevel);
		long exp = 0;
		if (oldLevel < 45) {
			exp = (long) (needExp * 0.05);
		}
		else if (oldLevel == 45) {
			exp = (long) (needExp * 0.045);
		}
		else if (oldLevel == 46) {
			exp = (long) (needExp * 0.04);
		}
		else if (oldLevel == 47) {
			exp = (long) (needExp * 0.035);
		}
		else if (oldLevel == 48) {
			exp = (long) (needExp * 0.03);
		}
		else if (oldLevel >= 49) {
			exp = (long) (needExp * 0.025);
		}

		if (exp == 0) {
			return;
		}
		addExp(exp);
	}

	/**
	 * 将玩家资料储存到资料库中。
	 * 
	 * @throws Exception
	 */
	public void save() throws Exception {
		if (isGhost()) {
			return;
		}
		if (isInCharReset()) {
			return;
		}

		CharacterTable.getInstance().storeCharacter(this);
	}

	/**
	 * 将角色身上道具的状态存入资料库。
	 */
	public void saveInventory() {
		for (final L1ItemInstance item : getInventory().getItems()) {
			getInventory().saveItem(item, item.getRecordingColumns());
			getInventory().saveEnchantAccessory(item, item.getRecordingColumnsEnchantAccessory());
		}
	}

	/**
	 * 发送单体封包
	 * 
	 * @param serverbasepacket
	 *            封包
	 */
	public void sendPackets(final ServerBasePacket serverbasepacket) {
		if (_out == null) {
			return;
		}

		try {
			_out.sendPacket(serverbasepacket);
		}
		catch (final Exception e) {
		}
	}

	/** 在登录时发送的视觉效果 */
	public void sendVisualEffectAtLogin() {
		// S_Emblemの送信はC_Clanに移行
		// for (L1Clan clan : L1World.getInstance().getAllClans()) {
		// sendPackets(new S_Emblem(clan.getClanId()));
		// }

		if (getClanid() != 0) { // 有血盟
			final L1Clan clan = L1World.getInstance().getClan(getClanname());
			if (clan != null) {
				if (isCrown() && (getId() == clan.getLeaderId()) && // 王族ンスまたは王族ンセス、かつ、血盟主で自クランが城主
						(clan.getCastleId() != 0)) {
					sendPackets(new S_CastleMaster(clan.getCastleId(), getId()));
				}
			}
		}

		sendVisualEffect();
	}

	/** 发送瞬移视觉效果 */
	public void sendVisualEffectAtTeleport() {
		if (isDrink()) { // liquorで醉っている
			sendPackets(new S_Liquor(getId(), 1));
		}

		sendVisualEffect();
	}

	/** 设定PK次数 */
	public void set_PKcount(final int i) {
		_PKcount = i;
	}

	/** 设定性别 */
	public void set_sex(final int i) {
		_sex = (byte) i;
	}

	/** 设定账号等级 */
	public void setAccessLevel(final short i) {
		_accessLevel = i;
	}

	/** 设定账号名称 */
	public void setAccountName(final String s) {
		_accountName = s;
	}

	/** 设定灵魂升华增加的HP */
	public void setAdvenHp(final int i) {
		_advenHp = i;
	}

	/** 设定灵魂升华增加的MP */
	public void setAdvenMp(final int i) {
		_advenMp = i;
	}

	/** 设定觉醒技能ID */
	public void setAwakeSkillId(final int i) {
		_awakeSkillId = i;
	}

	/** 设定角色封锁 */
	public void setBanned(final boolean flag) {
		_banned = flag;
	}

	/**  */
	public void setBirthday() {
		_birthday = new Timestamp(System.currentTimeMillis());
	}

	/** 设定角色生日 */
	public void setBirthday(final Timestamp time) {
		_birthday = time;
	}

	/** 设定奖励点分配状况 */
	public void setBonusStats(final int i) {
		_bonusStats = i;
	}

	/** 设定呼叫血盟名称 */
	public void setCallClanHeading(final int i) {
		_callClanHeading = i;
	}

	/** 设定呼叫血盟ID */
	public void setCallClanId(final int i) {
		_callClanId = i;
	}

	/** 设定可以密语 */
	public void setCanWhisper(final boolean flag) {
		_isCanWhisper = flag;
	}

	/** 设定聊天组队 */
	public void setChatParty(final L1ChatParty cp) {
		_chatParty = cp;
	}

	/** 设定血盟 ID */
	public void setClanid(final int i) {
		_clanid = i;
	}

	/** 设定血盟名称 */
	public void setClanname(final String s) {
		clanname = s;
	}

	/** 设定血盟内的阶级(联盟君主、守护骑士、一般、见习) */
	public void setClanRank(final int i) {
		_clanRank = i;
	}

	/** 设定角色的ClassId */
	public void setClassId(final int i) {
		_classId = i;
		_classFeature = L1ClassFeature.newClassFeature(i);
	}

	/** 设定贡献度 */
	public void setContribution(final int i) {
		_contribution = i;
	}

	/** 设定烹饪ID */
	public void setCookingId(final int i) {
		_cookingId = i;
	}

	@Override
	public void setCurrentHp(final int i) {
		if (getCurrentHp() == i) {
			return;
		}
		int currentHp = i;
		if (currentHp >= getMaxHp()) {
			currentHp = getMaxHp();
		}
		setCurrentHpDirect(currentHp);
		sendPackets(new S_HPUpdate(currentHp, getMaxHp()));
		if (isInParty()) { // 组队中
			getParty().updateMiniHP(this);
		}
	}

	@Override
	public void setCurrentMp(final int i) {
		if (getCurrentMp() == i) {
			return;
		}
		int currentMp = i;
		if ((currentMp >= getMaxMp()) || isGm()) {
			currentMp = getMaxMp();
		}
		setCurrentMpDirect(currentMp);
		sendPackets(new S_MPUpdate(currentMp, getMaxMp()));
	}

	/** 设定当前武器 */
	public void setCurrentWeapon(final int i) {
		_currentWeapon = i;
	}

	/** 设定角色删除时间 */
	public void setDeleteTime(final Timestamp time) {
		_deleteTime = time;
	}

	/** 设定点心ID */
	public void setDessertId(final int i) {
		_dessertId = i;
	}

	/** 设定醉酒状态 */
	public void setDrink(final boolean flag) {
		_isDrink = flag;
	}

	/** 设定精灵属性 */
	public void setElfAttr(final int i) {
		_elfAttr = i;
	}

	/**
	 * 设定万能药使用状况
	 * 
	 * @param i
	 */
	public void setElixirStats(final int i) {
		_elixirStats = i;
	}

	/**
	 * 设置防具的装备
	 * 
	 * @param armor
	 *            装备的防具
	 */
	public void setEquippedArmor(final L1ItemInstance armor) {

		// 取回防具类型
		final int type = armor.getItem().getType();

		// 取回角色背包道具
		final L1PcInventory pcInventory = getInventory();

		// 装备栏是否有空位
		boolean equipeSpace;

		// 戒指可戴2个,其他都只能戴1个
		if (type == 9) {
			equipeSpace = pcInventory.getTypeEquipped(2, 9) <= 1;
		}
		else {
			equipeSpace = pcInventory.getTypeEquipped(2, type) <= 0;
		}

		// 防具穿戴
		if (equipeSpace && !armor.isEquipped()) { // 要安装的装备栏尚未安装物品

			// 取回变身编号
			final int polyid = getTempCharGfx();

			// 在此变身状态不能装备的装备
			if (!L1PolyMorph.isEquipableArmor(polyid, type)) {
				return;
			}

			// 已经装备其他东西。
			if (((type == 13) && (pcInventory.getTypeEquipped(2, 7) >= 1)) || ((type == 7) && (pcInventory.getTypeEquipped(2, 13) >= 1))) {
				sendPackets(new S_ServerMessage(124)); // 已经装备其他东西。
				return;
			}

			// 使用双手武器时无法装备盾牌
			if ((type == 7) && (getWeapon() != null)) {
				if (getWeapon().getItem().isTwohandedWeapon()) { // 双手武器
					sendPackets(new S_ServerMessage(129)); // \f1当你使用双手武器时，无法装备盾牌。
					return;
				}
			}

			// 穿着斗篷时不可穿内衣
			if ((type == 3) && (pcInventory.getTypeEquipped(2, 4) >= 1)) {
				sendPackets(new S_ServerMessage(126, "$224", "$225")); // \f1穿着%1 无法装备 %0%o 。
				return;
			}

			// 穿着盔甲时不可穿内衣
			else if ((type == 3) && (pcInventory.getTypeEquipped(2, 2) >= 1)) {
				sendPackets(new S_ServerMessage(126, "$224", "$226")); // \f1穿着%1 无法装备 %0%o 。
				return;
			}

			// 穿着斗篷时不可穿盔甲
			else if ((type == 2) && (pcInventory.getTypeEquipped(2, 4) >= 1)) {
				sendPackets(new S_ServerMessage(126, "$226", "$225")); // \f1穿着%1 无法装备 %0%o 。
				return;
			}
			pcInventory.setEquipped(armor, true);
		}

		// 防具脱除
		else if (armor.isEquipped()) { // 所选防具穿戴在身上
			if (armor.getItem().getBless() == 2) { // 被诅咒的装备
				sendPackets(new S_ServerMessage(150)); // \f1你无法这样做。这个物品已经被诅咒了。
				return;

			}
			else {

				// 穿着盔甲时不能脱下内衣
				if ((type == 3) && (pcInventory.getTypeEquipped(2, 2) >= 1)) {
					sendPackets(new S_ServerMessage(127)); // \f1你不能够脱掉那个。
					return;

				}

				// 穿着斗篷时不能脱下内衣
				else if (((type == 2) || (type == 3)) && (pcInventory.getTypeEquipped(2, 4) >= 1)) {
					sendPackets(new S_ServerMessage(127)); // \f1你不能够脱掉那个。
					return;
				}

				// 解除坚固防御
				if (type == 7) {
					if (hasSkillEffect(SOLID_CARRIAGE)) {
						removeSkillEffect(SOLID_CARRIAGE);
					}
				}
				pcInventory.setEquipped(armor, false);
			}
		}
		else {
			if (armor.getItem().getUseType() == 23) {
				sendPackets(new S_ServerMessage(144)); // \f1你已经戴着二个戒指。
				return;
			}
			else {
				sendPackets(new S_ServerMessage(124)); // \f1已经装备其他东西。
				return;
			}
		}

		setCurrentHp(getCurrentHp()); // 更新角色HP
		setCurrentMp(getCurrentMp()); // 更新角色MP
		sendPackets(new S_OwnCharAttrDef(null)); // 更新角色物理防御与四属性防御
		sendPackets(new S_OwnCharStatus(null)); // 更新角色属性与能力值
		sendPackets(new S_SPMR(null)); // 更新角色魔法攻击与魔法防御
	}

	/**
	 * 设置武器的装备
	 * 
	 * @param weapon
	 *            装备的武器
	 */
	public void setEquippedWeapon(final L1ItemInstance weapon) {

		// 取回角色背包道具
		final L1PcInventory pcInventory = getInventory();

		// 没有使用武器或使用武器与所选武器不同
		if ((getWeapon() == null) || !getWeapon().equals(weapon)) {

			// 取回武器类型
			final int weapon_type = weapon.getItem().getType();

			// 取回变身编号
			final int polyid = getTempCharGfx();

			// 此变身状态不能使用的武器
			if (!L1PolyMorph.isEquipableWeapon(polyid, weapon_type)) {
				return;
			}

			// 装备盾牌时不可再使用双手武器
			if (weapon.getItem().isTwohandedWeapon() && (pcInventory.getTypeEquipped(2, 7) >= 1)) {
				sendPackets(new S_ServerMessage(128));
				return;
			}
		}

		// 已有装备的状态
		if (getWeapon() != null) {

			// 被诅咒的装备
			if (getWeapon().getItem().getBless() == 2) {
				sendPackets(new S_ServerMessage(150)); // \f1你无法这样做。这个物品已经被诅咒了。
				return;
			}

			// 解除装备
			if (getWeapon().equals(weapon)) {
				pcInventory.setEquipped(getWeapon(), false, false, false);
				return;
			}
			else { // 武器交换
				pcInventory.setEquipped(getWeapon(), false, false, true);
			}
		}

		// 被诅咒的装备
		if (weapon.getItem().getBless() == 2) {
			sendPackets(new S_ServerMessage(149, weapon.getLogName())); // \f1%0%s 主动固定在你的手上！
		}
		pcInventory.setEquipped(weapon, true, false, false);
	}

	@Override
	public synchronized void setExp(final long i) {
		_exp = i;
	}

	/** 设定恢复EXP */
	public void setExpRes(final int i) {
		_expRes = i;
	}

	/** 设定战斗ID */
	public void setFightId(final int i) {
		_fightId = i;
	}

	/** 设定钓鱼 */
	public void setFishing(final boolean flag) {
		_isFishing = flag;
	}

	/** 设定准备好钓鱼 */
	public void setFishingReady(final boolean flag) {
		_isFishingReady = flag;
	}

	/** 设定钓鱼时间 */
	public void setFishingTime(final long i) {
		_fishingTime = i;
	}

	/** 设定钓鱼坐标X */
	public void setFishX(final int i) {
		_fishX = i;
	}

	/** 设定钓鱼坐标Y */
	public void setFishY(final int i) {
		_fishY = i;
	}

	/** 设定使用屠宰者判断 */
	public void setFoeSlayer(final boolean FoeSlayer) {
		_FoeSlayer = FoeSlayer;
	}

	/** 设定GM */
	public void setGm(final boolean flag) {
		_gm = flag;
	}

	/** 设定GM隐身 */
	public void setGmInvis(final boolean flag) {
		_gmInvis = flag;
	}

	/**  */
	public void setGres(final boolean flag) {
		_isGres = flag;
	}

	/** 设定地狱停留时间 (秒) */
	public void setHellTime(final int i) {
		_hellTime = i;
	}

	/** 设定过去最高等级 */
	public void setHighLevel(final int i) {
		_highLevel = i;
	}

	/** 设定所住村镇ID */
	public void setHomeTownId(final int i) {
		_homeTownId = i;
	}

	/** 设定角色重新开始 */
	public void setInCharReset(final boolean flag) {
		_isInCharReset = flag;
	}

	public void setInOrderList(final boolean bool) {
		_order_list = bool;
	}

	@Override
	public void setKarma(final int i) {
		_karma.set(i);
	}

	/** 设定宠物竞速圈数 */
	public void setLap(final int i) {
		_lap = i;
	}

	/** 设定检查宠物竞速圈数 */
	public void setLapCheck(final int i) {
		_lapCheck = i;
	}

	/**
	 * 设定角色的最终PK时间为现在的时刻。
	 */
	public void setLastPk() {
		_lastPk = new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 设定玩家的最后PK时间。
	 * 
	 * @param time
	 *            最终PK时间（Timestamp型） 解除する场合はnullを代入
	 */
	public void setLastPk(final Timestamp time) {
		_lastPk = time;
	}

	public void setLastPkForElf() {
		_lastPkForElf = new Timestamp(System.currentTimeMillis());
	}

	public void setLastPkForElf(final Timestamp time) {
		_lastPkForElf = time;
	}

	/** 设定管理者 */
	public void setMonitor(final boolean flag) {
		_monitor = flag;
	}

	/** 设定网络连接状态 */
	public void setNetConnection(final ClientThread clientthread) {
		_netConnection = clientthread;
	}

	/** 设定在线状态 */
	public void setOnlineStatus(final int i) {
		_onlineStatus = i;
	}

	/** 设定原始的魅力值 */
	public void setOriginalCha(final int i) {
		_originalCha = i;
	}

	/** 设定原始的体质值 */
	public void setOriginalCon(final int i) {
		_originalCon = i;
	}

	/** 设定原始的敏捷值 */
	public void setOriginalDex(final int i) {
		_originalDex = i;
	}

	/** 设定原始的智力值 */
	public void setOriginalInt(final int i) {
		_originalInt = i;
	}

	/** 设定原始的力量值 */
	public void setOriginalStr(final int i) {
		_originalStr = i;
	}

	/** 设定原始的精神值 */
	public void setOriginalWis(final int i) {
		_originalWis = i;
	}

	/**
	 * 设定封包加密管理
	 * 
	 * @param out
	 */
	public void setPacketOutput(final PacketOutput out) {
		_out = out;
	}

	/** 设定结婚伴侣ID */
	public void setPartnerId(final int i) {
		_partnerId = i;
	}

	/**
	 * 设定出售物品种类数量
	 * 
	 * @param i
	 */
	public void setPartnersPrivateShopItemCount(final int i) {
		_partnersPrivateShopItemCount = i;
	}

	/** 设定组队 */
	public void setParty(final L1Party p) {
		_party = p;
	}

	/** 设定组队ID */
	public void setPartyID(final int partyID) {
		_partyID = partyID;
	}

	/** 设定组队类型 */
	public void setPartyType(final int type) {
		_partyType = type;
	}

	/** 设定村庄福利金 */
	public void setPay(final int i) {
		_pay = i;
	}

	/**
	 * 设定 宠物/召唤兽 攻击目标
	 * 
	 * @param target
	 */
	public void setPetTarget(final L1Character target) {
		final Object[] petList = getPetList().values().toArray();
		for (final Object pet : petList) {
			if (pet instanceof L1PetInstance) {
				final L1PetInstance pets = (L1PetInstance) pet;
				pets.setMasterTarget(target);
			}
			else if (pet instanceof L1SummonInstance) {
				final L1SummonInstance summon = (L1SummonInstance) pet;
				summon.setMasterTarget(target);
			}
		}
	}

	/** 设定粉名 */
	public void setPinkName(final boolean flag) {
		_isPinkName = flag;
	}

	/** 设定PK次数 (精灵用) */
	public void setPkCountForElf(final int i) {
		_PkCountForElf = i;
	}

	@Override
	public void setPoisonEffect(final int effectId) {
		sendPackets(new S_Poison(getId(), effectId));

		if (!isGmInvis() && !isGhost() && !isInvisble()) {
			broadcastPacket(new S_Poison(getId(), effectId));
		}
		if (isGmInvis() || isGhost()) {
		}
		else if (isInvisble()) {
			broadcastPacketForFindInvis(new S_Poison(getId(), effectId), true);
		}
		else {
			broadcastPacket(new S_Poison(getId(), effectId));
		}
	}

	/**
	 * 设定商店模式
	 * 
	 * @param flag
	 */
	public void setPrivateShop(final boolean flag) {
		_isPrivateShop = flag;
	}

	public void setRegenState(final int state) {
		_mpRegen.setState(state);
		_hpRegen.setState(state);
	}

	/** 设定变身 */
	public void setShapeChange(final boolean isShapeChange) {
		_isShapeChange = isShapeChange;
	}

	/** 设定商店聊天 */
	public void setShopChat(final byte[] chat) {
		_shopChat = chat;
	}

	/** 设定显示血盟聊天 */
	public void setShowClanChat(final boolean flag) {
		_isShowClanChat = flag;
	}

	/** 设定显示组队聊天 */
	public void setShowPartyChat(final boolean flag) {
		_isShowPartyChat = flag;
	}

	/** 设定显示交易聊天 */
	public void setShowTradeChat(final boolean flag) {
		_isShowTradeChat = flag;
	}

	/** 设定显示世界聊天 */
	public void setShowWorldChat(final boolean flag) {
		_isShowWorldChat = flag;
	}

	/** 设定学习技能 */
	public void setSkillMastery(final int skillid) {
		if (!skillList.contains(skillid)) {
			skillList.add(skillid);
		}
	}

	/** 设定判断是否无道具施法(召戒清单、变身清单) */
	public void setSummonMonster(final boolean SummonMonster) {
		_isSummonMonster = SummonMonster;
	}

	/** 设定瞬移 */
	public void setTeleport(final boolean flag) {
		_isTeleport = flag;
	}

	/** 设定传送目的地面向 */
	public void setTeleportHeading(final int i) {
		_teleportHeading = i;
	}

	/** 设定传送目的地地图ID */
	public void setTeleportMapId(final short i) {
		_teleportMapId = i;
	}

	/**
	 * 设定传送目的地坐标X
	 * 
	 * @param i
	 */
	public void setTeleportX(final int i) {
		_teleportX = i;
	}

	/**
	 * 设定传送目的地坐标Y
	 * 
	 * @param i
	 */
	public void setTeleportY(final int i) {
		_teleportY = i;
	}

	/** 设定角色死亡时的临时GFX图像 */
	public void setTempCharGfxAtDead(final int i) {
		_tempCharGfxAtDead = i;
	}

	/** 设定临时ID */
	public void setTempID(final int tempID) {
		_tempID = tempID;
	}

	/** 设定临时等级 */
	public void setTempLevel(final int i) {
		_tempLevel = i;
	}

	/** 设定临时最高等级 */
	public void setTempMaxLevel(final int i) {
		_tempMaxLevel = i;
	}

	/**
	 * 设置暂存字符串(收件者)
	 * 
	 * @param text
	 */
	public void setText(final String text) {
		_text = text;
	}

	/**
	 * 设置暂存byte[]阵列
	 * 
	 * @param textByte
	 */
	public void setTextByte(final byte[] textByte) {
		_textByte = textByte;
	}

	/** 设定交易ID */
	public void setTradeID(final int tradeID) {
		_tradeID = tradeID;
	}

	/** 设定交易OK */
	public void setTradeOk(final boolean tradeOk) {
		_tradeOk = tradeOk;
	}

	/**
	 * 设定正在进行个人商店交易
	 * 
	 * @param flag
	 */
	public void setTradingInPrivateShop(final boolean flag) {
		_isTradingInPrivateShop = flag;
	}

	/** 设定类型 */
	public void setType(final int i) {
		_type = i;
	}

	/**
	 * 设定使用的武器
	 * 
	 * @param weapon
	 */
	public void setWeapon(final L1ItemInstance weapon) {
		_weapon = weapon;
	}

	/**
	 * 是否在参加血盟战争中
	 * 
	 * @param lastAttacker
	 * @return true:是 false:不是
	 */
	public boolean simWarResult(final L1Character lastAttacker) {
		if (getClanid() == 0) { // 没有血盟
			return false;
		}
		if (Config.SIM_WAR_PENALTY) { // 模拟战中false
			return false;
		}
		L1PcInstance attacker = null;
		String enemyClanName = null;
		boolean sameWar = false;

		if (lastAttacker instanceof L1PcInstance) {
			attacker = (L1PcInstance) lastAttacker;
		}
		else if (lastAttacker instanceof L1PetInstance) {
			attacker = (L1PcInstance) ((L1PetInstance) lastAttacker).getMaster();
		}
		else if (lastAttacker instanceof L1SummonInstance) {
			attacker = (L1PcInstance) ((L1SummonInstance) lastAttacker).getMaster();
		}
		else {
			return false;
		}

		// 取得全部战争列表
		for (final L1War war : L1World.getInstance().getWarList()) {
			final L1Clan clan = L1World.getInstance().getClan(getClanname());

			final int warType = war.GetWarType();
			final boolean isInWar = war.CheckClanInWar(getClanname());
			if ((attacker != null) && (attacker.getClanid() != 0)) { // lastAttackerがPC、サモン、ペットでクラン所属中
				sameWar = war.CheckClanInSameWar(getClanname(), attacker.getClanname());
			}

			if ((getId() == clan.getLeaderId()) && // 血盟主で模拟战中
					(warType == 2) && (isInWar == true)) {
				enemyClanName = war.GetEnemyClanName(getClanname());
				if (enemyClanName != null) {
					war.CeaseWar(getClanname(), enemyClanName); // 终结
				}
			}

			if ((warType == 2) && sameWar) { // 模拟战で同じ战争に参加中の场合、ペナルティなし
				return true;
			}
		}
		return false;
	}

	/** 开始玩家恢复自身体力 */
	public void startHpRegeneration() {
		final int INTERVAL = 1000;

		if (!_hpRegenActive) {
			_hpRegen = new HpRegeneration(this);
			_regenTimer.scheduleAtFixedRate(_hpRegen, INTERVAL, INTERVAL);
			_hpRegenActive = true;
		}
	}

	/** 开始娃娃恢复玩家体力 */
	public void startHpRegenerationByDoll() {
		final int INTERVAL_BY_DOLL = 64000;
		boolean isExistHprDoll = false;
		if (L1MagicDoll.isHpRegeneration(this)) {
			isExistHprDoll = true;
		}
		if (!_hpRegenActiveByDoll && isExistHprDoll) {
			_hpRegenByDoll = new HpRegenerationByDoll(this);
			_regenTimer.scheduleAtFixedRate(_hpRegenByDoll, INTERVAL_BY_DOLL, INTERVAL_BY_DOLL);
			_hpRegenActiveByDoll = true;
		}
	}

	/** 取得道具开始 */
	public void startItemMakeByDoll() {
		final int INTERVAL_BY_DOLL = 240000;
		boolean isExistItemMakeDoll = false;
		if (L1MagicDoll.isItemMake(this)) {
			isExistItemMakeDoll = true;
		}
		if (!_ItemMakeActiveByDoll && isExistItemMakeDoll) {
			_itemMakeByDoll = new ItemMakeByDoll(this);
			_regenTimer.scheduleAtFixedRate(_itemMakeByDoll, INTERVAL_BY_DOLL, INTERVAL_BY_DOLL);
			_ItemMakeActiveByDoll = true;
		}
	}

	/** 开始觉醒恢复玩家魔力 */
	public void startMpReductionByAwake() {
		final int INTERVAL_BY_AWAKE = 4000;
		if (!_mpReductionActiveByAwake) {
			_mpReductionByAwake = new MpReductionByAwake(this);
			_regenTimer.scheduleAtFixedRate(_mpReductionByAwake, INTERVAL_BY_AWAKE, INTERVAL_BY_AWAKE);
			_mpReductionActiveByAwake = true;
		}
	}

	/** 开始玩家恢复自身魔力 */
	public void startMpRegeneration() {
		final int INTERVAL = 1000;

		if (!_mpRegenActive) {
			_mpRegen = new MpRegeneration(this);
			_regenTimer.scheduleAtFixedRate(_mpRegen, INTERVAL, INTERVAL);
			_mpRegenActive = true;
		}
	}

	/** 开始娃娃恢复玩家魔力 */
	public void startMpRegenerationByDoll() {
		final int INTERVAL_BY_DOLL = 64000;
		boolean isExistMprDoll = false;
		if (L1MagicDoll.isMpRegeneration(this)) {
			isExistMprDoll = true;
		}
		if (!_mpRegenActiveByDoll && isExistMprDoll) {
			_mpRegenByDoll = new MpRegenerationByDoll(this);
			_regenTimer.scheduleAtFixedRate(_mpRegenByDoll, INTERVAL_BY_DOLL, INTERVAL_BY_DOLL);
			_mpRegenActiveByDoll = true;
		}
	}

	/** 开始自动更新物件 */
	public void startObjectAutoUpdate() {
		removeAllKnownObjects();
		_autoUpdateFuture = GeneralThreadPool.getInstance().pcScheduleAtFixedRate(new L1PcAutoUpdate(getId()), 0L, INTERVAL_AUTO_UPDATE);
	}

	/** 组队更新 3.3C */
	public void startRefreshParty() {

		final int INTERVAL = 25000;

		if (!_rpActive) {

			_rp = new L1PartyRefresh(this);

			_regenTimer.scheduleAtFixedRate(_rp, INTERVAL, INTERVAL);

			_rpActive = true;

		}

	}

	/**
	 * 停止各种监控任务。
	 */
	public void stopEtcMonitor() {
		if (_autoUpdateFuture != null) {
			_autoUpdateFuture.cancel(true);
			_autoUpdateFuture = null;
		}
		if (_expMonitorFuture != null) {
			_expMonitorFuture.cancel(true);
			_expMonitorFuture = null;
		}
		if (_ghostFuture != null) {
			_ghostFuture.cancel(true);
			_ghostFuture = null;
		}

		if (_hellFuture != null) {
			_hellFuture.cancel(true);
			_hellFuture = null;
		}

	}

	/** 停止玩家恢复自身体力 */
	public void stopHpRegeneration() {
		if (_hpRegenActive) {
			_hpRegen.cancel();
			_hpRegen = null;
			_hpRegenActive = false;
		}
	}

	/** 停止娃娃恢复玩家体力 */
	public void stopHpRegenerationByDoll() {
		if (_hpRegenActiveByDoll) {
			_hpRegenByDoll.cancel();
			_hpRegenByDoll = null;
			_hpRegenActiveByDoll = false;
		}
	}

	/** 取得道具停止 */
	public void stopItemMakeByDoll() {
		if (_ItemMakeActiveByDoll) {
			_itemMakeByDoll.cancel();
			_itemMakeByDoll = null;
			_ItemMakeActiveByDoll = false;
		}
	}

	/** 停止觉醒恢复玩家魔力 */
	public void stopMpReductionByAwake() {
		if (_mpReductionActiveByAwake) {
			_mpReductionByAwake.cancel();
			_mpReductionByAwake = null;
			_mpReductionActiveByAwake = false;
		}
	}

	/** 停止玩家恢复自身魔力 */
	public void stopMpRegeneration() {
		if (_mpRegenActive) {
			_mpRegen.cancel();
			_mpRegen = null;
			_mpRegenActive = false;
		}
	}

	/** 停止娃娃恢复玩家魔力 */
	public void stopMpRegenerationByDoll() {
		if (_mpRegenActiveByDoll) {
			_mpRegenByDoll.cancel();
			_mpRegenByDoll = null;
			_mpRegenActiveByDoll = false;
		}
	}

	/**
	 * 复活后移出死亡清单
	 */
	public void stopPcDeleteTimer() {
		if (_pcDeleteTimer != null) {
			_pcDeleteTimer.cancel();
			_pcDeleteTimer = null;
		}
	}

	/** 组队暂停更新 3.3C */
	public void stopRefreshParty() {

		if (_rpActive) {

			_rp.cancel();

			_rp = null;

			_rpActive = false;

		}
	}

	/** 更新范围内的物件 */
	public void updateObject() {
		removeOutOfRangeObjects();

		if (getMapId() <= 10000) {
			for (final L1Object visible : L1World.getInstance().getVisibleObjects(this, Config.PC_RECOGNIZE_RANGE)) {
				if (!knownsObject(visible)) {
					visible.onPerceive(this);
				}
				else {
					if (visible instanceof L1NpcInstance) {
						final L1NpcInstance npc = (L1NpcInstance) visible;
						if (getLocation().isInScreen(npc.getLocation()) && (npc.getHiddenStatus() != 0)) {
							npc.approachPlayer(this);
						}
					}
				}
				if (hasSkillEffect(GMSTATUS_HPBAR) && L1HpBar.isHpBarTarget(visible)) {
					sendPackets(new S_HPMeter((L1Character) visible));
				}
			}
		}
		else { // 旅馆内判断
			for (final L1Object visible : L1World.getInstance().getVisiblePlayer(this)) {
				if (!knownsObject(visible)) {
					visible.onPerceive(this);
				}
				if (hasSkillEffect(GMSTATUS_HPBAR) && L1HpBar.isHpBarTarget(visible)) {
					if (getInnKeyId() == ((L1Character) visible).getInnKeyId()) {
						sendPackets(new S_HPMeter((L1Character) visible));
					}
				}
			}
		}
	}

	/** 惩罚结果 */
	private void caoPenaltyResult(final int count) {
		for (int i = 0; i < count; i++) {
			final L1ItemInstance item = getInventory().CaoPenalty();

			if (item != null) {
				getInventory().tradeItem(item, item.isStackable() ? item.getCount() : 1, L1World.getInstance().getInventory(getX(), getY(), getMapId()));
				sendPackets(new S_ServerMessage(638, item.getLogName())); // 您损失了 %0。
			}
			else {
			}
		}
	}

	/** 取得统计 */
	private L1PcInstance getStat() {
		return null;
	}

	/**
	 * 在战争旗帜坐标內
	 * 
	 * @param pc
	 * @param target
	 * @return
	 */
	private boolean isInWarAreaAndWarTime(final L1PcInstance pc, final L1PcInstance target) {
		// pcとtargetが战争中に战争エリアに居るか
		final int castleId = L1CastleLocation.getCastleIdByArea(pc);
		final int targetCastleId = L1CastleLocation.getCastleIdByArea(target);
		if ((castleId != 0) && (targetCastleId != 0) && (castleId == targetCastleId)) {
			if (WarTimeController.getInstance().isNowWar(castleId)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 等级下降
	 * 
	 * @param gap
	 */
	private void levelDown(final int gap) {
		resetLevel();

		for (int i = 0; i > gap; i--) {
			// レベルダウン时はランダム值をそのままマイナスする为に、base值に0を设定
			final short randomHp = CalcStat.calcStatHp(getType(), 0, getBaseCon(), getOriginalHpup());
			final short randomMp = CalcStat.calcStatMp(getType(), 0, getBaseWis(), getOriginalMpup());
			addBaseMaxHp((short) -randomHp);
			addBaseMaxMp((short) -randomMp);
		}
		resetBaseHitup();
		resetBaseDmgup();
		resetBaseAc();
		resetBaseMr();
		if (Config.LEVEL_DOWN_RANGE != 0) {
			if (getHighLevel() - getLevel() >= Config.LEVEL_DOWN_RANGE) {
				sendPackets(new S_ServerMessage(64)); // 连线中断。
				sendPackets(new S_Disconnect());
				_log.info(String.format("超过允许等级上下限差异的范围，切断 %s的连线。", getName()));
			}
		}

		try {
			// 将资料保存到资料库
			save();
		}
		catch (final Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		sendPackets(new S_OwnCharStatus(this));

		// 处理新手保护系统(遭遇的守护)状态资料的变动
		checkNoviceType();
	}

	/**
	 * 判断提升等级
	 * 
	 * @param gap
	 */
	private void levelUp(final int gap) {
		resetLevel();

		// 返生药水
		if ((getLevel() == 99) && Config.ALT_REVIVAL_POTION) {
			try {
				final L1Item l1item = ItemTable.getInstance().getTemplate(43000);
				if (l1item != null) {
					getInventory().storeItem(43000, 1);
					sendPackets(new S_ServerMessage(403, l1item.getName())); // 获得%0%o 。
				}
				else {
					sendPackets(new S_SystemMessage("返生药水取得失败。"));
				}
			}
			catch (final Exception e) {
				_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
				sendPackets(new S_SystemMessage("返生药水取得失败。"));
			}
		}

		for (int i = 0; i < gap; i++) {
			final short randomHp = CalcStat.calcStatHp(getType(), getBaseMaxHp(), getBaseCon(), getOriginalHpup());
			final short randomMp = CalcStat.calcStatMp(getType(), getBaseMaxMp(), getBaseWis(), getOriginalMpup());
			addBaseMaxHp(randomHp);
			addBaseMaxMp(randomMp);

			if (Config.LvUpHpMpFull) {
				setCurrentHp(getMaxHp()); // 升级血满
				setCurrentMp(getMaxMp()); // 升级魔满
			}
		}
		resetBaseHitup();
		resetBaseDmgup();
		resetBaseAc();
		resetBaseMr();
		if (getLevel() > getHighLevel()) {
			setHighLevel(getLevel());
		}

		try {
			// 将资料保存到资料库
			save();
		}
		catch (final Exception e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		// 奖励点数
		if ((getLevel() >= 51) && (getLevel() - 50 > getBonusStats())) {
			if ((getBaseStr() + getBaseDex() + getBaseCon() + getBaseInt() + getBaseWis() + getBaseCha()) < (Config.BONUS_STATS1 * 6)) {
				sendPackets(new S_bonusstats(getId(), 1));
			}
		}
		sendPackets(new S_OwnCharStatus(this)); // 更新角色属性资料

		// 根据等级判断地图限制
		if (((getMapId() == 2005) || (getMapId() == 86))) { // 新手村
			if (getLevel() >= 13) { // 等级大于13
				if (getQuest().get_step(L1Quest.QUEST_TUTOR) != 255) {
					getQuest().set_step(L1Quest.QUEST_TUTOR, 255);
				}
				L1Teleport.teleport(this, 33084, 33391, (short) 4, 5, true);// 银骑士村
			}
		}
		else if (getLevel() >= 52) { // 指定等级
			if (getMapId() == 777) { // 原生魔族抛弃之地地面(影の神殿)
				L1Teleport.teleport(this, 34043, 32184, (short) 4, 5, true); // 象牙塔门口前
			}
			else if ((getMapId() == 778) || (getMapId() == 779)) { // 原生魔族抛弃之地海底(欲望洞窟)or不死魔族抛弃之地
				L1Teleport.teleport(this, 32608, 33178, (short) 4, 5, true); // WB
			}
		}

		// 处理新手保护系统(遭遇的守护)状态资料的变动
		checkNoviceType();
	}

	/**
	 * 通知指定的玩家登出
	 * 
	 * @param playersList
	 *            玩家列表
	 */
	private void notifyPlayersLogout(final List<L1PcInstance> playersArray) {
		for (final L1PcInstance player : playersArray) {
			if (player.knownsObject(this)) {
				player.removeKnownObject(this);
				player.sendPackets(new S_RemoveObject(this));
			}
		}
	}

	/** 删除画面范围外的对象 */
	private void removeOutOfRangeObjects() {
		for (final L1Object known : getKnownObjects()) {
			if (known == null) {
				continue;
			}

			if (Config.PC_RECOGNIZE_RANGE == -1) {
				if (!getLocation().isInScreen(known.getLocation())) { // 画面外
					removeKnownObject(known);
					sendPackets(new S_RemoveObject(known));
				}
			}
			else {
				if (getLocation().getTileLineDistance(known.getLocation()) > Config.PC_RECOGNIZE_RANGE) {
					removeKnownObject(known);
					sendPackets(new S_RemoveObject(known));
				}
			}
		}
	}

	/** 发送视觉效果 */
	private void sendVisualEffect() {
		int poisonId = 0;
		if (getPoison() != null) { // 毒状态
			poisonId = getPoison().getEffectId();
		}
		if (getParalysis() != null) { // 麻痹状态
			// 麻痹エフェクトを优先して送りたい为、poisonIdを上书き。
			poisonId = getParalysis().getEffectId();
		}
		if (poisonId != 0) { // このifはいらないかもしれない
			sendPackets(new S_Poison(getId(), poisonId));
			broadcastPacket(new S_Poison(getId(), poisonId));
		}
	}

	/** 设定幽灵状态 */
	private void setGhost(final boolean flag) {
		_ghost = flag;
	}

	/** 设定幽灵状态可以与NPC对话 */
	private void setGhostCanTalk(final boolean flag) {
		_ghostCanTalk = flag;
	}

	/** 设定G-RES有效 */
	private void setGresValid(final boolean valid) {
		_gresValid = valid;
	}

	/** 设定准备解除幽灵状态 */
	private void setReserveGhost(final boolean flag) {
		_isReserveGhost = flag;
	}

	/**
	 * 将重复的状态删除 (经验药水、魔眼等等)
	 * 
	 * @param _skillId
	 *            技能ID
	 * @param repeat_skill
	 *            重复的技能ID
	 */
	private void stopSkillList(final int _skillId, final int[] repeat_skill) {
		for (final int skillId : repeat_skill) {
			if (skillId != _skillId) {
				removeSkillEffect(skillId);
			}
		}
	}
}
