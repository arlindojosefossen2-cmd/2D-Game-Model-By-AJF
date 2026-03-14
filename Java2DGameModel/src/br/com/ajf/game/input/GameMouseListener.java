package br.com.ajf.game.input;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 * The Class GameMouseListener.
 * 
 * Author A.J.F
 */
public final class GameMouseListener
{
	
	/** The adapter. */
	private final MouseAdapter adapter;
	
	/** The Constant BUTTON_COUNT. */
	private static final int BUTTON_COUNT = 3;
	
	/** The mouse pos. */
	private static Point mousePos;
	
	/** The current pos. */
	private static Point currentPos;
	
	/** The mouse. */
public static boolean[] mouse;
	
	/** The polled. */
public static short[] polled;
	
	/** The notches. */
	private static short notches;
	
	/** The polled notches. */
	private static short polledNotches;
	
	/**
	 * Instantiates a new game mouse listener.
	 */
	public GameMouseListener()
	{
		reset();
		
		adapter = new MouseAdapter()
		{	
			@Override
			public synchronized void mousePressed(final MouseEvent e)
			{
				int b = e.getButton();
				
				if(b >= 0 && b < mouse.length)
				{
					mouse[b] = true;
				}
			}

			@Override
			public synchronized void mouseReleased(final MouseEvent e)
			{
				int b = e.getButton();
				
				if(b >= 0 && b < mouse.length)
				{
					mouse[b] = false;
				}
			}
			
			@Override
			public void mouseMoved(final MouseEvent e)
			{
				currentPos = e.getPoint();
			}
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e)
			{
				notches += e.getWheelRotation();
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				mouseMoved(e);
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				mouseMoved(e);
			}
			
			@Override
			public void mouseDragged(MouseEvent e)
			{
				mouseMoved(e);
			}
		};
	}

	/**
	 * Reset.
	 */
	public static void reset()
	{
		mousePos = new Point(0,0);
		currentPos = new Point(0, 0);
		mouse = new boolean[BUTTON_COUNT];
		polled = new short[BUTTON_COUNT];
		notches = 0;
		polledNotches = 0;
	}
	
	/**
	 * Update.
	 */
	public static synchronized void update()
	{
		mousePos = currentPos;
		
		polledNotches = notches;
		notches = 0;
		
		for (int i = 0; i < mouse.length; ++i)
		{
			if(mouse[i])
			{
				polled[i]++;
			}
			else
			{
				polled[i] = 0;
			}
		}
	}
	
	/**
	 * Button down.
	 *
	 * @param button the button
	 * @return true, if successful
	 */
	public static boolean buttonDown(int button)
	{
		return polled[button] > 0;
	}
	
	/**
	 * Button down once.
	 *
	 * @param button the button
	 * @return true, if successful
	 */
	public static boolean buttonDownOnce(int button)
	{
		return polled[button] == 1;
	}
	
	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public static Point getPosition()
	{
		return mousePos;
	}
	
	/**
	 * Gets the notches.
	 *
	 * @return the notches
	 */
	public static short getNotches()
	{
		return polledNotches;
	}
	
	/**
	 * Gets the adapter.
	 *
	 * @return the adapter
	 */
	public MouseAdapter getAdapter()
	{
		return adapter;
	}
}