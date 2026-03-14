package br.com.ajf.game.thread;

import br.com.ajf.game.model.Game;

/**
 * The Class GameThread.
 *
 * Author A.J.F
 */
public final class GameThread implements Runnable
{
	/** The Constant ONE. */
	private static final double ONE = 1;

	/** The game game. */
	private final Game game;
	
	/** The thread. */
	private final Thread thread;
	
	/** The running. */
	public boolean running;
	
	/**
	 * Instantiates a new game thread.
	 *
	 * @param game the game
	 */
	public GameThread(final Game game)
	{
		this.game = game;
		this.thread = new Thread(this);
	}
	
	/**
	 * Run.
	 *
	 * @see java.lang.Runnable#run()
	 * method that run the thread
	 */
	@Override
	public void run()
	{
		final double drawInterval = 1_000_000_000 / this.game.getFps();
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
//        long timer = 0;
//        int drawCount = 0;
		
		while(this.running)
		{
			 currentTime = System.nanoTime();
	         delta += (currentTime - lastTime) / drawInterval;
//	         timer += (currentTime - lastTime);
	         lastTime = currentTime;

	         if(delta >= ONE) 
	         {    
	        	this.game.update();
	            delta--;
//	             drawCount++;
	         }

//	         if (timer >= 1_000_000_000) 
//	         {
//	        	 this.game.setGameTitle(String.valueOf(drawCount));
//	        	 drawCount = 0;
//	        	 timer = 0;
//	         }
		}
		
		try
		{
			this.thread.join();
		} 
		catch (InterruptedException err)
		{
			err.printStackTrace();
		}
	}
	
	/**
	 * method that start the thread.
	 */
	public void start()
	{
		this.running = true;
		this.thread.start();
	}
}