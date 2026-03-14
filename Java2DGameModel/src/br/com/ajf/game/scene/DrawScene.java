package br.com.ajf.game.scene;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import br.com.ajf.game.character.AbstractCharacter;
import br.com.ajf.game.character.Player;
import br.com.ajf.game.collision.Collider;
import br.com.ajf.game.model.Game;
import br.com.ajf.game.tile.ITileManager;

/**
 * The Class DrawScene.
 */
public final class DrawScene
{	
	
	/**
	 * Instantiates a new draw scene.
	 */
	private DrawScene()
	{
		
	}
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param game the game
	 * @param characters the characters
	 * @param colliders the colliders
	 * @param player the player
	 * @param tileManager the tile manager
	 * @param layers the layers
	 * @param debug the debug
	 */
	public static void draw(Graphics2D graphics2d,Game game,List<AbstractCharacter> characters,List<Collider> colliders,
			AbstractCharacter player,ITileManager tileManager,int[] layers, boolean debug)
	{
		for (int layer : layers)
		{
			tileManager.draw(graphics2d,game, player.position.getX(),
					player.position.getY(), 
					Player.SCREEN_X,
					Player.SCREEN_Y,layer);
			
			for (AbstractCharacter abstractCharacter : characters)
			{
				if(abstractCharacter != null && abstractCharacter.collider.getLayer() == layer)
				{
					abstractCharacter.draw(graphics2d,-player.position.getX()+Player.SCREEN_X,
							-player.position.getY()+Player.SCREEN_Y);
				}
			}
		}
		
		//Debug Colliders
		if(debug)
		{
			for (Collider rect : colliders)
			{
				if(rect.getLayer() == player.collider.getLayer())
				{
					graphics2d.setColor(Color.RED);
					graphics2d.drawRect(rect.getX()-player.position.getX()+Player.SCREEN_X,
							rect.getY()-player.position.getY()+Player.SCREEN_Y,
							rect.getWidth(), rect.getHeight());
				}
			}
		}
	}
}