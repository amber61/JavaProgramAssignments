package server;

/* File Name: SpriteServer.java
 * Author Name: Zhe Huang
 * Date: 2017-03-22
 * Description: This file defines a remote server for sprites.
 */
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

/**
 * This class defines a remote server for sprites. Date March 22, 2017
 * 
 * @author Zhe (Amber) Huang
 * @version 1.0.0
 * @see java.rmi.Naming
 * @see java.rmi.registry.LocateRegistry
 * @see java.rmi.server.RemoteServer
 * @see java.rmi.server.UnicastRemoteObject
 * @since 1.8.0_73
 */
public class SpriteServer extends RemoteServer {

	/**
	 * {@value #serialVersionUID}
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Field to the host name
	 */
	private static String hostName = "localhost";

	/**
	 * {@value #PORTNUM} port number of registry service
	 */
	private static final int PORTNUM = 8081;

	/**
	 * Entry point for server
	 * 
	 * @param args
	 *            Command line arguments (not used)
	 */
	public static void main(String[] args) {
		try {
			SpriteInterface remoteRef = new SpriteInterfaceImpl();
			LocateRegistry.createRegistry(PORTNUM);
			System.out.println("Registry created...");
			UnicastRemoteObject.exportObject(remoteRef, 0);
			Naming.rebind(
					"rmi://" + hostName + ":" + PORTNUM + "/SpriteService",
					remoteRef);
		} catch (Exception e) {
			System.out.println("Sprite server failed: " + e);
		}

	} // end of main()
} // end of server class
