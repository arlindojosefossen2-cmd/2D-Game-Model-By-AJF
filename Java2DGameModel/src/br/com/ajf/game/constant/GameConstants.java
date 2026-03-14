package br.com.ajf.game.constant;

/**
 * The Class GameConstants.
 */
public final class GameConstants
{
	
	/**
	 *Can't instantiates a new game constants.
	 */
	private GameConstants()
	{
		
	}
	
	/** The Constant ORIGINAL_TILESIZE_16. */
	public static final int ORIGINAL_TILESIZE_16 = 16;
	
	/** The Constant SCALE. */
	public static final float SCALE = 3;
	
	/** The Constant TILESIZE. */
	public static final int TILESIZE = (int) (ORIGINAL_TILESIZE_16*SCALE);
	
	/** The Constant MAX_ROWS. */
	public static final int MAX_ROWS = 18;
	
	/** The Constant MAX_COLLUNM. */
	public static final int MAX_COLLUNM = 10;
	
	/** The Constant SCREEN_WIDTH. */
	public static final int SCREEN_WIDTH = MAX_ROWS*TILESIZE;
	
	/** The Constant SCREEN_HEIGHT. */
	public static final int SCREEN_HEIGHT = MAX_COLLUNM*TILESIZE;	
	
}