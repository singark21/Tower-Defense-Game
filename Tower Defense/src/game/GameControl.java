/**
 * The class that represents the overall controlling of the game.  
 * Deals with time, and enemy generation.
 * 
 * @author Arkein Singh
 * @version November 30, 2020 
 */
package game;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class GameControl implements Runnable, ActionListener {
	private GameState state;
	private GameView view;
	private long previousTime;
	private double totalTime;
	private long snailCount;
	private long vanCount;
	private double nextSnailTime;
	private double nextVanTime;
	private boolean gameStart;

	public GameControl() {
	}

	/**
	 * Sets up the gameState that gets passed throughout the program. Also builds
	 * the view and sets up the backDrop, menu, timer, and start screen.
	 */
	public void run() {
		state = new GameState();
		view = new GameView(state);
		totalTime = 0.0;
		snailCount = 0;
		vanCount = 0;
		nextSnailTime = 0.0;
		nextVanTime = 0.0;
		gameStart = false;
		state.addGameObject(new Backdrop());
		state.addGameObject(new Menu(state));
		StartGame introScene = new StartGame(state);
		state.addGameObject(introScene);
		Timer timer = new Timer(16, this);
		timer.start();

	}

	/**
	 * Only begins enemy generation when the game is started. The game is started
	 * through the first click from the user. Calculates time passed between frames
	 * to pass into the update function. Consumes mouse clicks so that the mouse can
	 * click new objects. Calls enemy generation with the elapsed time.
	 */
	public void actionPerformed(ActionEvent e) {
		if (!gameStart) {
			if (state.isMouseClicked()) {
				gameStart = true;
				totalTime = 0;
			}
		}
		long currentTime = System.nanoTime();
		double elapsedTime = (currentTime - previousTime) / 1_000_000_000.0;
		totalTime += elapsedTime;
		previousTime = currentTime;
		if (gameStart)
			generateEnemies(elapsedTime);
		state.updateAll(elapsedTime);
		state.consumeMouseClick();
		view.repaint();
	}

	/**
	 * Generates 3 snails a second for 3 seconds than waits 3 seconds Generates 2
	 * s-cargos every 10 seconds
	 * 
	 * @param elapsedTime
	 */
	public void generateEnemies(double elapsedTime) {
		if (totalTime > nextSnailTime) {
			state.addGameObject(new EnemySnail(0, state));
			snailCount++;
			nextSnailTime++;
			if (snailCount % 4 == 0) {
				nextSnailTime += 3;
			}
		}
		if (totalTime > nextVanTime) {
			state.addGameObject(new EnemyScargo(0, state));
			vanCount++;
			nextVanTime++;
			if (vanCount % 2 == 0) {
				nextVanTime += 10;
			}
		}
	}
}
