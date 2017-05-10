package dataaccesslayer;

/* File: DataSource.java
 * Author: Zhe Huang
 * Date: 2016
 * Description: Implementation DataSource
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * Implementation DataSource. Code in this file was based on lecture materials
 * provided by Stanley Pieda(2015) personal communication
 * 
 * @author ZHE Huang
 * @version 1.0.0
 * @see java.sql.DriverManager
 * @see java.sql.SQLException
 * @see java.sql.Connection
 * @since 1.8.0_73
 */
public class DataSource {

	/**
	 * Field to access to connection
	 */
	private Connection connection;

	/**
	 * Field to access to connectionString
	 */
	private String connectionString;

	/**
	 * Field to access to userName
	 */
	private String userName;

	/**
	 * Field to access to password
	 */
	private String password;

	/**
	 * Default constructor
	 */
	public DataSource() {
		connection = null;
		connectionString = "jdbc:mysql://localhost/ToDoList";
		userName = "scott";
		password = "tiger";
	}

	/**
	 * Create the connection with database
	 * 
	 * @return Connection return result of connection
	 */
	public Connection createConnection() {
		try {
			if (connection != null) {
				System.out.println(
						"Cannot create new connection, one exists already");
			} else {
				connection = DriverManager.getConnection(connectionString,
						userName, password);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return connection;
	}

}
