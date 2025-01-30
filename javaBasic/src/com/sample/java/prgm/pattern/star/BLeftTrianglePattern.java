package com.sample.java.prgm.pattern.star;

public class BLeftTrianglePattern {
	public static void main(String args[]) {
		// i for rows and j for columns
		// row denotes the number of rows you want to print
		int i, j, row = 6;
		// Outer loop work for rows
		for (i = 0; i < row; i++) { //[0, 1, 2, 3, 4, 5]
			// inner loop work for space
			for (j = 2 * (row - i); j >= 0; j--) { //12,10,8,6,4,2
				// prints space between two stars
				System.out.print(" ");
			}
			// inner loop for columns
			for (j = 0; j <= i; j++) { //[0, 1, 2, 3, 4, 5]
				// prints star
				System.out.print("* ");
			}
			// throws the cursor in a new line after printing each line
			System.out.println();
		}
		
	}

}
