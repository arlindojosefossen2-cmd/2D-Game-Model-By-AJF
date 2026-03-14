package br.com.ajf.game.render;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import br.com.ajf.game.input.InputManager;



/**
 *  The Class GameRenderManager.
 *  
 * Author A.J.F.
 * @version 1.0
 * 28 June 2025
 */
public final class GameRenderManager
{
	/** The input manager. */
	public final InputManager inputManager;
	
	/** The canvas. */
	public final JPanel canvas ;
	
	/** The image screen. */
	public final BufferedImage imageScreen ; 

    /** The graphics 2 d. */
    public final Graphics2D graphics2d ;
    
    /**
     * Instantiates a new game render manager.
     *
     * @param width the width
     * @param height the height
     */
    public GameRenderManager(int width, int height)
    {
    	this.inputManager = new InputManager();
		
		this.canvas  = new JPanel();
		final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		if(width > dimension.getWidth() || width <= 0)
		{
			width = (int) dimension.getWidth();
		}
		if(height > dimension.getHeight() || height <= 0)
		{
			height = (int) dimension.getHeight();
		}
		
		this.imageScreen = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);	
		this.graphics2d = this.imageScreen.createGraphics();
    }
    /**
	 * Creates the J panel and add properties.
	 */
	public void createJPanelAndAddProperties()
	{
		this.canvas.setPreferredSize(new Dimension(imageScreen.getWidth(), imageScreen.getHeight()));
		
		this.canvas.setBackground(Color.BLACK);
		this.canvas.setDoubleBuffered(true);
		
		this.canvas.addKeyListener(inputManager.getInput().getKeyAdapter());
		this.canvas.addMouseListener(inputManager.getMouse().getAdapter());
		this.canvas.addMouseMotionListener(inputManager.getMouse().getAdapter());
		
		this.canvas.setFocusable(true);		
	}
	
	/**
	 * Draw to buffered image.
	 */
	public void drawToBufferedImage()
	{
		this.graphics2d.clearRect(0, 0,imageScreen.getWidth(), imageScreen.getHeight());
	}
	/**
	 * Draw to screen.
	 */
	public void drawToScreen()
	{
		final Graphics graphics =  this.canvas.getGraphics();	
		graphics.drawImage(imageScreen, 0, 0, null);		
		graphics.dispose();
	}
}