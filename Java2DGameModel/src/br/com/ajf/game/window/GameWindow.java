package br.com.ajf.game.window;

import java.awt.EventQueue;

import javax.swing.JFrame;

import br.com.ajf.game.gamepanel.GamePanel;
import br.com.ajf.game.input.GameWindowFocusLost;
import br.com.ajf.game.model.Game;

/**
 * Author A.J.F.
 * @version 1.0
 * 27 June 2025
 */
public final class GameWindow implements IGameWindow
{
	
	/** The window. */
	private final JFrame window;
	
	/**
	 * Instantiates a new game window.
	 *
	 * @param title is the title of the window
	 * Constructor that create the Window
	 */
	public GameWindow(final String title)
	{
		this.window = new JFrame(title);
	}
	
	/**
	 * Instantiates a new game window properties.
	 *
	 * @param gamepanel this is the screen
	 * method that start fields and attributes of the Window
	 */
	@Override
	public void init(final GamePanel gamepanel)
	{
		EventQueue.invokeLater( () ->
		{
			this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.window.setResizable(false);
		
			this.window.addWindowFocusListener(new GameWindowFocusLost(gamepanel).getWindowAdapter());
			
			this.window.setAutoRequestFocus(true);
			
			this.window.add(gamepanel.getCanvas());
			this.window.pack();
			
			this.window.setLocationRelativeTo(null);
			this.window.setVisible(true);
		
			gamepanel.start();
		});
	}
	
	/**
	 * Sets the icon.
	 *
	 * @param path is the way for add a new icon to the window
	 */
	@Override
	public void setIcon(final String path)
	{
		this.window.setIconImage(Game.LOADER.loadImage(path));
	}
	
	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	@Override
	public void setTitle(final String title)
	{
		this.window.setTitle(title);
	}
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle()
	{
		return this.window.getTitle();
	}
}