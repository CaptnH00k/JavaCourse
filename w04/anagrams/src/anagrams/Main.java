package anagrams;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String stringA = scan.next();
		String stringB = scan.next();
		System.out.println(isAnagram(stringA, stringB) ? "Anagrams" : "Not anagrams");
	}
	
	/**
	 * Check if StringA and StringB are Anagrams (both contain the
	 * same characters, including duplicates, ignoring lower/upper case):
	 * @param StringA
	 * @param StringB
	 * @return
	 */
	public static boolean isAnagram(String StringA, String StringB) {
		// First we lower case both strings
		StringA = StringA.toLowerCase();
		StringB = StringB.toLowerCase();
		
		// Now we split them so each character is an own element in our 
		// splitted array
		String[] splittedStringA = StringA.split("");
		String[] splittedStringB = StringB.split("");
		
		// Now sort them
		Arrays.sort(splittedStringA);
		Arrays.sort(splittedStringB);
		
		// and if they now equal, we have an Anagram.
		return Arrays.equals(splittedStringA, splittedStringB);
	}
}
