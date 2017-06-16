package secondhighest;

public class Main {
	public static void Main(String[] args) {
		System.out.println("hallo");
		int[] numbers = {1,2,3,4,5};
		System.out.println(secondHighest(numbers));
	}
	public static int secondHighest(int[] numbers) {
		int highest = Integer.MIN_VALUE + 1;
		int secondHighest = Integer.MIN_VALUE;
		boolean foundSecondHighest = false;
		for(int n : numbers) {
			//System.out.println(n + " " + highest + " " + secondHighest);
			if(n >= highest) {
				secondHighest = highest;
				highest = n;
			} else if(n >= secondHighest) {
				secondHighest = n;
				foundSecondHighest = true;
			}
		}
		if(foundSecondHighest == false) {
			return Integer.MIN_VALUE;
		}
		return secondHighest;
	}
}
