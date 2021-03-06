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
package l1j.server.server.serverpackets;

import l1j.server.server.Opcodes;
import l1j.server.server.model.Instance.L1ItemInstance;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket, S_SendInvOnLogin

/**
 * 更新物品使用状态 (背包) - 可用次数
 */
public class S_ItemAmount extends ServerBasePacket {

	private static final String S_ITEM_AMOUNT = "[S] S_ItemAmount";

	/**
	 * 更新物品使用状态 (背包) - 可用次数
	 * 
	 * @param item
	 */
	public S_ItemAmount(final L1ItemInstance item) {
		if (item == null) {
			return;
		}

		this.buildPacket(item);
	}

	@Override
	public byte[] getContent() {
		return this.getBytes();
	}

	@Override
	public String getType() {
		return S_ITEM_AMOUNT;
	}

	private void buildPacket(final L1ItemInstance item) {
		// writeC(Opcodes.S_OPCODE_ITEMAMOUNT);
		// writeD(item.getId());
		// writeD(item.getCount());
		// writeC(0);
		// 3.0
		this.writeC(Opcodes.S_OPCODE_ITEMAMOUNT);
		this.writeD(item.getId());
		this.writeS(item.getViewName());
		this.writeD(item.getCount());
		if (!item.isIdentified()) { // 未鉴定状态不发送详细资料
			this.writeC(0);
		}
		else {
			final byte[] status = item.getStatusBytes();
			this.writeC(status.length);
			for (final byte b : status) {
				this.writeC(b);
			}
		}
		// 3.0 end
	}

}
