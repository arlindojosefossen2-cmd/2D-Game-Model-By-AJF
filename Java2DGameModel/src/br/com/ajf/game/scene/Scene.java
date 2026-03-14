package br.com.ajf.game.scene;

import java.awt.Graphics2D;

/**
 * Author A.J.F
 *
 */
public interface Scene
{
	
	/**
	 * method that start the fields and Object of the State.
	 *
	 * @return the scene
	 */
	public Scene start();
	
	/**
	 * method that update the fields and Object of the State.
	 */
	public void update();
	
	/**
	 * Draw.
	 *
	 * @param graphics2d method that draw the fields and Object of the State
	 */
	public void draw(Graphics2D graphics2d);
}