package br.com.ajf.game.image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

/**
 * The Class ImageSFX.
 */
public final class ImageSFX
{
	
	/** The Constant VERTICAL_FLIP. */
	public static final int VERTICAL_FLIP = 0;
	
	/** The Constant HORIZONTAL_FLIP. */
	public static final int HORIZONTAL_FLIP = 1;
	
	/** The Constant DOUBLE_FLIP. */
	public static final int DOUBLE_FLIP = 2;
	
	/**
	 * Instantiates a new image SFX.
	 */
	public ImageSFX()
	{
		
	}
	
	/**
	 * Image color SFX.
	 *
	 * @param img the img
	 * @param row the row
	 * @param col the col
	 * @param red the red
	 * @param green the green
	 * @param blue the blue
	 * @param alpha the alpha
	 * @return the int
	 */
	private int bufferedImageColorSFX(BufferedImage img,int row,int col,int red,int green,int blue,int alpha)
	{
		int pixel = img.getRGB(row, col);
		int alphaVal = (pixel >> 24) & alpha;
		int redVal = (pixel >> 16) & red;
		int greenVal = (pixel >> 8) & green;
		int blueVal = pixel & blue;	
		int newPixel = blueVal | (greenVal << 8) | ( redVal << 16) | (alphaVal << 24); 
		
		return newPixel;	
	}
	
	/**
	 * Scale image.
	 *
	 * @param img the img
	 * @param scale the scale
	 * @return the image
	 */
	public Image scaleImage(Image img,float scale)
	{
		ImageIcon aux = new ImageIcon(img);
		Image im = aux.getImage().getScaledInstance((int)(aux.getIconWidth()*scale),
				(int)(aux.getIconHeight()*scale),
				Image.SCALE_REPLICATE);
		return im;
	}
	
	/**
	 * Scale image.
	 *
	 * @param img the img
	 * @param scale the scale
	 * @return the image[]
	 */
	public Image[] scaleImages(Image[] img,float scale)
	{
		for (int i = 0; i < img.length; i++)
		{
			img[i] = scaleImage(img[i], scale);
		}
		return img;
	}
	
	/**
	 * Scale buffered image.
	 *
	 * @param img the img
	 * @param scale the scale
	 * @return the buffered image[]
	 */
	public BufferedImage[] scaleBufferedImages(BufferedImage[] img,float scale)
	{
		for (int i = 0; i < img.length; i++)
		{
			img[i] = scaleBufferedImage(img[i], scale);
		}
		return img;
	}
	
	/**
	 * Scale buffered image.
	 *
	 * @param img the img
	 * @param scale the scale
	 * @return the buffered image
	 */
	public BufferedImage scaleBufferedImage(BufferedImage img,float scale)
	{
		BufferedImage aux = new BufferedImage((int)(img.getWidth()*scale),(int)(img.getHeight()*scale),
				BufferedImage.TYPE_INT_ARGB);	
		Graphics2D g2d = aux.createGraphics();	
		g2d.drawImage(img, 0, 0, aux.getWidth(), aux.getHeight(), null);
		g2d.dispose();
		
	return aux;
	}
	
	/**
	 * Buffered image color SFX.
	 *
	 * @param img the img
	 * @param red the red
	 * @param green the green
	 * @param blue the blue
	 * @param alpha the alpha
	 */
	public void bufferedImageColorSFX(BufferedImage img,int red,int green,int blue,int alpha)
	{	
		for (int i = 0; i < img.getWidth(); i++)
		{
			for (int j = 0; j < img.getHeight(); j++)
			{
				img.setRGB(i, j, bufferedImageColorSFX(img, i, j, red, green, blue, alpha));
			}
		}
	}
	
	/**
	 * Gets the rotated buffered image.
	 *
	 * @param src the src
	 * @param angle the angle
	 * @return the rotated buffered image
	 */
	public BufferedImage getRotatedBufferedImage(BufferedImage src, int angle)
	{
		 if (src == null) 
		 {
			 return null;
		 }
		 
		 BufferedImage dest = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_INT_ARGB);
		 Graphics2D g2d = dest.createGraphics( );	 
		 AffineTransform origAT = g2d.getTransform( );  
		 AffineTransform rot = new AffineTransform( );
		
		 rot.rotate( Math.toRadians(angle), src.getWidth( )/2, src.getHeight( )/2);
		 
		 g2d.transform(rot);
		 g2d.drawImage(src, 0, 0, null); 
		 g2d.setTransform(origAT);		
		 g2d.dispose( );
		 
	 return dest;
	}
	
	/**
	 * Gets the flipped buffered image.
	 *
	 * @param im the im
	 * @param flipKind the flip kind
	 * @return the flipped buffered image
	 */
	public BufferedImage getFlippedBufferedImage(BufferedImage im,int flipKind)
	{
		 if (im == null) 
		 {
			 return null;
		 }
		 
		 int imWidth = im.getWidth( );
		 int imHeight = im.getHeight( ); 
		 
		 BufferedImage copy = new BufferedImage(imWidth,imHeight, BufferedImage.TYPE_INT_ARGB);
		 Graphics2D g2d = copy.createGraphics( );
		 renderFlip(g2d, im, imWidth, imHeight, flipKind);	 
		 g2d.dispose( );
		 
	 return copy;
	} 
	
	/**
	 * Gets the flipped buffered images.
	 *
	 * @param imgs the imgs
	 * @param flipKind the flip kind
	 * @return the flipped buffered images
	 */
	public BufferedImage[] getFlippedBufferedImages(BufferedImage[] imgs,int flipKind)
	{
		BufferedImage[] other = new BufferedImage[imgs.length];
		
		for (int i = 0; i < other.length; i++)
		{
			other[i] = getFlippedBufferedImage(imgs[i], flipKind);
		}
		return other;
	}
	
	/**
	 * Render flip.
	 *
	 * @param g2d the g 2 d
	 * @param im the im
	 * @param imWidth the im width
	 * @param imHeight the im height
	 * @param flipKind the flip kind
	 */
	private void renderFlip(Graphics2D g2d, BufferedImage im,int imWidth, int imHeight, int flipKind)
	{
		if (flipKind == VERTICAL_FLIP)
			 g2d.drawImage(im, imWidth, 0, 0, imHeight, 0, 0, imWidth, imHeight, null);
		else if (flipKind == HORIZONTAL_FLIP)
			 g2d.drawImage(im, 0, imHeight, imWidth, 0,0, 0, imWidth, imHeight, null);
		else 
			 g2d.drawImage(im, imWidth, imHeight, 0, 0, 0, 0, imWidth, imHeight, null);
	}
	
	
	/**
	 * Crop buffered image A array.
	 *
	 * @param img the img
	 * @param startPos the start pos
	 * @param endPos the end pos
	 * @return the buffered image[]
	 */
	public BufferedImage[] cropBufferedImageArray(BufferedImage[] img,int startPos,int endPos)
	{
		final BufferedImage aux[] = new BufferedImage[endPos - startPos+1];
		
		int index = 0;
		
		for (int i = startPos;i <= endPos; i++)
		{
			if(((index < aux.length) && (i >= 0 && i < img.length)))
			{
				aux[index] = img[i];
				index++;
			}
		}
		
		return aux;
	}
	
	/**
	 * Crop buffered image.
	 *
	 * @param img the img
	 * @param startPos the start pos
	 * @param frames the frames
	 * @return the buffered image[]
	 */
	public BufferedImage[] cropBufferedImage(BufferedImage[] img,int startPos,int frames)
	{
		final BufferedImage aux[] = new BufferedImage[frames];
		
		int index = startPos;
		
		for (int i = 0;i < frames; i++)
		{
			if(((i < aux.length) && (index >= 0 && index < img.length)))
			{
				aux[i] = img[index];
				index++;
			}
		}
		
		return aux;
	}
}