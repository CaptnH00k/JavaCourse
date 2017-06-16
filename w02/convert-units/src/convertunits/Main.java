package convertunits;

public class Main {

	/**
	 * Convert x (km) to miles
	 * @param x
	 * @return
	 */
	public static double km2miles(double x) {
		return x * 0.621371;
	}
	
	/**
	 * Convert x (miles) to km	
	 * @param x
	 * @return
	 */
	public static double miles2km(double x) {
		return x * 1.60934;
	}
	
	/**
	 * Convert x (celsius) to fahrenheit
	 * @param x
	 * @return
	 */
	public static double celsius2fahrenheit(double x) {
		return x * 1.8 + 32;
	}
	
	/**
	 * Convert x (fahrenheit) to celsius
	 * @param x
	 * @return
	 */
	public static double fahrenheit2celsius(double x) {
		return x / 1.8 + 32;
	}

}
