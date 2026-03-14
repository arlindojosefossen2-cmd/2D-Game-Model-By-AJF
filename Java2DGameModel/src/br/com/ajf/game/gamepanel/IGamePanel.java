package br.com.ajf.game.gamepanel;

import javax.swing.JPanel;

import br.com.ajf.game.scene.Scene;

/**
 * The Interface IGamePanelManager.
 *
 * Author A.J.F
 */
public interface IGamePanel
{
	/**
	 * Gets the canvas.
	 *
	 * @return the canvas
	 */
	 public JPanel getCanvas();

	/**
	 * this method update the state.
	 */
	public void update();

	/**
	 * this method start the state.
	 */
	public void start();


	/**
	 * Sets the scene.
	 *
	 * @param scene the new scene
	 */
	public void setScene(Scene scene);
}