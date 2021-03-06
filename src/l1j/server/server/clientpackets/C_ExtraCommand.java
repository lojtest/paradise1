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

import static l1j.server.server.model.skill.L1SkillId.SHAPE_CHANGE;
import l1j.server.server.ClientThread;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_DoActionGFX;

// Referenced classes of package l1j.server.server.clientpackets:
// ClientBasePacket

/**
 * 处理收到由客户端传来额外动作指令的封包
 */
public class C_ExtraCommand extends ClientBasePacket {

	private static final String C_EXTRA_COMMAND = "[C] C_ExtraCommand";

	public C_ExtraCommand(final byte abyte0[], final ClientThread client) throws Exception {
		super(abyte0);
		final int actionId = this.readC();
		final L1PcInstance pc = client.getActiveChar();
		if (pc.isGhost()) {
			return;
		}
		if (pc.isInvisble()) { // 隐形中
			return;
		}
		if (pc.isTeleport()) { // 传送中
			return;
		}
		if (pc.hasSkillEffect(SHAPE_CHANGE)) { // 变身中
			final int gfxId = pc.getTempCharGfx();
			if ((gfxId != 6080) && (gfxId != 6094)) { // 骑马用的变身例外
				return;
			}
		}
		final S_DoActionGFX gfx = new S_DoActionGFX(pc.getId(), actionId);
		pc.broadcastPacket(gfx); // 将动作送给附近的玩家
	}

	@Override
	public String getType() {
		return C_EXTRA_COMMAND;
	}
}
