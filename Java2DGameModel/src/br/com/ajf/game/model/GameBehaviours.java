package br.com.ajf.game.model;

import br.com.ajf.game.image.ImageLoader;
import br.com.ajf.game.scene.Scene;

/** 
 * Author A.J.F.
 * @version 1.0
 * 30 June 2025
 */
public sealed interface GameBehaviours permits Game
{
	/** The Constant loader. */
	public static final ImageLoader LOADER = new ImageLoader();
	
	 /**
 	 * Instantiates the attributes and thread.
 	 *
 	 * @param fps the fps
 	 */
 	public void init(int fps);
 	
 	/**
	  * Update.
	  */
	 public void update();
	 
	/**
	 * Adds the state.
	 *
	 * @param scene the scene
	 */
	public void addScene(Scene scene);
	 
	 /**
 	 * Sets the icon.
 	 *
 	 * @param path the new icon
 	 */
 	public void setIcon(String path);
 	
 	/**
	  * Delta.
	  *
	  * @return the float
	  */
	public float delta();
	
	/**
	 * Gets the fps.
	 *
	 * @return the fps
	 */
	public int getFps();
}