/**
 * The animatable interface is used for every animatable game object.  
 * Ensures every animatable object has the specified methods
 * 
 * @author Arkein Singh
 * @version November 30, 2021 
 */
package game;

import java.awt.Graphics;

public interface Animatable {
	/**
	 * The update method every animatable object has.
	 * 
	 * @param timeElapsed
	 */
	public void update(double timeElapsed);

	/**
	 * The draw method every animatable object has.
	 * 
	 * @param timeElapsed
	 */
	public void draw(Graphics g, GameView v);
}
