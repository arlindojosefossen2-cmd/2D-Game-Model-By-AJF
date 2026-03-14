package br.com.ajf.game.tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import br.com.ajf.game.image.ImageLoader;
import br.com.ajf.game.image.ImageSFX;
import br.com.ajf.game.model.Game;
import br.com.ajf.game.util.GameUtils;
import br.com.ajf.game.util.ResourceLoader;
import br.com.ajf.game.util.XMLUtility;

/**
 * The Class TileManager.
 */
public final class TileManager implements ITileManager
{
	/** The tiles. */
	private ITile tiles[] ;
	
	/** The data. */
	private short data[][][];
	
	/** The tilesize. */
	public int tilesize;

	/**
	 * Instantiates a new tile manager.
	 */
	public TileManager()
	{
		super();
	}
	
	/**
	 * Instantiates a new tile manager.
	 *
	 * @param tiles the tiles
	 * @param data the data
	 * @param tilesize the tilesize
	 */
	public TileManager(ITile[] tiles, short[][][] data, int tilesize)
	{
		super();
		this.tiles = tiles;
		this.data = data;
		this.tilesize = tilesize;
	}

	/**
	 * Load data.
	 *
	 * @param path the path
	 */
	public void loadData(final String path)
	{
		InputStream inpustrean = null;
    	BufferedReader bufferedRead = null; 	
    	
        try {

        	inpustrean = getClass().getResourceAsStream(path);
        	bufferedRead = new BufferedReader(new InputStreamReader(inpustrean));
        	
        	String au[] = bufferedRead.readLine().split(" ");
        	
        	short num = 0;
        	int idlayer = Integer.parseInt(au[0]);
        	int row = Integer.parseInt(au[1]);
        	int col = Integer.parseInt(au[2]);
        
			data = new short[idlayer][row][col];
			String aux[] = null;
			
			for(int layer = 0;layer < data.length;layer++)
			{
	        	for(int r = 0;r < data[layer].length;r++)
	        	{
	        		if(bufferedRead.ready())
	        			aux = bufferedRead.readLine().split(",");
	        	 		
		        	for(int c = 0;c < data[layer][r].length;c++)
		            {
		        		if(aux != null && !aux[c].isEmpty() && !aux[c].isBlank())
		        			num  = Short.parseShort(aux[c]);
		        			
		        		data[layer][r][c] =  num;
		            }
	        	}
			}
        	
        	inpustrean.close();
        	bufferedRead.close();
        }
        catch(Exception err)
        {
        	err.printStackTrace();
        }
	}
	
	/**
	 * Load data from XML file.
	 *
	 * @param resFilePath the res file path
	 * @param folderFilePath the folder file path
	 */
	public void loadDataFromXMLFile(String resFilePath,String folderFilePath)
	{
		XMLUtility xmlUtility = new XMLUtility();
		
		try
		{
			Document doc = xmlUtility.parseDocument(
					new ResourceLoader().load(TileManager.class,
							resFilePath,folderFilePath));
			
			Element documentElement = doc.getDocumentElement();
			
			Element map = xmlUtility.getElementsByTagName(documentElement, "map").get(0);
			
			int layers = Integer.parseInt(map.getAttribute("layers"));
			int rows = Integer.parseInt(map.getAttribute("rows"));
			int columns = Integer.parseInt(map.getAttribute("columns"));
				
			data = new short[layers][rows][columns];
				
			List<Element> layersList = xmlUtility.getElementsByTagName(map, "layer"); 
				
			for (Element layer : layersList)
			{
				int layerId = Integer.parseInt(layer.getAttribute("id"));
					
				String[] aux = layer.getTextContent().split(",");
					
				int index = 0;
				for (int row = 0; row < rows; row++)
				{
					for (int column = 0; column < columns; column++)
					{
						String num = aux[index++].replace("\n", "");			
						data[layerId][row][column] = (short) Integer.parseInt(num);
					}
				}
			}
		}
		catch (ParserConfigurationException | IOException | SAXException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Load tiles by XML.
	 *
	 * @param fileResourcePath the file resource path
	 * @param fileFolderName the file folder name
	 */
	@Override
	public void loadTilesByXML(String fileResourcePath, String fileFolderName)
	{
		try
		{
			XMLUtility xmlUtility = new XMLUtility();
			
			Document doc = xmlUtility.parseDocument(
					new ResourceLoader().load(TileManager.class,
							fileResourcePath, fileFolderName));
			
			ImageLoader loader = new ImageLoader();
			ImageSFX imageSFX = new ImageSFX();
			
			Element element = doc.getDocumentElement();
				
			
			String path = element.getAttribute("path");
			
			int rows = Integer.parseInt(element.getAttribute("rows"));
			int columns = Integer.parseInt(element.getAttribute("columns"));
			int size = Integer.parseInt(element.getAttribute("size"));
			int tilesize = Integer.parseInt(element.getAttribute("tilesize"));
			int scale = Integer.parseInt(element.getAttribute("scale"));
			
			BufferedImage[] images = loader.loadScaledBufferedImagesFromSheet(path, rows, columns, scale);
				
			tiles = new ITile[size];
			
			List<Element> tileList = xmlUtility.getAllElementsByTagName(element, "tile");
			
			for (Element element2 : tileList)
			{
				int id = Integer.parseInt(element2.getAttribute("id"));
				boolean solid = Boolean.parseBoolean(element2.getAttribute("solid"));
				boolean animated = Boolean.parseBoolean(element2.getAttribute("animated"));
				
				if(animated)
				{
					Element aux = xmlUtility.getElementsByTagName(element2,"anime").get(0);
					
					int interval = Integer.parseInt(aux.getAttribute("interval"));
					int frames = Integer.parseInt(aux.getAttribute("frames"));
				
					tiles[id] = new TileAnimated(id, solid, 
							imageSFX.cropBufferedImage(images, id,frames),
							interval);
				}
				else if(!animated)
				{
					tiles[id] = new Tile(id, solid, imageSFX.cropBufferedImage(images,id,1)[0]);
				}
			}
		
			this.tilesize = tilesize*scale;
			
		} 
		catch (ParserConfigurationException | IOException | SAXException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Load tiles.
	 *
	 * @param path the path
	 * @param tilesize the tilesize
	 * @param scale the scale
	 */
	@Override
	public void loadTiles(final String path,final int tilesize, float scale)
	{
		GameUtils ultis = new GameUtils();
		this.tilesize = (int)(tilesize*scale);
		tiles = ultis.setUpAllTiles(path, tilesize,scale);
	}
	
	/**
	 * Load tiles.
	 *
	 * @param path the path
	 * @param tilesize the tilesize
	 * @param scale the scale
	 */
	@Override
	public void loadTiles(final String path,final int tilesize, int scale)
	{
		GameUtils ultis = new GameUtils();
		this.tilesize = (int)(tilesize*scale);
		tiles = ultis.setUpAllTiles(path,tilesize, scale);
	}
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param playerX the player X
	 * @param playerY the player Y
	 * @param playerscreenx the playerscreenx
	 * @param playerscreeny the playerscreeny
	 * @param idlayer the idlayer
	 */
	@Override
	public void draw(Graphics2D graphics2d,Game game,int playerX,int playerY,int playerscreenx,int playerscreeny,int idlayer)
	{
		if(idlayer < data.length)
		{	
			for(int r = 0;r < data[idlayer].length;r++)
	    	{
	    		for(int c = 0;c < data[idlayer][0].length;c++)
	        	{
	    			int num = data[idlayer][r][c]-1;
	    			
	    			if(num == -1)
	    				continue;
	    			
	    			final int worldX = (int) (c * tilesize );
	            	final int worldY = (int) (r * tilesize );
	                
	            	final int screenX = (int) (worldX - playerX + playerscreenx);
	            	final int screenY = (int) (worldY -  playerY + playerscreeny );
	
	    			if(isPlayerONScreem(worldX, worldY, this.tilesize,playerX,playerY,playerscreenx,playerscreeny))
	    				graphics2d.drawImage(tiles[num].getImage(game.delta()), screenX,screenY, null);
	    			
	        	}
	    	}
		}
	}
	
	/**
	 * Draw.
	 *
	 * @param graphics2d the graphics 2 d
	 * @param playerX the player X
	 * @param playerY the player Y
	 * @param playerscreenx the playerscreenx
	 * @param playerscreeny the playerscreeny
	 */
	@Override
	public void draw(Graphics2D graphics2d,int playerX,int playerY,int playerscreenx,int playerscreeny)
	{
		for(int idlayer = 0; idlayer < data.length;idlayer++)
		{	
			for(int r = 0;r < data[idlayer].length;r++)
	    	{
	    		for(int c = 0;c < data[idlayer][0].length;c++)
	        	{
	    			int num = data[idlayer][r][c]-1;
	    			
	    			if(num == -1)
	    				continue;
	    			
	    			final int worldX = (int) (c * tilesize );
	            	final int worldY = (int) (r * tilesize );
	                
	            	final int screenX = (int) (worldX - playerX + playerscreenx);
	            	final int screenY = (int) (worldY -  playerY + playerscreeny );
	
	    			if(isPlayerONScreem(worldX, worldY, this.tilesize,playerX,playerY,playerscreenx,playerscreeny))
	    				graphics2d.drawImage(tiles[num].getImage(0.5f), screenX,screenY, null);
	        	}
	    	}
		}
	}
	
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
	@Override
	public void draw(Graphics2D graphics2d, int playerX, int playerY, int playerscreenx, int playerscreeny,int[] idlayers)
	{
		for(int idlayer = 0; idlayer < data.length;idlayer++)
		{	
			if(idlayer < idlayers.length && idlayer == idlayers[idlayer])
			{
				for(int r = 0;r < data[idlayer].length;r++)
		    	{
		    		for(int c = 0;c < data[idlayer][0].length;c++)
		        	{
		    			int num = data[idlayer][r][c]-1;
		    			
		    			if(num == -1)
		    				continue;
		    			
		    			final int worldX = (int) (c * tilesize );
		            	final int worldY = (int) (r * tilesize );
		                
		            	final int screenX = (int) (worldX - playerX + playerscreenx);
		            	final int screenY = (int) (worldY -  playerY + playerscreeny );
		
		    			if(isPlayerONScreem(worldX, worldY, this.tilesize,playerX,playerY,playerscreenx,playerscreeny))
		    				graphics2d.drawImage(tiles[num].getImage(0.5f), screenX,screenY, null);
		        	}
		    	}
			}
		}
	}

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
	@Override
	public boolean isPlayerONScreem(int worldX,int worldY,int tilesize,int playerX,int playerY,int width,int height)
	{
		return (worldX + 5*tilesize > playerX - width &&
                worldX - 5*tilesize < playerX + width &&
                worldY + 5*tilesize > playerY - height &&
                worldY - 5*tilesize < playerY + height);
	}
	
	/**
	 * Gets the tiles.
	 *
	 * @return the tiles
	 */
	@Override
	public ITile[] getTiles()
	{
		return tiles;
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	@Override
	public short[][][] getData()
	{
		return data;
	}
}