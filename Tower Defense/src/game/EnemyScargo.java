/**
 * The class that represents the the s-cargo enemy. 
 * Goal is to burst into snails when destroyed
 * 
 * @author Arkein Singh
 * @version November 30, 2020 
 */
package game;

 
import java.awt.Graphics;
import java.awt.Point;

public class EnemyScargo extends Enemy {

	/**
	 * Constructor to initialize position
	 * 
	 * @param p position of the circle along the path
	 */
	public EnemyScargo(double p, GameState state) {
		super(p, 3, 0.03, state);

	}

	/**
	 * Updates the Scargo position along the path. Resets position and loses lives
	 * if Scargo reaches the end.
	 */
	public void update(double timeElapsed) {
		position += speed * timeElapsed;
		if (position > 1) {
			state.removeGameObject(this);
			state.changeLifeCounter(-5);
		}
	}

	/**
	 * Draws the Scargo at the new position.
	 */
	public void draw(Graphics g, GameView v) {
		Point p = ResourceLoader.getLoader().getPath("path_2.jpg").getPathPosition(position);
		v.drawCenteredImage(g, "s-cargo.png", p.x, p.y, 1);
	}

	/**
	 * S-cargo loses health each time it is hit and dies when at 0 health. Rewards 2
	 * credits when killed. Gets slowed when hit by a beer puddle which does 1
	 * damage.
	 * 
	 * @param damageDealt The amount of damage taken
	 */
	@Override
	public void die(double damageDealt) {
		health -= damageDealt;
		if (damageDealt == 1 && speed == 0.03) {
			speed = 0.03 / 2;
		}
		if (health <= 0) {
			state.removeGameObject(this);
			state.addGameObject(new EnemyCrashedSCargo(position, state));
			state.changeCredits(2);
		}
	}
}
