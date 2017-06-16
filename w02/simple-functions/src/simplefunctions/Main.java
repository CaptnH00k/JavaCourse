package simplefunctions;

public class Main {

	public static void main(String[] args) {
		
	}
	/**
	 * Calculates the distance between the point (x,y) to the origin
	 * @param x
	 * @param y
	 * @return
	 */
	public static double distanceOrigin(double x, double y) {
		return Math.sqrt(x*x+y*y);
	}
	
	/**
	 * Calculates the volum of a cube with the side length x
	 * @param x
	 * @return
	 */
	public static double cubeVolume(double x) {
		return x*x*x;
	}
	
	/**
	 * Calculates the surface of a cube with the side length x
	 * @param x
	 * @return
	 */
	public static double cubeSurface(double x) {
		return 6*x*x;
	}
	
	/**
	 * Returns a new string where a "_" is added at the position pos.
	 * @param str
	 * @param pos
	 * @return
	 */
	public static String stringInsert(String str, int pos) {
		return str.substring(0, pos) + "_" + str.substring(pos, str.length());
	}
	
	/**
	 * Calculates capacity of a condensator
	 * @param epsilonR
	 * @param A
	 * @param d
	 * @return
	 */
	public static double capacitance(double epsilonR, double A, double d) {
		double vacuum = 1 / ( 4 * Math.PI * Math.pow(10, -7) * Math.pow(299792458, 2));
		return vacuum * epsilonR * (A / d);
	}

}
