package datatransferobjects;

/* File: Task.java
 * Author: Zhe Huang
 * Date: 2016
 * Description: Implementation of elements of Task
 */
import java.sql.Date;

/**
 * Implementation of elements of Task. Code in this file was based on lecture
 * materials provided by Stanley Pieda(2015) personal communication
 * 
 * @author ZHE Huang
 * @version 1.0.0
 * @see java.sql.Date
 * @since 1.8.0_73
 */
public class Task {

	/**
	 * Field to access taskId
	 */
	private int taskId;

	/**
	 * Field to access title
	 */
	private String title;

	/**
	 * Field to access priotiry
	 */
	private String priotiry;

	/**
	 * Field to access isComplete
	 */
	private boolean isComplete;

	/**
	 * Field to access dateCompleted
	 */
	private Date dateCompleted;

	/**
	 * Field to access note
	 */
	private String note;

	/**
	 * Getter to taskId
	 * 
	 * @return int return id of task
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * Setter to taskId
	 * 
	 * @param taskId
	 *            id of task
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	/**
	 * Getter to title
	 * 
	 * @return String return title of task
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Setter to title
	 * 
	 * @param title
	 *            title of task
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Getter to priotiry
	 * 
	 * @return String return priotiry of taskId
	 */
	public String getPriority() {
		return priotiry;
	}

	/**
	 * Setter to priotiry
	 * 
	 * @param priotiry
	 *            priotiry of task
	 */
	public void setPriority(String priotiry) {
		this.priotiry = priotiry;
	}

	/**
	 * Getter to isComplete
	 * 
	 * @return boolean return isComplete of task
	 */
	public boolean getIsComplete() {
		return isComplete;
	}

	/**
	 * Setter to isComplete
	 * 
	 * @param isComplete
	 *            isComplete of task
	 */
	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	/**
	 * Getter to dateCompleted
	 * 
	 * @return Date return dateCompleted of task
	 */
	public Date getDateCompleted() {
		return dateCompleted;
	}

	/**
	 * Setter to dateCompleted
	 * 
	 * @param dateCompleted
	 *            dateCompleted of task
	 */
	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	/**
	 * Getter to note
	 * 
	 * @return String return note of task
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Setter to note
	 * 
	 * @param note
	 *            note of task
	 */
	public void setNote(String note) {
		this.note = note;
	}
}
