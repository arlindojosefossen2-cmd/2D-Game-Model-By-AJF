package br.com.ajf.game.tile;

import java.awt.Graphics2D;

import br.com.ajf.game.model.Game;

/**
 * The Interface ITileManager.
 */
public interface ITileManager
{
	/**
	 * Load data.
	 *
	 * @param path the path
	 */
	public void loadData(String path);
	
	
	/**
	 * Load data from XML file.
	 *
	 * @param resFilePath the res file path
	 * @param folderFilePath the folder file path
	 */
	public void loadDataFromXMLFile(String resFilePath,String folderFilePath);
	
	/**
	 * Load tiles by XML.
	 *
	 * @param FileResourcePath the file resource path
	 * @param fileFolderName the file folder name
	 */
	public void loadTilesByXML(String FileResourcePath,String fileFolderName);
	
	/**
	 * Load tiles.
	 *
	 * @param path the path
	 * @param tilesize the tilesize
	 * @param scale the scale
	 */
	public void loadTiles(String path,int tilesize, float scale);
	
	/**
	 * Load tiles.
	 *
	 * @param path the path
	 * @param tilesize the tilesize
	 * @param scale the scale
	 */
	public void loadTiles(final String path,final int tilesize, int scale);
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param game the game
	 * @param playerX the player X
	 * @param playerY the player Y
	 * @param playerscreenx the playerscreenx
	 * @param playerscreeny the playerscreeny
	 * @param idlayer the idlayer
	 */
	public void draw(Graphics2D graphics2d,Game game,int playerX,int playerY,int playerscreenx,int playerscreeny,int idlayer);
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param playerX the player X
	 * @param playerY the player Y
	 * @param playerscreenx the playerscreenx
	 * @param playerscreeny the playerscreeny
	 */
	public void draw(Graphics2D graphics2d,int playerX,int playerY,int playerscreenx,int playerscreeny);
	
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param playerX the player X
	 * @param playerY the player Y
	 * @param playerscreenx the playerscreenx
	 * @param playerscreeny the playerscreeny
	 * @param idlayers the idlayers
	 */
	public void draw(Graphics2D graphics2d,int playerX,int playerY,int playerscreenx,int playerscreeny,int[] idlayers);

	/**
	 * Checks if is player ON screem.
	 *
	 * @param worldX the world X
	 * @param worldY the world Y
	 * @param tilesize the tilesize
	 * @param playerX the player X
	 * @param playerY the player Y
	 * @param width the width
	 * @param height the height
	 * @return true, if is player ON screem
	 */
	public boolean isPlayerONScreem(int worldX,int worldY,int tilesize,int playerX,int playerY,int width,int height);
	
	/**
	 * Gets the tiles.
	 *
	 * @return the tiles
	 */
	public ITile[] getTiles();
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public short[][][] getData();
}
