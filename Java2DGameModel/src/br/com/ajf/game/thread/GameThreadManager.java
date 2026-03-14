package br.com.ajf.game.thread;

import br.com.ajf.game.model.Game;

/**
 * The Class GameThreadManager.
 *
 * Author A.J.F
 */
public final class GameThreadManager implements IGameThreadManager
{	
    
    /** The game thread. */
    private GameThread gameThread ;
    
    /** The thread timer. */
    private GameThreadTaskTimer threadTimer;

	/** The thread type. */
	private int threadType;

	/**
	 * Instantiates a new game thread manager.
	 *
	 * @param game the game
	 * @param threadtype the type of the thread
	 */
	public GameThreadManager(final Game game,final int threadtype)
	{
		this.threadType = threadtype;
		switch(threadtype)
		{
			case 0:
				this.gameThread = new GameThread(game);
				break;
				
			case 1:
				this.threadTimer = new GameThreadTaskTimer(game);
				break;
				
			default:
				this.gameThread = new GameThread(game);
				break;
					
		}
	}

	
	/**
	 * Start.
	 */
	@Override
	public void start()
	{
		switch(this.threadType)
		{
			case 0:
				this.gameThread.start();
				break;
				
			case 1:
				this.threadTimer.start();
				break;
				
			default:
				this.gameThread.start();
				break;		
		}
	}
}