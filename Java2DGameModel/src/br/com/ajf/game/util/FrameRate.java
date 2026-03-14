package br.com.ajf.game.util;

/**
 * The Class FrameRate.
 */
public final class FrameRate
{
	/** The framerate. */
	private String framerate;
	
	/** The lastime. */
	private long lastime;
	
	/** The delta. */
	private long delta;
	
	/** The frame counter. */
	private int frameCounter;
	
	/**
	 * Instantiates a new frame rate.
	 */
	public FrameRate()
	{
		
	}

	/**
	 * Initialize.
	 */
	public void initialize()
	{
		lastime = System.currentTimeMillis();
		framerate = "";
	}

	/**
	 * Calculate.
	 */
	public void calculate()
	{
		long current = System.currentTimeMillis();
		delta += current - lastime;
		lastime = current;
		
		frameCounter++;
		
		if(delta > 1000)
		{
			delta -= 1000;
			framerate = String.format(String.valueOf(frameCounter));
			frameCounter = 0;
		}
	}

	/**
	 * Gets the frame rate.
	 *
	 * @return the frame rate
	 */
	public String getFrameRate()
	{
		return framerate;
	}
}