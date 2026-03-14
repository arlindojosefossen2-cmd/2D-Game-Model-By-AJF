package br.com.ajf.game.math;

/**
 * The Class Matrix3x3F.
 */
public final class Matrix3x3F
{
	
	/** The m. */
	private float[][] m = new float[3][3];
	
	/**
	 * Instantiates a new matrix 3 x 3 F.
	 */
	public Matrix3x3F()
	{
		
	}
	
	/**
	 * Instantiates a new matrix 3 x 3 F.
	 *
	 * @param m the m
	 */
	public Matrix3x3F(float[][] m)
	{
		this.m = m;
	}
	
	/**
	 * Adds the.
	 *
	 * @param mi the mi
	 * @return the matrix 3 x 3 F
	 */
	public Matrix3x3F add(Matrix3x3F mi)
	{
		return new Matrix3x3F(new float[][]
				{
					{	
						this.m[0][0] + mi.m[0][0],
						this.m[0][1] + mi.m[0][1],
						this.m[0][2] + mi.m[0][2]
						
					},
					{
						this.m[1][0] + mi.m[1][0],
						this.m[1][1] + mi.m[1][1],
						this.m[1][2] + mi.m[1][2]
					},
					{
						this.m[2][0] + mi.m[2][0],
						this.m[2][1] + mi.m[2][1],
						this.m[2][2] + mi.m[2][2]
					}
				});
	}
	
	/**
	 * Sub.
	 *
	 * @param mi the mi
	 * @return the matrix 3 x 3 F
	 */
	public Matrix3x3F sub(Matrix3x3F mi)
	{
		return new Matrix3x3F(new float[][]
				{
					{	
						this.m[0][0] - mi.m[0][0],
						this.m[0][1] - mi.m[0][1],
						this.m[0][2] - mi.m[0][2]
						
					},
					{
						this.m[1][0] - mi.m[1][0],
						this.m[1][1] - mi.m[1][1],
						this.m[1][2] - mi.m[1][2]
					},
					{
						this.m[2][0] - mi.m[2][0],
						this.m[2][1] - mi.m[2][1],
						this.m[2][2] - mi.m[2][2]
					}
				});
	}
	
	/**
	 * Mul.
	 *
	 * @param m1 the m 1
	 * @return the matrix 3 x 3 F
	 */
	public Matrix3x3F mul( Matrix3x3F m1 ) {
		return new Matrix3x3F( new float[][] {
		{ this.m[ 0 ][ 0 ] * m1.m[ 0 ][ 0 ] 
		+ this.m[ 0 ][ 1 ] * m1.m[ 1 ][ 0 ] 
		+ this.m[ 0 ][ 2 ] * m1.m[ 2 ][ 0 ],
		this.m[ 0 ][ 0 ] * m1.m[ 0 ][ 1 ]
		+ this.m[ 0 ][ 1 ] * m1.m[ 1 ][ 1 ] 
		+ this.m[ 0 ][ 2 ] * m1.m[ 2 ][ 1 ], 
		this.m[ 0 ][ 0 ] * m1.m[ 0 ][ 2 ] 
		+ this.m[ 0 ][ 1 ] * m1.m[ 1 ][ 2 ] 
		+ this.m[ 0 ][ 2 ] * m1.m[ 2 ][ 2 ] },
		{ this.m[ 1 ][ 0 ] * m1.m[ 0 ][ 0 ] 
		+ this.m[ 1 ][ 1 ] * m1.m[ 1 ][ 0 ] 
		+ this.m[ 1 ][ 2 ] * m1.m[ 2 ][ 0 ], 
		this.m[ 1 ][ 0 ] * m1.m[ 0 ][ 1 ]
		+ this.m[ 1 ][ 1 ] * m1.m[ 1 ][ 1 ] 
		+ this.m[ 1 ][ 2 ] * m1.m[ 2 ][ 1 ], 
		this.m[ 1 ][ 0 ] * m1.m[ 0 ][ 2 ] 
		+ this.m[ 1 ][ 1 ] * m1.m[ 1 ][ 2 ] 
		+ this.m[ 1 ][ 2 ] * m1.m[ 2 ][ 2 ] },
		{ this.m[ 2 ][ 0 ] * m1.m[ 0 ][ 0 ]
		+ this.m[ 2 ][ 1 ] * m1.m[ 1 ][ 0 ] 
		+ this.m[ 2 ][ 2 ] * m1.m[ 2 ][ 0 ], 
		this.m[ 2 ][ 0 ] * m1.m[ 0 ][ 1 ]
		+ this.m[ 2 ][ 1 ] * m1.m[ 1 ][ 1 ] 
		+ this.m[ 2 ][ 2 ] * m1.m[ 2 ][ 1 ], 
		this.m[ 2 ][ 0 ] * m1.m[ 0 ][ 2 ] 
		+ this.m[ 2 ][ 1 ] * m1.m[ 1 ][ 2 ] 
		+ this.m[ 2 ][ 2 ] * m1.m[ 2 ][ 2 ] } 
		});
	}

	/**
	 * Sets the matrix 3 x 3 F.
	 *
	 * @param m the new matrix 3 x 3 F
	 */
	public void setMatrix3x3F(float[][] m)
	{
		this.m = m;
	}
	
	/**
	 * Zero.
	 *
	 * @return the matrix 3 x 3 F
	 */
	public static Matrix3x3F zero()
	{
		return new Matrix3x3F(
				new float[][]
					{
						{0,0,0},
						{0,0,0},
						{0,0,0}
					}
				);
	}
	
	/**
	 * Identity.
	 *
	 * @return the matrix 3 x 3 F
	 */
	public static Matrix3x3F identity()
	{
		return new Matrix3x3F(
				new float[][]
					{
						{1f,0,0},
						{0,1f,0},
						{0,0,1f}
					}
				);
	}
	
	/**
	 * Translate.
	 *
	 * @param v the v
	 * @return the matrix 3 x 3 F
	 */
	public static Matrix3x3F translate(Vector2F v)
	{
		return translate(v.x,v.y);
	}
	
	/**
	 * Translate.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the matrix 3 x 3 F
	 */
	public static Matrix3x3F translate(float x,float y)
	{
		return new Matrix3x3F(
				new float[][]
					{
						{1f,0,0},
						{0,1f,0},
						{x,y,1f}
					}
				);
	}
	
	/**
	 * Scale.
	 *
	 * @param v the v
	 * @return the matrix 3 x 3 F
	 */
	public static Matrix3x3F scale(Vector2F v)
	{
		return scale(v.x,v.y);
	}

	/**
	 * Scale.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the matrix 3 x 3 F
	 */
	public static Matrix3x3F scale(float x, float y)
	{
		return new Matrix3x3F(
				new float[][]
					{
						{x,0,0},
						{0,y,0},
						{0,0,1f}
					}
				);
	}
	
	/**
	 * Shear.
	 *
	 * @param v the v
	 * @return the matrix 3 x 3 F
	 */
	public static Matrix3x3F shear(Vector2F v)
	{
		return shear(v.x,v.y);
	}

	/**
	 * Shear.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the matrix 3 x 3 F
	 */
	public static Matrix3x3F shear(float x, float y)
	{
		return new Matrix3x3F(
				new float[][]
					{
						{1f,y,0},
						{x,1f,0},
						{0,0,1f}
					}
				);
	}
	
	/**
	 * Rotate.
	 *
	 * @param rad the rad
	 * @return the matrix 3 x 3 F
	 */
	public static Matrix3x3F rotate(float rad)
	{
		return new Matrix3x3F(
				new float[][]
					{
						{(float)Math.cos(rad),(float)Math.sin(rad),0},
						{(float)Math.sin(rad),(float)Math.cos(rad),0},
						{0,0,1f}
					}
				);
	}
	
	/**
	 * Mul.
	 *
	 * @param v the v
	 * @return the vector 2 F
	 */
	public Vector2F mul(Vector2F v)
	{
		return new Vector2F(
				
				v.x*this.m[0][0]+
				v.y* this.m[1][0]+
				v.w*this.m[2][0],
				
				v.x*this.m[0][1]+
				v.y* this.m[1][1]+
				v.w*this.m[2][1],
				
				v.x*this.m[0][2]+
				v.y* this.m[1][2]+
				v.w*this.m[2][2]
				
			);
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString()
	{
		StringBuffer buf = new StringBuffer();
		
		for (int i = 0; i < m.length; ++i)
		{
			buf.append("[ ")
			.append(m[i][0])
			.append(".\t")
			.append(m[i][1])
			.append(".\t")
			.append(m[2][0])
			.append("]\n");
			
		}
	return buf.toString();
	}	
	
}