package shapes;

public class Ellipse implements Shape{
	
	private final V2 center;
	private final V2 radii;

    public Ellipse(V2 center, V2 radii) {
    	this.center = center;
    	this.radii = radii;
    }

	public boolean contains(V2 point) {
		double h = center.getX();
		double k = center.getY();
		double rx = radii.getX();
		double ry = radii.getY();
		
		double x = point.getX();
		double y = point.getY();
		
		return Math.pow(x-h, 2) / Math.pow(rx, 2) +
			   Math.pow(y-k, 2) / Math.pow(ry, 2) <= 1;
	}

	public Shape move(V2 displacement) {
		double newCenterX = center.getX() + displacement.getX();
		double newCenterY = center.getY() + displacement.getY();
		
		return Shapes.makeEllipse(
				new V2(newCenterX, newCenterY),
				radii
		);
	}

	public Box boundingBox() {
		double upperLeftCornerX = this.center.getX() - this.radii.getX();
		double upperLeftCornerY = this.center.getY() + this.radii.getY();
		
		double dimensionX = 2 * this.radii.getX();
		double dimensionY = 2 * this.radii.getY();
		
		return new Box(
				new V2(upperLeftCornerX, upperLeftCornerY),
				new V2(dimensionX, dimensionY)
		);
	}

}
