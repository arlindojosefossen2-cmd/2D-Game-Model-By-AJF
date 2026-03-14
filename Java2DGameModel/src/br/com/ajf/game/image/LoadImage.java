package br.com.ajf.game.image;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

/**
 * The Class LoadImage.
 */
public final class LoadImage
{
	
	/**
	 * Instantiates a new load image.
	 */
	public LoadImage()
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
		return Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(filename));
	}
	
	/**
	 * Load images from files.
	 *
	 * @param filename the filename
	 * @return the image[]
	 */
	public Image[] loadImagesFromFiles(String[] filename)
	{
		Image[] img = new Image[filename.length];
		
		for (int i = 0; i < filename.length; i++)
		{
			img[i] = loadImage(filename[i]);
		}
	return img;
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
		ImageIcon iconAux  = new ImageIcon(loadImage(filename));
		Image[] img = new Image[rows*cols];
		
		int sizeW = iconAux.getIconWidth()/cols;
		int sizeH = iconAux.getIconHeight()/rows;
		
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				img[j + i*cols] = ((BufferedImage) iconAux.getImage()).getSubimage(j*sizeW, i*sizeH, sizeW, sizeH); 
			}
		}
		
	return (Image[])img;
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
		ImageSFX imageSFX = new ImageSFX();
	return imageSFX.scaleImage(loadImage(filename), scale);
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
		Image[] img = loadImagesFromFiles(filename);
		ImageSFX imageSFX = new ImageSFX();
		img = imageSFX.scaleImages(img, scale);
	return img;
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
		Image[] img = loadImagesFromSheet(filename, rows, cols);
		ImageSFX imageSFX = new ImageSFX();
		img = imageSFX.scaleImages(img, scale);
	return img;
	}
}