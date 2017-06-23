package shapes;

/**
 * A class for a box in a cartesian coordinate system
 * Created by thiemann on 11.06.17.
 */
public class Box {
	// Changed from private to protected so that we can access it from
	// Rectangle. Saves at least 5 lines.
    protected final V2 upperLeftCorner;
    protected final V2 dimensions;

    /**
     * A box is defined by its upper left corner and its dimensions.
     * Dimensions have to be positive.
     *
     * As we are in cartesian coordinates, a box with upper left corner (0,0)
     * and dimensions (1,1) has a lower right corner of (-1, -1).
     */
    public Box(V2 upperLeftCorner, V2 dimensions) {
        if (dimensions.getY() < 0 || dimensions.getY() < 0) {
            throw new IllegalArgumentException("Bad dimensions: " + dimensions);
        }
        this.upperLeftCorner = upperLeftCorner;
        this.dimensions = dimensions;
    }

    /**
     * Return upperLeftCorner
     * @return
     */
    public V2 getUpperLeftCorner() {
        return upperLeftCorner;
    }

    /**
     * Return dimensions
     * @return
     */
    public V2 getDimensions() {
        return dimensions;
    }
}
