package br.com.ajf.game.tmx;

import java.util.List;

import org.w3c.dom.Element;

import br.com.ajf.game.collision.Collider;
import br.com.ajf.game.util.XMLUtility;

/**
 * The Class TMXColliderLoader.
 */
public final class TMXColliderLoader
{
	
	/**
	 * Instantiates a new TMX collider loader.
	 */
	public TMXColliderLoader()
	{
		super();
	}

	/**
	 * Gets the colliders.
	 *
	 * @param atributeName the atribute name
	 * @param colliders the colliders
	 * @param objectGroup the object group
	 * @param scale the scale
	 * @param xmlUtility the xml utility
	 * @return the colliders
	 */
	protected List<Collider> getColliders(String atributeName, List<Collider> colliders, List<Element> objectGroup, float scale, XMLUtility xmlUtility)
	{
		for (Element object : objectGroup)
		{
			List<Element> objectsList = xmlUtility.getAllElementsByTagName(object,"object");
			
			for (Element object1 : objectsList)
			{
				if(object1.getAttribute("name").equalsIgnoreCase(atributeName))
				{
					Element properties = xmlUtility.getAllElementsByTagName(object1,"properties").get(0);
						
					Element property = xmlUtility.getAllElementsByTagName(properties,"property").get(0);
						
					int id = Integer.parseInt(object1.getAttribute("id"));
					int x = (int) Float.parseFloat(object1.getAttribute("x"));
					int y = (int) Float.parseFloat(object1.getAttribute("y"));
					int widthSize = (int) Float.parseFloat(object1.getAttribute("width"));
					int heightSize = (int) Float.parseFloat(object1.getAttribute("height"));
					String type = object1.getAttribute("type");	
						
					int layer = Integer.parseInt(property.getAttribute("value"));
			
					colliders.add(new Collider(id,layer,(int)(x*scale),(int)(y*scale),(int)(widthSize*scale),(int)(heightSize*scale),type));
				}
			}
		}
		return colliders;
	}
}