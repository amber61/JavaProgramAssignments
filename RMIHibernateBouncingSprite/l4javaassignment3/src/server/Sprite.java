package server;

/* File Name: Sprite.java
 * Author Name: Zhe Huang
 * Date: 2017-03-22
 * Description: This file defines the sprite.
 */

import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class is an example of a Hibernate Entity. Sprite objects are to be
 * stored in the database. Date March 22, 2017
 * 
 * @author Zhe (Amber) Huang
 * @version 1.0.0
 * @see java.awt.Color
 * @see java.io.Serializable
 * @see java.util.Random
 * @see javax.persistence.Column
 * @see javax.persistence.Convert
 * @see javax.persistence.Entity
 * @see javax.persistence.GeneratedValue
 * @see javax.persistence.GenerationType
 * @see javax.persistence.Id
 * @see javax.persistence.Table
 * @since 1.8.0_73
 */

@Entity
@Table(name = "sprite")
public class Sprite implements Serializable {
	/**
	 * {@value #serialVersionUID}
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * {@value #random} Create a random number generator
	 */
	public final static Random random = new Random();

	/**
	 * {@value #MAX_SPEED} Define the max speed
	 */
	public final static int MAX_SPEED = 5;

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
	 * Field to the color of sprite
	 */
	private Color color;

	/**
	 * Field to the id of sprite in database
	 */
	private int id;

	/**
	 * Field to the color of sprite in string
	 */
	// private String colorString;

	/**
	 * No-arg Constructor.
	 */
	public Sprite() {

	}

	/**
	 * Arg-Constructor. Set up properties of sprite.
	 * 
	 * @param x
	 *            x-position of sprite
	 * @param y
	 *            y-position of sprite
	 * @param color
	 *            color of sprite
	 */
	public Sprite(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
		// this.colorString = color.toString();
		dx = random.nextInt(2 * MAX_SPEED) - MAX_SPEED;
		dy = random.nextInt(2 * MAX_SPEED) - MAX_SPEED;
	}

	/**
	 * Getter of id
	 * 
	 * @return int id of sprite
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	/**
	 * Setter of id
	 * 
	 * @param id
	 *            id of sprite
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter of x-position
	 * 
	 * @return int x-position of sprite
	 */
	@Column
	public int getX() {
		return x;
	}

	/**
	 * Setter of x-position
	 * 
	 * @param x
	 *            x-position of sprite
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Getter of y-position
	 * 
	 * @return int y-position of sprite
	 */
	@Column
	public int getY() {
		return y;
	}

	/**
	 * Setter of y-position
	 * 
	 * @param y
	 *            y-position of sprite
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Getter of dx-position
	 * 
	 * @return int dx-position of sprite
	 */
	@Column
	public int getDx() {
		return dx;
	}

	/**
	 * Setter of dx-position
	 * 
	 * @param dx
	 *            dx-position of sprite
	 */
	public void setDx(int dx) {
		this.dx = dx;
	}

	/**
	 * Getter of dy-position
	 * 
	 * @return int dy-position of sprite
	 */
	@Column
	public int getDy() {
		return dy;
	}

	/**
	 * Setter of dy-position
	 * 
	 * @param dy
	 *            dy-position of sprite
	 */
	public void setDy(int dy) {
		this.dy = dy;
	}

	/**
	 * Getter of color
	 * 
	 * @return Color color of sprite
	 */
	@Column
	@Convert(converter = ColorConverter.class)
	public Color getColor() {
		return color;
	}

	/**
	 * Setter of color
	 * 
	 * @param color
	 *            color of sprite
	 */
	public void setColor(Color color) {
		this.color = color;
	}

}
