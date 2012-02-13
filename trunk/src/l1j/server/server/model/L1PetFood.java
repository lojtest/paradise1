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

import l1j.server.server.datatables.PetTable;
import l1j.server.server.datatables.PetTypeTable;
import l1j.server.server.model.Instance.L1PetInstance;
import l1j.server.server.serverpackets.S_NpcChatPacket;
import l1j.server.server.templates.L1Pet;
import l1j.server.server.templates.L1PetType;

/**
 * 宠物饱食度计时器
 */
public class L1PetFood extends TimerTask {

	private final L1PetInstance _pet;

	private int _food = 0;

	private final L1Pet _l1pet;

	/** 宠物饱食度计时器 */
	public L1PetFood(final L1PetInstance pet, final int itemObj) {
		_pet = pet;
		_l1pet = PetTable.getInstance().getTemplate(itemObj);
	}

	@Override
	public void run() {
		if ((_pet != null) && !_pet.isDead()) {
			_food = _pet.get_food() - 2;
			if (_food <= 0) {
				_pet.set_food(0);
				_pet.setCurrentPetStatus(3);

				// 非常饿时提醒主人
				final L1PetType type = PetTypeTable.getInstance().get(_pet.getNpcTemplate().get_npcId());
				final int id = type.getDefyMessageId();
				if (id != 0) {
					_pet.broadcastPacket(new S_NpcChatPacket(_pet, "$" + id, 0));
				}
			}
			else {
				_pet.set_food(_food);
			}
			if (_l1pet != null) {
				// 纪录宠物饱食度
				_l1pet.set_food(_pet.get_food());
				PetTable.getInstance().storePetFood(_l1pet);
			}
		}
		else {
			cancel();
		}
	}

}
