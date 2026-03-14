package br.com.ajf.game.tile;

import java.awt.image.BufferedImage;

/**
 * The Class Tile.
 */
public final class Tile implements ITile
{
	/** The id. */
	private int id;
	
	/** The solid. */
	private boolean solid;
	
	/** The image. */
	private BufferedImage image;
	
	/**
	 * Instantiates a new tile.
	 *
	 * @param id the id
	 * @param solid the solid
	 * @param image the image
	 */
	public Tile(int id, boolean solid, BufferedImage image)
	{
		this.id = id;
		this.solid = solid;
		this.image = image;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * Checks if is solid.
	 *
	 * @return true, if is solid
	 */
	public boolean isSolid()
	{
		return solid;
	}
	
	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public BufferedImage getImage(float delta)
	{
		return image;
	}
}