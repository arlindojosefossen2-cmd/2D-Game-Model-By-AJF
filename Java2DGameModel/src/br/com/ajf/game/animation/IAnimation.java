package br.com.ajf.game.animation;

import java.awt.Graphics2D;

/**
 * Author A.J.F.
 * @version 1.0
 * 17 June 2025
 */
public interface IAnimation
{
	/** The Constant NORMAL_ANIMATION. */
	public static final String NORMAL_ANIMATION = "normal";
	
	/** The Constant PINGPONG_ANIMATION. */
	public static final String PINGPONG_ANIMATION = "pingpong";
	
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
	 * @param xPos the x position to the animation
	 * @param yPos the y position to the animation
	 */
	public void draw(Graphics2D graphics2d,int xPos,int yPos);
	
	/**
	 * Checks if is finished.
	 *
	 * @return true, if is finished
	 */
	public boolean isFinished();
	
	/**
	 * Reset.
	 */
	public void reset();
	
	/**
	 * Checks if is looping.
	 *
	 * @return true, if is looping
	 */
	public boolean isLooping();

	/**
	 * Checks if is ping pong.
	 *
	 * @return true, if is ping pong
	 */
	public boolean isPingPong();
	
	/**
	 * Gets the index.
	 *
	 * @return the index
	 */
	public int getIndex();
}