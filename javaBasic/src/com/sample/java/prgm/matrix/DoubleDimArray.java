

package com.sample.java.prgm.matrix;

public class DoubleDimArray {
	
	public static void main(String[] args) {
		
		//x[row_index][column_index]
		double2();
	}

	public static void double1() {
		ThreeDimArray t[]=new ThreeDimArray[2];
		 int[][] arr = new int[10][20]; 
	        arr[0][0] = 1; 
	  
	        System.out.println("arr[0][0] = " + arr[0][0]); 
	}
	
	public static void double2() {
		int[][] arr = { { 1, 2 }, { 3, 4 } }; 
		  
        for (int i = 0; i < 2; i++) 
            for (int j = 0; j < 2; j++) 
                System.out.println("arr[" + i + "][" + j + "] = "
                                   + arr[i][j]); 
        System.out.println("element at 0,1 : "+arr[0][1]);
	}
}
