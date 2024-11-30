/**
 * The class that represents the game over graphic. 
 * 
 * @author Arkein Singh
 * @version November 30, 2020 
 */
package game;

import java.awt.Graphics;

public class GameOver implements Animatable {

	@Override
	public void update(double timeElapsed) {

	}

	/**
	 * Draws the game over graphic
	 */
	@Override
	public void draw(Graphics g, GameView v) {
		g.drawImage(ResourceLoader.getLoader().getImage("game_over.png"), 0, 0, null);

	}

}
