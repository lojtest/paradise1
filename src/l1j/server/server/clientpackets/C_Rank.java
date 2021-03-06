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
package l1j.server.server.clientpackets;

import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.server.ClientThread;
import l1j.server.server.datatables.CharacterTable;
import l1j.server.server.model.L1Clan;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_PacketBox;
import l1j.server.server.serverpackets.S_ServerMessage;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

/**
 * 处理收到由客户端传来血盟阶级的封包
 */
public class C_Rank extends ClientBasePacket {

	private static final String C_RANK = "[C] C_Rank";

	private static Logger _log = Logger.getLogger(C_Rank.class.getName());

	public C_Rank(final byte abyte0[], final ClientThread clientthread) throws Exception {
		super(abyte0);

		final int data = this.readC(); // ?

		final L1PcInstance pc = clientthread.getActiveChar();

		if (data == 1) {
			final int rank = this.readC();
			final String name = this.readS();
			final L1PcInstance targetPc = L1World.getInstance().getPlayer(name);
			if (pc == null) {
				return;
			}

			final L1Clan clan = L1World.getInstance().getClan(pc.getClanname());
			if (clan == null) {
				return;
			}

			if ((rank < 1) && (3 < rank)) {
				// 请输入想要变更阶级的人的名称与阶级。[阶级 = 守护骑士、一般、见习]
				pc.sendPackets(new S_ServerMessage(781));
				return;
			}

			if (pc.isCrown()) { // 君主
				if (pc.getId() != clan.getLeaderId()) { // 血盟主
					pc.sendPackets(new S_ServerMessage(785)); // 你不再是君主了
					return;
				}
			}
			else {
				pc.sendPackets(new S_ServerMessage(518)); // 血盟君主才可使用此命令。
				return;
			}

			if (targetPc != null) { // 玩家在线上
				if (pc.getClanid() == targetPc.getClanid()) { // 同血盟
					try {
						targetPc.setClanRank(rank);
						targetPc.save(); // 储存玩家的资料到资料库中
						targetPc.sendPackets(new S_PacketBox(S_PacketBox.MSG_RANK_CHANGED, rank)); // 你的阶级变更为%s
					}
					catch (final Exception e) {
						_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
					}
				}
				else {
					pc.sendPackets(new S_ServerMessage(414)); // 您只能邀请您血盟中的成员。
					return;
				}
			}
			else { // 不在线
				final L1PcInstance restorePc = CharacterTable.getInstance().restoreCharacter(name);
				if ((restorePc != null) && (restorePc.getClanid() == pc.getClanid())) { // 同じ血盟
					try {
						restorePc.setClanRank(rank);
						restorePc.save(); // 储存玩家的资料到资料库中
					}
					catch (final Exception e) {
						_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
					}
				}
				else {
					pc.sendPackets(new S_ServerMessage(109, name)); // 没有叫%0的人。
					return;
				}
			}
		}
		else if (data == 2) {
			pc.sendPackets(new S_ServerMessage(74, "同盟目录"));
		}
		else if (data == 3) {
			pc.sendPackets(new S_ServerMessage(74, "加入同盟"));
		}
		else if (data == 4) {
			pc.sendPackets(new S_ServerMessage(74, "退出同盟")); // \f1%0%o 无法使用。
		}
		else {
			/*
			*/
		}
	}

	@Override
	public String getType() {
		return C_RANK;
	}
}
