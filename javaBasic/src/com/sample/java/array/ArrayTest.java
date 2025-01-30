package com.sample.java.array;

public class ArrayTest {
	public static void main(String[] args) {
		// Normally, an array is a collection of similar type of elements which have a
		// contiguous memory location.
		// Array in Java is index-based, the first element of the array is stored at the
		// 0th index,
		// 2nd element is stored on 1st index and so on.
		// Java array is an object which contains elements of a similar data type.
		// We can store only a fixed set of elements in a Java array.
		// Advantages
		// Code Optimization: It makes the code optimized, we can retrieve or sort the
		// data efficiently.
		// Random access: We can get any data located at an index position.
		// Disadvantages
		// Size Limit: We can store only the fixed size of elements in the array.
		// It doesn't grow its size at runtime. To solve this problem,
		// collection framework is used in Java which grows automatically.

		int a[] = new int[5];// declaration and instantiation
		a[0] = 10;// initialization
		a[1] = 20;
		a[2] = 70;
		a[3] = 40;
		a[4] = 50;
		// traversing array
		for (int i = 0; i < a.length; i++)// length is the property of array
			System.out.println(a[i]);

		int a1[] = { 33, 3, 4, 5 };// declaration, instantiation and initialization
		for (int i : a1)
			System.out.println(i);

		printArray(new int[] { 10, 22, 44, 66 });// passing anonymous array to method

		// calling method which returns an array
		int arr[] = get();
		// printing the values of an array
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);

		// declaring and initializing 2D array
		int arr1[][] = { { 1, 2, 3 }, { 2, 4, 5 }, { 4, 4, 5 } };
		// printing 2D array
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr1[i][j] + " ");
			}
		}
		// If we are creating odd number of columns in a 2D array, it is known as a
		// jagged array.
		// In other words, it is an array of arrays with different number of columns.
		// declaring a 2D array with odd columns
		int arr2[][] = new int[3][];
		arr2[0] = new int[3];
		arr2[1] = new int[4];
		arr2[2] = new int[2];
		// initializing a jagged array
		int count = 0;
		for (int i = 0; i < arr2.length; i++)
			for (int j = 0; j < arr2[i].length; j++)
				arr2[i][j] = count++;

		// printing the data of a jagged array
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();// new line
		}

		// getting the class name of Java array
		Class<? extends int[]> c = arr.getClass();
		String name = c.getName();
		// printing the class name of Java array
		System.out.println(name);

		// arraycopy
		char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e', 'i', 'n', 'a', 't', 'e', 'd' };
		// declaring a destination array
		char[] copyTo = new char[7];
		// copying array using System.arraycopy() method
		System.arraycopy(copyFrom, 2, copyTo, 0, 7);
		// printing the destination array
		System.out.println(String.valueOf(copyTo));
		
		//array clone
		int arr3[]={33,3,4,5};  
		System.out.println("Printing original array:");  
		for(int i:arr3)  
		System.out.println(i);  
		  
		System.out.println("Printing clone of the array:");  
		int carr[]=arr3.clone();  
		for(int i:carr)  
		System.out.println(i);  
		  
		System.out.println("Are both equal?");  
		System.out.println(arr3==carr);
		
		//array addition
		int a4[][]={{1,3,4},{3,4,5}};  
		int b4[][]={{1,3,4},{3,4,5}};  
		  
		//creating another matrix to store the sum of two matrices  
		int c4[][]=new int[2][3];  
		  
		//adding and printing addition of 2 matrices  
		for(int i=0;i<2;i++){  
		for(int j=0;j<3;j++){  
		c4[i][j]=a4[i][j]+b4[i][j];  
		System.out.print(c4[i][j]+" ");  
		}  
		System.out.println();//new line  
		}  
		
		//matrix multiplication
		int a5[][]={{1,1,1},{2,2,2},{3,3,3}};    
		int b5[][]={{1,1,1},{2,2,2},{3,3,3}};    
		    
		//creating another matrix to store the multiplication of two matrices    
		int c5[][]=new int[3][3];  //3 rows and 3 columns  
		    
		//multiplying and printing multiplication of 2 matrices    
		for(int i=0;i<3;i++){    
		for(int j=0;j<3;j++){    
		c5[i][j]=0;      
		for(int k=0;k<3;k++)      
		{      
		c5[i][j]+=a5[i][k]*b5[k][j];      
		}//end of k loop  
		System.out.print(c5[i][j]+" ");  //printing matrix element  
		}//end of j loop  
		System.out.println();//new line    
		}  
	}

	public static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	// creating method which returns an array
	static int[] get() {
		return new int[] { 10, 30, 50, 90, 60 };
	}
}
