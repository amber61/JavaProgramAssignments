package Assignment4StarterCode;

/* File: SimpleTest.java
 * Author: Stanley Pieda
 * Date: 2015
 * Description: Starter code for Lab Assignment 4 
 */
import businesslayer.TaskBusinessLogic;
import businesslayer.ValidationException;
import datatransferobjects.Task;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Simple test harness to test DAO with business layer To Do: Stan... Replace
 * this with JUnit testing. (and Quickly!)
 * 
 * @author Stan Pieda
 * @see businesslayer.TaskBusinessLogic
 * @see businesslayer.ValidationException
 * @see datatransferobjects.Task
 * @see java.util.List
 * @see java.sql.Date
 * @see java.time.LocalDate
 * @version 1.0.0
 * @since 1.8.0_73
 */
public class SimpleTest {

	/**
	 * Runs a sequence of tests.
	 */
	public void runTest() {
		try {
			TaskBusinessLogic logic = new TaskBusinessLogic();
			List<Task> list = null;
			Task task = null;

			System.out.println("Printing Tasks");
			list = logic.getAllTasks();
			printTasks(list);

			System.out.println("Printing One Task");
			task = logic.getTaskById(1);
			printTask(task);
			System.out.println();

			System.out.println("Inserting One Task");
			task = new Task();
			task.setTitle("Test Title");
			task.setPriority("high"); // change p
			task.setIsComplete(true);
			Date date = Date.valueOf(LocalDate.now());
			task.setDateCompleted(date);
			task.setNote("Test Note");
			logic.addTask(task);
			list = logic.getAllTasks();
			printTasks(list);

			// assume the returned list has the last task added at the end.
			System.out.println("Updating inserted Task");
			task = new Task();
			int taskId = list.get(list.size() - 1).getTaskId();
			task.setTaskId(taskId);
			task.setTitle("Test Title 42");
			task.setPriority("medium");
			task.setIsComplete(false);
			date = Date.valueOf(LocalDate.now());
			task.setDateCompleted(date);
			task.setNote("Test Note 42");
			logic.updateTask(task);
			list = logic.getAllTasks();
			printTasks(list);

			// testing validation, each of these should also be tested against
			// addTask(Task)
			// as well but only updateTask(Task) was used.
			try {
				System.out.println("Checking for exception from null title.");
				task = new Task();
				task.setTaskId(taskId);
				task.setPriority("high");
				logic.updateTask(task);
				System.out.println("well that didn't work");
			} catch (ValidationException e) {
				System.out.println("Title null check: " + e.getMessage());
			} // Codes to check for exception from null title
			System.out.println();
			try {
				System.out
						.println("Checking for exception from null priority.");
				task = new Task();
				task.setTaskId(taskId);
				task.setTitle("good");
				task.setPriority(null);
				logic.updateTask(task);
				System.out.println("well that didn't work");
			} catch (ValidationException e) {
				System.out.println("Priority null check: " + e.getMessage());
			} // Codes to check for exception from null priority
			System.out.println();
			try {
				System.out.println("Checking for no-exception from null note.");
				task = new Task();
				task.setTaskId(taskId);
				task.setTitle("good");
				task.setPriority("high");
				task.setNote(null);
				logic.updateTask(task);
				System.out.println("well that worked");
			} catch (ValidationException e) {
				System.out.println("Note null permitted check didn't work: "
						+ e.getMessage());
			} // Codes to check for no-exception from null note
			System.out.println();
			try {
				System.out.println("Checking for exception from empty title.");
				task = new Task();
				task.setTaskId(taskId);
				task.setTitle("");
				task.setPriority("high");
				logic.updateTask(task);
				System.out.println("well that didn't work");
			} catch (ValidationException e) {
				System.out.println("Title empty check: " + e.getMessage());
			} // Codes to check for exception from empty title
			System.out.println();
			try {
				System.out
						.println("Checking for exception from empty priority.");
				task = new Task();
				task.setTaskId(taskId);
				task.setTitle("good");
				task.setPriority("");
				logic.updateTask(task);
				System.out.println("well that didn't work");
			} catch (ValidationException e) {
				System.out.println("Priority empty check: " + e.getMessage());
			} // Codes to check for exception from empty priority
			System.out.println();
			try {
				System.out.println("Checking for exception from empty notes.");
				task = new Task();
				task.setTaskId(taskId);
				task.setTitle("good");
				task.setPriority("high");
				task.setNote("");
				logic.updateTask(task);
				System.out.println("well that didn't work");
			} catch (ValidationException e) {
				System.out.println("Note empty check: " + e.getMessage());
			} // Codes to check for exception from empty notes
			System.out.println();
			try {
				System.out.println("Checking for title too large."); // 50 max
				task = new Task();
				task.setTaskId(taskId);
				task.setTitle("1234567890" + "1234567890" + "1234567890"
						+ "1234567890" + "1234567890" + "1234567890"); // 60
																		// chars
				task.setPriority("high");
				logic.updateTask(task);
				System.out.println("well that didn't work");
			} catch (ValidationException e) {
				System.out.println(" Title too large: " + e.getMessage());
			} // Codes to check Title are too large
			System.out.println();
			try {
				System.out.println("Checking for priority too large."); // 6 max
				task = new Task();
				task.setTaskId(taskId);
				task.setTitle("good");
				task.setPriority("1234567890"); // 10 chars
				logic.updateTask(task);
				System.out.println("well that didn't work");
			} catch (ValidationException e) {
				System.out.println(" Priority too large: " + e.getMessage());
			} // Codes to check Priority are too large
			System.out.println();
			try {
				System.out.println("Checking for notes too large."); // 250 max
				task = new Task();
				task.setTaskId(taskId);
				task.setTitle("good"); // 10 chars
				task.setPriority("high");
				String bigNote = "";
				for (int i = 1; i <= 100; i++) {
					bigNote += "1234567890"; // 100 * 10 chars = 1000 chars
				}
				task.setNote(bigNote);
				logic.updateTask(task);
				System.out.println("well that didn't work");
			} catch (ValidationException e) {
				System.out.println(" Notes too large: " + e.getMessage());
			} // Codes to check notes are too large
			System.out.println();
			try {
				System.out.println("Checking for value of priority.");
				task = new Task();
				task.setTaskId(taskId);
				task.setTitle("good");
				task.setPriority("Java");
				logic.updateTask(task);
				System.out.println("well that didn't work");
			} catch (ValidationException e) {
				System.out.println("Priority Value check: " + e.getMessage());
			} // Codes to check whether value of priority is one of three.
			System.out.println();
			try {
				System.out.println("Validation for Date.");
				task = new Task();
				task.setTaskId(taskId);
				task.setTitle("good");
				task.setPriority("low");
				task.setNote("note");

				Date d = new Date(2017, 4, 5); // Set a future time
				task.setDateCompleted(d);

				logic.updateTask(task);
				System.out.println("well that didn't work");
			} catch (ValidationException e) {
				System.out.println("Date validation check: " + e.getMessage());
			} // Codes to check Date validation
			System.out.println();
			System.out.println("Deleting updated Title");
			task = logic.getTaskById(taskId);
			logic.deleteTask(task);
			list = logic.getAllTasks();
			printTasks(list);
		} catch (ValidationException e) {
			System.err.println(e.getMessage());
		} // Codes to delete records
	}

	private void printTask(Task task) {
		String output = String
				.format("%d, %s, %s, %b, %s, %s", task.getTaskId(),
						task.getTitle(), task.getPriority(),
						task.getIsComplete(),
						// if task date completed is null provide null, else
						// provide toString()
						(task.getDateCompleted() == null) ? null
								: task.getDateCompleted().toString(),
						task.getNote());
		System.out.println(output);
	}

	private void printTasks(List<Task> tasks) {
		for (Task task : tasks) {
			printTask(task);
		}
		System.out.println();
	}
}
