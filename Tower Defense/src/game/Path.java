/**
 * The class that represents the path of the game. 
 * 
 * @author Arkein Singh
 * @version November 30, 2020 
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Path {
	private ArrayList<Point> points = new ArrayList<>();

	/**
	 * Constructor for the Path. Adds all points to the point ArrayList.
	 * 
	 * @param pathScanner The scanner object that goes through the coordinate file
	 */
	public Path(Scanner pathScanner) {
		int coordinates = pathScanner.nextInt();

		for (int pos = 0; pos < coordinates; pos++) {
			Point point = new Point();
			point.x = pathScanner.nextInt();
			point.y = pathScanner.nextInt();
			points.add(point);
		}
	}

	/**
	 * Draws the path, currently unused.
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		for (int pos = 1; pos < points.size(); pos++) {
			g.drawLine(points.get(pos - 1).x, points.get(pos - 1).y, points.get(pos).x, points.get(pos).y);
		}

	}

	/**
	 * Returns the total length of the path. Since the path is specified using
	 * screen coordinates, the length is in pixel units (by default).
	 * 
	 * @return the length of the path
	 */
	public double getPathLength() {
		double length = 0;
		for (int pos = 1; pos < points.size(); pos++) {
			length += points.get(pos - 1).distance(points.get(pos));
		}
		return length;
	}

	/**
	 * Given a percentage between 0% and 100%, this method calculates the location
	 * along the path that is exactly this percentage along the path. The location
	 * is returned in a Point object (integer x and y), and the location is a screen
	 * coordinate.
	 * 
	 * If the percentage is less than 0%, the starting position is returned. If the
	 * percentage is greater than 100%, the final position is returned.
	 * 
	 * 
	 * @param percentTraveled a distance along the path
	 * @return the screen coordinate of this position along the path
	 */
	public Point getPathPosition(double percentTraveled) {
		Point finalPoint = new Point();
		if (percentTraveled <= 0) {
			finalPoint = points.get(0);
			return finalPoint;
		}
		if (percentTraveled >= 1) {
			finalPoint = points.get(points.size() - 1);
			return finalPoint;
		}
		double distanceLeft = percentTraveled * getPathLength();
		double segmentLength = 0;
		int count = 0;
		while (segmentLength < distanceLeft) {
			count++;
			distanceLeft -= segmentLength;
			segmentLength = points.get(count - 1).distance(points.get(count));
		}
		if (distanceLeft - segmentLength == 0) {
			return points.get(count);
		}
		double usedDistancePercent = distanceLeft / segmentLength;
		double xFinal = (1 - usedDistancePercent) * points.get(count - 1).x + usedDistancePercent * points.get(count).x;
		double yFinal = (1 - usedDistancePercent) * points.get(count - 1).y + usedDistancePercent * points.get(count).y;
		finalPoint.setLocation(xFinal, yFinal);
		return finalPoint;
	}

	/**
	 * @param p The point we are measuring the distance to.
	 * @return The distance from the nearest path node to the parameter point.
	 */
	public double distanceToNearestPathNode(Point p) {
		double shortest = points.get(0).distance(p);
		for (Point q : points) {
			double distance = p.distance(q);
			if (distance < shortest)
				shortest = distance;
		}
		return shortest;
	}
}
