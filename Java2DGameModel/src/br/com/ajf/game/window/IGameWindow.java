package br.com.ajf.game.window;

import br.com.ajf.game.gamepanel.GamePanel;

/**
 * Author A.J.F.
 * @version 1.0
 * 30 June 2025
 */
public sealed interface IGameWindow permits GameWindow
{
	
	/**
	 * Instantiates the window attributes.
	 *
	 * @param gamepanel the game panel
	 */
	public void init(GamePanel gamepanel);
	
	/**
	 * Sets the icon.
	 *
	 * @param path the new icon
	 */
	public void setIcon(String path);
	
	/**
	 * Sets the tile.
	 *
	 * @param title the new tile
	 */
	public void setTitle(String title);
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle();
}