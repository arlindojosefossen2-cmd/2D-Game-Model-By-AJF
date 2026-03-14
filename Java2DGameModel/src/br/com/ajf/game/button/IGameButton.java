package br.com.ajf.game.button;

import java.awt.Graphics2D;

/**
 * The Interface IGameButton.
 * Author A.J.F.
 * @version 1.0
 * 17 June 2025
 */
public interface IGameButton
{
	/**
	 * Update.
	 */
	public void update();
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 */
	public void draw(Graphics2D graphics2d);
}