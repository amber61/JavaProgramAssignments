package businesslayer;

/* File: TaskBusinessLogic.java
 * Author: Zhe Huang
 * Date: 2016
 * Description: Implementation business logic layer of task
 */
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import dataaccesslayer.TaskDao;
import dataaccesslayer.TaskDaoImpl;
import datatransferobjects.Task;

/**
 * Implementation business logic layer of task. Code in this file was based on
 * lecture materials provided by Stanley Pieda(2015) personal communication
 * 
 * @author ZHE Huang
 * @version 1.0.0
 * @see java.sql.Date
 * @see java.util.List
 * @see dataaccesslayer.TaskDao
 * @see dataaccesslayer.TaskDaoImpl
 * @see datatransferobjects.Task
 * @since 1.8.0_73
 */
public class TaskBusinessLogic {

	/**
	 * {@value} Description the constant of TITLE_MAX_LENGTH
	 */
	private final static int TITLE_MAX_LENGTH = 50;

	/**
	 * {@value} Description the constant of PRIORITY_MAX_LENGTH
	 */
	private final static int PRIORITY_MAX_LENGTH = 6;

	/**
	 * {@value} Description the constant of NOTE_MAX_LENGTH
	 */
	private final static int NOTE_MAX_LENGTH = 250;

	/**
	 * Reference to access taskDao
	 */
	private TaskDao taskDao;

	/**
	 * Default constructor
	 */
	public TaskBusinessLogic() {
		taskDao = new TaskDaoImpl();
	}

	/**
	 * Get all tasks
	 * 
	 * @return List return a list of tasks
	 */
	public List<Task> getAllTasks() {
		return taskDao.getAllTasks();
	}

	/**
	 * Get tasks by id
	 * 
	 * @param taskId
	 *            given taskId
	 * @return Task return a task
	 */
	public Task getTaskById(int taskId) {
		return taskDao.getTaskById(taskId);
	}

	/**
	 * Add a task
	 * 
	 * @param task
	 *            given task
	 * @throws ValidationException
	 *             throws exception if any
	 */
	public void addTask(Task task) throws ValidationException {
		cleanTask(task);
		validateTask(task);
		taskDao.addTask(task);
	}

	/**
	 * Update a task
	 * 
	 * @param task
	 *            given task
	 * @throws ValidationException
	 *             throws exception if any
	 */
	public void updateTask(Task task) throws ValidationException {
		cleanTask(task);
		validateTask(task);
		taskDao.updateTask(task);
	}

	/**
	 * Delete a task
	 * 
	 * @param task
	 *            given task
	 */
	public void deleteTask(Task task) {
		taskDao.deleteTask(task);
	}

	/**
	 * Clean the data of a task
	 * 
	 * @param task
	 *            given task
	 */
	private void cleanTask(Task task) {
		if (task.getTitle() != null) {
			task.setTitle(cleanString(task.getTitle()));
		}
		if (task.getPriority() != null) {
			task.setPriority(cleanString(cleanString(task.getPriority())));
		}
		if (task.getNote() != null) {
			task.setNote(cleanString(cleanString(task.getNote())));
		}
	}

	/**
	 * Clean the given string
	 * 
	 * @param data
	 *            given data
	 * @return String return data
	 */
	private String cleanString(String data) {
		if (data != null) {
			data = data.trim();
		}
		return data;
	}

	/**
	 * Validate a task
	 * 
	 * @param task
	 *            given task
	 * @throws ValidationException
	 *             throws exception if any
	 */
	private void validateTask(Task task) throws ValidationException {
		validateString(task.getTitle(), "Title", TITLE_MAX_LENGTH, false);
		validateString(task.getPriority(), "Priority", PRIORITY_MAX_LENGTH,
				false);
		validateDate(task.getDateCompleted());
		validateString(task.getNote(), "Note", NOTE_MAX_LENGTH, true);

	}

	/**
	 * Validate a string
	 * 
	 * @param value
	 *            given string
	 * @param fieldName
	 *            given column
	 * @param maxLength
	 *            given max length
	 * @param isNullAllowed
	 *            give boolean value
	 * @throws ValidationException
	 *             throws exception if any
	 */
	private void validateString(String value, String fieldName, int maxLength,
			boolean isNullAllowed) throws ValidationException {
		if (value == null && isNullAllowed) {
			// return; // null permitted, nothing to validate
		} else if (value == null && !isNullAllowed) {
			throw new ValidationException(
					String.format("%s cannot be null", fieldName));
		} else if (value.length() == 0) {
			throw new ValidationException(String.format(
					"%s cannot be empty or only whitespace", fieldName));
		} else if (value.length() > maxLength) {
			throw new ValidationException(String.format(
					"%s cannot exceed %d characters", fieldName, maxLength));
		} else if (value != null && fieldName.equals("Priority")) {
			if (!value.equals("high") && !value.equals("medium")
					&& !value.equals("low")) {
				throw new ValidationException(String.format(
						"%s can only be one of high, medium and low",
						fieldName));
			}
		}
	}

	/**
	 * Validate a date
	 * 
	 * @param value
	 *            give Date
	 * @throws ValidationException
	 *             throws exception if any
	 */
	private void validateDate(Date value) throws ValidationException {
		// make sure the DateCompleted is not a future date
		if (value != null) {
			long a = value.getTime();
			long b = Date.valueOf(LocalDate.now()).getTime();
			if (a > b) {
				throw new ValidationException(
						"DateCompleted cannot be a future date");
			}
		}
	}
}
