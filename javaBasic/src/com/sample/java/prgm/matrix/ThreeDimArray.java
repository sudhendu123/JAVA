

package com.sample.java.prgm.matrix;

public class ThreeDimArray {

	public static void main(String[] args) {

		//x[array_index][row_index][column_index]
		threeDim1();
		threeDim2();
		threeDim3();
		threeDIm4();
	}

	public static void threeDim1() {
		int[][][] arr = new int[10][20][30];
		arr[0][0][0] = 1;

		System.out.println("threeDim1 : arr[0][0][0] = " + arr[0][0][0]);
	}

	public static void threeDim2() {
		int[][][] arr = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };

		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				for (int z = 0; z < 2; z++)
					System.out.println("threeDim2 : arr[" + i + "][" + j + "][" + z + "] = " + arr[i][j][z]);
	}

	public static void threeDim3() {
		int[][][] arr = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };

		System.out.println("threeDim3: arr[0][0][0] = " + arr[0][0][0]);
	}

	public static void threeDIm4() {
		int[][][] arr = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };

		for (int i = 0; i < 2; i++) {

			for (int j = 0; j < 2; j++) {

				for (int k = 0; k < 2; k++) {

					System.out.print(arr[i][j][k] + " ");
				}

				System.out.println();
			}
			System.out.println();
		}
	}
}
