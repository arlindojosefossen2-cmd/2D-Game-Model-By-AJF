package br.com.ajf.game.character;

/**
 * The Class AbstractCharacterInput.
 */
public abstract class AbstractCharacterInput
{	
	/** The character. */
	protected AbstractCharacter character;
	
	/**
	 * Instantiates a new abstract character input.
	 *
	 * @param character the character
	 */
	public AbstractCharacterInput(AbstractCharacter character)
	{
		this.character = character;
	}

	/**
	 * Update inputs.
	 */
	protected abstract void updateInputs();
}