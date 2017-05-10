package client;

/* File Name:
 * Author Name: Todd
 * Date: 2017-02-18
 * Description: This file defines echo client
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Define echo client. Date February 18, 2017
 * 
 * @author Todd
 * @version 1.0.0
 * @see java.io.IOException
 * @see java.io.ObjectInputStream
 * @see java.io.ObjectOutputStream
 * @see java.net.InetAddress
 * @see java.net.Socket
 * @see java.io.BufferedReader
 * @see java.io.InputStreamReader
 * @since 1.8.0_73
 */
public class EchoClient {

	/**
	 * Field to message
	 */
	private String message = "";

	/**
	 * Field to server name
	 */
	private String serverName;

	/**
	 * Field to port number
	 */
	private int portNum;

	/**
	 * Field to default server name
	 */
	public static final String DEFAULT_SERVER_NAME = "localhost";

	/**
	 * Entry point for running client
	 * 
	 * @param args
	 *            Command line arguments
	 */
	public static void main(String[] args) {
		switch (args.length) {
		case 2:
			(new EchoClient(args[0], Integer.parseInt(args[1]))).runClient();
			break;
		case 1:
			(new EchoClient(DEFAULT_SERVER_NAME, Integer.parseInt(args[0])))
					.runClient();
			break;
		default:
			(new EchoClient(DEFAULT_SERVER_NAME,
					server.EchoServer.DEFAULT_PORT)).runClient();
		}
	}

	/**
	 * Constructor. Set up client with port number and server name
	 * 
	 * @param portNum
	 *            port number
	 * @param serverName
	 *            server name
	 */
	public EchoClient(String serverName, int portNum) {
		this.serverName = serverName;
		this.portNum = portNum;
	}

	/**
	 * Start a client.
	 */
	public void runClient() {
		// close buffer automatically
		try (BufferedReader keyboard = new BufferedReader(
				new InputStreamReader(System.in))) {
			// close socket and stream automatically
			try (Socket connection = new Socket(
					InetAddress.getByName(serverName), portNum);
					ObjectOutputStream output = new ObjectOutputStream(
							connection.getOutputStream());
					ObjectInputStream input = new ObjectInputStream(
							connection.getInputStream());) {
				System.out.println(
						"To Quit, enter EOF (^Z on Windows; ^D on Linux/Mac)");
				do {
					System.out.print("Input> ");
					message = keyboard.readLine();
					if (message != null) {
						output.writeObject(message);
						output.flush();
						message = (String) input.readObject();
						System.out.println(message);
					}
				} while (message != null);
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}

	} // end of runClient
} // end of class
