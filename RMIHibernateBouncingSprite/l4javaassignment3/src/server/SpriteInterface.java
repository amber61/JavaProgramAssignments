package server;

/* File Name: SpriteInterface.java
 * Author Name: Zhe Huang
 * Date: 2017-03-22
 * Description: This file defines an interface including remote methods.
 */

import java.awt.Color;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * This class is an interface to define remote methods. Date March 22, 2017
 * 
 * @author Zhe (Amber) Huang
 * @version 1.0.0
 * @see java.awt.Color
 * @see java.rmi.Remote
 * @see java.rmi.RemoteException
 * @see java.util.List
 * @since 1.8.0_73
 */
public interface SpriteInterface extends Remote {

	/**
	 * Abstract method of creating sprites
	 * 
	 * @param x
	 *            x-position of sprite
	 * @param y
	 *            y-position of sprite
	 * @param color
	 *            color of sprite
	 * @throws RemoteException
	 *             exception when invoking remote methods
	 */
	public void createSprite(int x, int y, Color color) throws RemoteException;

	/**
	 * Abstract method of getting list of sprites
	 * 
	 * @return List<Sprite> list of sprites
	 * @throws RemoteException
	 *             exception when invoking remote methods
	 */
	public List<Sprite> getSprites() throws RemoteException;

	/**
	 * Abstract method of get width of window
	 * 
	 * @return
	 * @throws RemoteException
	 *             exception when invoking remote methods
	 */
	public int getWidth() throws RemoteException;

	/**
	 * Abstract method of get height of window
	 * 
	 * @return int height of window
	 * @throws RemoteException
	 *             exception when invoking remote methods
	 */
	public int getHeight() throws RemoteException;

	/**
	 * Abstract method to update position of sprite after moving
	 * 
	 * @throws RemoteException
	 *             exception when invoking remote methods
	 */
	public void updateSprites() throws RemoteException;

	/**
	 * Abstract method to specify color of sprite
	 * 
	 * @return Color color of sprite
	 * @throws RemoteException
	 *             exception when invoking remote methods
	 */
	public Color colorSprite() throws RemoteException;

}
