package br.com.ajf.game.collision;

/**
 * The Class Collider.
 */
public final class Collider
{
	
	/** The id. */
	private final int id;
	
	/** The layer. */
	private int layer;
	
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;
	
	/** The width. */
	private final int width;
	
	/** The height. */
	private final int height;
	
	/** The type. */
	private final String type;

	/**
	 * Instantiates a new collider.
	 *
	 * @param id the id
	 * @param layer the layer
	 * @param x the x
	 * @param y the y
	 * @param width the width
	 * @param height the height
	 * @param type the type
	 */
	public Collider(final int id,final int layer,final int x,final int y,
			final int width,final int height,final String type)
	{
		this.id = id;
		this.layer = layer;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.type = type;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Gets the layer.
	 *
	 * @return the layer
	 */
	public int getLayer()
	{
		return layer;
	}
	
	/**
	 * Sets the layer.
	 *
	 * @param layer the new layer
	 */
	public void setLayer(int layer)
	{
		this.layer = layer;
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
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth()
	{
		return width;
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
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType()
	{
		return type;
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
	 * Intersects.
	 *
	 * @param solidArea the solid area
	 * @return true, if successful
	 */
	public boolean intersects(final Collider solidArea)
	{
		return intersects(solidArea.getX(), solidArea.getY(), solidArea.getWidth(), solidArea.getHeight());
	}
}