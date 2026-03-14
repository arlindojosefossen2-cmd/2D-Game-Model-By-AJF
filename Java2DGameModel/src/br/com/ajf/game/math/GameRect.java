package br.com.ajf.game.math;

import java.awt.Point;

/**
 *  Author A.J.F
 * The Class GameRect.
 * @version 1.0
 * 23 June 2025
 */
public final class GameRect
{
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;
	
	/** The width. */
	private int width;
	
	/** The height. */
	private int height;
		
	/**
	 * Instantiates a new game rect.
	 */
	public GameRect()
	{
	
	}	

	/**
	 * Instantiates a new game rect.
	 *
	 * @param x the x
	 * @param y the y
	 * @param width the width
	 * @param height the height
	 */
	public GameRect(final int x,final int y,final int width,final int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * Contains.
	 *
	 * @param x the x
	 * @param y the y
	 * @return true, if successful
	 */
	public boolean contains(final double x,final double y) 
	{
        double x0 = getX();
        double y0 = getY();
        
        return 	x >= x0 &&
                y >= y0 &&
                x < x0 + getWidth() &&
                y < y0 + getHeight();
    }

	/**
	 * Contains.
	 *
	 * @param point the point
	 * @return true, if successful
	 */
	public boolean contains(final Point point) 
	{
		double x = point.getX();
		double y = point.getY();
		
        double x0 = getX();
        double y0 = getY();
        
        return 	x >= x0 &&
                y >= y0 &&
                x < x0 + getWidth() &&
                y < y0 + getHeight();
    }


    /**
     * Intersects.
     *
     * @param x the x
     * @param y the y
     * @param w the w
     * @param h the h
     * @return true, if successful
     */
    public boolean intersects(final double x,final double y,final double w,final double h) 
    {
        if (w <= 0 || h <= 0) 
        {
            return false;
        }
        
        final double x0 = getX();
        final double y0 = getY();
        
        return  x + w > x0 &&
                y + h > y0 &&
                x < x0 + getWidth() &&
                y < y0 + getHeight();
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
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(final int x)
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
	public void setY(final int y)
	{
		this.y = y;
	}


	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth()
	{
		return width;
	}


	/**
	 * Sets the width.
	 *
	 * @param width the new width
	 */
	public void setWidth(final int width)
	{
		this.width = width;
	}


	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight()
	{
		return height;
	}


	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(final int height)
	{
		this.height = height;
	}

	/**
	 * Intersects.
	 *
	 * @param solidArea the solid area
	 * @return true, if successful
	 */
	public boolean intersects(final GameRect solidArea)
	{
		return intersects(solidArea.getX(), solidArea.getY(), solidArea.getWidth(), solidArea.getHeight());
	}
}