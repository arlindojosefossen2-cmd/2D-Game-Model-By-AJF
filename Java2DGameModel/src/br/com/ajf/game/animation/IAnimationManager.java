package br.com.ajf.game.animation;

import java.awt.Graphics2D;

/**
 * Author A.J.F.
 * @version 1.0
 * 21 June 2025
 */
public sealed interface IAnimationManager permits AnimationManager
{	
	/** The Constant NOT_LOOPING_COUNTINUES. */
	public static final boolean NOT_LOOPING_COUNTINUES = false;
	
	/** The Constant LOOPING_COUNTINUES. */
	public static final boolean LOOPING_COUNTINUES = true;
	
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
	 * Adds the animation.
	 *
	 * @param animation the animation
	 */
	public void addAnimation(IAnimation animation);
	/**
	 * Sets the animation by index.
	 *
	 * @param index the new animation by index
	 */
	public void setAnimationByIndex(int index);
	
	/**
	 * Checks if is finished.
	 *
	 * @param index the index
	 * @return true, if is finished
	 */
	public boolean isFinished(int index);
	
	/**
	 * Reset.
	 *
	 * @param index the index
	 */
	public void reset(int index);
	
	/**
	 * Gets the index.
	 *
	 * @param index the index
	 * @return the index
	 */
	public int getIndex(int index);
	
	/**
	 * Clear.
	 */
	public void clear();
}