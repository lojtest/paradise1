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

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.List;
import java.util.StringTokenizer;

import l1j.server.server.Opcodes;
import l1j.server.server.utils.collections.Lists;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

/**
 * 公告视窗 (点击登入后)
 */
public class S_CommonNews extends ServerBasePacket {

	private List<String> _announcements;

	public S_CommonNews() {
		_announcements = Lists.newList();
		loadAnnouncements();
		writeC(Opcodes.S_OPCODE_COMMONNEWS);
		String message = "";
		for (int i = 0; i < _announcements.size(); i++) {
			message = (new StringBuilder()).append(message).append(_announcements.get(i)).append("\n").toString();
		}
		writeS(message);
	}

	/**
	 * 公告视窗 (点击登入后)
	 * 
	 * @param s
	 */
	public S_CommonNews(final String s) {
		writeC(Opcodes.S_OPCODE_COMMONNEWS);
		writeS(s);
	}

	@Override
	public byte[] getContent() {
		return getBytes();
	}

	@Override
	public String getType() {
		return "[S] S_CommonNews";
	}

	/** 载入公告 */
	private void loadAnnouncements() {
		_announcements.clear();
		final File file = new File("data/announcements.txt");
		if (file.exists()) {
			readFromDisk(file);
		}
	}

	/** 读取 */
	private void readFromDisk(final File file) {
		LineNumberReader lnr = null;
		try {
			String line = null;
			lnr = new LineNumberReader(new FileReader(file));
			do {
				if ((line = lnr.readLine()) == null) {
					break;
				}
				final StringTokenizer st = new StringTokenizer(line, "\n\r");
				if (st.hasMoreTokens()) {
					final String announcement = st.nextToken();
					_announcements.add(announcement);
				}
				else {
					_announcements.add(" ");
				}
			} while (true);
		}
		catch (final Exception e) {
		}
	}

}
