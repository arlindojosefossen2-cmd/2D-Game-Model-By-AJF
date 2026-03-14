package br.com.ajf.game.input;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import br.com.ajf.game.gamepanel.GamePanel;


/**
 * The Class GameWindowFocusLost.
 *
 * Author A.J.F
 */
public final class GameWindowFocusLost
{
	
	/** The window adapter. */
	private final WindowAdapter windowAdapter;
	/**
	 * Instantiates a new game window focus lost.
	 *
	 * @param gamepanel Constructor that start the field
	 */
	public GameWindowFocusLost(final GamePanel gamepanel)
	{	
		windowAdapter = new WindowAdapter()
		{
			@Override
			public void windowLostFocus(final WindowEvent e)
			{
				gamepanel.reset();
			}
		};
	}
	
	/**
	 * Gets the window adapter.
	 *
	 * @return the window adapter
	 */
	public WindowAdapter getWindowAdapter()
	{
		return windowAdapter;
	}
}