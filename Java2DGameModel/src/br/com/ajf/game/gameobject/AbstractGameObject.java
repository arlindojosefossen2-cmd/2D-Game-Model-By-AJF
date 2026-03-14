package br.com.ajf.game.gameobject;

import java.awt.Graphics2D;

import br.com.ajf.game.math.GameRect;

/**
 * The Class AbstractGameObject.
 */
public abstract class AbstractGameObject
{
	/** The container. */
	private final AbstractGameObjectContainer container = new AbstractGameObjectContainer();
	
	/**
	 * Instantiates a new abstract game object.
	 */
	public AbstractGameObject()
	{
		super();
	}

	/**
	 * Start.
	 */
	public abstract void start();
	
	/**
	 * Update.
	 *
	 * @param delta the delta
	 */
	public abstract void update(float delta);
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param playerXOffset the player X offset
	 * @param playerYOffset the player Y offset
	 */
	public abstract void draw(Graphics2D graphics2d,int playerXOffset,int playerYOffset);
	
	/**
	 * Gets the x pos.
	 *
	 * @return the x pos
	 */
	public int getxPos()
	{
		return container.xPos;
	}
	
	/**
	 * Sets the x pos.
	 *
	 * @param xpos the new x pos
	 */
	public void setxPos(int xpos)
	{
		this.container.xPos = xpos;
	}
	
	/**
	 * Gets the solid area.
	 *
	 * @return the solid area
	 */
	public GameRect getSolidArea()
	{
		return container.solidArea;
	}

	/**
	 * Gets the y pos.
	 *
	 * @return the y pos
	 */
	public int getyPos()
	{
		return container.yPos;
	}
	
	/**
	 * Sets the y pos.
	 *
	 * @param ypos the new y pos
	 */
	public void setyPos(int ypos)
	{
		this.container.yPos = ypos;
	}

	/**
	 * Gets the direction.
	 *
	 * @return the direction
	 */
	public int getDirection()
	{
		return container.direction;
	}
	
	/**
	 * Sets the direction.
	 *
	 * @param direction the new direction
	 */
	public void setDirection(int direction)
	{
		this.container.direction = direction;
	}

	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public int getSpeed()
	{
		return container.speed;
	}
	
	/**
	 * Sets the speed.
	 *
	 * @param speed the new speed
	 */
	public void setSpeed(int speed)
	{
		this.container.speed = speed;
	}

	/**
	 * Sets the collision.
	 *
	 * @param b the new collision
	 */
	public void setCollision(boolean b)
	{
		this.container.collision = b;
	}
	
	/**
	 * Gets the collision.
	 *
	 * @return the collision
	 */
	public boolean getCollision()
	{
		return container.collision;
	}

	/**
	 * Checks if is moving.
	 *
	 * @return true, if is moving
	 */
	public boolean isMoving()
	{
		return container.moving;
	}

	/**
	 * Sets the moving.
	 *
	 * @param moving the new moving
	 */
	public void setMoving(boolean moving)
	{
		this.container.moving = moving;
	}

	/**
	 * Gets the container.
	 *
	 * @return the container
	 */
	public AbstractGameObjectContainer getContainer()
	{
		return container;
	}
}