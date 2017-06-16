package linenumbers;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	private static Scanner scan;

	public static void main(String[] args) {
		// validate args
		long start = 2;
		long end = 2;
		if(args.length > 0) {
			try {
				start = Long.parseLong(args[0]) -1;
			} catch(Exception e) {
				printBadArguments();
				printUsage();
				return;
			}
		}
		if(args.length > 1) {
			try {
				start = Long.parseLong(args[1]) -1;
			} catch(Exception e) {
				printBadArguments();
				printUsage();
				return;
			}		
		}
		
		scan = new Scanner(System.in);
		ArrayList<String> bufferLines = new ArrayList<String>();
		String line;
		
		for(long i=0;(end == -1||i<end);i++) {
			try {
				line = scan.nextLine();
				//if(line.equals("")) {
				//	break;
				//}
			} catch(NoSuchElementException err) {
				break;
			}
			if(i >= start) {
				bufferLines.add(line);
			}
		}
	
		long lineNumber = start;
		for(String bufLine : bufferLines) {
			System.out.println((lineNumber+1) + " " + bufLine);
			lineNumber++;
			if(lineNumber > end) break;
		}
	}
	
	public static void printBadArguments() {
		System.out.println("Bad arguments.");
	}
	
	public static void printUsage() {
		System.out.println("Usage: line-numbers [start-number [end-number]]");
	}
}
