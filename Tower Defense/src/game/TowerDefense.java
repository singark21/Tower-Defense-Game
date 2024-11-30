/**
 * The main class that starts the application. 
 * 
 * @author Arkein Singh
 * @version November 30, 2020 
 */

package game;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class TowerDefense {
	/**
	 * Creates a GameControl object to start the game and invokes and waits.
	 * 
	 * @param args
	 * @throws InvocationTargetException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		GameControl gc = new GameControl();
		SwingUtilities.invokeAndWait(gc);
	}

}
