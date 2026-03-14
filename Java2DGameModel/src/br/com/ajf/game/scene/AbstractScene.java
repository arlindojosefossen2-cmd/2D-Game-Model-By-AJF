package br.com.ajf.game.scene;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import br.com.ajf.game.character.AbstractCharacter;
import br.com.ajf.game.character.CharacterCollisions;
import br.com.ajf.game.collision.Collider;
import br.com.ajf.game.input.GameInput;
import br.com.ajf.game.model.Game;
import br.com.ajf.game.tile.ITileManager;

/**
 * The Class AbstractScene.
 */
public abstract class AbstractScene implements Scene
{
	/** The Constant TRASITION. */
	protected static final String TRASITION = "Transition";
	
	/** The Constant COLLISION. */
	protected static final String COLLISION = "Collision";
	
	/** The rects. */
	protected List<Collider> rects ;
	
	/** The transitions. */
	protected List<Collider> transitions ;
	
	/** The characters. */
	protected List<AbstractCharacter> characters = new ArrayList<>();
	
	/** The characters array. */
	protected AbstractCharacter[] charactersArray = new AbstractCharacter[10];
	
	/** The game. */
	protected Game game;
	
	/** The player. */
	protected AbstractCharacter player;
	
	/** The tile manager. */
	protected ITileManager tileManager;
	
	/** The layers. */
	protected int[] layers;

	/** The debug. */
	private boolean debug;
	
	/**
	 * Instantiates a new abstract scene.
	 *
	 * @param game the game
	 * @param player the player
	 */
	public AbstractScene(Game game,AbstractCharacter player)
	{
		this.game = game;
		this.player = player;
	}
	
	/**
	 * Transitions.
	 *
	 * @param abstractCharacter the abstract character
	 * @param collider the collider
	 */
	protected abstract void transitions(AbstractCharacter abstractCharacter, Collider collider);
	
	/**
	 * Update.
	 */
	@Override
	public void update()
	{
		//Debug Colliders
		if(GameInput.keyDownOnce(KeyEvent.VK_B))
		{
			debug = !debug;
		}
		
		characters.clear();
		
		for (AbstractCharacter abstractCharacter : charactersArray)
		{
			if(abstractCharacter != null)
			{
				abstractCharacter.update(this.game.delta());
				
				for(Collider collider : transitions)
				{
					if(collider != null)
					{
						transitions(abstractCharacter, collider);
						
						if(abstractCharacter.collider.intersects(collider))
						{
							if(collider.getLayer() == 2)
							{
								abstractCharacter.collider.setLayer(2);
							}	
							else if(collider.getLayer() == 1)
							{
								abstractCharacter.collider.setLayer(1);
							}
							else
							{
								abstractCharacter.collider.setLayer(0);
							}
						}
					}
				}
				
				if(CharacterCollisions.isCollisionBYCharacterTypeName(abstractCharacter, rects,COLLISION))
				{
					abstractCharacter.preventMoviment(game.delta());
				}
				
				characters.add(abstractCharacter);
			}
		}
	}

	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 */
	@Override
	public void draw(Graphics2D graphics2d)
	{
		DrawScene.draw(graphics2d,game, characters, rects, player, tileManager, layers, debug);
	}
}