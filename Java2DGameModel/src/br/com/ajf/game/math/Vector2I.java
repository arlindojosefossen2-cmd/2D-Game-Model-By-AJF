package br.com.ajf.game.math;

/**
 * The Class Vector2I.
 */
public final class Vector2I
{
	
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;
	
	/**
	 * Instantiates a new vector 2 I.
	 */
	public Vector2I()
	{
		x = 1;
		y = 1;
	}
	
	/**
	 * Instantiates a new vector 2 I.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Vector2I(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * Adds the.
	 *
	 * @param value the value
	 * @return the vector 2 I
	 */
	public Vector2I add(int value)
	{
		
		this.x += value;
		this.y += value;
		
		return this;
	}
	
	/**
	 * Adds the.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the vector 2 I
	 */
	public Vector2I add(int x,int y)
	{
		
		this.x += x;
		this.y += y;
		
		return this;
	}
	
	/**
	 * Adds the.
	 *
	 * @param vec the vec
	 * @return the vector 2 I
	 */
	public Vector2I add(Vector2I vec)
	{
		
		this.x += vec.x;
		this.y += vec.y;
		
		return this;
	}
	
	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(int y)
	{
		this.y = y;
	}

	/**
	 * Sets the.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void set(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString()
	{
		return "Vector2I [x=" + x + ", y=" + y + "]";
	}
}