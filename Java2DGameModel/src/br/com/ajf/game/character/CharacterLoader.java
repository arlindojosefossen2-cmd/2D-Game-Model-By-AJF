package br.com.ajf.game.character;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import br.com.ajf.game.animation.Animation;
import br.com.ajf.game.animation.AnimationManager;
import br.com.ajf.game.animation.IAnimation;
import br.com.ajf.game.animation.IAnimationManager;
import br.com.ajf.game.animation.PingPongAnimation;
import br.com.ajf.game.image.ImageLoader;
import br.com.ajf.game.image.ImageSFX;
import br.com.ajf.game.util.ResourceLoader;
import br.com.ajf.game.util.XMLUtility;

/**
 * The Class CharacterLoader.
 */
public final class CharacterLoader
{
	/**
	 * Instantiates a new character loader.
	 */
	public CharacterLoader()
	{
		
	}
	
	/**
	 * Loade animation from XML file.
	 *
	 * @param resPath the res path
	 * @param character the character
	 * @return the i animation manager
	 */
	public IAnimationManager loadeAnimationFromXMLFile(String resPath,AbstractCharacter character)
	{
		IAnimationManager animations = new AnimationManager();
		XMLUtility xml = new XMLUtility();
		
		try
		{
			Document doc = xml.parseDocument(
					new ResourceLoader().load(AbstractCharacter.class, resPath));
			
			Element documentElement = doc.getDocumentElement();
			
			Element velocity = xml.getAllElementsByTagName(documentElement,"velocity").get(0);
			
			character.velocity.set(Integer.parseInt(velocity.getAttribute("xVelocity")),
						Integer.parseInt(velocity.getAttribute("yVelocity")));
			
			List<Element> elements = xml.getAllElementsByTagName(documentElement,"animations");
			ImageLoader loader = new ImageLoader();
			ImageSFX imageSFX = new ImageSFX();
			
			for (Element element : elements)
			{			
				String path = element.getAttribute("path");
				float scale = Float.parseFloat(element.getAttribute("scale"));
				int rows = Integer.parseInt(element.getAttribute("rows"));
				int cols = Integer.parseInt(element.getAttribute("columns"));
				
				BufferedImage[] img = loader.loadScaledBufferedImagesFromSheet(
						path, rows, cols, scale);
				
				List<Element> aux = xml.getElementsByTagName(element, "animation");
				
				for (Element element2 : aux)
				{
					int init = Integer.parseInt(element2.getAttribute("init"));
					int frames = Integer.parseInt(element2.getAttribute("frames"));
					float interval = Float.parseFloat(element2.getAttribute("interval"));
					boolean looping = Boolean.parseBoolean(element2.getAttribute("looping"));
					String type = element2.getAttribute("type");
					
					BufferedImage[] anim = imageSFX.cropBufferedImage(img, init, frames);
					
					if(type.equalsIgnoreCase(IAnimation.NORMAL_ANIMATION))
					{
						animations.addAnimation(new Animation(anim, interval, looping));
					}
					else if(type.equalsIgnoreCase(IAnimation.PINGPONG_ANIMATION))
					{
						animations.addAnimation(new PingPongAnimation(anim, interval, looping));
					}
				}
			}
		}
		catch (ParserConfigurationException | IOException | SAXException e)
		{
			e.printStackTrace();
		}
		
		return animations;
	}
}