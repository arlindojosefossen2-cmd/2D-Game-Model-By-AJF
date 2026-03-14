package br.com.ajf.game.audio.wav;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;


/**
 * 
 * Author A.J.F.
 * @version 1.0
 * 18 June 2025
 */
public final class Music implements IAudio
{
	
	/** The clip. */
	private final Clip clip;
	
	/** The volume. */
	private final FloatControl volume;
	
	/**
	 * Instantiates a new music.
	 *
	 * @param musicPath the music path
	 */
	public Music(final String musicPath)
	{
		final AudioLoader loader = new AudioLoader();
		this.clip = loader.getClipOpened(musicPath);
		this.volume = (FloatControl) this.clip.getControl(FloatControl.Type.MASTER_GAIN);
	}
	

	/**
	 * Play.
	 */
	@Override
	public void play()
	{
		this.clip.start();
		this.clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	/**
	 * Stop.
	 */
	@Override
	public void stop()
	{
		this.clip.setMicrosecondPosition(0);
		this.clip.stop();
	}

	/**
	 * Sets the volume.
	 *
	 * @param volume the new volume
	 */
	@Override
	public void setVolume(final float volume)
	{
		this.volume.setValue(volume);
	}

	/**
	 * Gets the volume.
	 *
	 * @return the volume
	 */
	@Override
	public float getVolume()
	{
		return this.volume.getValue();
	}
}