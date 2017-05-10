
/* File Name: Sprite.java
 * Author Name: Algonquin College
 * Modified By: Zhe (Amber) Huang
 * Date: 2017-01-28
 * Description: This file defines the sprite and its movement.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Draw the sprite and define its movement. Date January 28, 2017
 * 
 * @author Zhe (Amber) Huang
 * @version 1.0.0
 * @see java.awt.Color
 * @see java.awt.Graphics
 * @see java.util.Random
 * @since 1.8.0_73
 */
public class Sprite implements Runnable {

	/**
	 * {@value #random} Create a random number generator
	 */
	public final static Random random = new Random();

	/**
	 * {@value #SIZE} radius of the sprite
	 */
	final static int SIZE = 10;

	final static int CIRCLERADIUS = 175;
	// ControlSpriteNumberBuffer buffer = new ControlSpriteNumberBuffer();

	/**
	 * {@value #MAX_SPEED} Define the max speed
	 */
	final static int MAX_SPEED = 5;

	/**
	 * Field to declare a sprite panel
	 */
	SpritePanel panel;

	/**
	 * Field to the position of x for the sprite
	 */
	private int x;

	/**
	 * Field to the position of y for the sprite
	 */
	private int y;

	/**
	 * Field to the distance of each movement based x
	 */
	private int dx;

	/**
	 * Field to the distance of each movement based y
	 */
	private int dy;

	/**
	 * Field to the color of outside sprite
	 */
	private Color colorOutside = Color.BLUE;

	/**
	 * Field to the color of inside sprite
	 */
	private Color colorInside = Color.RED;

	/**
	 * Constructor. Set up properties of sprite on the same panel.
	 * 
	 * @param panel
	 *            object of sprite panel
	 */
	public Sprite(SpritePanel panel) {
		this.panel = panel;
		do {
			x = random.nextInt(panel.getWidth());
			y = random.nextInt(panel.getHeight());

			dx = random.nextInt(2 * MAX_SPEED) - MAX_SPEED;
			dy = random.nextInt(2 * MAX_SPEED) - MAX_SPEED;
		} while (judgeInsideCircle(x, y));
	}

	/**
	 * Draw the current sprite
	 * 
	 * @param g
	 *            the object to be painted
	 */
	public void draw(Graphics g) {
		if (!judgeInsideCircle(x, y))
			g.setColor(colorOutside);
		else
			g.setColor(colorInside);
		g.fillOval(x, y, SIZE, SIZE);

	}

	/**
	 * Method to move sprite
	 * 
	 * @throws InterruptedException
	 */
	public void move() throws InterruptedException {

		// check for bounce and make the ball bounce if necessary
		//
		if (x < 0 && dx < 0) {
			// bounce off the left wall
			x = 0;
			dx = -dx;
		}
		if (y < 0 && dy < 0) {
			// bounce off the top wall
			y = 0;
			dy = -dy;
		}
		if (x > panel.getWidth() - SIZE && dx > 0) {
			// bounce off the right wall
			x = panel.getWidth() - SIZE;
			dx = -dx;
		}
		if (y > panel.getHeight() - SIZE && dy > 0) {
			// bounce off the bottom wall
			y = panel.getHeight() - SIZE;
			dy = -dy;
		}

		// plan to enter
		if (!judgeInsideCircle(x, y) && judgeInsideCircle(x + dx, y + dy))
			panel.enterCircle();
		// // plan to exit
		if (judgeInsideCircle(x, y) && (!judgeInsideCircle(x + dx, y + dy)))
			panel.exitCircle();

		// make the ball move
		x += dx;
		y += dy;
	}

	/**
	 * Method to implement interface Runnable, thread starts
	 */
	@Override
	public void run() {
		while (true) {
			try {
				move();
				Thread.sleep(20);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
	}

	/**
	 * Method to judge whether a sprite is inside the circle or not
	 * 
	 * @param x
	 *            position x of current sprite
	 * @param y
	 *            position y of current sprite
	 */
	private boolean judgeInsideCircle(int x, int y) {
		double twoCenterDistance = Math
				.sqrt(Math.pow(panel.getWidth() / 2 - (x + SIZE / 2), 2)
						+ Math.pow(panel.getHeight() / 2 - (y + SIZE / 2), 2));
		return twoCenterDistance < (CIRCLERADIUS + SIZE / 2);
	}
}
