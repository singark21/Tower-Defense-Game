/**
 * This class represents the beer puddle that is shot from the beer can
 * 
 * @author Arkein Singh
 * @version 12/7/2021
 */
package game;

import java.awt.Graphics;
import java.awt.Point;

public class EffectBeerPuddle extends Effect {

	private GameState state;
	private double age;
	private double x, y;
	private double dx, dy;

	/**
	 * Constructor for the beer puddle effect
	 * 
	 * @param state The game state object
	 * @param start The starting point of the puddle
	 * @param end   the ending point of the puddle
	 */
	public EffectBeerPuddle(GameState state, Point start, Point end) {
		this.state = state;
		age = 0;
		x = start.x;
		y = start.y;
		dx = end.x - start.x;
		dy = end.y - start.y;
	}

	/**
	 * Moves a small distance based on the time elapsed between updates. The
	 * projectile lasts for 1 second before disappearing . Also disappears when it
	 * hits an enemy.
	 */
	public void update(double timeElapsed) {
		age += timeElapsed;
		if (age > 1.0) {
			state.removeGameObject(this);
			return;
		}
		x += dx * timeElapsed;
		y += dy * timeElapsed;

		Point p = new Point((int) x, (int) y);
		Enemy e = state.findNearestEnemy(p);
		if (e != null && e.getPosition().distance(p) < 30) {
			e.die(1.0);
			state.removeGameObject(this);
		}
	}

	/**
	 * Draws the effect at the new position.
	 */
	public void draw(Graphics g, GameView v) {
		v.drawCenteredImage(g, "puddle.png", (int) x, (int) y, 0.2);
	}

}
