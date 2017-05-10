package server;

/* File Name:
 * Author Name: Todd
 * Modified By: Zhe Huang
 * Date: 2017-02-18
 * Description: This file defines echo server
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Define echo server. Date February 18, 2017
 * 
 * @author Todd
 * @author Zhe Huang
 * @version 1.0.0
 * @see java.io.IOException
 * @see java.net.Socket
 * @see java.net.ServerSocket
 * @since 1.8.0_73
 */

public class EchoServer {

	/**
	 * Field to server socket
	 */
	private ServerSocket server;

	/**
	 * Field to socket
	 */
	private Socket connection;

	/**
	 * Field to port number
	 */
	private int portNum;

	/**
	 * Field to default port number
	 */
	public static final int DEFAULT_PORT = 8081;

	/**
	 * Entry point for running server
	 * 
	 * @param args
	 *            Command line arguments
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			(new EchoServer(Integer.parseInt(args[0]))).runServer();
		} else {
			(new EchoServer(DEFAULT_PORT)).runServer();
		}
	}

	/**
	 * Constructor. Set up server with port number
	 * 
	 * @param portNum
	 *            port number
	 */
	public EchoServer(int portNum) {
		this.portNum = portNum;
	}

	/**
	 * Start a server.
	 */
	public void runServer() {
		System.out.println("Echo Server Started...");

		try {
			server = new ServerSocket(portNum);
		} catch (IOException e1) {
			System.out.println("Unable to start Echo Server...");
			System.exit(1);
		}

		while (true) {
			try {
				connection = server.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			new Thread(new ClientHandler(connection)).start();
		}
	} // end of method
} // end of class
