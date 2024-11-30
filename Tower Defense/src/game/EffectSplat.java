/**
 * This class represents that splat effect that occurs when a snail dies
 * 
 * @author Arkein Singh
 * @version 12/7/2021
 */
package game;

import java.awt.Graphics;
import java.awt.Point;

public class EffectSplat extends Effect {
	private double age;
	private GameState state;
	private Point location;

	/**
	 * Constructor for the splat effect.
	 * 
	 * @param state    game state object.
	 * @param location The location of the dead snail.
	 */
	public EffectSplat(GameState state, Point location) {
		this.state = state;
		this.location = location;
		this.age = 0;
	}

	/**
	 * The update function makes sure the splat only lasts for half a second.
	 */
	@Override
	public void update(double timeElapsed) {
		age += timeElapsed;
		if (age > 0.5)
			state.removeGameObject(this);

	}

	/**
	 * Draws the splat in a slowly enlarging manner.
	 */
	@Override
	public void draw(Graphics g, GameView v) {
		v.drawCenteredImage(g, "splat.png", location.x, location.y, age * 2);

	}

}
