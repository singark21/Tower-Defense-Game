/**
 * The class that represents a beer tower that is placed on the map. 
 * It slows down s-cargos when it hits them.
 * 
 * @author Arkein Singh
 * @version November 30, 2020 
 */
package game;

import java.awt.Graphics;
import java.awt.Point;

public class TowerBeer extends Tower {
	private GameState state;
	private int x;
	private int y;
	private double timeSinceLastShot;

	/**
	 * Beer tower constructor.
	 * 
	 * @param state
	 * @param x     coordinate of tower
	 * @param y     coordinate of tower
	 */
	public TowerBeer(GameState state, int x, int y) {
		this.state = state;
		this.x = x;
		this.y = y;
		timeSinceLastShot = 0;
	}

	/**
	 * Updates the shooting function of the tower. Makes sure it fires at a steady
	 * rate and fires at the closest enemies.
	 */
	@Override
	public void update(double timeElapsed) {
		timeSinceLastShot += timeElapsed;
		if (timeSinceLastShot < 1)
			return;
		Point towerPoint = new Point(x, y);
		Enemy e = state.findNearestEnemy(towerPoint);
		if (e == null)
			return;
		if (towerPoint.distance(e.getPosition()) > 100)
			return;
		EffectBeerPuddle s = new EffectBeerPuddle(state, towerPoint, e.getPosition());
		state.addGameObject(s);
		timeSinceLastShot = 0;
	}

	/**
	 * Draws the tower in a centered manner where the mouse is clicked
	 */
	@Override
	public void draw(Graphics g, GameView v) {
		v.drawCenteredImage(g, "beer.png", x, y, 1);
	}

}
