package br.com.ajf.game.button;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import br.com.ajf.game.input.GameMouseListener;
import br.com.ajf.game.math.GameRect;
import br.com.ajf.game.util.FontLoader;


/**
 * The Class GameButton.
 * Author A.J.F.
 * @version 1.0
 * 17 June 2025

 */
public final class GameButton implements IGameButton
{
	
	/** The rect. */
	private final GameRect rect ;
	
	/** The mousein. */
	private boolean mousein;
	
	/** The i button clicked. */
	private final IButtonClicked iButtonClicked;
	
	/** The font. */
	private Font font ;
	
	/** The text. */
	private final String text;
	
	/**  the size of the font to draw the text on button */
	private final float size ;
	
	
	/**
	 * Instantiates a new game button.
	 *
	 * @param text the text
	 * @param xPos the x position
	 * @param yPos the y position
	 * @param width the width
	 * @param height the height
	 * @param fontSize the font size
	 * @param iButtonClicked the i button clicked
	 */
	public GameButton(final String text,final int xPos,final int yPos,final int width,final int height,final float fontSize,final IButtonClicked iButtonClicked)
	{
		this.text = text;
		this.rect = new GameRect(xPos,yPos,width,height);
		this.size  = fontSize;
		this.iButtonClicked = iButtonClicked;
	}

	
	/**
	 * Instantiates a new game button.
	 *
	 * @param text the text
	 * @param xPos the x position
	 * @param yPos the y position
	 * @param width the width
	 * @param height the height
	 * @param fontSize the font size
	 * @param fontPath the font path
	 * @param iButtonClicked the i button clicked
	 */
	public GameButton(final String text,final int xPos,final int yPos,final int width,final int height,final float fontSize,final String fontPath,final IButtonClicked iButtonClicked)
	{
		this.text = text;
		this.rect = new GameRect(xPos,yPos,width,height);
		this.size = fontSize;
		this.iButtonClicked = iButtonClicked;
		FontLoader loader = new FontLoader();
		this.font = loader.getFont(fontPath);
	}
	
	/**
	 * Update.
	 */
	@Override
	public void update()
	{
		if(rect.contains(GameMouseListener.getPosition()))
		{
			mousein = true;
		}
		else
		{
			mousein = false;
		}
		if(mousein)
		{
			if(GameMouseListener.buttonDown(MouseEvent.BUTTON1))
			{
				this.iButtonClicked.onClicked();
			}
		}	
	}

	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 */
	@Override
	public void draw(final Graphics2D graphics2d)
	{
		if(font != null)
		{
			graphics2d.setFont(font.deriveFont(size).deriveFont(Font.BOLD));
		}
		else
		{
			graphics2d.setFont(graphics2d.getFont().deriveFont(size).deriveFont(Font.BOLD));
		}
		
		final FontMetrics fontMetrics = graphics2d.getFontMetrics();
		
		graphics2d.setStroke(new BasicStroke(3F));		
		graphics2d.setColor(Color.DARK_GRAY);
		graphics2d.drawRoundRect(rect.getX()-3, rect.getY()-3, rect.getWidth()+4, rect.getHeight()+4, 5, 5);
		
		if(mousein)
		{
			graphics2d.setColor(Color.LIGHT_GRAY);		
		}
		else
		{
			graphics2d.setColor(Color.GRAY);
		}

		graphics2d.fillRoundRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), 5, 5);

		graphics2d.setColor(Color.BLACK);		
		final int yPos = rect.getY()+(rect.getHeight()/2+((int)fontMetrics.getStringBounds(text, graphics2d).getHeight())/2-4);
		final int xPos = rect.getX()-(-rect.getWidth()/2+( (int)fontMetrics.getStringBounds(text, graphics2d).getWidth())/2);
		graphics2d.drawString(text, xPos, yPos);	
	}
}