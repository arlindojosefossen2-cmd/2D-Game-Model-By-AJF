package br.com.ajf.game.character;

import java.util.List;

import br.com.ajf.game.collision.Collider;


/**
 * The Class CharacterCollisions.
 */
public final class CharacterCollisions
{
	/**
	 * Instantiates a new character collisions.
	 */
	private CharacterCollisions()
	{
		
	}
	
	/**
	 * Checks if is collision by collider layer.
	 *
	 * @param collider the collider
	 * @param rects the rects
	 * @return true, if is collision by collider layer
	 */
	public static boolean isCollisionByColliderLayer(Collider collider,List<Collider> rects)
	{	
		for (Collider objectCollider : rects)
		{
			if(collider.getLayer() == objectCollider.getLayer())
			{
				if(collider.intersects(objectCollider))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks if is collision BY collider type name.
	 *
	 * @param collider the collider
	 * @param rects the rects
	 * @param typeName the type name
	 * @return true, if is collision BY collider type name
	 */
	public static boolean isCollisionBYColliderTypeName(Collider collider,List<Collider> rects,String typeName)
	{	
		for (Collider objectCollider : rects)
		{
			if(objectCollider.getType().equalsIgnoreCase(typeName))
			{
				if(collider.intersects(objectCollider))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks if is collision by C haracter layer.
	 *
	 * @param character the character
	 * @param rects the rects
	 * @return true, if is collision by C haracter layer
	 */
	public static boolean isCollisionByCHaracterLayer(AbstractCharacter character,List<Collider> rects)
	{	
		character.collider.setX(character.position.getX() + 
				character.solidAreaX);
		character.collider.setY(character.position.getY() + 
				character.solidAreaY);
		
		return isCollisionByColliderLayer(character.collider, rects);
	}
	
	/**
	 * Checks if is collision BY character type name.
	 *
	 * @param character the character
	 * @param rects the rects
	 * @param typeName the type name
	 * @return true, if is collision BY character type name
	 */
	public static boolean isCollisionBYCharacterTypeName(AbstractCharacter character,List<Collider> rects,String typeName)
	{	
		character.collider.setX(character.position.getX() + 
				character.solidAreaX);
		character.collider.setY(character.position.getY() + 
				character.solidAreaY);
		
		return isCollisionBYColliderTypeName(character.collider, rects, typeName);
	}
}