package server;

/* File Name: SpriteInterfaceImpl.java
 * Author Name: Zhe Huang
 * Date: 2017-03-22
 * Description: This file implements remote methods defined in interface.
 */
import java.awt.Color;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * This class implements remote methods defined in interface. Date March 22,
 * 2017
 * 
 * @author Zhe (Amber) Huang
 * @version 1.0.0
 * @see java.awt.Color
 * @see java.rmi.RemoteException
 * @see java.util.ArrayList
 * @see java.util.List
 * @see org.hibernate.Session
 * @see org.hibernate.SessionFactory
 * @see org.hibernate.boot.registry.StandardServiceRegistry
 * @see org.hibernate.boot.registry.StandardServiceRegistryBuilder
 * @see org.hibernate.cfg.Configuration
 * @since 1.8.0_73
 */
public class SpriteInterfaceImpl implements SpriteInterface, Runnable {

	/**
	 * Field for list of sprites
	 */
	private List<Sprite> sprites;

	/**
	 * {@value #WINDOWWIDTH} Define the size of window width
	 */
	private static final int WINDOWWIDTH = 400;

	/**
	 * {@value #WINDOWLENGTH} Define the size of window length
	 */
	private static final int WINDOWHEIGHT = 400;

	/**
	 * {@value #SIZE} Define the size of sprite radius
	 */
	public final static int SIZE = 10;

	/**
	 * Field for session factory
	 */
	private SessionFactory factory;

	/**
	 * Field for color array
	 */
	private Color[] colors;

	/**
	 * Field for counting sprite number for specify color
	 */
	private static int count = 0;

	/**
	 * Constructor
	 * 
	 * @throws RemoteException
	 *             exception when invoking remote methods
	 */
	public SpriteInterfaceImpl() throws RemoteException {
		sprites = new ArrayList<>();
		colors = new Color[] { Color.RED, Color.BLUE, Color.GREEN };
		Configuration config = new Configuration()
				.addAnnotatedClass(Sprite.class).configure("hibernate.cfg.xml");
		// new SchemaExport(config).create(true, true);
		StandardServiceRegistryBuilder sRBuilder = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties());
		StandardServiceRegistry sR = sRBuilder.build();
		// build one factory, then use it to get and use sessions
		factory = config.buildSessionFactory(sR);
	}

	/**
	 * Method of creating sprites
	 * 
	 * @throws RemoteException
	 *             exception when invoking remote methods
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public void createSprite(int x, int y, Color color) throws RemoteException {
		Session session1 = factory.getCurrentSession(); // open has to be closed
		try {
			Sprite spr = new Sprite(x, y, color);
			session1.beginTransaction();
			session1.save(spr);
			// get list of sprites from database
			sprites = (ArrayList<Sprite>) session1.createCriteria(Sprite.class)
					.list();
			session1.getTransaction().commit();
		} catch (Exception e) {
			if (session1.beginTransaction() != null)
				session1.beginTransaction().rollback(); // rollback what commit
														// done in case of
														// exception
			System.out.println("Error in createSprite: " + e);
		}
		new Thread(this).start(); // every sprite runs in their own thread
	}

	/**
	 * Method to specify color of sprite
	 * 
	 * @throws RemoteException
	 *             exception when invoking remote methods
	 */

	@Override
	public Color colorSprite() throws RemoteException {
		synchronized (this) {
			int i = ++count % colors.length;
			if (i == 0)
				return colors[colors.length - 1];
			else if (i == 1 || i == 2)
				return colors[i - 1];
			else
				return Color.BLACK;
		}
	}

	/**
	 * Method of getting list of sprites
	 * 
	 * @throws RemoteException
	 *             exception when invoking remote methods
	 */
	@Override
	public List<Sprite> getSprites() throws RemoteException {
		return this.sprites;
	}

	/**
	 * Method of get width of window
	 * 
	 * @throws RemoteException
	 *             exception when invoking remote methods
	 */
	@Override
	public int getWidth() throws RemoteException {
		return WINDOWWIDTH;
	}

	/**
	 * Method of get height of window
	 * 
	 * @throws RemoteException
	 *             exception when invoking remote methods
	 */
	@Override
	public int getHeight() throws RemoteException {
		return WINDOWHEIGHT;
	}

	/**
	 * Method to update position of sprite after moving
	 * 
	 * @throws RemoteException
	 *             exception when invoking remote methods
	 */
	@Override
	public void updateSprites() throws RemoteException {
		Session session3 = factory.getCurrentSession();
		try {
			session3.beginTransaction();
			for (Sprite spr : sprites) {
				move(spr);
				session3.update(spr);
			}
			session3.getTransaction().commit();
		} catch (Exception e) {
			if (session3.getTransaction() != null)
				session3.getTransaction().rollback();
			System.out.println("Error in move: " + e);
		}
	}

	/**
	 * Movement of sprites
	 * 
	 * @throws RemoteException
	 *             exception when invoking remote methods
	 */
	public void move(Sprite sprite) throws RemoteException {
		// obtain current position of given sprite
		int x = sprite.getX();
		int y = sprite.getY();
		int dx = sprite.getDx();
		int dy = sprite.getDy();
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

		if (x >= WINDOWWIDTH - SIZE && dx > 0) {
			// bounce off the right wall
			x = WINDOWWIDTH - SIZE;
			dx = -dx;
		}

		if (y >= WINDOWHEIGHT - SIZE && dy > 0) {
			// bounce off the bottom wall
			y = WINDOWHEIGHT - SIZE;
			dy = -dy;
		}

		// make the ball move
		x += dx;
		y += dy;

		// set new position back to class Sprite
		sprite.setX(x);
		sprite.setY(y);
		sprite.setDx(dx);
		sprite.setDy(dy);
	}

	/**
	 * Thread to update sprites after moving
	 */
	@Override
	public void run() {
		while (true) {
			try {
				updateSprites();
				Thread.sleep(20);
			} catch (InterruptedException exception) {
				// exception.printStackTrace();
				System.out.println("Error in run interrupted");
			} catch (RemoteException e) {
				// e.printStackTrace();
				System.out.println("Error in run remote");
			}
		}
	} // end of run()

} // end of main()
