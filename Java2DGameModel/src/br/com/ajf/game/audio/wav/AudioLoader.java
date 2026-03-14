package br.com.ajf.game.audio.wav;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * The Class SoundLoader.
 *
 * Author A.J.F
 * @version 1.0
 */
public final class AudioLoader
{	
	/**
	 * Instantiates a new audio loader.
	 */
	public AudioLoader()
	{
		super();
	}

	/**
	 * Gets the url.
	 *
	 * @param path  path is the way to the file
	 * @return a URl object or null
	 */
	public URL getUrl(final String path)
	{
		return AudioLoader.class.getResource(path);
	}
	
	/**
	 * Gets the clip.
	 *
	 * @param path is the way to the file
	 * @return a Clip object or null
	 */
	public Clip getClipOpened(final String path)
	{
		Clip clip = null;
		try
		{
			final AudioInputStream audioin = AudioSystem.getAudioInputStream(getUrl(path));
			clip = AudioSystem.getClip();
			clip.open(audioin);
		} 
		catch (LineUnavailableException | IOException | UnsupportedAudioFileException err)
		{
			err.printStackTrace();
		} 
		return clip;
	}	
}