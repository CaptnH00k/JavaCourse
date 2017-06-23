package shapes;

/**
 * A Rectangle Class implementing Shape interface.
 */
public class Rectangle extends Box implements Shape {

	/**
	 * A Rectangle is defined by its upper left corner and its dimensions.
     * Dimensions have to be positive.
     *
     * As we are in cartesian coordinates, a Rectangle with upper left corner (0,0)
     * and dimensions (1,1) has a lower right corner of (-1, -1).
 
	 * @param upperLeftCorner
	 * @param dimensions
	 */
	public Rectangle(V2 upperLeftCorner, V2 dimensions) {
        super(upperLeftCorner, dimensions);
	}
	
	/**
	 * Returns true if point is inside Rectangle
	 * @param point
	 */
	public boolean contains(V2 point) {
		double pointX = point.getX();
		double pointY = point.getY();
		
		double leftX = upperLeftCorner.getX();
		double rightX = leftX + dimensions.getX();
		
		double upperY = upperLeftCorner.getY();
		double lowerY = upperY - dimensions.getY();
		
		return pointX >= leftX && pointX <= rightX &&
			   pointY >= lowerY && pointY <= upperY;
	}

	/**
	 * Moves Rectangle by displacement and returns new
	 * moved Rectangle
	 * @param displacement
	 * @return
	 */
	public Shape move(V2 displacement) {
		double newUpperLeftCornerX = upperLeftCorner.getX() + displacement.getX();
		double newUpperLeftCornerY = upperLeftCorner.getY() + displacement.getY();
		
		return new Rectangle(
			new V2(newUpperLeftCornerX, newUpperLeftCornerY),
			this.dimensions
		);
	}

	/**
	 * Returns a box around rectangle. It's the same,
	 * just a different Class Type.
	 */
	public Box boundingBox() {
		return new Box(
			this.upperLeftCorner,
			this.dimensions
		);
	}

}
