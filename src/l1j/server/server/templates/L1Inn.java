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
package l1j.server.server.templates;

import java.sql.Timestamp;

/**
 * 旅馆
 */
public class L1Inn {

	/**  */
	private int _npcId;
	/** 房间编号 */
	private int _roomNumber;
	/** 钥匙ID */
	private int _keyId;
	/** 房客ID */
	private int _lodgerId;
	/** 大厅 */
	private boolean _hall;
	/** 到期时间 */
	private Timestamp _dueTime;

	public Timestamp getDueTime() {
		return _dueTime;
	}

	public int getInnNpcId() {
		return _npcId;
	}

	public int getKeyId() {
		return _keyId;
	}

	public int getLodgerId() {
		return _lodgerId;
	}

	public int getRoomNumber() {
		return _roomNumber;
	}

	public boolean isHall() {
		return _hall;
	}

	public void setDueTime(final Timestamp i) {
		_dueTime = i;
	}

	public void setHall(final boolean hall) {
		_hall = hall;
	}

	public void setInnNpcId(final int i) {
		_npcId = i;
	}

	public void setKeyId(final int i) {
		_keyId = i;
	}

	public void setLodgerId(final int i) {
		_lodgerId = i;
	}

	public void setRoomNumber(final int i) {
		_roomNumber = i;
	}

}
