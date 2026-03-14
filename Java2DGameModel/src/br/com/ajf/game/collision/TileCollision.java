package br.com.ajf.game.collision;

import br.com.ajf.game.gameobject.AbstractGameObject;
import br.com.ajf.game.moviment.IDirection;
import br.com.ajf.game.tile.TileManager;
/**
 * The Class TileCollision.
 */
public final class TileCollision
{
	
	
	/**
	 * Instantiates a new tile collision.
	 */
	public TileCollision()
	{
		super();
	}

	/**
	 * Check tile.
	 *
	 * @param gameobject the gameobject
	 * @param tManager the t manager
	 */
	public void checkTile(final AbstractGameObject gameobject,final TileManager tManager)
	{
		int gameobjectLeftWorldX = gameobject.getxPos() + gameobject.getSolidArea().getX();
		int gameobjectRightWorldX = gameobject.getxPos() + gameobject.getSolidArea().getX()+ gameobject.getSolidArea().getWidth();
		
		int gameobjectTopWorldY = gameobject.getyPos() + gameobject.getSolidArea().getY();
		int gameobjectBottomWorldY = gameobject.getyPos() + gameobject.getSolidArea().getY() + gameobject.getSolidArea().getHeight();
		
		int gameobjectLeftCollun = gameobjectLeftWorldX / tManager.tilesize;
		int gameobjectRightCollun = gameobjectRightWorldX / tManager.tilesize;
		int gameobjectTopRow = gameobjectTopWorldY / tManager.tilesize;
		int gameobjectBottomRow = gameobjectBottomWorldY / tManager.tilesize;
		
		int tileId1 = 0 ;
		int tileId2 = 0 ;	
		
		for(int layerid = 0; layerid < tManager.getData().length;layerid++)
		{
			switch(gameobject.getDirection())
			{
				case IDirection.UP:
					gameobjectTopRow = (gameobjectTopWorldY - gameobject.getSpeed()) / tManager.tilesize;					
					tileId1 = tManager.getData()[layerid][gameobjectTopRow][gameobjectLeftCollun]-1;
		            tileId2 = tManager.getData()[layerid][gameobjectTopRow][gameobjectRightCollun]-1;
    
					break;
				case IDirection.DOWN:
					gameobjectBottomRow = (gameobjectBottomWorldY + gameobject.getSpeed()) / tManager.tilesize;
					tileId1 = tManager.getData()[layerid][gameobjectBottomRow][gameobjectLeftCollun]-1;
		            tileId2 = tManager.getData()[layerid][gameobjectBottomRow][gameobjectRightCollun]-1;
		    		       
					break;
				case IDirection.LEFT:
					gameobjectLeftCollun = (gameobjectLeftWorldX - gameobject.getSpeed()) / tManager.tilesize;
					tileId1 = tManager.getData()[layerid][gameobjectTopRow][gameobjectLeftCollun]-1;
		            tileId2 = tManager.getData()[layerid][gameobjectBottomRow][gameobjectRightCollun]-1;
		
					break;
				case IDirection.RIGHT:
					gameobjectRightCollun = (gameobjectRightWorldX + gameobject.getSpeed()) / tManager.tilesize;
					tileId1 = tManager.getData()[layerid][gameobjectTopRow][gameobjectLeftCollun]-1;
		            tileId2 = tManager.getData()[layerid][gameobjectBottomRow][gameobjectRightCollun]-1;
				
					break;
			}
			
			if(tileId1 ==  -1)
			{
				if(tileId2 != -1)
					if(tManager.getTiles()[tileId2].isSolid())
				    {
						gameobject.setCollision(true);
				    } 
			}
			else if(tileId2 == -1)
			{
	        	if(tileId1 != -1)
	        		if(tManager.getTiles()[tileId1].isSolid())
	        		{
						gameobject.setCollision(true);
	        		}
			}
			else if(tManager.getTiles()[tileId2].isSolid() || tManager.getTiles()[tileId1].isSolid())
			{
				gameobject.setCollision(true);
			} 
		}
	}
	
	/**
	 * Check tile by layer.
	 *
	 * @param gameobject the gameobject
	 * @param tManager the t manager
	 * @param layerid the layerid
	 */
	public void checkTileByLayer(final AbstractGameObject gameobject,final TileManager tManager, int layerid)
	{
		int gameobjectLeftWorldX = gameobject.getxPos() + gameobject.getSolidArea().getX();
		int gameobjectRightWorldX = gameobject.getxPos() + gameobject.getSolidArea().getX()+ gameobject.getSolidArea().getWidth();
		
		int gameobjectTopWorldY = gameobject.getyPos() + gameobject.getSolidArea().getY();
		int gameobjectBottomWorldY = gameobject.getyPos() + gameobject.getSolidArea().getY() + gameobject.getSolidArea().getHeight();
		
		int gameobjectLeftCollun = gameobjectLeftWorldX / tManager.tilesize;
		int gameobjectRightCollun = gameobjectRightWorldX / tManager.tilesize;
		int gameobjectTopRow = gameobjectTopWorldY / tManager.tilesize;
		int gameobjectBottomRow = gameobjectBottomWorldY / tManager.tilesize;
		
		int tileId1 = 0  ;
		int tileId2 = 0  ;	
	
		switch(gameobject.getDirection())
		{
				case IDirection.UP:
					gameobjectTopRow = (gameobjectTopWorldY - gameobject.getSpeed()) / tManager.tilesize;							
					tileId1 = tManager.getData()[layerid][gameobjectTopRow][gameobjectLeftCollun]-1;
		            tileId2 = tManager.getData()[layerid][gameobjectTopRow][gameobjectRightCollun]-1;
    
					break;
				case IDirection.DOWN:
					gameobjectBottomRow = (gameobjectBottomWorldY + gameobject.getSpeed()) / tManager.tilesize;
					tileId1 = tManager.getData()[layerid][gameobjectBottomRow][gameobjectLeftCollun]-1;
		            tileId2 = tManager.getData()[layerid][gameobjectBottomRow][gameobjectRightCollun]-1;
		    		       
					break;
				case IDirection.LEFT:
					gameobjectLeftCollun = (gameobjectLeftWorldX - gameobject.getSpeed()) / tManager.tilesize;
					tileId1 = tManager.getData()[layerid][gameobjectTopRow][gameobjectLeftCollun]-1;
		            tileId2 = tManager.getData()[layerid][gameobjectBottomRow][gameobjectRightCollun]-1;
		
					break;
				case IDirection.RIGHT:
					gameobjectRightCollun = (gameobjectRightWorldX + gameobject.getSpeed()) / tManager.tilesize;
					tileId1 = tManager.getData()[layerid][gameobjectTopRow][gameobjectLeftCollun]-1;
		            tileId2 = tManager.getData()[layerid][gameobjectBottomRow][gameobjectRightCollun]-1;
				
					break;
		}
			
		if(tileId1 ==  -1)
		{
			if(tileId2 != -1)
				if(tManager.getTiles()[tileId2].isSolid())
			    {
					gameobject.setCollision(true);
			    } 
		}
		else if(tileId2 == -1)
		{
        	if(tileId1 != -1)
        		if(tManager.getTiles()[tileId1].isSolid())
        		{
					gameobject.setCollision(true);
        		}
		}
		else if(tManager.getTiles()[tileId2].isSolid() || tManager.getTiles()[tileId1].isSolid())
		{
			gameobject.setCollision(true);
		} 
	}
	
}