package br.com.ajf.game.tmx;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import br.com.ajf.game.image.ImageSFX;
import br.com.ajf.game.tile.ITile;
import br.com.ajf.game.tile.Tile;
import br.com.ajf.game.tile.TileAnimated;
import br.com.ajf.game.util.XMLUtility;

/**
 * The Class TMXTilesLoader.
 */
public final class TMXTilesLoader
{
	
	/**
	 * Instantiates a new TMX tiles loader.
	 */
	public TMXTilesLoader()
	{
		super();
	}

	/**
	 * Load tiles by image.
	 *
	 * @param tiles the tiles
	 * @param images the images
	 * @return the i tile[]
	 */
	protected ITile[] loadTilesByImage(ITile[] tiles, BufferedImage[] images)
	{
		for (int i = 0; i < tiles.length; i++)
		{
			tiles[i] = new Tile(i,false,images[i]);
		}
		return tiles;
	}

	/**
	 * Load tiles by tag.
	 *
	 * @param tiles the tiles
	 * @param tileList the tile list
	 * @param images the images
	 * @param imageSFX the image SFX
	 * @param xmlUtility the xml utility
	 * @return the i tile[]
	 */
	protected ITile[] loadTilesByTag(ITile[] tiles, List<Element> tileList, BufferedImage[] images, ImageSFX imageSFX,XMLUtility xmlUtility)
	{
		for (Element t : tileList)
		{
			int id = Integer.parseInt(t.getAttribute("id"));
			
			Element props = xmlUtility.getElementsByTagName(t,"properties").get(0);
			
			List<Element> prop = xmlUtility.getAllElementsByTagName(props, "property");
			
			boolean animated = false;
			float interval = 0;
			int frames = 1;
			
			List<String> auxList = new ArrayList<>(); 
			
			for (Element p : prop)
			{
				auxList.add(p.getAttribute("value"));
			}
			
			animated = Boolean.parseBoolean(auxList.get(0));
			
			if(animated)
			{
				frames = Integer.parseInt(auxList.get(1));
				interval = Float.parseFloat(auxList.get(2));
				
				tiles[id] = new TileAnimated(id, animated, 
						imageSFX.cropBufferedImage(images, id, frames),
						interval);
				auxList.clear();
				interval = 0;
				frames = 0;
			}
			else
			{
				tiles[id] = new Tile(1, animated, images[id]);
			}
		}
		
		return tiles;
	}

}