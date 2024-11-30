/**
 * The class that represents the beer tower that follows the mouse after clicked on the menu. 
 * 
 * @author Arkein Singh
 * @version November 30, 2020 
 */
package game;

import java.awt.Graphics;
import java.awt.Point;

public class TowerBeerMoving implements Animatable {
	private GameState state;

	/**
	 * Constructor for the moving beer tower.
	 * 
	 * @param state
	 */
	public TowerBeerMoving(GameState state) {
		this.state = state;
	}

	/**
	 * As long as the tower isn't placed on the menu or path, a new beer tower will
	 * be placed on the map when clicked. Also uses up 5 credits to place this
	 * tower.
	 */
	@Override
	public void update(double timeElapsed) {
		Path p = ResourceLoader.getLoader().getPath("path_2.jpg");
		Point q = new Point(state.getMouseX(), state.getMouseY());
		if (state.isMouseClicked() && p.distanceToNearestPathNode(q) > 50) {
			state.removeGameObject(this);
			if (state.getMouseX() < 580) {
				state.changeCredits(-5);
				state.addGameObject(new TowerBeer(state, state.getMouseX(), state.getMouseY()));
			}
		}

	}

	/**
	 * Draws the moving tower when the menu tower is clicked on.
	 */
	@Override
	public void draw(Graphics g, GameView v) {
		v.drawCenteredImage(g, "beer.png", state.getMouseX(), state.getMouseY(), 1);

	}

}
