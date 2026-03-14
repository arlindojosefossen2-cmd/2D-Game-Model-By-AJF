package br.com.ajf.game.math;

/**
 * The Class Vector2F.
 */
public final class Vector2F
{
    
    /** The x. */
    public float x;
    
    /** The y. */
    public float y;
    
    /** The w. */
    public float w;

    /**
     * Instantiates a new vector 2 F.
     */
    public Vector2F()
    {
        this.x = 0.0f;
        this.y = 0.0f;
        this.w = 1.0f;
    }

    /**
     * Instantiates a new vector 2 F.
     *
     * @param v the v
     */
    public Vector2F(Vector2F v)
    {
        this.x = v.x;
        this.y = v.y;
        this.w = v.w;
    }

    /**
     * Instantiates a new vector 2 F.
     *
     * @param x the x
     * @param y the y
     */
    public Vector2F(float x,float y)
    {
        this.x = x;
        this.y = y;
        this.w = 1.0f;
    }

    /**
     * Instantiates a new vector 2 F.
     *
     * @param x the x
     * @param y the y
     * @param w the w
     */
    public Vector2F(float x,float y,float w)
    {
        this.x = x;
        this.y = y;
        this.w = w;
    }

    /**
     * Translate.
     *
     * @param tx the tx
     * @param ty the ty
     */
    public void translate(float tx,float ty)
    {
        x += tx;
        y += ty;
    }
    
    /**
     * Scale.
     *
     * @param sx the sx
     * @param sy the sy
     */
    public void scale(float sx,float sy)
    {
        x *= sx;
        y *= sy;
    }

    /**
     * Rotate.
     *
     * @param rad the rad
     */
    public void rotate(float rad)
    {
        float tmp = (float)(x*Math.cos(rad) - y*Math.sin(rad));
        y = (float)(x*Math.sin(rad) + y*Math.cos(rad));
        x = tmp;
    }

    /**
     * Shear.
     *
     * @param sx the sx
     * @param sy the sy
     */
    public void shear(float sx,float sy)
    {
        float tmp = x + sx*y;
        y = y + sy*x;
        x = tmp;
    }

    /**
     * Adds the.
     *
     * @param vec the vec
     * @return the vector 2 F
     */
    public Vector2F add(Vector2F vec)
    {
        return new Vector2F(x + vec.x,y + vec.y);
    }
    
    /**
     * Sub.
     *
     * @param vec the vec
     * @return the vector 2 F
     */
    public Vector2F sub(Vector2F vec)
    {
        return new Vector2F(x - vec.x,y - vec.y);
    }

    /**
     * Mul.
     *
     * @param scalar the scalar
     * @return the vector 2 F
     */
    public Vector2F mul(float scalar)
    {
        return new Vector2F(x * scalar,y * scalar);
    }

    /**
     * Div.
     *
     * @param scalar the scalar
     * @return the vector 2 F
     */
    public Vector2F div(float scalar)
    {
        return new Vector2F(x / scalar,y / scalar);
    }

    /**
     * Inv.
     *
     * @return the vector 2 F
     */
    public Vector2F inv()
    {
        return new Vector2F(-x,-y);
    }

    /**
     * Norm.
     *
     * @return the vector 2 F
     */
    public Vector2F norm()
    {
        return div(len());
    }

    /**
     * Dot.
     *
     * @param vec the vec
     * @return the float
     */
    public float dot(Vector2F vec)
    {
        return x*vec.x+y*vec.y;
    }

    /**
     * Len.
     *
     * @return the float
     */
    public float len()
    {
        return (float)Math.sqrt(x*x+y*y);
    }

    /**
     * Len SQR.
     *
     * @return the float
     */
    public float lenSQR()
    {
        return x*x+y*y;
    }

    /**
     * Perp.
     *
     * @return the vector 2 F
     */
    public Vector2F perp()
    {
        return new Vector2F(-y, x);
    }

    /**
     * Angle.
     *
     * @return the float
     */
    public float angle()
    {
        return (float)Math.atan2(y, x);
    }

    /**
     * Polar.
     *
     * @param angle the angle
     * @param radius the radius
     * @return the vector 2 F
     */
    public static Vector2F polar(float angle,float radius)
    {
        return new Vector2F(radius*(float)Math.cos(angle),
                radius*(float)Math.sin(angle));
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString()
    {
        return "Vector2f(" +
                "x=" + x +
                ", y=" + y +
                ", w=" + w +
                ')';
    }
    
}