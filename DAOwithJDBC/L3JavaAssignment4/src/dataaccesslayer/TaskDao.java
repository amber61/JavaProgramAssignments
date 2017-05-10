package dataaccesslayer;

/* File: TaskDao.java
 * Author: Zhe Huang
 * Date: 2016
 * Description: Implementation an interface of TaskDao
 */
import java.util.List;
import datatransferobjects.Task;

/**
 * Implementation an interface of TaskDao. Code in this file was based on
 * lecture materials provided by Stanley Pieda(2015) personal communication
 * 
 * @author ZHE Huang
 * @version 1.0.0
 * @see java.util.List
 * @see datatransferobjects.Task
 * @since 1.8.0_73
 */
public interface TaskDao {

	/**
	 * Interface of get all the tasks
	 * 
	 * @return List return a list of tasks
	 */
	public List<Task> getAllTasks();

	/**
	 * Interface of get task according id
	 * 
	 * @return Task return a task
	 * @param taskId
	 *            given taskId
	 */
	public Task getTaskById(int taskId);

	/**
	 * Interface of add a task
	 * 
	 * @param task
	 *            given task
	 */
	public void addTask(Task task);

	/**
	 * Interface of update a task
	 * 
	 * @param task
	 *            given task
	 */
	public void updateTask(Task task);

	/**
	 * Interface of delete a task
	 * 
	 * @param task
	 *            given task
	 */
	public void deleteTask(Task task);

}
