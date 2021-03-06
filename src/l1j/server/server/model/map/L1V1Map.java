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
package l1j.server.server.model.map;

import l1j.server.server.ActionCodes;
import l1j.server.server.datatables.DoorTable;
import l1j.server.server.model.Instance.L1DoorInstance;
import l1j.server.server.types.Point;

/**
 * V1地图
 */
public class L1V1Map extends L1Map {
	private int _mapId;

	private int _worldTopLeftX;

	private int _worldTopLeftY;

	private int _worldBottomRightX;

	private int _worldBottomRightY;

	private byte _map[][];

	private boolean _isUnderwater;

	private boolean _isMarkable;

	private boolean _isTeleportable;

	private boolean _isEscapable;

	private boolean _isUseResurrection;

	private boolean _isUsePainwand;

	private boolean _isEnabledDeathPenalty;

	private boolean _isTakePets;

	private boolean _isRecallPets;

	private boolean _isUsableItem;

	private boolean _isUsableSkill;

	/*
	 * マップ情報を1面で保持するために仕方なくビットフラグ。 可読性が大きく下がるので良い子は真似しない。
	 */
	/**
	 * Mobなどの通行不可能になるオブジェクトがタイル上に存在するかを示すビットフラグ
	 */
	private static final byte BITFLAG_IS_IMPASSABLE = (byte) 128; // 1000 0000

	public L1V1Map(final int mapId, final byte map[][], final int worldTopLeftX, final int worldTopLeftY, final boolean underwater, final boolean markable, final boolean teleportable, final boolean escapable, final boolean useResurrection, final boolean usePainwand,
			final boolean enabledDeathPenalty, final boolean takePets, final boolean recallPets, final boolean usableItem, final boolean usableSkill) {
		this._mapId = mapId;
		this._map = map;
		this._worldTopLeftX = worldTopLeftX;
		this._worldTopLeftY = worldTopLeftY;

		this._worldBottomRightX = worldTopLeftX + map.length - 1;
		this._worldBottomRightY = worldTopLeftY + map[0].length - 1;

		this._isUnderwater = underwater;
		this._isMarkable = markable;
		this._isTeleportable = teleportable;
		this._isEscapable = escapable;
		this._isUseResurrection = useResurrection;
		this._isUsePainwand = usePainwand;
		this._isEnabledDeathPenalty = enabledDeathPenalty;
		this._isTakePets = takePets;
		this._isRecallPets = recallPets;
		this._isUsableItem = usableItem;
		this._isUsableSkill = usableSkill;
	}

	public L1V1Map(final L1V1Map map) {
		this._mapId = map._mapId;

		// _mapをコピー
		this._map = new byte[map._map.length][];
		for (int i = 0; i < map._map.length; i++) {
			this._map[i] = map._map[i].clone();
		}

		this._worldTopLeftX = map._worldTopLeftX;
		this._worldTopLeftY = map._worldTopLeftY;
		this._worldBottomRightX = map._worldBottomRightX;
		this._worldBottomRightY = map._worldBottomRightY;

	}

	protected L1V1Map() {

	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return this._worldBottomRightY - this._worldTopLeftY + 1;
	}

	@Override
	public int getId() {
		return this._mapId;
	}

	@Override
	public int getOriginalTile(final int x, final int y) {
		return this.accessOriginalTile(x, y);
	}

	/*
	 * ものすごく良くない気がする
	 */
	public byte[][] getRawTiles() {
		return this._map;
	}

	@Override
	public int getTile(final int x, final int y) {
		final short tile = this._map[x - this._worldTopLeftX][y - this._worldTopLeftY];
		if (0 != (tile & BITFLAG_IS_IMPASSABLE)) {
			return 300;
		}
		return this.accessOriginalTile(x, y);
	}

	@Override
	public int getWidth() {
		return this._worldBottomRightX - this._worldTopLeftX + 1;
	}

	@Override
	public int getX() {
		return this._worldTopLeftX;
	}

	@Override
	public int getY() {
		return this._worldTopLeftY;
	}

	@Override
	public boolean isArrowPassable(final int x, final int y) {
		return (this.accessOriginalTile(x, y) & 0x0e) != 0;
	}

	@Override
	public boolean isArrowPassable(final int x, final int y, final int heading) {
		// 現在のタイル
		final int tile1 = this.accessTile(x, y);
		// 移動予定のタイル
		int tile2;
		// 移動予定の座標
		int newX;
		int newY;

		if (heading == 0) {
			tile2 = this.accessTile(x, y - 1);
			newX = x;
			newY = y - 1;
		}
		else if (heading == 1) {
			tile2 = this.accessTile(x + 1, y - 1);
			newX = x + 1;
			newY = y - 1;
		}
		else if (heading == 2) {
			tile2 = this.accessTile(x + 1, y);
			newX = x + 1;
			newY = y;
		}
		else if (heading == 3) {
			tile2 = this.accessTile(x + 1, y + 1);
			newX = x + 1;
			newY = y + 1;
		}
		else if (heading == 4) {
			tile2 = this.accessTile(x, y + 1);
			newX = x;
			newY = y + 1;
		}
		else if (heading == 5) {
			tile2 = this.accessTile(x - 1, y + 1);
			newX = x - 1;
			newY = y + 1;
		}
		else if (heading == 6) {
			tile2 = this.accessTile(x - 1, y);
			newX = x - 1;
			newY = y;
		}
		else if (heading == 7) {
			tile2 = this.accessTile(x - 1, y - 1);
			newX = x - 1;
			newY = y - 1;
		}
		else {
			return false;
		}

		if (this.isExistDoor(newX, newY)) {
			return false;
		}

		// if (Config.ARROW_PASS_FLOWER_BED) {
		// if (tile2 == 0x00 || (tile2 & 0x10) == 0x10) { // 花壇
		// if (tile2 == 0x00) { // 花壇
		// return true;
		// }
		// }

		if (heading == 0) {
			return (tile1 & 0x08) == 0x08;
		}
		else if (heading == 1) {
			final int tile3 = this.accessTile(x, y - 1);
			final int tile4 = this.accessTile(x + 1, y);
			return ((tile3 & 0x04) == 0x04) || ((tile4 & 0x08) == 0x08);
		}
		else if (heading == 2) {
			return (tile1 & 0x04) == 0x04;
		}
		else if (heading == 3) {
			final int tile3 = this.accessTile(x, y + 1);
			return (tile3 & 0x04) == 0x04;
		}
		else if (heading == 4) {
			return (tile2 & 0x08) == 0x08;
		}
		else if (heading == 5) {
			return ((tile2 & 0x04) == 0x04) || ((tile2 & 0x08) == 0x08);
		}
		else if (heading == 6) {
			return (tile2 & 0x04) == 0x04;
		}
		else if (heading == 7) {
			final int tile3 = this.accessTile(x - 1, y);
			return (tile3 & 0x08) == 0x08;
		}

		return false;
	}

	@Override
	public boolean isArrowPassable(final Point pt) {
		return this.isArrowPassable(pt.getX(), pt.getY());
	}

	@Override
	public boolean isArrowPassable(final Point pt, final int heading) {
		return this.isArrowPassable(pt.getX(), pt.getY(), heading);
	}

	@Override
	public boolean isCombatZone(final int x, final int y) {
		final int tile = this.accessOriginalTile(x, y);

		return (tile & 0x30) == 0x20;
	}

	@Override
	public boolean isCombatZone(final Point pt) {
		return this.isCombatZone(pt.getX(), pt.getY());
	}

	@Override
	public boolean isEnabledDeathPenalty() {
		return this._isEnabledDeathPenalty;
	}

	@Override
	public boolean isEscapable() {
		return this._isEscapable;
	}

	@Override
	public boolean isExistDoor(final int x, final int y) {
		for (final L1DoorInstance door : DoorTable.getInstance().getDoorList()) {
			if (this._mapId != door.getMapId()) {
				continue;
			}
			if (door.getOpenStatus() == ActionCodes.ACTION_Open) {
				continue;
			}
			if (door.isDead()) {
				continue;
			}
			final int leftEdgeLocation = door.getLeftEdgeLocation();
			final int rightEdgeLocation = door.getRightEdgeLocation();
			final int size = rightEdgeLocation - leftEdgeLocation;
			if (size == 0) { // 1マス分の幅のドア
				if ((x == door.getX()) && (y == door.getY())) {
					return true;
				}
			}
			else { // 2マス分以上の幅があるドア
				if (door.getDirection() == 0) { // ／方向
					for (int doorX = leftEdgeLocation; doorX <= rightEdgeLocation; doorX++) {
						if ((x == doorX) && (y == door.getY())) {
							return true;
						}
					}
				}
				else { // ＼方向
					for (int doorY = leftEdgeLocation; doorY <= rightEdgeLocation; doorY++) {
						if ((x == door.getX()) && (y == doorY)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean isFishingZone(final int x, final int y) {
		return this.accessOriginalTile(x, y) == 28; // 3.3C 釣魚池可釣魚區域
	}

	@Override
	public boolean isInMap(final int x, final int y) {
		// 确定的棕色领域的地区
		if ((this._mapId == 4) && ((x < 32520) || (y < 32070) || ((y < 32190) && (x < 33950)))) {
			return false;
		}
		return ((this._worldTopLeftX <= x) && (x <= this._worldBottomRightX) && (this._worldTopLeftY <= y) && (y <= this._worldBottomRightY));
	}

	@Override
	public boolean isInMap(final Point pt) {
		return this.isInMap(pt.getX(), pt.getY());
	}

	@Override
	public boolean isMarkable() {
		return this._isMarkable;
	}

	@Override
	public boolean isNormalZone(final int x, final int y) {
		final int tile = this.accessOriginalTile(x, y);
		return (tile & 0x30) == 0x00;
	}

	@Override
	public boolean isNormalZone(final Point pt) {
		return this.isNormalZone(pt.getX(), pt.getY());
	}

	@Override
	public boolean isPassable(final int x, final int y) {
		return this.isPassable(x, y - 1, 4) || this.isPassable(x + 1, y, 6) || this.isPassable(x, y + 1, 0) || this.isPassable(x - 1, y, 2);
	}

	@Override
	public boolean isPassable(final int x, final int y, final int heading) {
		// 目前的面向
		final int tile1 = this.accessTile(x, y);
		// 移动后的面向
		int tile2;

		if (heading == 0) {
			tile2 = this.accessTile(x, y - 1);
		}
		else if (heading == 1) {
			tile2 = this.accessTile(x + 1, y - 1);
		}
		else if (heading == 2) {
			tile2 = this.accessTile(x + 1, y);
		}
		else if (heading == 3) {
			tile2 = this.accessTile(x + 1, y + 1);
		}
		else if (heading == 4) {
			tile2 = this.accessTile(x, y + 1);
		}
		else if (heading == 5) {
			tile2 = this.accessTile(x - 1, y + 1);
		}
		else if (heading == 6) {
			tile2 = this.accessTile(x - 1, y);
		}
		else if (heading == 7) {
			tile2 = this.accessTile(x - 1, y - 1);
		}
		else {
			return false;
		}

		if ((tile2 & BITFLAG_IS_IMPASSABLE) == BITFLAG_IS_IMPASSABLE) {
			return false;
		}

		if (!(((tile2 & 0x02) == 0x02) || ((tile2 & 0x01) == 0x01))) {
			return false;
		}

		if (heading == 0) {
			return (tile1 & 0x02) == 0x02;
		}
		else if (heading == 1) {
			final int tile3 = this.accessTile(x, y - 1);
			final int tile4 = this.accessTile(x + 1, y);
			return ((tile3 & 0x01) == 0x01) || ((tile4 & 0x02) == 0x02);
		}
		else if (heading == 2) {
			return (tile1 & 0x01) == 0x01;
		}
		else if (heading == 3) {
			final int tile3 = this.accessTile(x, y + 1);
			return (tile3 & 0x01) == 0x01;
		}
		else if (heading == 4) {
			return (tile2 & 0x02) == 0x02;
		}
		else if (heading == 5) {
			return ((tile2 & 0x01) == 0x01) || ((tile2 & 0x02) == 0x02);
		}
		else if (heading == 6) {
			return (tile2 & 0x01) == 0x01;
		}
		else if (heading == 7) {
			final int tile3 = this.accessTile(x - 1, y);
			return (tile3 & 0x02) == 0x02;
		}

		return false;
	}

	@Override
	public boolean isPassable(final Point pt) {
		return this.isPassable(pt.getX(), pt.getY());
	}

	@Override
	public boolean isPassable(final Point pt, final int heading) {
		return this.isPassable(pt.getX(), pt.getY(), heading);
	}

	@Override
	public boolean isRecallPets() {
		return this._isRecallPets;
	}

	@Override
	public boolean isSafetyZone(final int x, final int y) {
		final int tile = this.accessOriginalTile(x, y);

		return (tile & 0x30) == 0x10;
	}

	@Override
	public boolean isSafetyZone(final Point pt) {
		return this.isSafetyZone(pt.getX(), pt.getY());
	}

	@Override
	public boolean isTakePets() {
		return this._isTakePets;
	}

	@Override
	public boolean isTeleportable() {
		return this._isTeleportable;
	}

	@Override
	public boolean isUnderwater() {
		return this._isUnderwater;
	}

	@Override
	public boolean isUsableItem() {
		return this._isUsableItem;
	}

	@Override
	public boolean isUsableSkill() {
		return this._isUsableSkill;
	}

	@Override
	public boolean isUsePainwand() {
		return this._isUsePainwand;
	}

	@Override
	public boolean isUseResurrection() {
		return this._isUseResurrection;
	}

	@Override
	public void setPassable(final int x, final int y, final boolean isPassable) {
		if (isPassable) {
			this.setTile(x, y, (short) (this.accessTile(x, y) & (~BITFLAG_IS_IMPASSABLE)));
		}
		else {
			this.setTile(x, y, (short) (this.accessTile(x, y) | BITFLAG_IS_IMPASSABLE));
		}
	}

	@Override
	public void setPassable(final Point pt, final boolean isPassable) {
		this.setPassable(pt.getX(), pt.getY(), isPassable);
	}

	@Override
	public String toString(final Point pt) {
		return "" + this.getOriginalTile(pt.getX(), pt.getY());
	}

	private int accessOriginalTile(final int x, final int y) {
		return this.accessTile(x, y) & (~BITFLAG_IS_IMPASSABLE);
	}

	private int accessTile(final int x, final int y) {
		if (!this.isInMap(x, y)) { // XXX とりあえずチェックする。これは良くない。
			return 0;
		}

		return this._map[x - this._worldTopLeftX][y - this._worldTopLeftY];
	}

	private void setTile(final int x, final int y, final int tile) {
		if (!this.isInMap(x, y)) { // XXX とりあえずチェックする。これは良くない。
			return;
		}
		this._map[x - this._worldTopLeftX][y - this._worldTopLeftY] = (byte) tile;
	}
}
