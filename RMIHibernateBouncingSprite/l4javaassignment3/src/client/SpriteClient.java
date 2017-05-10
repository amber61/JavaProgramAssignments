package client;

/* File Name: SpriteClient.java
 * Author Name: Zhe Huang
 * Date: 2017-03-22
 * Description: This file defines a remote client for sprites.
 */
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import server.Sprite;
import server.SpriteInterface;

/**
 * This class defines a remote client for sprites. Date March 22, 2017
 * 
 * @author Zhe (Amber) Huang
 * @version 1.0.0
 * @see java.awt.Graphics
 * @see java.awt.event.MouseAdapter
 * @see java.awt.event.MouseEvent
 * @see java.net.MalformedURLException
 * @see java.rmi.Naming
 * @see java.rmi.NotBoundException
 * @see java.rmi.server.RemoteException
 * @see java.util.List
 * @see javax.swing.JFrame
 * @see javax.swing.JPanel
 * @see server.Sprite
 * @see server.SpriteInterface
 * @since 1.8.0_73
 */
public class SpriteClient extends JPanel {

	/**
	 * {@value #serialVersionUID}
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Field to the frame
	 */
	private JFrame frame;

	/**
	 * Field to the size of sprite radius
	 */
	private final static int SIZE = 10;

	/**
	 * Field to the name of host
	 */
	private static String hostName = "localhost";

	/**
	 * Field to the port number
	 */
	private static final int PORTNUM = 8081;

	/**
	 * Field to the remote reference
	 */
	private SpriteInterface remoteRef;

	/**
	 * List of sprites
	 */
	List<Sprite> spriteList;

	/**
	 * Constructor. Specify the property of class
	 * 
	 * @throws MalformedURLException
	 *             Thrown to indicate that a malformed URL has occurred.
	 * @throws RemoteException
	 *             exception when invoking remote methods
	 * @throws NotBoundException
	 *             exception when not meeting bound requirement
	 */
	public SpriteClient()
			throws MalformedURLException, RemoteException, NotBoundException {
		remoteRef = (SpriteInterface) Naming
				.lookup("rmi://" + hostName + ":" + PORTNUM + "/SpriteService");
		// create main window title
		frame = new JFrame("Bouncing Sprites 2017W Assign3");
		// create main window size
		frame.setSize(remoteRef.getWidth(), remoteRef.getHeight());
		// System.exit() when JFrame is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// add sprite panel
		frame.add(this);
		// display frame
		frame.setVisible(true);

		addMouseListener(new Mouse());
		animate();
	}

	/**
	 * Inner class Mouse that is used to listen to mouse click
	 */
	private class Mouse extends MouseAdapter {

		/**
		 * The action when mouse is pressed
		 * 
		 * @param event
		 *            create a new sprite when click mouse
		 */
		@Override
		public void mousePressed(final MouseEvent event) {
			// create a new sprite when mouse is clicked
			try {
				remoteRef.createSprite(event.getX(), event.getY(),
						remoteRef.colorSprite());
			} catch (RemoteException e) {
				System.out.println(
						"Invoke remote methods failed when Mouse clicked");
			}
		}

	}

	/**
	 * Describe the each animation
	 */
	public void animate() {
		while (true) {
			repaint();
			// sleep while waiting to display the next frame of the animation
			try {
				Thread.sleep(40); // wake up roughly 25 frames per second
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
	}

	/**
	 * Paint components
	 * 
	 * @param g
	 *            the object to be painted
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			spriteList = remoteRef.getSprites();
			if (spriteList != null) {
				for (int i = 0; i < spriteList.size(); i++) {
					draw(g, spriteList.get(i));//
				}
			}
		} catch (RemoteException e) {
			System.out.println("Failed in painting sprites.");
		}
	} // end of paintComponent method

	/**
	 * Draw the current sprite
	 * 
	 * @param g
	 *            the object to be painted
	 * @param sprite
	 *            Specify draw current sprite
	 */
	public void draw(Graphics g, Sprite sprite) throws RemoteException {
		g.setColor(sprite.getColor());
		g.fillOval(sprite.getX(), sprite.getY(), SIZE, SIZE);
	}

	/**
	 * Entry point for client
	 * 
	 * @param args
	 *            Command line arguments (not used)
	 */
	public static void main(String[] args)
			throws MalformedURLException, RemoteException, NotBoundException {
		new SpriteClient();
	}

} // end of class
