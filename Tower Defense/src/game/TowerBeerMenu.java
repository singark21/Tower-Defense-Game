/**
 * The class that represents the beer tower in the menu. 
 * 
 * @author Arkein Singh
 * @version November 30, 2020 
 */
package game;

import java.awt.Graphics;

public class TowerBeerMenu implements Animatable {
	private GameState state;
	private int x;
	private int y;

	/**
	 * Beer tower menu constructor.
	 * 
	 * @param state
	 * @param x     coordinate of menu tower
	 * @param y     coordinate of menu tower
	 */
	public TowerBeerMenu(GameState state, int x, int y) {
		this.state = state;
		this.x = x;
		this.y = y;
	}

	/**
	 * When clicked this method creates a moving beer tower that follows the mouse
	 */
	@Override
	public void update(double timeElapsed) {
		if (state.getMouseX() >= x - 25 && state.getMouseX() < x + 25 && state.getMouseY() >= y - 25
				&& state.getMouseY() < y + 25 && state.isMouseClicked() && state.getCredits() > 4)
			state.addGameObject(new TowerBeerMoving(state));
	}

	/**
	 * Draws the menu beer tower
	 */
	@Override
	public void draw(Graphics g, GameView v) {
		v.drawCenteredImage(g, "beer.png", x, y, 1);

	}

}
