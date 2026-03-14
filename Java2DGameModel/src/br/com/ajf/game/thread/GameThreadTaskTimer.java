package br.com.ajf.game.thread;

import java.util.Timer;
import java.util.TimerTask;

import br.com.ajf.game.model.Game;

/**
 * The Class GameThreadTaskTimer.
 *
 * Author A.J.F
 */
public final class GameThreadTaskTimer
{	
	/** The Constant SLEEP_14. */
	private static final long SLEEP_14 = 14;
	
	/** The Constant SLEEP_28. */
	private static final long SLEEP_28 = 28;

	/** The timer. */
	private final Timer timer;
	
	/** The timer task. */
	private final TimerTask timerTask;
	
	/** The game. */
	private final Game game;
	
	/**
	 * Instantiates a new game thread task timer.
	 *
	 * @param game the game
	 */
	public GameThreadTaskTimer(final Game game)
	{
		this.game = game;
		this.timer = new Timer();
		this.timerTask = new TimerTask()
		{
			@Override
			public void run()
			{
				game.update();
			}
		};
	}

	/**
	 * method that start the thread.
	 */
	public void start()
	{
		if(this.game.getFps() == IGameThreadManager.FPS_60)
		{
			this.timer.schedule(this.timerTask, 1,SLEEP_14);
		}
		else if(this.game.getFps() == IGameThreadManager.FPS_30)
		{
			this.timer.schedule(this.timerTask, 1,SLEEP_28);
		}
	}
}