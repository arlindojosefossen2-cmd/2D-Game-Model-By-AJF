package br.com.ajf.game.character;

import br.com.ajf.game.gameobject.GameObject;

/**
 * The Class AbstractCharacter.
 */
public abstract class AbstractCharacter extends GameObject
{
	/** The input. */
	public AbstractCharacterInput input;	
	
	/** The character moviment. */
	public AbstractCharacterMoviment characterMoviment ;
		
	/**
	 * Instantiates a new abstract character.
	 */
	public AbstractCharacter()
	{
		super();
	}

	/**
	 * Adds the character input.
	 *
	 * @param input the input
	 */
	public void addCharacterInput(AbstractCharacterInput input)
	{
		this.input = input;
	}
	
	/**
	 * Adds the character moviment.
	 *
	 * @param characterMoviment the character moviment
	 */
	public void addCharacterMoviment(AbstractCharacterMoviment characterMoviment)
	{
		this.characterMoviment = characterMoviment;
	}
	
	/**
	 * Update.
	 *
	 * @param delta the delta
	 */
	@Override
	public void update(float delta)
	{
		input.updateInputs();
		characterMoviment.update(delta,animations);
	}
	
	/**
	 * Prevent moviment.
	 *
	 * @param delta the delta
	 */
	public void preventMoviment(float delta)
	{
		characterMoviment.prevent(delta);
	}
}