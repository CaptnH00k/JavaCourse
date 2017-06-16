package listoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> internalList = new ArrayList<String>();
		
		String[] splittedLine;
		
		while(scan.hasNext()) {
			boolean invalidCommand = false;
			boolean cantCompute = false;
			
			splittedLine = scan.nextLine().split(" ");
			if(splittedLine.length < 1) {
				invalidCommand = true;
			}
			
			if(invalidCommand == false) {
				splittedLine[0] = splittedLine[0].toLowerCase();
				switch(splittedLine[0]) {
					case "append":
						if(splittedLine.length == 2 && isValidWord(splittedLine[1])) {
							internalList.add(splittedLine[1]);
						} else {
							invalidCommand = true;
						}
						break;
					case "pop":
						if(internalList.size() == 0) {
							cantCompute = true;
						} else {
							internalList.remove(internalList.size() - 1);							
						}
						break;
					case "print":
						String stdout = "::";
						for(String s : internalList) {
							stdout += " " + s;
						}
						System.out.println(stdout);
						break;
					case "set":
						if(splittedLine.length != 3 || isValidWord(splittedLine[2]) == false) {
							invalidCommand = true;
						}
						int iArg = 0;
						try {
							iArg = Integer.parseInt(splittedLine[1]);							
						} catch(Exception e) {
							invalidCommand = true;
						}
						if(invalidCommand == false) {
							try {
								internalList.set(iArg, splittedLine[2]);								
							} catch (IndexOutOfBoundsException e) {
								cantCompute = true;
							}
						}
						break;
					case "remove-first":
						if(splittedLine.length != 2 || isValidWord(splittedLine[1]) == false) {
							invalidCommand = true;
						}else {
							int indexW = internalList.indexOf(splittedLine[1]);
							if(indexW == -1) {
								cantCompute = true;
							}else {								
								internalList.remove(indexW);
							}
						}
						break;
					case "remove-all":
						if(splittedLine.length != 2 || isValidWord(splittedLine[1]) == false) {
							invalidCommand = true;
						}else {
							int indexW = internalList.indexOf(splittedLine[1]);
							if(indexW == -1) {
								cantCompute = true;
							}else {
								internalList.removeAll(Arrays.asList(splittedLine[1]));			
							}
						}
						break;
					case "sort":
						Collections.sort(internalList);
						break;
					case "reverse":
						Collections.reverse(internalList);
						break;
				}				
			}
			
			if(invalidCommand == true) {
				System.out.println("INVALID COMMAND");
			} else if(cantCompute == true) {
				System.out.println("DOES NOT COMPUTE");
			}
		}
	}
	public static boolean isValidWord(String supposedWord) {
		return supposedWord.matches("[a-zA-Z0-9]+");
	}

}
