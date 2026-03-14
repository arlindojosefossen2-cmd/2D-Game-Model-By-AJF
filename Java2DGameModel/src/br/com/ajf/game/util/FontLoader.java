package br.com.ajf.game.util;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

/**
 * The Class FontLoader.
 * @version 1.0
 * Author A.J.F
 */
public final class FontLoader
{
	/**
	 * Instantiates a new font loader.
	 */
	public FontLoader()
	{
		super();
	}

	/**
	 * Gets the font.
	 *
	 * @param path way of the font resource
	 * @return a font or null
	 * method used to load fonts
	 */
	public Font getFont(final String path)
	{
		Font font = null;
		
			try
			{
				font = Font.createFont(Font.TRUETYPE_FONT, FontLoader.class.getResourceAsStream(path));
				
			} 
			catch (FontFormatException | IOException err)
			{				
				err.printStackTrace();
			}
	
		return font;
	}
	
	/**
	 * Gets the font.
	 *
	 * @param path way of the font resource
	 * @param size the size of the font
	 * @return a font or null
	 * method used to load fonts
	 */
	public Font getFont(final String path,final float size)
	{
		Font font = null;
		
			try
			{
				font = Font.createFont(Font.TRUETYPE_FONT, FontLoader.class.getResourceAsStream(path)).deriveFont(size);
			} 
			catch (FontFormatException | IOException err)
			{
				err.printStackTrace();
			}
	
		return font;
	}
}