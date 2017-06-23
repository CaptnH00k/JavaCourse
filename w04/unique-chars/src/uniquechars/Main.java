package uniquechars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	/**
	 * Calculate the uniqueChars of input string and saves it into the cache
	 * map. If we already calculated the unique chars for input string and input
	 * is in cache, it will directly return the cached value.
	 * @param cache
	 * @param input
	 * @return
	 */
	public static int uniqueChars(Map<String, Integer> cache, String input) {
		// If we have input in our cache, just return the pair value.
		if(cache.containsKey(input)) {
			return cache.get(input);
		}
		
		// count unique chars with some java8 magic
		int uniqueChars = (int) input.chars().distinct().count();
		
		// now put it in cache
		cache.put(input, uniqueChars);
		
		return uniqueChars;
		
	}
	
	/**
	 * For all strings in input calculate the uniqueChars count with cache and 
	 * return a list of integers containing all those uniqueChars count. Index will remain
	 * the same for input an the returned list of uniqueCharsCount.
	 * @param cache
	 * @param input
	 * @return
	 */
	public static ArrayList<Integer> allUniqueChars(Map<String, Integer> cache, ArrayList<String> input) {
		// This ArrayList will hold our calculated uniqueChars counts.
		ArrayList<Integer> uniqueCharsCount = new ArrayList<Integer>();
		
		for(String in : input) {
			int uniqueChars = uniqueChars(cache, in);
			uniqueCharsCount.add(uniqueChars);
		}
		return uniqueCharsCount;
	}
	
	/**
	 * Creates a new cache object and uses this with input on allUniqueChars(cache, input);
	 * @param input
	 * @return
	 */
	public static ArrayList<Integer> allUniqueChars(ArrayList<String> input) {
		Map<String, Integer> cache = new HashMap<>();
		return allUniqueChars(cache, input);
		
	}
}
