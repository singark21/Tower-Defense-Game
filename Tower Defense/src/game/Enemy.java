/**
 * The class that represents the Enemies. 
 * All types of enemies have this class as the superclass
 * 
 * @author Arkein Singh
 * @version November 30, 2020 
 */
package game;

import java.awt.Point;

public abstract class Enemy implements Animatable {
	protected double position;
	protected double health;
	protected double speed;
	protected GameState state;

	/**
	 * Constructor for the enemy super class.
	 * 
	 * @param p  The position of the enemy.
	 * @param h  The health of the enemy.
	 * @param sp The speed of the enemy.
	 * @param s  The game state.
	 */
	public Enemy(double p, int h, double sp, GameState s) {
		position = p;
		health = h;
		speed = sp;
		state = s;
	}

	/**
	 * @return current position of an enemy.
	 */
	public Point getPosition() {
		return ResourceLoader.getLoader().getPath("path_2.jpg").getPathPosition(position);
	}

	/**
	 * This is called each time an enemy takes damage, all enemies have this method.
	 * 
	 * @param damageDealt
	 */
	abstract public void die(double damageDealt);

}