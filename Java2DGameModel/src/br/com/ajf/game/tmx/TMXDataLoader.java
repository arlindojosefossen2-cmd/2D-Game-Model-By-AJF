package br.com.ajf.game.tmx;

import java.util.List;

import org.w3c.dom.Element;

import br.com.ajf.game.util.XMLUtility;

/**
 * The Class TMXDataLoader.
 */
public final class TMXDataLoader
{
	
	/**
	 * Instantiates a new TMX data loader.
	 */
	public TMXDataLoader()
	{
		super();
	}

	/** The scale. */
	protected float scale;
	
	/** The layers. */
	protected int layers;

	/**
	 * Gets the map data.
	 *
	 * @param xmlUtility the xml utility
	 * @param documentElement the document element
	 * @return the map data
	 */
	public short[][][] getMapData(XMLUtility xmlUtility, Element documentElement)
	{
		short[][][] data = null;	
		
		List<Element> layers = xmlUtility.getAllElementsByTagName(documentElement,"layer");
			
		Element props = xmlUtility.getElementsByTagName(documentElement,"properties").get(0);
		
		Element prop = xmlUtility.getAllElementsByTagName(props,"property").get(0);
		
		this.scale = Float.parseFloat(prop.getAttribute("value"));
		
		this.layers = layers.size();
		int columns = Integer.parseInt(documentElement.getAttribute("width"));
		int rows = Integer.parseInt(documentElement.getAttribute("height"));
			
		data = new short[this.layers][rows][columns];
			
		for (Element  layer : layers)
		{
			int layerId = Integer.parseInt(layer.getAttribute("id"));
			Element layerData = xmlUtility.getElementsByTagName(layer,"data").get(0);
				
			String[] dataArray = layerData.getTextContent().replace("\n","").split(",");
				
			int index = 0;
			for (int r = 0; r < rows; r++)
			{
				for (int c = 0; c < columns; c++)
				{
					String num = dataArray[index++];
					data[layerId-1][r][c] = Short.parseShort(num);
				}
			}
		}
		
	return data;
	}
}