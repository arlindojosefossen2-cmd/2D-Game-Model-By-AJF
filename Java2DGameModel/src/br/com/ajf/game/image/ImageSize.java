package br.com.ajf.game.image;

/**
 * The Class ImageSize.
 */
public final class ImageSize
{
	
	/** The width. */
	private final int width;
	
	/** The height. */
	private final int height;
	
	/**
	 * Instantiates a new image size.
	 *
	 * @param width the width
	 * @param height the height
	 */
	public ImageSize(final int width,final int height)
	{
		this.width = width;
		this.height = height;
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight()
	{
		return height;
	}
}
