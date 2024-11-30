/**
 * The class that represents the starting text of the game 
 */
package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class StartGame implements Animatable {
	private GameState state;

	/**
	 * Constructor for the start of the game.
	 * 
	 * @param state
	 */
	public StartGame(GameState state) {
		this.state = state;
	}

	/**
	 * When the mouse is first clicked this object will be gone.
	 */
	@Override
	public void update(double timeElapsed) {
		if (state.isMouseClicked()) {
			state.removeGameObject(this);
		}

	}

	/**
	 * Draws the starting text
	 */
	@Override
	public void draw(Graphics g, GameView v) {

		g.setColor(Color.CYAN);
		g.setFont(new Font("arial", Font.BOLD, 50));
		g.drawString("Click anywhere to start", 25, 300);

	}

}
