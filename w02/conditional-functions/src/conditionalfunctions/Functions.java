package conditionalfunctions;

public class Functions {
	public static String turbineControl(double f) {
		if(f <= 49 || f >= 51) {
			return "DISCONNECT";
		}else if(f < 49.999) {
			return "MORE_WATER";
		}else if(f > 50.001) {
			return "LESS_WATER";
		}else {
			return "STEADY";
		}
	}
}
