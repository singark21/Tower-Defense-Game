/**
 * The class that represents the snail enemy. 
 * Basic enemy that moves along the path and dies in 1 shot.
 * 
 * @author Arkein Singh
 * @version November 30, 2020 
 */
package game;
 
import java.awt.Graphics;
import java.awt.Point;

public class EnemySnail extends Enemy {
	/**
	 * Constructor for enemy snail.
	 * 
	 * @param p     position along path.
	 * @param state the gamestate.
	 */
	public EnemySnail(double p, GameState state) {
		super(p, 1, 0.04, state);
	}

	/**
	 * Updates the snail position along the path. Lose life if snail reaches the
	 * end.
	 */
	public void update(double timeElapsed) {
		position += speed * timeElapsed;
		if (position > 1) {
			state.removeGameObject(this);
			state.changeLifeCounter(-1);
		}
	}

	/**
	 * Draws the snail at the new position.
	 */
	public void draw(Graphics g, GameView v) {
		Point p = getPosition();
		v.drawCenteredImage(g, "snail.png", p.x, p.y, 1);
	}

	/**
	 * Snail loses health each time it is hit and dies when at 0 health. Rewards 0.5
	 * credit when killed.
	 * 
	 * @param damageDealt The amount of damage taken
	 */
	@Override
	public void die(double damageDealt) {
		health -= damageDealt;
		if (health <= 0) {
			state.removeGameObject(this);
			EffectSplat s = new EffectSplat(state, getPosition());
			state.addGameObject(s);
			state.changeCredits(0.25);
		}
	}
}
