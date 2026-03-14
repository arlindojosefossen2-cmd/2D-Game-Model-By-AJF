package br.com.ajf.game.tmx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import br.com.ajf.game.collision.Collider;
import br.com.ajf.game.image.ImageSFX;
import br.com.ajf.game.math.Vector2I;
import br.com.ajf.game.model.Game;
import br.com.ajf.game.tile.ITile;
import br.com.ajf.game.tile.ITileManager;
import br.com.ajf.game.tile.TileManager;
import br.com.ajf.game.util.ResourceLoader;
import br.com.ajf.game.util.XMLUtility;

/**
 * The Class TMXLoader.
 */
public final class TMXLoader
{
	/** The xml utility. */
	private final XMLUtility xmlUtility = new XMLUtility();
	
	/** The document element. */
	private Element documentElement;
	
	/** The size. */
	private int size = 1;
	
	/** The scale. */
	private float scale = 1;
	
	/** The layers. */
	private int layers;
	
	/**
	 * Instantiates a new TMX loader.
	 *
	 * @param resPath the res path
	 */
	public TMXLoader(String resPath)
	{	
		try
		{
			documentElement = xmlUtility.parseDocument(new ResourceLoader()
					.load(TMXLoader.class, resPath))
					.getDocumentElement();
		} 
		catch (ParserConfigurationException | IOException | SAXException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the map data.
	 *
	 * @return the map data
	 */
	public short[][][] getMapData()
	{
		TMXDataLoader tmxDataLoader = new TMXDataLoader();
		short[][][] data = tmxDataLoader.getMapData(xmlUtility, documentElement);
		this.scale = tmxDataLoader.scale;
		this.layers = tmxDataLoader.layers;
		
	return data;
	}
	
	/**
	 * Gets the tiles.
	 *
	 * @return the tiles
	 */
	public ITile[] getTiles()
	{
		ITile[] tiles = null;
			
		Element tileset = xmlUtility.getAllElementsByTagName(documentElement, "tileset").get(0);
			
		List<Element> tileList = xmlUtility.getAllElementsByTagName(tileset, "tile");
		
		int tilecount = Integer.parseInt(tileset.getAttribute("tilecount"));
			
		Element imageElement = xmlUtility.getAllElementsByTagName(tileset, "image").get(0);
			
		String path = imageElement.getAttribute("source");
			
		int width = Integer.parseInt(imageElement.getAttribute("width"));
		int height = Integer.parseInt(imageElement.getAttribute("height"));
			
		size = Integer.parseInt(tileset.getAttribute("tilewidth"));
			
		int imageColumns = width/size;
		int imageRows = height/size;
			
		BufferedImage[] images = Game.LOADER.loadScaledBufferedImagesFromSheet(path, 
				imageRows, 
				imageColumns, 
				scale);
		
		ImageSFX imageSFX = new ImageSFX();
		
		tiles = new ITile[tilecount];	
		
		if(tileList.isEmpty())
		{
			return loadTilesByImage(tiles, images);
		}
		
	return loadTilesByTag(tiles, tileList, images, imageSFX);
	}

	/**
	 * Load tiles by image.
	 *
	 * @param tiles the tiles
	 * @param images the images
	 * @return the i tile[]
	 */
	private ITile[] loadTilesByImage(ITile[] tiles, BufferedImage[] images)
	{
		return new TMXTilesLoader().loadTilesByImage(tiles, images);
	}

	/**
	 * Load tiles by tag.
	 *
	 * @param tiles the tiles
	 * @param tileList the tile list
	 * @param images the images
	 * @param imageSFX the image SFX
	 * @return the i tile[]
	 */
	private ITile[] loadTilesByTag(ITile[] tiles, List<Element> tileList, BufferedImage[] images, ImageSFX imageSFX)
	{
		return new TMXTilesLoader().loadTilesByTag(tiles, tileList, images, imageSFX, xmlUtility);
	}
	
	/**
	 * Gets the rects colliders by atribute name.
	 *
	 * @param atributeName the atribute name
	 * @return the rects colliders by atribute name
	 */
	public List<Collider> getRectsCollidersByAtributeName(String atributeName)
	{
		List<Collider> colliders = new ArrayList<>();
		
		List<Element> objectGroup = xmlUtility.getAllElementsByTagName(documentElement,"objectgroup");

		return getColliders(atributeName, colliders, objectGroup);
	}

	/**
	 * Gets the colliders.
	 *
	 * @param atributeName the atribute name
	 * @param colliders the colliders
	 * @param objectGroup the object group
	 * @return the colliders
	 */
	private List<Collider> getColliders(String atributeName, List<Collider> colliders, List<Element> objectGroup)
	{
		return new TMXColliderLoader().getColliders(atributeName, colliders, objectGroup, scale, xmlUtility);
	}
	
	/**
	 * Gets the vector 2 I list from property tag name.
	 *
	 * @param tagName the tag name
	 * @return the vector 2 I list from property tag name
	 */
	public List<Vector2I> getVector2IListFromPropertyTagName(String tagName)
	{
		List<Element> objectGroup = xmlUtility.getAllElementsByTagName(documentElement, "objectgroup");
		return loadDataPositions(tagName, objectGroup);
	}

	/**
	 * Load data positions.
	 *
	 * @param tagName the tag name
	 * @param objectGroup the object group
	 * @return the list
	 */
	private List<Vector2I> loadDataPositions(String tagName, List<Element> objectGroup)
	{
		List<Vector2I> positions = new ArrayList<>();
		
		for (Element object : objectGroup)
		{
			loadPositions(tagName, positions,object);
		}
		
		return positions;
	}

	/**
	 * Load positions.
	 *
	 * @param tagName the tag name
	 * @param positions the positions
	 * @param object the object
	 */
	private void loadPositions(String tagName, List<Vector2I> positions,Element object)
	{
		List<Element> objectsList = xmlUtility.getAllElementsByTagName(object, "object");	
		
		for (Element object1 : objectsList)
		{
			Element properties = xmlUtility
						.getAllElementsByTagName(object1,"properties").get(0);
					
			Element property = xmlUtility
						.getAllElementsByTagName(properties,"property").get(0);
					
			if(property.getAttribute("value").equalsIgnoreCase(tagName))
			{
				int x = (int) Float.parseFloat(object1.getAttribute("x"));
				int y = (int) Float.parseFloat(object1.getAttribute("y"));
				positions.add(new Vector2I((int)(x*scale),(int)(y*scale)));
			}
		}
	}
	
	/**
	 * Gets the tile manager.
	 *
	 * @return the tile manager
	 */
	public ITileManager getTileManager()
	{	
		short[][][] mapData = getMapData();
		ITile[] tiles = getTiles();
		return new TileManager(tiles, mapData,(int)(size*scale));
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * Gets the scale.
	 *
	 * @return the scale
	 */
	public float getScale()
	{
		return scale;
	}

	/**
	 * Gets the layers.
	 *
	 * @return the layers
	 */
	public int[] getLayers()
	{
		int layers[] = new int[this.layers];
		
		for (int i = 0; i < layers.length; i++)
		{
			layers[i] = i;
		}
		
		return layers;
	}
}