package br.com.ajf.game.audio.wav;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Author A.J.F.
 * @version 1.0
 * 24 June 2025
 */
public final class AudioManager implements IAudioManager
{
	
	/** The audios. */
	private final List<IAudio> audios = new ArrayList<IAudio>();
	
	/**
	 * Instantiates a new audio manager.
	 */
	public AudioManager()
	{
		super();
	}

	/**
	 * Play.
	 *
	 * @param audioIndex the audio index
	 */
	@Override
	public void play(final int audioIndex)
	{
		audios.get(audioIndex).play();
	}

	/**
	 * Stop.
	 *
	 * @param audioIndex the audio index
	 */
	@Override
	public void stop(final int audioIndex)
	{
		audios.get(audioIndex).stop();
	}

	/**
	 * Adds the audio.
	 *
	 * @param audio the audio
	 */
	@Override
	public void addAudio(final IAudio audio)
	{
		audios.add(audio);
	}

	/**
	 * Sets the volume.
	 *
	 * @param audioIndex the audio index
	 * @param volume the volume
	 */
	@Override
	public void setVolume(final int audioIndex,final float volume)
	{
		audios.get(audioIndex).setVolume(volume);
	}

	/**
	 * Gets the volume.
	 *
	 * @param audioIndex the audio index
	 * @return the volume
	 */
	@Override
	public float getVolume(final int audioIndex)
	{
		return audios.get(audioIndex).getVolume();
	}
}