package br.com.ajf.game.util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.ajf.game.image.ImageSize;
import br.com.ajf.game.model.Game;
import br.com.ajf.game.tile.ITile;
import br.com.ajf.game.tile.Tile;
import br.com.ajf.game.tile.TileAnimated;

/**
 * The Class GameUtils.
 */
public final class GameUtils
{	
	/**
	 * Instantiates a new game utils.
	 */
	public GameUtils()
	{
		super();
	}
	
	/**
	 * Sets the up all tiles.
	 *
	 * @param path the path
	 * @param tilesize the tilesize
	 * @param scale the scale
	 * @return the i tile[] info: Idependent of the number of <br>rows or columns of the image SpritSheet
	 */
	public ITile[] setUpAllTiles(final String path,final int tilesize, float scale)
	{
        try
        {
         	final InputStream inpustrean = GameUtils.class.getResourceAsStream(path);
         	final BufferedReader bufferedRead = new BufferedReader(new InputStreamReader(inpustrean));
        	
        	final String[] util = bufferedRead.readLine().split(" ");
        	
        	final ImageSize size = Game.LOADER.getScaledImageSize(util[0], scale);
        	
        	final int rows = (int) (size.getHeight()/(tilesize*scale));
			final int cols = (int)(size.getWidth()/(tilesize*scale));
			
			final BufferedImage[] auxImg = Game.LOADER.loadScaledBufferedImagesFromSheet(util[0], rows, cols,scale);
        	
        	final ITile[] tiles = new ITile[Integer.parseInt(util[1])];
        	
        	int auxCol = 0;	
        	for (int r = 0; r < tiles.length; r++)
			{
				final String[] aux = bufferedRead.readLine().split(" ");
				
				if(aux.length == 4)
				{
					tiles[r] = new TileAnimated(r, Boolean.parseBoolean(aux[1]), aux[0], tilesize,Integer.parseInt(aux[2]),scale,Integer.parseInt(aux[3]));
				}
				else
				{
					tiles[r] = new Tile(r, Boolean.parseBoolean(aux[0]), auxImg[auxCol++]);
				}
			}
        	
        	inpustrean.close();
        	bufferedRead.close();
        	
        	return tiles;
        }
        
        catch(Exception err)
       	{
        		err.printStackTrace();
       	}
       return null;
	}
}