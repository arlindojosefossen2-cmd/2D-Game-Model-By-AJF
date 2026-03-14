package br.com.ajf.game.thread;

/**
 * The Interface IGameThreadManager.
 *
 * Author A.J.F
 */
@FunctionalInterface
public interface IGameThreadManager
{
	/** The Constant GAME_THREAD_RUNNABLE. */
	public static int GAME_THREAD_RUNNABLE = 0;

	/** The Constant GAME_THREAD_TIMER_TASK. */
	public static int GAME_THREAD_TIMER_TASK = 1;

	/** The Constant GAME_THREAD_DEFAULT. */
	public static int GAME_THREAD_DEFAULT = 0;
	
	/** The Constant FPS_60. */
	public static final int FPS_60 = 60;
	
	/** The Constant FPS_30. */
	public static final int FPS_30 = 30;
	
	/**
	 * Start.
	 */
	public void start();
}