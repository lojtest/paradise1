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

import java.util.Calendar;

import l1j.server.Config;
import l1j.server.server.Opcodes;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

/**
 * 攻城战时间
 */
public class S_WarTime extends ServerBasePacket {

	private static final String S_WAR_TIME = "[S] S_WarTime";

	/**
	 * 攻城时间设定
	 * 
	 * @param cal
	 */
	public S_WarTime(final Calendar cal) {
		// 1997/01/01 17:00を基点としている
		final Calendar base_cal = Calendar.getInstance();
		base_cal.set(1997, 0, 1, 17, 0);
		final long base_millis = base_cal.getTimeInMillis();
		final long millis = cal.getTimeInMillis();
		long diff = millis - base_millis;
		diff -= 1200 * 60 * 1000; // 誤差修正
		diff = diff / 60000; // 分以下切捨て
		// timeは1加算すると3:02（182分）進む
		final int time = (int) (diff / 182);

		// writeDの直前のwriteCで時間の調節ができる
		// 0.7倍した時間だけ縮まるが
		// 1つ調整するとその次の時間が広がる？
		this.writeC(Opcodes.S_OPCODE_WARTIME);
		this.writeH(6); // リストの数（6以上は無効）
		this.writeS(Config.TIME_ZONE); // 時間の後ろの（）内に表示される文字列
		this.writeC(0); // ?
		this.writeC(0); // ?
		this.writeC(0);
		this.writeD(time);
		this.writeC(0);
		this.writeD(time - 1);
		this.writeC(0);
		this.writeD(time - 2);
		this.writeC(0);
		this.writeD(time - 3);
		this.writeC(0);
		this.writeD(time - 4);
		this.writeC(0);
		this.writeD(time - 5);
		this.writeC(0);
	}

	@Override
	public byte[] getContent() {
		return this.getBytes();
	}

	@Override
	public String getType() {
		return S_WAR_TIME;
	}
}
