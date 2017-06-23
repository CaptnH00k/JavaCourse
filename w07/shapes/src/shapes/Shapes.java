package shapes;

import java.util.List;

public class Shapes {

	/**
	 * Creates a new Instance of Ellipse with passed arguments
	 * and returns it.
	 * @param center
	 * @param radii
	 * @return
	 */
	public static Shape makeEllipse(V2 center, V2 radii) {
		return new Ellipse(center, radii);
	}
	
	/**
	 * Creates a new Instance of Rectangle with passed arguments
	 * and returns it.
	 * @param upperLeftCorner
	 * @param dimensions
	 * @return
	 */
	public static Shape makeRectangle(V2 upperLeftCorner, V2 dimensions) {
		return new Rectangle(upperLeftCorner, dimensions);
	}
	
	/**
	 * Creates a new Instance of Picture with passed arguments
	 * and returns it.
	 * @param shapes
	 * @return
	 */
	public static Shape makePicture(List<Shape> shapes) {
		return new Picture(shapes);
	}
}
