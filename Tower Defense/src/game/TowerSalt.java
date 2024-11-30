/**
 * The class that represents a salt tower that is placed on the map. 
 * 
 * @author Arkein Singh
 * @version November 30, 2020 
 */
package game;

import java.awt.Graphics;
import java.awt.Point;

public class TowerSalt extends Tower {
	private GameState state;
	private int x;
	private int y;
	private double timeSinceLastShot;

	/**
	 * Salt tower constructor.
	 * 
	 * @param state
	 * @param x     coordinate of tower
	 * @param y     coordinate of tower
	 */
	public TowerSalt(GameState state, int x, int y) {
		this.state = state;
		this.x = x;
		this.y = y;
		timeSinceLastShot = 0;
	}

	/**
	 * This tower shoots salt crystals to the position of the mouse. The update
	 * function controls the fire rate and makes sure it does not shoot into the
	 * menu
	 */
	@Override
	public void update(double timeElapsed) {
		timeSinceLastShot += timeElapsed;
		if (timeSinceLastShot < 0.25)
			return;
		Point towerPoint = new Point(x, y);
		int shotXPoint = state.getMouseX();
		if (shotXPoint > 600) {
			return;
		}
		Point endShot = new Point(shotXPoint, state.getMouseY());
		EffectSalt s = new EffectSalt(state, towerPoint, endShot);
		state.addGameObject(s);
		timeSinceLastShot = 0;
	}

	/**
	 * Draws the tower in a centered manner where the mouse is clicked
	 */
	@Override
	public void draw(Graphics g, GameView v) {
		v.drawCenteredImage(g, "salt.png", x, y, 1.3);
	}

}
