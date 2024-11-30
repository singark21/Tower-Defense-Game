/**
 * The class that represents the game state.  
 * Deals mainly with mouse actions, lives, and the game objects overall functionality.
 * 
 * @author Arkein Singh
 * @version November 30, 2020 
 */
package game;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GameState {
	private List<Animatable> gameObjects;
	private List<Animatable> objectsToRemove;
	private List<Animatable> objectsToAdd;
	private int mouseX, mouseY;
	private boolean mouseClicked;
	private int lifeCounter;
	private boolean isGameOver;
	private double credits;

	/**
	 * Constructor that initializes the list that holds the game objects. Also sets
	 * up important mouse variables as well as the lifeCounter and game over flag.
	 */
	public GameState() {
		gameObjects = new ArrayList<>();
		objectsToRemove = new ArrayList<>();
		objectsToAdd = new ArrayList<>();
		mouseX = mouseY = 0;
		mouseClicked = false;
		lifeCounter = 200;
		credits = 200;
		isGameOver = false;
	}

	/**
	 * @return amount of lives remaining
	 */
	public int getLifeCounter() {
		return lifeCounter;
	}

	/**
	 * @return amount of credits.
	 */
	public double getCredits() {
		return credits;
	}

	/**
	 * changes lives by a specified parameter
	 * 
	 * @param delta The amount the lives will be changed
	 */
	public void changeLifeCounter(int delta) {
		lifeCounter += delta;
	}

	/**
	 * Change credits by a specified amount.
	 * 
	 * @param d desired change in credits.
	 */
	public void changeCredits(double d) {
		credits += d;
	}

	/**
	 * adds a game object to the list of objects to be added.
	 * 
	 * @param a the animatable object to be added to the list.
	 */
	public void addGameObject(Animatable a) {
		objectsToAdd.add(a);
	}

	/**
	 * adds a game object to the list of objects to be removed.
	 * 
	 * @param a the object to be removed.
	 */
	public void removeGameObject(Animatable a) {
		objectsToRemove.add(a);
	}

	/**
	 * As long as the game is not over, the method calls the individual update
	 * methods for every animatable object. Also updates the necessary lists for the
	 * next update cycle.
	 */
	public void updateAll(double elapsedTime) {
		if (!isGameOver) {
			for (Animatable a : gameObjects)
				a.update(elapsedTime);
			if (lifeCounter <= 0) {
				lifeCounter = 0;
				isGameOver = true;
				addGameObject(new GameOver());
			}
			gameObjects.removeAll(objectsToRemove);
			objectsToRemove.clear();
			gameObjects.addAll(objectsToAdd);
			objectsToAdd.clear();

		}
	}

	/**
	 * draws the animatable objects
	 * 
	 * @param g
	 */
	public void drawAll(Graphics g, GameView view) {
		for (Animatable a : gameObjects) {
			a.draw(g, view);
		}
	}

	/**
	 * Finds nearest enemy to the parameter
	 * 
	 * @param p The point that we are finding the closest enemy to
	 * @return The nearest enemy to the point
	 */
	public Enemy findNearestEnemy(Point p) {
		Enemy closest = null;
		for (Animatable a : gameObjects) {
			if (a instanceof Enemy) {
				Enemy e = (Enemy) a;
				if (closest == null)
					closest = e;
				else {
					Point currentClosest = closest.getPosition();
					Point enemyPosition = e.getPosition();

					double distanceToCurrentClosest = p.distance(currentClosest);
					double distanceToEnemy = p.distance(enemyPosition);

					if (distanceToEnemy < distanceToCurrentClosest)
						closest = e;
				}
			}
		}
		return closest;
	}

	/**
	 * Sets the mouse location
	 * 
	 * @param x coordinate
	 * @param y coordinate
	 */
	public void setMouseLocation(int x, int y) {
		mouseX = x;
		mouseY = y;
	}

	/**
	 * @return x coordinate of mouse
	 */
	public int getMouseX() {
		return mouseX;
	}

	/**
	 * @return y coordinate of mouse
	 */
	public int getMouseY() {
		return mouseY;
	}

	/**
	 * When the mouse is clicked this sets the flag to true
	 */
	public void setMouseClicked() {
		mouseClicked = true;
	}

	/**
	 * @return whether or not the mouse is clicked in the form of a boolean
	 */
	public boolean isMouseClicked() {
		return mouseClicked;
	}

	/**
	 * This changes the mouse click boolean back to false when the mouse is no
	 * longer clicked
	 */
	public void consumeMouseClick() {
		mouseClicked = false;
	}
}
