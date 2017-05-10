
/* File Name:BouncingSprites.java
 * Author Name: Algonquin College
 * Modified By: Zhe (Amber) Huang
 * Date: 2017-01-28
 * Description: This file defines the frame and the start point of the application.
 */

import javax.swing.JFrame;

/**
 * Draw the main container and start application. Date January 28, 2017
 * 
 * @author Zhe (Amber) Huang
 * @version 1.0.0
 * @see javax.swing.JFrame
 * @since 1.8.0_73
 */
public class BouncingSprites {

	/**
	 * Field to declare the main container
	 */
	private JFrame frame;

	/**
	 * Field to create a sprite panel
	 */
	private SpritePanel panel = new SpritePanel();

	/**
	 * Constructor. Set up properties of JFrame.
	 */
	public BouncingSprites() {
		// create main window title
		frame = new JFrame("Bouncing Sprites 2017W");
		// create main window size
		frame.setSize(500, 500);
		// System.exit() when JFrame is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// add sprite panel
		frame.add(panel);
		// display frame
		frame.setVisible(true);
	}

	/**
	 * Start to animate
	 */
	public void start() {
		panel.animate(); // never returns due to infinite loop in animate method
	}

	/**
	 * Entry point for application
	 * 
	 * @param args
	 *            Command line arguments (not used)
	 */
	public static void main(String[] args) {
		new BouncingSprites().start();
	}
}
