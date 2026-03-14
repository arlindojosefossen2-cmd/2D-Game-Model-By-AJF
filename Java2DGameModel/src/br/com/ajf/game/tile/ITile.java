package br.com.ajf.game.tile;

import java.awt.image.BufferedImage;

/**
 * The Interface ITile.
 */
public interface ITile
{
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId();
	
	/**
	 * Checks if is solid.
	 *
	 * @return true, if is solid
	 */
	public boolean isSolid();
	
	/**
	 * Gets the image.
	 *
	 * @param delta the delta
	 * @return the image
	 */
	public BufferedImage getImage(float delta);
}