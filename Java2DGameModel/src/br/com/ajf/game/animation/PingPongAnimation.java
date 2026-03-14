package br.com.ajf.game.animation;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * The Class PingPongAnimation.
 */
public final class PingPongAnimation implements IAnimation
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
	private boolean looping;
	
	/** the pingPong. */
	private boolean pingPong;
	
	/** the control incremment and decrement index of frames. */
	private int controlFrameIndex;
	
	/**
	 * Instantiates a new ping pong animation.
	 *
	 * @param imgs the imgs
	 * @param interval the interval
	 */
	public PingPongAnimation(final BufferedImage imgs[],final float interval)
	{
		this(imgs, interval,true);
	}
	
	/**
	 * Instantiates a new ping pong animation.
	 *
	 * @param imgs the imgs
	 * @param interval the interval
	 * @param looping the looping
	 */
	public PingPongAnimation(final BufferedImage imgs[],final float interval,final boolean looping)
	{
		this.images = imgs;
		this.interval = interval;
		this.looping = looping;
		this.pingPong = true;
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
				return;
		
		counter += delta;
			
		if(counter >= interval)
		{	
			if(index <= 0)
			{
				controlFrameIndex = 1;
			}
			else if(index >= images.length-1)
			{
				controlFrameIndex = 0;
			}
				
			if(controlFrameIndex == 1)
			{
				index++;
			}
			else if(controlFrameIndex == 0)
			{
				index--;
			}
				
			counter = 0;
		}
	}

	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param xPos the x pos
	 * @param yPos the y pos
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
		return pingPong;
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