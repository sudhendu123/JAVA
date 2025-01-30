package com.sample.java.prgm.pattern.star;

public class APyramidPattern {

	public static void main(String args[]) // driver function
	{
		int n = 5;
		pyramidPattern(n);
	}

	public static void pyramidPattern(int row) {
		// i for rows and j for columns
		// row denotes the number of rows you want to print
		int i, j;
		// Outer loop work for rows
		for (i = 0; i < row; i++) {//0,1,2,3,4
			// inner loop work for space
			for (j = row - i; j > 1; j--) {//5,4,3,2
				// prints space between two stars
				System.out.print(" ");
			}
			// inner loop for columns
			for (j = 0; j <= i; j++) { //0,1,2,3,4
				// prints star
				System.out.print("* ");
			}
			// throws the cursor in a new line after printing each line
			System.out.println();
		}
	}

}
