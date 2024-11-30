/**
 * The class that represents the backdrop.  
 * 
 * @author Arkein Singh
 * @version November 30, 2020 
 */
package game;

import java.awt.Graphics;

public class Backdrop implements Animatable {

	@Override
	public void update(double timeElapsed) {

	}

	@Override
	/**
	 * Draws the backdrop.
	 */
	public void draw(Graphics g, GameView v) {
		g.drawImage(ResourceLoader.getLoader().getImage("path_2.jpg"), 0, 0, null);

	}

}
