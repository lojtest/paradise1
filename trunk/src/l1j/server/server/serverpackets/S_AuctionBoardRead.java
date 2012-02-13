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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.L1DatabaseFactory;
import l1j.server.server.Opcodes;
import l1j.server.server.utils.SQLUtil;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

/**
 * 拍卖盟屋公告栏内容
 */
public class S_AuctionBoardRead extends ServerBasePacket {

	private static Logger _log = Logger.getLogger(S_AuctionBoardRead.class.getName());
	private static final String S_AUCTIONBOARDREAD = "[S] S_AuctionBoardRead";
	private byte[] _byte = null;

	public S_AuctionBoardRead(final int objectId, final String house_number) {
		buildPacket(objectId, house_number);
	}

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = getBytes();
		}
		return _byte;
	}

	@Override
	public String getType() {
		return S_AUCTIONBOARDREAD;
	}

	private void buildPacket(final int objectId, final String house_number) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			final int number = Integer.valueOf(house_number);
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM board_auction WHERE house_id=?");
			pstm.setInt(1, number);
			rs = pstm.executeQuery();
			while (rs.next()) {
				writeC(Opcodes.S_OPCODE_SHOWHTML);
				writeD(objectId);
				writeS("agsel"); // 对话档名称
				writeS(house_number); // 盟屋编号
				writeH(9); // 以下显示数字个数
				writeS(rs.getString(2)); // 盟屋名称
				writeS(rs.getString(6)); // 盟屋位置
				writeS(String.valueOf(rs.getString(3))); // 盟屋面积
				writeS(rs.getString(7)); // 前任屋主
				writeS(rs.getString(9)); // 现任屋主
				writeS(String.valueOf(rs.getInt(5))); // 售屋价格
				final Calendar cal = timestampToCalendar((Timestamp) rs.getObject(4));
				final int month = cal.get(Calendar.MONTH) + 1;
				final int day = cal.get(Calendar.DATE);
				final int hour = cal.get(Calendar.HOUR_OF_DAY);
				writeS(String.valueOf(month)); // 截止月
				writeS(String.valueOf(day)); // 截止日
				writeS(String.valueOf(hour)); // 截止时
			}
		}
		catch (final SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}

	private Calendar timestampToCalendar(final Timestamp ts) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(ts.getTime());
		return cal;
	}
}
