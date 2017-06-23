package linenumbers;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	
	/**
	 * Reads lines from Stdin and prints them out with a line number.
	 * Behaviour can be modified with args[0] and args[1].
	 * @param {String[]} args            - Args from cmd
	 * @param {String} args[0] [start=1] - at which line do we want to print out? 
	 *                                     has to be castable to long
	 * @param {String} args[1] [end=-1]  - at which line do we want to stop printing out?
	 *                                     has to be castable to long
	 */
	public static void main(String[] args) {
		// init default values for start and end
		long start = 0;
		long end = -1; // -1 => read lines as long as possible

		// parse args, if args format is wrong (more than 3 args, or not
		// castable as long) brings Error message + usage.
		try {
			if(args.length > 0) start = Long.parseLong(args[0]) -1;
			if(args.length > 1) end = Long.parseLong(args[1]) -1;
			if(args.length > 2) throw new Exception("Bad Arguments");
		} catch(Exception e) {
			System.out.println("Bad arguments.");
			System.out.println("Usage: line-numbers [start-number [end-number]]");
			return;
		}		
		
		// Init scanner and String variable for line.
		Scanner scan = new Scanner(System.in);	
		String line;
		
		// As long lineNumber <= end we want to read in lines
		for(long lineNumber=0;(end == -1||lineNumber<=end);lineNumber++) {
			try {
				line = scan.nextLine();
			} catch(NoSuchElementException err) {
				break;
			}
			if(lineNumber >= start) {
				// lineNumber var starts with 0, but we want for printed
				// out line number start with 1, so just add 1.
				System.out.println((lineNumber+1) + " " + line);
			}
		}
	}
}
