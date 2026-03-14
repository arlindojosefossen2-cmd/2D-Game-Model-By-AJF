package br.com.ajf.game.gameobject;

import java.awt.Graphics2D;

/**
 * The Interface IGameObject.
 */
public interface IGameObject
{
	
	/**
	 * Start.
	 */
	public void start();
	
	/**
	 * Update.
	 *
	 * @param delta the delta
	 */
	public void update(float delta);
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param playerXOfffset the player X offfset
	 * @param playerYOffset the player Y offset
	 */
	public void draw(Graphics2D graphics2d,int playerXOfffset,int playerYOffset);
}
