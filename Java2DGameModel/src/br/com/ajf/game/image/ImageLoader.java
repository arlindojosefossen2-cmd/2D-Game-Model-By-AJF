package br.com.ajf.game.image;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * The Class ImageLoader.
 */
public final class ImageLoader
{
	/**
	 * Instantiates a new image loader.
	 */
	public ImageLoader()
	{
		
	}
	
	/**
	 * Load image.
	 *
	 * @param filename the filename
	 * @return the image
	 */
	public Image loadImage(String filename)
	{
		return new LoadImage().loadImage(filename);
	}
	
	/**
	 * Load images from files.
	 *
	 * @param filename the filename
	 * @return the image[]
	 */
	public Image[] loadImagesFromFiles(String[] filename)
	{
		return new LoadImage().loadImagesFromFiles(filename);
	}
	
	/**
	 * Load images from sheet.
	 *
	 * @param filename the filename
	 * @param rows the rows
	 * @param cols the cols
	 * @return the image[]
	 */
	public Image[] loadImagesFromSheet(String filename,int rows,int cols)
	{	
		return new LoadImage().loadImagesFromSheet(filename, rows, cols);
	}
	
	/**
	 * Load scaled image.
	 *
	 * @param filename the filename
	 * @param scale the scale
	 * @return the image
	 */
	public Image loadScaledImage(String filename, float scale)
	{
		return new LoadImage().loadScaledImage(filename, scale);
	}
	
	/**
	 * Load scaled images from files.
	 *
	 * @param filename the filename
	 * @param scale the scale
	 * @return the image[]
	 */
	public Image[] loadScaledImagesFromFiles(String[] filename, float scale)
	{
		return new LoadImage().loadScaledImagesFromFiles(filename, scale);
	}
	
	/**
	 * Load scaled images from sheet.
	 *
	 * @param filename the filename
	 * @param rows the rows
	 * @param cols the cols
	 * @param scale the scale
	 * @return the image[]
	 */
	public Image[] loadScaledImagesFromSheet(String filename,int rows,int cols, float scale)
	{
		return new LoadImage().loadScaledImagesFromSheet(filename, rows, cols, scale);
	}
	
	/**
	 * Load buffered image.
	 *
	 * @param filename the filename
	 * @return the buffered image
	 */
	public BufferedImage loadBufferedImage(String filename)
	{
		return new BufferedImageLoader().loadBufferedImage(filename);
	}
	
	/**
	 * Load buffered images from sheet.
	 *
	 * @param filename the filename
	 * @param rows the rows
	 * @param cols the cols
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadBufferedImagesFromSheet(String filename,int rows,int cols)
	{
		return new BufferedImageLoader().loadBufferedImagesFromSheet(filename, rows, cols);
	}
	
	/**
	 * Load buffered images from files.
	 *
	 * @param filename the filename
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadBufferedImagesFromFiles(String[] filename)
	{
		return new BufferedImageLoader().loadBufferedImagesFromFiles(filename);
	}
	
	/**
	 * Load scaled buffered image.
	 *
	 * @param filename the filename
	 * @param scale the scale
	 * @return the buffered image
	 */
	public BufferedImage loadScaledBufferedImage(String filename,float scale)
	{	
		return new BufferedImageLoader().loadScaledBufferedImage(filename, scale);
	}
	
	/**
	 * Load scaled buffered images from sheet.
	 *
	 * @param filename the filename
	 * @param rows the rows
	 * @param cols the cols
	 * @param scale the scale
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadScaledBufferedImagesFromSheet(String filename,int rows,int cols,float scale)
	{
		return new BufferedImageLoader().loadScaledBufferedImagesFromSheet(filename, rows, cols, scale);
	}
	
	/**
	 * Load scaled buffered images from files.
	 *
	 * @param filename the filename
	 * @param scale the scale
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadScaledBufferedImagesFromFiles(String[] filename,float scale)
	{
		return new BufferedImageLoader().loadScaledBufferedImagesFromFiles(filename, scale);
	}
	
	/**
	 * Load flipped buffered image.
	 *
	 * @param fileName the file name
	 * @param flipKind the flip kind
	 * @return the buffered image
	 */
	public BufferedImage loadFlippedBufferedImage(String fileName, int flipKind)
	{
		return new BufferedImageLoader().loadFlippedBufferedImage(fileName, flipKind);
	}
	
	/**
	 * Load flipped buffered images from sheet.
	 *
	 * @param fileName the file name
	 * @param rows the rows
	 * @param cols the cols
	 * @param flipKind the flip kind
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadFlippedBufferedImagesFromSheet(String fileName,int rows,int cols, int flipKind)
	{
		return new BufferedImageLoader().loadFlippedBufferedImagesFromSheet(fileName, rows, cols, flipKind);
	}
	
	/**
	 * Load flipped buffered images from files.
	 * @param fileName the file name
	 * @param flipKind the flip kind
	 * @return the buffered image[]
	 */
	public BufferedImage[] loadFlippedBufferedImagesFromFiles(String[] fileName,int flipKind)
	{
		return new BufferedImageLoader().loadFlippedBufferedImagesFromFiles(fileName, flipKind);
	}
	
	/**
	 * Convert image to buffered image.
	 *
	 * @param img the img
	 * @return the buffered image
	 */
	public BufferedImage convertImageToBufferedImage(Image img)
	{	
		return new ImageConversor().convertImageToBufferedImage(img);
	}
	
	/**
	 * Convert image to buffered image.
	 *
	 * @param img the img
	 * @param width the width
	 * @param height the height
	 * @return the buffered image
	 */
	public BufferedImage convertImageToBufferedImage(Image img,int width,int height)
	{
		return new ImageConversor().convertImageToBufferedImage(img, width, height);
	}
	
	/**
	 * Gets the scaled image size.
	 *
	 * @param filePath the file path
	 * @param scale the scale
	 * @return the scaled image size or a default 'new ImageSize(1,1)';
	 */
	public ImageSize getScaledImageSize(String filePath,float scale)
	{
		if(scale > 0)
		{
			return new BufferedImageLoader().getScaledImageSize(filePath, scale);
		}
		return new ImageSize(1, 1);
	}
}