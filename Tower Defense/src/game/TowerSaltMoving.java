/**
 * The class that represents the salt tower that follows the mouse after clicked on the menu.   
 * 
 * @author Arkein Singh
 * @version December 1, 2024 
 */
package game;

import java.awt.Graphics;
import java.awt.Point;

public class TowerSaltMoving implements Animatable {
	private GameState state;

	/**
	 * Constructor for the moving salt tower.
	 * 
	 * @param state
	 */
	public TowerSaltMoving(GameState state) {
		this.state = state;
	}

	/**
	 * As long as the tower isn't placed on the menu or path, a new salt tower will
	 * be placed on the map when clicked. Uses 20 credits.
	 */
	@Override
	public void update(double timeElapsed) {
		Path p = ResourceLoader.getLoader().getPath("path_2.jpg");
		Point q = new Point(state.getMouseX(), state.getMouseY());
		if (state.isMouseClicked() && p.distanceToNearestPathNode(q) > 50) {
			state.removeGameObject(this);
			if (state.getMouseX() < 580) {
				state.changeCredits(-15);
				state.addGameObject(new TowerSalt(state, state.getMouseX(), state.getMouseY()));
			}
		}

	}

	/**
	 * Draws the moving tower when the menu tower is clicked on.
	 */
	@Override
	public void draw(Graphics g, GameView v) {
		v.drawCenteredImage(g, "salt.png", state.getMouseX(), state.getMouseY(), 1.3);

	}

}
