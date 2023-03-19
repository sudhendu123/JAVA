package com.prac.ds.math;

/**
 * 
 * Given the coordinates of four points in 2D space p1, p2, p3 and p4, return
 * true if the four points construct a square.
 * 
 * The coordinate of a point pi is represented as [xi, yi]. The input is not
 * given in any order.
 * 
 * A valid square has four equal sides with positive length and four equal
 * angles (90-degree angles).
 * 
 * Example 1:
 * 
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1] Output: true Example 2:
 * 
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12] Output: false Example
 * 3:
 * 
 * Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1] Output: true
 *
 */
public class ValidSquare593 {

	public static void main(String[] args) {

		int td[][]= {{0,0},{0,1},{1,0},{1,1}};
		System.out.println("four points:"+fourPointSquare(td));
	}

	/**
	 * 
	 * Example 1:
	 * 
	 * Input: points=(0,0),(0,1),(1,0),(1,1) Output: 1 Explanation: These points
	 * form a square. Example 2:
	 * 
	 * Input: points=(0,0),(1,1),(1,0),(0,2) Output: 0 Explanation: These four
	 * points do not form a square.
	 */
	public static int fourPointSquare(int points[][]) {
		// code here
		int a = Math.abs(points[0][0] - points[0][1]);
		int b = Math.abs(points[1][0] - points[1][1]);
		int c = Math.abs(points[2][0] - points[2][1]);
		int d = Math.abs(points[3][0] - points[3][1]);

		if (a == 0 && a == b && b == c && c == d && d == a) {
			return 0;
		}

		if (a + c == b + d) {
			return 1;
		}
		return 0;
	}

}
