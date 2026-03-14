package br.com.ajf.game.gamepanel;

import javax.swing.JPanel;

import br.com.ajf.game.input.GameInput;
import br.com.ajf.game.input.GameMouseListener;
import br.com.ajf.game.model.Game;
import br.com.ajf.game.render.GameRender;
import br.com.ajf.game.scene.Scene;
import br.com.ajf.game.thread.GameThreadManager;
import br.com.ajf.game.thread.IGameThreadManager;

/**
 * 
 * Author A.J.F.
 * @version 1.0
 * 27 June 2025
 */
public final class GamePanel implements IGamePanel
{
    /** The game render. */
    private final GameRender gamerender;
	
	/** The game thread manager. */
	private final IGameThreadManager gameThreadManager;

	/** The delta. */
	private float delta;
	
	/** The current. */
	long current = System.nanoTime();
    
    /** The latime. */
    long latime = current;
    
    /** The ns per frame. */
    double nsPerFrame = 0;

	/**
	 * Instantiates a new game panel.
	 *
	 * @param game the game
	 * @param width the size of the screen
	 * @param height the size of the screen
	 * @param threadtype type of the thread
	 */
	public GamePanel(final Game game,final int width,final int height,final int threadtype)
	{
		gamerender = new GameRender(width, height);
		this.gameThreadManager = new GameThreadManager(game,threadtype);
		gamerender.createJPanelAndAddProperties();
	}	
	
	/**
	 * this method update the state.
	 */
	public void update()
	{
	    current = System.nanoTime();
	    nsPerFrame = current - latime;
	    
	    delta = (float)(nsPerFrame/1.0E9);
	    
		GameInput.update();
		GameMouseListener.update();
		
		this.gamerender.update();
	}
	
	/**
	 * Draw.
	 */
	public void draw()
	{
		this.gamerender.drawToBufferedImage();
		this.gamerender.drawToScreen();
		latime = current;
	}

	/**
	 * this method reset the inputs if the window focus lost.
	 */
	public void reset()
	{
		GameMouseListener.reset();
		GameInput.reset();
	}
	
	/**
	 * this method start all the states in the list and the thread.
	 */
	public void start()
	{	
		this.gameThreadManager.start();
	}

	/**
	 * Sets the scene.
	 *
	 * @param scene the new scene
	 */
	public void setScene(final Scene scene)
	{
		gamerender.setScene(scene);
	}


	/**
	 * Gets the canvas.
	 *
	 * @return the canvas
	 */
	@Override
	public JPanel getCanvas()
	{
		
		return gamerender.getCanvas();
	}

	/**
	 * Gets the delta.
	 *
	 * @return the delta
	 */
	public float getDelta()
	{
		return delta;
	}
}