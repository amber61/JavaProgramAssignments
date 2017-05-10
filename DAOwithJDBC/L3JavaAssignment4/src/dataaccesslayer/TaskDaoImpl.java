package dataaccesslayer;

/* File: TaskDaoImpl.java
 * Author: Zhe Huang
 * Date: 2016
 * Description: Implementation from TaskDao
 */
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import datatransferobjects.Task;

/**
 * Implementation from TaskDao. Code in this file was based on lecture materials
 * provided by Stanley Pieda(2015) personal communication
 * 
 * @author ZHE Huang
 * @version 1.0.0
 * @see java.util.ArrayList
 * @see java.util.List
 * @see java.sql.Connection
 * @see java.sql.PreparedStatement
 * @see java.sql.ResultSet
 * @see java.sql.SQLException
 * @see datatransferobjects.Task
 * @since 1.8.0_73
 */
public class TaskDaoImpl implements TaskDao {

	/**
	 * Get all tasks
	 * 
	 * @return List return all tasks
	 */
	@Override
	public List<Task> getAllTasks() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Task> tasks = null;
		try {
			DataSource ds = new DataSource();
			con = ds.createConnection();
			pstmt = con.prepareStatement(
					"SELECT TaskID, Title, Priority, IsComplete, DateCompleted, Note FROM tasks ORDER BY TaskID");
			rs = pstmt.executeQuery();
			tasks = new ArrayList<Task>();
			while (rs.next()) {
				Task task = new Task();
				task.setTaskId(rs.getInt("TaskID"));
				task.setTitle(rs.getString("Title"));
				task.setPriority(rs.getString("Priority"));
				task.setIsComplete(rs.getBoolean("IsComplete"));
				task.setDateCompleted(rs.getDate("DateCompleted"));
				task.setNote(rs.getString("Note"));
				tasks.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return tasks;
	}

	/**
	 * Get task according to taskId
	 * 
	 * @param taskId
	 *            given taskId
	 * @return Task return a task
	 */
	@Override
	public Task getTaskById(int taskId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Task task = null;
		try {
			DataSource ds = new DataSource();
			con = ds.createConnection();
			pstmt = con.prepareStatement(
					"SELECT TaskID, Title, Priority, IsComplete, DateCompleted, Note FROM tasks WHERE TaskID = ?");
			pstmt.setInt(1, taskId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				task = new Task();
				task.setTaskId(rs.getInt("TaskID"));
				task.setTitle(rs.getString("Title"));
				task.setPriority(rs.getString("Priority"));
				task.setIsComplete(rs.getBoolean("IsComplete"));
				task.setDateCompleted(rs.getDate("DateCompleted"));
				task.setNote(rs.getString("Note"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return task;
	}

	/**
	 * Add a task
	 * 
	 * @param task
	 *            given task
	 */
	@Override
	public void addTask(Task task) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			DataSource ds = new DataSource();
			con = ds.createConnection();
			// do not insert TaskID, it is generateed by Database
			pstmt = con.prepareStatement(
					"INSERT INTO tasks (Title, Priority, IsComplete, DateCompleted, Note) "
							+ "VALUES(?, ?, ?, ?, ?)");
			pstmt.setString(1, task.getTitle());
			pstmt.setString(2, task.getPriority());
			pstmt.setBoolean(3, task.getIsComplete());
			pstmt.setDate(4, task.getDateCompleted());
			pstmt.setString(5, task.getNote());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	/**
	 * Update a task
	 * 
	 * @param task
	 *            given task
	 */
	@Override
	public void updateTask(Task task) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			DataSource ds = new DataSource();
			con = ds.createConnection();
			pstmt = con.prepareStatement(
					"UPDATE tasks SET Title = ?, Priority = ?, IsComplete = ?, DateCompleted = ?, Note = ? WHERE TaskID = ?");
			pstmt.setString(1, task.getTitle());
			pstmt.setString(2, task.getPriority());
			pstmt.setBoolean(3, task.getIsComplete());
			pstmt.setDate(4, task.getDateCompleted());
			pstmt.setString(5, task.getNote());
			pstmt.setInt(6, task.getTaskId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	/**
	 * Delete a task
	 * 
	 * @param task
	 *            given task
	 */
	@Override
	public void deleteTask(Task task) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			DataSource ds = new DataSource();
			con = ds.createConnection();
			pstmt = con.prepareStatement("DELETE FROM tasks WHERE TaskID = ?");
			pstmt.setInt(1, task.getTaskId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

}
