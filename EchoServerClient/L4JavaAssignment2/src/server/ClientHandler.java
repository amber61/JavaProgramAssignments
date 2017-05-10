package server;

/* File Name:
 * Author Name: Zhe Huang
 * Date: 2017-02-18
 * Description: This file defines each thread for server
 */
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Define each thread for server. Date February 18, 2017
 * 
 * @author Zhe Huang
 * @version 1.0.0
 * @see java.io.EOFException
 * @see java.io.IOException
 * @see java.io.ObjectInputStream
 * @see java.io.ObjectOutputStream
 * @see java.net.Socket
 * @since 1.8.0_73
 */
public class ClientHandler implements Runnable {

	/**
	 * Field to socket
	 */
	private Socket connection;

	/**
	 * Field to message
	 */
	private String message = "";

	/**
	 * Field to message number
	 */
	private int messagenum;

	/**
	 * Field to default port number
	 */
	public static final int DEFAULT_PORT = 8081;

	/**
	 * Constructor. Set up client handler with socket
	 * 
	 * @param connection
	 *            connection socket
	 */
	public ClientHandler(Socket connection) {
		this.connection = connection;
	}

	/**
	 * Each thread for running server
	 */
	@Override
	public void run() {
		// close stream automatically
		try (ObjectOutputStream output = new ObjectOutputStream(
				connection.getOutputStream());
				ObjectInputStream input = new ObjectInputStream(
						connection.getInputStream());) {
			do {
				try {
					message = (String) input.readObject();
				} catch (EOFException e) {
					message = null;
				}
				if (message != null) {
					output.writeObject(
							messagenum++ + " FromServer> " + message);
					output.flush();
				}
			} while (message != null);
		} catch (IOException exception) {
			// exception.printStackTrace();
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}
	} // end of method

} // end of class
