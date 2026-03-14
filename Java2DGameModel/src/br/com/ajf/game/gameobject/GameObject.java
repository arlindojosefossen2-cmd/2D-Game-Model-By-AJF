package br.com.ajf.game.gameobject;

import br.com.ajf.game.animation.IAnimationManager;
import br.com.ajf.game.collision.Collider;
import br.com.ajf.game.math.Vector2I;
import br.com.ajf.game.moviment.FourDirections;

/**
 * The Class GameObject.
 */
public abstract class GameObject implements IGameObject
{
	/** The collider. */
	public Collider collider;

	/** The solid area X. */
	public int solidAreaX;

	/** The solid area Y. */
	public int solidAreaY;

	/** The animations. */
	public IAnimationManager animations;
	
	/** The position. */
	public Vector2I position = new Vector2I(0, 0);
	
	/** The velocity. */
	public Vector2I velocity = new Vector2I(1,1);
	
	/** The solid. */
	public boolean solid = true;
	
	/** The moving. */
	public boolean moving;
	
	/** The direction. */
	public FourDirections direction = FourDirections.DOWN;

	/**
	 * Instantiates a new game object.
	 */
	public GameObject()
	{
		super();
	}
}