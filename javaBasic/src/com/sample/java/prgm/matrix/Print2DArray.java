package com.sample.java.prgm.matrix;

public class Print2DArray {
	
	public static void main(String[] args) {
		 int mat[][] = { { 1, 2, 3, 4 },
                 { 5, 6, 7, 8 },
                 { 9, 10, 11, 12 } };
 print2D(mat);
 print2DA(mat);
	}
	
	public static void print2DA(int mat[][])
    {
        // Loop through all rows
        for (int[] row : mat)
 
            // Loop through all columns of current row
            for (int x : row)
                System.out.print(x + " ");
    }
	
	public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++)
 
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
    }

}
