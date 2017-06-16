package maximumhourglass;

public class Main {
	public static int maxHourglass(int[][] matrix) {
		int maxHour = 0;
		int thisHour;
		for(int row=0;row<4;row++) {
			// int counter for row, because the hourglass has
			// a height of 3, we only have to go till the 4th row.
			for(int column=0;column<4;column++) {
				// int counter for column, because the hourglass
				// has a width of 3, we only have to go till the 
				// 4th column.
					
				// Calculate the hour for this hourGlass,
				// indexes are hardcoded.
				// matrix[row][column] is the top left part
				// of the hourglass.
				thisHour = matrix[row][column];;
				thisHour += matrix[row][column+1];;
				thisHour += matrix[row][column+2];;
				thisHour += matrix[row+1][column+1];;
				thisHour += matrix[row+2][column];;
				thisHour += matrix[row+2][column+1];;
				thisHour += matrix[row+2][column+2];;
				
				// if this hour is bigger than maxHour,
				// replace it
				if(thisHour > maxHour) maxHour = thisHour;
			}
		}
		return maxHour;
	}

}
