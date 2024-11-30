/**
 * The class that represents the crashed s-cargo enemy. 
 * Acts as a spawner.
 * @author Arkein Singh
 * @version November 30, 2020 
 */
package game;


import java.awt.Graphics;
import java.awt.Point;

public class EnemyCrashedSCargo extends Enemy {

	private double age;

	/**
	 * Constructor to initialize position of the crashed s-cargo.
	 * 
	 * @param p position of the dead s-cargo.
	 */
	public EnemyCrashedSCargo(double p, GameState state) {
		super(p, 5, 0, state);
		age = 0;
	}

	/**
	 * Spawns a snail from the crashed s-cargo every half a second as long as the
	 * crashed s-cargo is alive. This enemy is stationary so it does not need a
	 * position update.
	 */
	public void update(double timeElapsed) {
		age += timeElapsed;
		if (age > 1) {
			state.addGameObject(new EnemySnail(position, state));
			age = 0;
		}
	}

	/**
	 * Draws the Crashed s-cargo
	 */
	public void draw(Graphics g, GameView v) {
		Point p = ResourceLoader.getLoader().getPath("path_2.jpg").getPathPosition(position);
		v.drawCenteredImage(g, "crash.png", p.x, p.y, 1);
	}

	/**
	 * Loses health each time it is shot and rewards 3 credits when defeated.
	 */
	@Override
	public void die(double damageDealt) {
		health -= damageDealt;
		if (health <= 0) {
			state.removeGameObject(this);
			state.changeCredits(3);
		}
	}
}
