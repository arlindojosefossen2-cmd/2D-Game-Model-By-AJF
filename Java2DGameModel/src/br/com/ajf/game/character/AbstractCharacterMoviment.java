package br.com.ajf.game.character;

import br.com.ajf.game.animation.IAnimationManager;

/**
 * The Class AbstractCharacterMoviment.
 */
public abstract class AbstractCharacterMoviment
{
	/** The input. */
	public final AbstractCharacter character;
	
	/**
	 * Instantiates a new abstract character moviment.
	 *
	 * @param character the character
	 */
	public AbstractCharacterMoviment(AbstractCharacter character)
	{
		this.character = character;
	}

	/**
	 * Update.
	 *
	 * @param delta the delta
	 * @param animations the animations
	 */
	protected abstract void update(float delta,IAnimationManager animations);

	/**
	 * Prevent.
	 *
	 * @param delta the delta
	 */
	protected abstract void prevent(float delta);
}