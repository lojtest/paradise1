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

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.server.datatables.ItemTable;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1MagicDoll;

/**
 * 魔法娃娃获得道具
 */
public class ItemMakeByDoll extends TimerTask {

	private static Logger _log = Logger.getLogger(ItemMakeByDoll.class.getName());

	private final L1PcInstance _pc;

	public ItemMakeByDoll(final L1PcInstance pc) {
		this._pc = pc;
	}

	/** 创造道具 */
	public void itemMake() {
		final L1ItemInstance temp = ItemTable.getInstance().createItem(L1MagicDoll.getMakeItemId(this._pc));
		if (temp != null) {
			if (this._pc.getInventory().checkAddItem(temp, 1) == L1Inventory.OK) {
				final L1ItemInstance item = this._pc.getInventory().storeItem(temp.getItemId(), 1);
				this._pc.sendPackets(new S_ServerMessage(403, item.getItem().getName())); // 获得%0%o 。
			}
		}
	}

	@Override
	public void run() {
		try {
			if (this._pc.isDead()) {
				return;
			}
			this.itemMake();
		}
		catch (final Throwable e) {
			_log.log(Level.WARNING, e.getLocalizedMessage(), e);
		}
	}
}
