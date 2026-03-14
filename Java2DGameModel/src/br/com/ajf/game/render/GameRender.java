package br.com.ajf.game.render;

import javax.swing.JPanel;

import br.com.ajf.game.scene.Scene;


/**
 * The Class GameRender.
 *
 * Author A.J.F
 */
public final class GameRender
{
	/** The game render manager. */
	private final GameRenderManager gameRenderManager;
    /** The state manager. */
    private Scene scene;

	/**
	 * Instantiates a new game render.
	 *
	 * @param width the width
	 * @param height the height
	 */
	public GameRender(final int width,final int height)
	{
		gameRenderManager = new GameRenderManager(width, height);
	}
    
	/**
	 * Creates the J panel and add properties.
	 */
	public void createJPanelAndAddProperties()
	{
		gameRenderManager.createJPanelAndAddProperties();
	}
	
	/**
	 * Draw to buffered image.
	 */
	public void drawToBufferedImage()
	{
		gameRenderManager.drawToBufferedImage();
		if(scene != null)
		{
			this.scene.draw(gameRenderManager.graphics2d);
		}
	}
	
	/**
	 * Draw to screen.
	 */
	public void drawToScreen()
	{
		gameRenderManager.drawToScreen();
	}
	
	/**
	 * Sets the scene manager.
	 * @param scene to set
	 */
	public void setScene(final Scene scene)
	{
		this.scene = scene;
	}
	
	/**
	 * Gets the canvas.
	 *
	 * @return the canvas
	 */
	public JPanel getCanvas()
	{
		return gameRenderManager.canvas;
	}

	/**
	 * this method update the state.
	 */
	public void update()
	{
		if(scene != null)
		{
			scene.update();
		}
	}
}