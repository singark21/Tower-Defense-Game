/**
 * The class that represents the menu object. 
 * 
 * @author Arkein Singh
 * @version November 30, 2020 
 */
package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menu implements Animatable {

	private GameState state;
	private boolean objectsAdded;

	/**
	 * Menu constructor
	 * 
	 * @param state The passed around GameState object
	 */
	public Menu(GameState state) {
		this.state = state;
		objectsAdded = false;

	}

	/**
	 * Adds the TowerSaltMenu to the menu (menu version of salt tower) when updated
	 * the first time.
	 */
	@Override
	public void update(double timeElapsed) {
		if (objectsAdded != true) {
			state.addGameObject(new TowerBeerMenu(state, 650, 100));
			state.addGameObject(new TowerSaltMenu(state, 750, 100));
			objectsAdded = true;
		}

	}

	/**
	 * Draws the menu with the lives and credits on it.
	 */
	@Override
	public void draw(Graphics g, GameView v) {
		g.setColor(new Color(0.9f, 0.8f, 0.7f));
		g.fillRect(600, 0, 300, 600);
		g.setColor(Color.BLACK);
		g.setFont(new Font("arial", Font.BOLD, 20));
		g.drawString("Lives: " + state.getLifeCounter(), 600, 50);
		g.drawString("Credits: " + state.getCredits(), 700, 50);
		g.drawString("5", 645, 150);
		g.drawString("15", 739, 150);
	}

}
