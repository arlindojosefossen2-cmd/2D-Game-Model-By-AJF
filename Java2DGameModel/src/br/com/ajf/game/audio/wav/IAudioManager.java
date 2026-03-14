package br.com.ajf.game.audio.wav;
/**
 * 
 * Author A.J.F.
 * @version 1.0
 * 24 June 2025
 */
public interface IAudioManager
{
	
	/**
	 * Play.
	 *
	 * @param audioIndex the audio index
	 */
	public void play(int audioIndex);
	
	/**
	 * Stop.
	 *
	 * @param audioIndex the audio index
	 */
	 public void stop(int audioIndex);
	
	/**
	 * Adds the audio.
	 *
	 * @param audio the audio
	 */
	 public void addAudio(IAudio audio);
	
	/**
	 * Sets the volume.
	 *
	 * @param audioIndex the audio index
	 * @param volume the volume
	 */
	public void setVolume(int audioIndex,float volume);
	
	/**
	 * Gets the volume.
	 *
	 * @param audioIndex the audio index
	 * @return the volume
	 */
	 public float getVolume(int audioIndex);
}