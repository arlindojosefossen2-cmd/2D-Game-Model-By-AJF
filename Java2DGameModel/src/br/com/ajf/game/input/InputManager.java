package br.com.ajf.game.input;


/**
 * The Class InputManager.
 *
 * Author A.J.F
 */
public final class InputManager
{
	/** The mouse. */
	private final GameMouseListener mouse ;

	/** The input. */
	private final GameInput input ;

	/**
	 * Instantiates a new input manager.
	 */
	public InputManager()
	{
		this.input = new GameInput();
		
		this.mouse = new GameMouseListener();
	}

	/**
	 * Gets the mouse.
	 *
	 * @return the mouse
	 */
	public GameMouseListener getMouse()
	{
		return mouse;
	}

	/**
	 * Gets the input.
	 *
	 * @return the input
	 */
	public GameInput getInput()
	{
		return input;
	}
}