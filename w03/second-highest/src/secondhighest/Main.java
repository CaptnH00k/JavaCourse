package secondhighest;

public class Main {
	public static void main(String[] args) {
		int[] numbers = {-89, 8, 78, 100, -39, -38, 30};
		System.out.println(Integer.MIN_VALUE);
		System.out.println(secondHighest(numbers));
	}

	/**
	 * Returns the second highest element of an int[] array
	 * @param {int[]} numbers - Int array of numbers from which the second
	 *                          highest element should be found
	 * @return int secondHighest
	 */
	public static int secondHighest(int[] numbers) {
		int highest = Integer.MIN_VALUE + 1;
		int secondHighest = Integer.MIN_VALUE;
		
		// if array has less than 2 elements, (so one or zero)
		// we can't find the second Highest element, so we just
		// return Integer.MIN_VALUE (which secondHighest equals
		// for the moment)
		if(numbers.length < 2) {
			return secondHighest;
		}
			
		boolean foundSecondHighest = false;
		int changedHighestTimes = 0;
		
		// Iterate over all elements of numbers
		for(int n : numbers) {
			// if n > highest, we want to replace highest with n
			// and set secondHighest to the value highest had before.
			System.out.println(n + " " + secondHighest + " " + highest + " " + foundSecondHighest+ " " + changedHighestTimes);
			if(n > highest) {
				secondHighest = highest;
				highest = n;
				// If we found two ns bigger highest, we also found a secondHighest.
				if(changedHighestTimes < 3) changedHighestTimes++;
				if(changedHighestTimes == 2) foundSecondHighest = true;
			// if n == highest, continue to not overwrite secondHighest
			}else if(n == highest) {
				continue;
			// if n> secondHighest, replace secondHighest with n and set
			// foundSecondHighest to true so that we know we found at least
			// once a second highest element.
			}else if(n > secondHighest) {
				secondHighest = n;
				foundSecondHighest = true;
			// if n equals secondHighest but foundSecondHighest is false, set it to true
			}else if(n == secondHighest && foundSecondHighest == false) {
				foundSecondHighest = true;
			}
		}
		
		// if we didn't find a secondHighest element, return Integer.MIN_VALUE,
		// otherwise secondHighest.
		
		return foundSecondHighest == true ? secondHighest : Integer.MIN_VALUE;
	}
}
