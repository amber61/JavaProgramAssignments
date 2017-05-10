
/* File Name:
 * Author Name: Algonquin College
 * Modified By: Zhe (Amber) Huang
 * Date: 2017-01-28
 * Description: This file defines each sprite panel.
 */

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JPanel;

/**
 * Draw the panel for each movement of sprite. Date January 28, 2017
 * 
 * @author Zhe (Amber) Huang
 * @version 1.0.0
 * @see java.awt.Graphics
 * @see java.awt.event.MouseAdapter
 * @see java.awt.event.MouseEvent
 * @see java.util.ArrayList
 * @see java.util.List
 * @see java.util.concurrent.ExecutorService
 * @see java.util.concurrent.Executors
 * @see javax.swing.JPanel
 * @since 1.8.0_73
 */
@SuppressWarnings("serial")
public class SpritePanel extends JPanel {
	/**
	 * Field to executor service to manage threads
	 */
	ExecutorService executorService = Executors.newCachedThreadPool();

	/**
	 * Field to list to store sprites
	 */
	List<Sprite> sprite = new ArrayList<>();

	/**
	 * Field to radius of circle
	 */
	private final static int CIRCLERADIUS = 175;

	/**
	 * Field to maximum number of sprites inside circle
	 */
	private int availablePosition = 4;

	/**
	 * Constructor. Set up sprite panel.
	 */
	public SpritePanel() {
		// listen to mouse click
		addMouseListener(new Mouse());
	}

	/**
	 * Draw a new sprite
	 * 
	 * @param event
	 *            create a new sprite when click mouse
	 */
	private void newSprite(MouseEvent event) {

		Sprite spr = new Sprite(this);
		sprite.add(spr);
		executorService.execute(spr);

		System.out.println("New ball created");
	}

	/**
	 * Describe the each animation
	 */
	public void animate() {

		while (true) {
			// repaint frame(invoke method paintComponent, clear and repaint)
			// after each movement

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
			newSprite(event);
		}

	}

	/**
	 * Paint components
	 * 
	 * @param g
	 *            the object to be painted
	 */
	@Override
	public void paintComponent(Graphics g) {
		// clear the panel
		super.paintComponent(g);

		int panelWidth = this.getWidth();
		int panelHeight = this.getHeight();
		int circleDiameter = 2 * CIRCLERADIUS;

		g.drawOval(panelWidth / 2 - CIRCLERADIUS,
				panelHeight / 2 - CIRCLERADIUS, circleDiameter, circleDiameter);
		for (Sprite spr : sprite) {
			if (spr != null) {
				spr.draw(g);
			}
		}
	}

	/**
	 * Controlling the movement when a sprite enters the circle
	 * 
	 * @throws InterruptedException
	 */
	public synchronized void enterCircle() throws InterruptedException {
		while (availablePosition <= 0) {
			System.out.println("Tries to enter. Producer waits.");
			wait();
		}

		availablePosition--;
		System.out.println(
				"Current available positions are: " + availablePosition);

		// notify others
		notifyAll();
	}

	/**
	 * Controlling the movement when a sprite exits the circle
	 * 
	 * @@throws InterruptedException
	 */
	public synchronized void exitCircle() throws InterruptedException {
		while (availablePosition >= 2) {
			System.out.println("Tries to exit. Consumer waits.");
			wait();
		}
		availablePosition++;
		System.out.println(
				"Current available positions are: " + availablePosition);

		// notify others
		notifyAll();
	}
}
