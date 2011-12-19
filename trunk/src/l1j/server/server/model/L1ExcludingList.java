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

import java.util.List;

import l1j.server.server.utils.collections.Lists;

/**
 * 剔除名单
 */
public class L1ExcludingList {

	private List<String> _nameList = Lists.newList();

	public void add(String name) {
		_nameList.add(name);
	}

	/**
	 * 从封锁名单删除指定的角色名称
	 * 
	 * @param name
	 *            角色的名称
	 * @return 实际的删除、客户端的封锁列表的角色。如果没有名称在列表中指定的，则返回null。
	 */
	public String remove(String name) {
		for (String each : _nameList) {
			if (each.equalsIgnoreCase(name)) {
				_nameList.remove(each);
				return each;
			}
		}
		return null;
	}

	/**
	 * 返回封锁角色的指定名称场合true
	 */
	public boolean contains(String name) {
		for (String each : _nameList) {
			if (each.equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 返回该表是否已达到16名的截止上限
	 */
	public boolean isFull() {
		return (_nameList.size() >= 16) ? true : false;
	}
}
