/**
 * The class that represents the ResourceLoader. This is a singleton.   
 * Mainly used for loading images. 
 * 
 * @author Arkein Singh
 * @version November 30, 2020 
 */
package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ResourceLoader {
	private Map<String, BufferedImage> images;
	private Map<String, Path> paths;
	static private ResourceLoader instance;

	/**
	 * Initializes the necessary maps for the ResourceLoader object
	 */
	private ResourceLoader() {
		images = new HashMap<>();
		paths = new HashMap<>();
	}

	/**
	 * Makes sure that an image is only loaded once so if there is a need to use the
	 * image again it will not be loaded again
	 * 
	 * @param fileName the name of the file containing the image
	 * @return the image specified by the name in the parameter.
	 */
	public BufferedImage getImage(String fileName) {
		if (images.containsKey(fileName)) {
			return images.get(fileName);
		}
		try {
			ClassLoader loader = this.getClass().getClassLoader();
			InputStream is = loader.getResourceAsStream("resources/" + fileName);
			images.put(fileName, javax.imageio.ImageIO.read(is));
		} catch (IOException e) {
			System.out.println("Could not load the backdrop or path.");
			System.exit(0);
		}
		return images.get(fileName);
	}

	/**
	 * Makes sure that a path is not scanned through and loaded multiple times
	 * through a map that holds previously used paths
	 * 
	 * @param pathName the name of the file holding coordinates for the path
	 * @return the path that is specified in the parameter
	 */
	public Path getPath(String pathName) {
		if (paths.containsKey(pathName)) {
			return paths.get(pathName);
		}

		ClassLoader loader = this.getClass().getClassLoader();
		Scanner pathScanner = new Scanner(loader.getResourceAsStream("resources/path.txt"));
		paths.put(pathName, new Path(pathScanner));
		return paths.get(pathName);
	}

	/**
	 * @return the one and only ResourceLoader object, creates one if not created
	 *         previously
	 */
	static public ResourceLoader getLoader() {
		if (instance == null)
			instance = new ResourceLoader();

		return instance;
	}
}
