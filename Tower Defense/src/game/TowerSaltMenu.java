/**
 * The class that represents the salt tower in the menu. 
 * 
 * @author Arkein Singh
 * @version November 30, 2020 
 */
package game;

import java.awt.Graphics;

public class TowerSaltMenu implements Animatable {
	private GameState state;
	private int x;
	private int y;

	/**
	 * Salt tower menu constructor.
	 * 
	 * @param state
	 * @param x     coordinate of menu tower
	 * @param y     coordinate of menu tower
	 */
	public TowerSaltMenu(GameState state, int x, int y) {
		this.state = state;
		this.x = x;
		this.y = y;
	}

	/**
	 * WHen clicked this method creates a moving salt tower that follows the mouse
	 */
	@Override
	public void update(double timeElapsed) {
		if (state.getMouseX() >= x - 25 && state.getMouseX() < x + 25 && state.getMouseY() >= y - 25
				&& state.getMouseY() < y + 25 && state.isMouseClicked() && state.getCredits() > 14)
			state.addGameObject(new TowerSaltMoving(state));
	}

	/**
	 * Draws the menu salt tower
	 */
	@Override
	public void draw(Graphics g, GameView v) {
		v.drawCenteredImage(g, "salt.png", x, y, 1.3);

	}

}
