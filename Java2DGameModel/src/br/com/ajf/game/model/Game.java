package br.com.ajf.game.model;

import br.com.ajf.game.gamepanel.GamePanel;
import br.com.ajf.game.scene.Scene;
import br.com.ajf.game.util.FrameRate;
import br.com.ajf.game.window.GameWindow;
import br.com.ajf.game.window.IGameWindow;

/**
 * Author A.J.F.
 * @version 1.0
 * 30 June 2025
 */
public final class Game implements GameBehaviours
{	
	/** The game panel. */
	private final GamePanel gamepanel;
	
	/** The game window. */
	private final IGameWindow gamewindow;
	
	/** The fps. */
	private int fps ;
	
	/** The frame rate. */
	private final FrameRate frameRate = new FrameRate();
	
	/** The title. */
	private String title;
	
	/**
	 * Instantiates a new game.
	 *
	 * @param title the title
	 * @param width the width
	 * @param height the height
	 * @param threadType the thread type
	 */
	public Game(final String title,final int width,final int height,final int threadType)
	{
		gamepanel = new GamePanel(this,width,height, threadType);
		gamewindow = new GameWindow(title);
		this.title = this.gamewindow.getTitle();
	}
	
	/**
	 * Instantiates the attributes and the thread.
	 *
	 * @param fps the fps
	 */
	@Override
	public void init(final int fps)
	{
		this.fps = fps;
		this.frameRate.initialize();
		gamewindow.init(gamepanel);
	}
	
	/**
	 * Adds the state.
	 *
	 * @param scene the scene
	 */
	@Override
	public void addScene(final Scene scene)
	{
		gamepanel.setScene(scene);
	}

	/**
	 * Sets the icon.
	 *
	 * @param path the new icon
	 */
	@Override
	public void setIcon(final String path)
	{
		this.gamewindow.setIcon(path);
	}

	/**
	 * Delta.
	 *
	 * @return the float
	 */
	@Override
	public float delta()
	{
		return gamepanel.getDelta();
	}
	
	/**
	 * Sets the game title.
	 *
	 * @param FPStitle the new game title
	 */
	private void setGameTitle(String FPStitle)
	{
		this.gamewindow.setTitle(FPStitle);
	}

	/**
	 * Update.
	 */
	@Override
	public void update()
	{
		this.frameRate.calculate();
		
		this.gamepanel.update();
		this.gamepanel.draw();
		
		setGameTitle(String.format("%s FPS: %s",this.title,this.frameRate.getFrameRate()));
	}
	
	/**
	 * Gets the fps.
	 *
	 * @return the fps
	 */
	@Override
	public int getFps()
	{
		return this.fps;
	}
}