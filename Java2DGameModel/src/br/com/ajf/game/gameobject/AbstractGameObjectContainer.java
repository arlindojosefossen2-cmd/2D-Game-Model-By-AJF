package br.com.ajf.game.gameobject;

import br.com.ajf.game.animation.AnimationManager;
import br.com.ajf.game.animation.IAnimationManager;
import br.com.ajf.game.constant.GameConstants;
import br.com.ajf.game.math.GameRect;

/**
 * The Class AbstractGameObjectContainer.
 */
public final class AbstractGameObjectContainer 
{
	/** The x pos. */
	public int xPos;
	
	/** The y pos. */
	public int yPos;
		
	/** The world X. */
	public int worldX ;
	
	/** The world Y. */
	public int worldY ;
		
	/** The speed. */
	public int speed;
		
	/** The name. */
	public String name;
		
	/** The solid area. */
	public GameRect solidArea = new GameRect(0,0,GameConstants.TILESIZE,GameConstants.TILESIZE);
	
	/** The solid area X. */
	public int solidAreaX = solidArea.getX();
	
	/** The solid area Y. */
	public int solidAreaY = solidArea.getY();
	
	/** The solid. */
	public boolean solid;
		
	/** The attack area. */
	public GameRect attackArea = new GameRect(0,0,GameConstants.ORIGINAL_TILESIZE_16,GameConstants.ORIGINAL_TILESIZE_16);
	
	/** The attack area X. */
	public int attackAreaX = attackArea.getX();
	
	/** The attack area Y. */
	public int attackAreaY = attackArea.getY();
		
	/** The animations. */
	public IAnimationManager animations = new AnimationManager();
		
	/** The direction. */
	public int direction ;
		
	/** The collision. */
	public boolean collision ; 
		
	/** The moving. */
	public boolean moving ;
		
	/** The max life. */
	public int maxLife = 6;
	
	/** The life. */
	public int life = maxLife;
		
	/** The alife. */
	public boolean alife = true;
	
	/** The dead. */
	public boolean dead = false;

	/**
	 * Instantiates a new abstract game object container.
	 */
	public AbstractGameObjectContainer()
	{
		super();
	}	
}