package shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * Picture is a Shape class which holds multiple other Shapes in it.
 */
public class Picture implements Shape{
	private final List<Shape> shapes;
	
	/**
	 * A Picture is defined as multiple Shapes together
	 * @param shapes
	 */
	public Picture(List<Shape> shapes) {
		this.shapes = shapes;
	}

	/**
	 * Returns true if at least one included shape contains point.
	 * False if none contains this point
	 * @param point
	 * @return
	 */
	public boolean contains(V2 point) {
		for(Shape s : shapes) {
			if(s.contains(point)) return true;
		}
		return false;
	}

	/**
	 * Move all shapes and return a new Picture
	 * holding the moved shapes.
	 * @param displacement
	 * @return
	 */
	public Shape move(V2 displacement) {
		List<Shape> movedShapes = new ArrayList<Shape>();
		for(Shape s : shapes) {
			movedShapes.add(
				s.move(displacement)
			);
		}
		return new Picture(movedShapes);
	}

	/**
	 * Returns a Box bounding around all shapes.
	 * @return
	 */
	public Box boundingBox() {
		double lowestLeftX = Double.MAX_VALUE;
		double highestLeftY = -Double.MAX_VALUE;
		double highestRightX = -Double.MAX_VALUE;
		double lowestRightY = Double.MAX_VALUE;
		
		double leftX;
		double leftY;
		double rightX;
		double rightY;
		// now we have to find the lowest and highest values
		for(Shape s : shapes) {
			Box b = s.boundingBox();
			
			leftX = b.upperLeftCorner.getX();
			leftY = b.upperLeftCorner.getY();
			
			lowestLeftX = leftX < lowestLeftX ? leftX : lowestLeftX;
			highestLeftY = leftY > highestLeftY ? leftY : highestLeftY;
			
			rightX = leftX + b.dimensions.getX();
			rightY = leftY - b.dimensions.getY();
			
			highestRightX = rightX > highestRightX ? rightX : highestRightX;
			lowestRightY = rightY < lowestRightY ? rightY : lowestRightY;
		}
		
		return new Box(
			new V2(lowestLeftX, highestLeftY),
			new V2(highestRightX - lowestLeftX, highestLeftY - lowestRightY)
		);
		
		
	}
}
