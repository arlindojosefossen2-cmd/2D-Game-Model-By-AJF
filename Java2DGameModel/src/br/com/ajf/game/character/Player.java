package br.com.ajf.game.character;

import java.awt.Graphics2D;

/**
 * The Class Player.
 */
public abstract class Player extends AbstractCharacter
{
	/** The Constant SCREEN_X. */
	public static int SCREEN_X = 0;
	
	/** The Constant SCREEN_Y. */
	public static int SCREEN_Y = 0;
	
	/**
	 * Instantiates a new player.
	 */
	public Player()
	{
		super();
	}

	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param playerXOffset the player X offset
	 * @param playerYOffset the player Y offset
	 */
	@Override
	public void draw(Graphics2D graphics2d,int playerXOffset,int playerYOffset)
	{	
		animations.draw(graphics2d, position.getX() + playerXOffset,
				position.getY() + playerYOffset);
	}
}