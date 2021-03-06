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
package l1j.server.server.taskmanager.tasks;

import l1j.server.server.Shutdown;
import l1j.server.server.taskmanager.Task;
import l1j.server.server.taskmanager.TaskManager.ExecutedTask;

/**
 * @author Layane
 * 
 */
public class TaskShutdown extends Task {
	public static String NAME = "shutdown";

	/*
	 * (non-Javadoc)
	 * 
	 * @see l1j.server.server.taskmanager.Task#getName()
	 */
	@Override
	public String getName() {
		return NAME;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see l1j.server.server.taskmanager.Task#onTimeElapsed(l1j.server.server.taskmanager.TaskManager.ExecutedTask)
	 */
	@Override
	public void onTimeElapsed(final ExecutedTask task) {
		final Shutdown handler = new Shutdown(Integer.valueOf(task.getParams()[2]), false);
		handler.start();
	}

}
