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

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.Config;
import l1j.server.server.model.Instance.L1ItemInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_DropItem;
import l1j.server.server.serverpackets.S_RemoveObject;
import l1j.server.server.utils.collections.Maps;

/**
 * 地面上的道具
 */
public class L1GroundInventory extends L1Inventory {

	private class DeletionTimer extends TimerTask {
		private final L1ItemInstance _item;

		public DeletionTimer(L1ItemInstance item) {
			_item = item;
		}

		@Override
		public void run() {
			try {
				synchronized (L1GroundInventory.this) {
					if (!_items.contains(_item)) {// 拾われたタイミングによってはこの条件を満たし得る
						return; // 已经捡起
					}
					removeItem(_item);
				}
			}
			catch (Throwable t) {
				_log.log(Level.SEVERE, t.getLocalizedMessage(), t);
			}
		}
	}

	private static final long serialVersionUID = 1L;

	private static Logger _log = Logger.getLogger(L1PcInventory.class.getName());

	private static final Timer _timer = new Timer();

	private Map<Integer, DeletionTimer> _reservedTimers = Maps.newMap();

	public L1GroundInventory(int objectId, int x, int y, short map) {
		setId(objectId);
		setX(x);
		setY(y);
		setMap(map);
		L1World.getInstance().addVisibleObject(this);
	}

	// 空インベントリ破棄及び見える範囲内にいるプレイヤーのオブジェクト削除
	@Override
	public void deleteItem(L1ItemInstance item) {
		cancelTimer(item);
		for (L1PcInstance pc : L1World.getInstance().getRecognizePlayer(item)) {
			pc.sendPackets(new S_RemoveObject(item));
			pc.removeKnownObject(item);
		}

		_items.remove(item);
		if (_items.size() == 0) {
			L1World.getInstance().removeVisibleObject(this);
		}
	}

	// 对可见范围内的玩家送信
	@Override
	public void insertItem(L1ItemInstance item) {
		setTimer(item);

		for (L1PcInstance pc : L1World.getInstance().getRecognizePlayer(item)) {
			pc.sendPackets(new S_DropItem(item));
			pc.addKnownObject(item);
		}
	}

	@Override
	public void onPerceive(L1PcInstance perceivedFrom) {
		for (L1ItemInstance item : getItems()) {
			if (!perceivedFrom.knownsObject(item)) {
				perceivedFrom.addKnownObject(item);
				perceivedFrom.sendPackets(new S_DropItem(item)); // プレイヤーへDROPITEM情報を通知
			}
		}
	}

	// 对可见范围内的玩家更新
	@Override
	public void updateItem(L1ItemInstance item) {
		for (L1PcInstance pc : L1World.getInstance().getRecognizePlayer(item)) {
			pc.sendPackets(new S_DropItem(item));
		}
	}

	private void cancelTimer(L1ItemInstance item) {
		DeletionTimer timer = _reservedTimers.get(item.getId());
		if (timer == null) {
			return;
		}
		timer.cancel();
	}

	private void setTimer(L1ItemInstance item) {
		if (!Config.ALT_ITEM_DELETION_TYPE.equalsIgnoreCase("std")) {
			return;
		}
		if (item.getItemId() == 40515) { // 元素石
			return;
		}

		_timer.schedule(new DeletionTimer(item), Config.ALT_ITEM_DELETION_TIME * 60 * 1000);
	}

}
