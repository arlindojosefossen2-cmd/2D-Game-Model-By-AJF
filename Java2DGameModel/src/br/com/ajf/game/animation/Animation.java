package br.com.ajf.game.animation;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import br.com.ajf.game.model.Game;

/**
 * Author A.J.F.
 * @version 1.0
 * 17 June 2025
 */
public final class Animation implements IAnimation
{
	/** The index. */
	private int index;
	
	/** The interval. */
	private final float interval;
	
	/** The counter. */
	private float counter;
	
	/** The images. */
	private final BufferedImage[] images;

	/** The looping. */
	private final boolean looping;
	
	/**
	 * Instantiates a new animation.
	 *
	 * @param path the path
	 * @param numberOfCols the number of cols
	 * @param interval the interval
	 * @param scale the scale
	 */
	public Animation(final String path,final int numberOfCols,final float interval,final float scale)
	{
		this(path, numberOfCols, interval, scale, true);
	}
	
	/**
	 * Instantiates a new animation.
	 *
	 * @param path the path
	 * @param numberOfCols the number of cols
	 * @param interval the interval
	 * @param scale the scale
	 * @param looping the looping
	 */
	public Animation(final String path,final int numberOfCols,final float interval,final float scale,final boolean looping)
	{
		this(path,1, numberOfCols, interval, scale, looping);
	}
	
	/**
	 * Instantiates a new animation.
	 *
	 * @param path the path
	 * @param numberOfRows the rows
	 * @param numberOfCols the cols
	 * @param interval the interval
	 * @param scale the scale
	 */
	public Animation(final String path,final int numberOfRows,final int numberOfCols,final float interval,final float scale)
	{
		this(path, numberOfRows, numberOfCols, interval, scale, true);
	}
	
	/**
	 * Instantiates a new animation.
	 *
	 * @param path the path
	 * @param numberOfRows the rows
	 * @param numberOfCols the cols
	 * @param interval the interval
	 * @param scale the scale
	 * @param looping the looping
	 */
	public Animation(final String path,final int numberOfRows,final int numberOfCols,final float interval,final float scale,final boolean looping)
	{
		this.interval = interval;
		this.images = Game.LOADER.loadScaledBufferedImagesFromSheet(path,numberOfRows, numberOfCols, scale);
		this.looping = looping;
	}
	
	/**
	 * Instantiates a new animation.
	 *
	 * @param images the images
	 * @param interval the interval
	 * @param looping the looping
	 */
	public Animation(final BufferedImage[]  images,final float interval,final boolean looping)
	{
		this.interval = interval;
		this.images = images;
		this.looping = looping;
	}
	
	/**
	 * Update.
	 *
	 * @param delta the delta
	 */
	@Override
	public void update(float delta)
	{
		if(!looping && index == images.length - 1)
		{
				return;
		}
		
		counter+=delta;
			
		if(counter >= interval)
		{
			index++;
			counter =0;
				
			if(index >= images.length)
			{
				index = 0;
			}
		}
	}

	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param xPos the x position to the animation
	 * @param yPos the y position to the animation
	 */
	@Override
	public void draw(final Graphics2D graphics2d,final int xPos,final int yPos)
	{
		graphics2d.drawImage(this.images[this.index], xPos, yPos, null);
	}

	/**
	 * Checks if is finished.
	 *
	 * @return true, if is finished
	 */
	@Override
	public boolean isFinished()
	{
		return index == images.length - 1;
	}

	/**
	 * Reset.
	 */
	@Override
	public void reset()
	{
		index = 0;
	}

	/**
	 * Checks if is looping.
	 *
	 * @return true, if is looping
	 */
	@Override
	public boolean isLooping()
	{
		return looping;
	}

	/**
	 * Checks if is ping pong.
	 *
	 * @return true, if is ping pong
	 */
	@Override
	public boolean isPingPong()
	{
		return false;
	}

	/**
	 * Gets the index.
	 *
	 * @return the index
	 */
	@Override
	public int getIndex()
	{
		return index;
	}
}