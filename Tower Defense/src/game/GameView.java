/**
 * Class that represents the view of the game.
 * 
 *  @author Arkein Singh
 *  @version 12/7/2021
 */
package game;

import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameView extends JPanel implements MouseListener, ActionListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	Path path;
	private GameState state;

	/**
	 * Our GameView constructor. The 'view' is the GUI (Graphical User Interface)
	 * and this constructor builds a JFrame (window) so the user can see our
	 * 'drawing'. Also sets up mouse actions and path.
	 */
	public GameView(GameState state) {
		this.state = state;

		path = ResourceLoader.getLoader().getPath("path_2.jpg");

		JFrame frame = new JFrame("Tower Defense 2021");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = this;
		frame.setContentPane(p);

		Dimension d = new Dimension(900, 600);
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		this.setMaximumSize(d);

		frame.pack();
		frame.setVisible(true);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	/**
	 * Draws our game. This function will be called automatically when Java needs to
	 * repaint our window. Use the repaint() function call (on this object) to cause
	 * this function to be executed.
	 * 
	 * @param Graphics g the Graphics object to use for drawing
	 */
	public void paint(Graphics g) {
		state.drawAll(g, this);
	}

	/**
	 * Sets the mouse clicked flag to true when the mouse is clicked
	 */
	public void mousePressed(MouseEvent e) {
		state.setMouseClicked();
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
	}

	/**
	 * Sets mouse location when the mouse is dragged.
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		state.setMouseLocation(e.getX(), e.getY());

	}

	/**
	 * Sets mouse location when mouse is moved.
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		state.setMouseLocation(e.getX(), e.getY());

	}

	/**
	 * Allows for drawing any image centered. Helps with dealing from the center of
	 * the image rather than the top left corner.
	 * 
	 * @param g         graphics object
	 * @param imageName String for name of image.
	 * @param x         coordinate of desired placement.
	 * @param y         coordinate of desired placement.
	 * @param scale     determines size of the object relative to original size.
	 */
	public void drawCenteredImage(Graphics g, String imageName, int x, int y, double scale) {
		BufferedImage image = ResourceLoader.getLoader().getImage(imageName);
		int width = image.getWidth();
		int height = image.getHeight();
		int centerX = x - (int) (width / 2 * scale);
		int centerY = y - (int) (height / 2 * scale);
		g.drawImage(image, centerX, centerY, (int) (width * scale), (int) (height * scale), null);
	}
}
