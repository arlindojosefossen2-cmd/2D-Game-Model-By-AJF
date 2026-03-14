package br.com.ajf.game.image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


/**
 * The Class ImageUtility.
 */
public final class ImageUtility
{
	
	/**
	 * Instantiates a new image utility.
	 */
	public ImageUtility()
	{
		
	}
	
	/**
	 * Scale image.
	 *
	 * @param imageToScale the image to scale
	 * @param scale the scale
	 * @return the buffered image
	 */
	public BufferedImage scaleImage(BufferedImage imageToScale,float scale)
	{
		BufferedImage img = null;
		
		int width = imageToScale.getWidth();
		int height = imageToScale.getHeight();
		
		int targetWidth = (int) (width*scale);
		int targetHeight = (int) (height*scale);
		
		if(width < targetWidth || height < targetHeight)
		{
			img = scaledImageUp(imageToScale, targetWidth, targetHeight);
		}
		else
		{
			img = scaledImageDown(imageToScale, targetWidth, targetHeight,width, height);
		}
		
		return img;
	}
	
	/**
	 * Scale image.
	 *
	 * @param imageToScale the image to scale
	 * @param targetWidth the target width
	 * @param targetHeight the target height
	 * @return the buffered image
	 */
	public BufferedImage scaleImage(BufferedImage imageToScale,int targetWidth,int targetHeight)
	{
		BufferedImage img = null;
		
		int w = imageToScale.getWidth();
		int h = imageToScale.getHeight();
		
		if(w < targetWidth || h < targetHeight)
		{
			img = scaledImageUp(imageToScale, targetWidth, targetHeight);
		}
		else
		{
			img = scaledImageDown(imageToScale, targetWidth, targetHeight, w, h);
		}
		
		return img;
	}
	
	/**
	 * Scaled image down.
	 *
	 * @param imageToScale the image to scale
	 * @param targetWidth the target width
	 * @param targetHeight the target height
	 * @param w the w
	 * @param h the h
	 * @return the buffered image
	 */
	private static BufferedImage scaledImageDown(BufferedImage imageToScale, int targetWidth, int targetHeight, int w,int h)
	{
		BufferedImage img;
		Graphics2D g;
		
		do 
		{
			w = w / 2;
			
			if( w < targetWidth )
			{
				w = targetWidth;
			}
			
			h = h / 2;
			
			if( h < targetHeight )
			{
				h = targetHeight;
			}
			
			img = new BufferedImage( w, h, BufferedImage.TYPE_INT_ARGB );
			
			g = img.createGraphics();
			
//			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
//					RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			
			g.drawImage( imageToScale, 0, 0, w, h, null );
			
			g.dispose();
			
			imageToScale = img;
			
		} while( w != targetWidth || h != targetHeight );
		return img;
	}
	
	/**
	 * Scaled image up.
	 *
	 * @param imageToScale the image to scale
	 * @param targetWidth the target width
	 * @param targetHeight the target height
	 * @return the buffered image
	 */
	private static BufferedImage scaledImageUp(BufferedImage imageToScale, int targetWidth, int targetHeight)
	{
		BufferedImage img;
		Graphics2D g;
		
		img = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);

		g = img.createGraphics();
		
//		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
//				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		
		g.drawImage(imageToScale, 0, 0, img.getWidth(), img.getHeight(), null);
		
		g.dispose();
		return img;
	}
	
}