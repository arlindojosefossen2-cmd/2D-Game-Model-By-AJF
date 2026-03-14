package br.com.ajf.game.audio.wav;

/**
 * 
 * Author A.J.F.
 * @version 1.0
 * 18 June 2025
 */
public interface IAudio
{
	
	/**
	 * Play.
	 */
	public void play();
	
	/**
	 * Stop.
	 */
	public void stop();
	
	/**
	 * Sets the volume.
	 *
	 * @param volume the new volume
	 */
	public void setVolume(float volume);
	
	/**
	 * Gets the volume.
	 *
	 * @return the volume
	 */
	public float getVolume();
}