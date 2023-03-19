package com.prac.ds.math;

import java.util.HashMap;

/**
 * 
 * Given an array of points where points[i] = [xi, yi] represents a point on the
 * X-Y plane, return the maximum number of points that lie on the same straight
 * line.
 *
 * Input: points = [[1,1],[2,2],[3,3]] Output: 3
 * 
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]] Output: 4
 */
public class MaxPointsOnLine149 {

	public static void main(String[] args) {
		int X[] = { 1, 2, 3 };
		int Y[] = { 1, 2, 3 };
		int in[][]= {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
		System.out.println("max points:" + maxPoints(X, Y, 3));
		System.out.println("max points:" + maxPoints(in));
	}

	/**
	 * 
	 * Input: X[] = {1, 2, 3} Y[] = {1, 2, 3} Output: 3 Explanation: The points are
	 * (1,1), (2,2) and (3,3).
	 * 
	 * Input: X[] = {1, 3, 5, 4, 2, 1} Y[] = {1, 2, 3, 1, 3, 4} Output: 4
	 * Explanation: The points are- (1,1),(3,2),(5,3),(4,1),(2,3),(1,4)
	 */
	public static int maxPoints(int X[], int Y[], int N) {
		if (N == 1) {
			return 1;
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			HashMap<Double, Integer> hashMap = new HashMap<>();
			for (int j = 0; j < N; j++) {
				int x1 = X[i];
				int y1 = Y[i];
				int x2 = X[j];
				int y2 = Y[j];
				double m = ((y2 - y1) / ((x2 - x1) * (1.0)));
				hashMap.put(m, hashMap.getOrDefault(m, 0) + 1);
				ans = Math.max(ans, hashMap.get(m));
			}
		}
		return ans + 1;
	}

	/**
	 * This method returns the maximum number of points that lie on the same line
	 * given a set of points represented by the 2D array points 
	 * Input: points = [[1,1],[2,2],[3,3]] 
	 * Output: 3 
	 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]] 
	 * Output: 4
	 */

	public static int maxPoints(int[][] points) {
		// n is the number of points in the array
		int n = points.length;

		// If there are 0 or 1 points, there is at most one line that can be formed
		// (i.e., the line formed by the single point, or no line if there are no
		// points)
		if (n <= 2)
			return n;

		// Initialize the maximum number of points on a line to 2, since there must be
		// at least 2 points to form a line
		int ans = 2;

		// Iterate through all pairs of points
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				// temp is the number of points on the line formed by point i and point j
				int temp = 2;
				// Check if any other points are on the same line as point i and point j
				for (int k = j + 1; k < n; k++) {
					// Check if point k is on the same line as point i and point j
					// This is done by checking if the slope between point i and point k is equal to
					// the slope between point i and point j
					int x = (points[j][1] - points[i][1]) * (points[k][0] - points[i][0]);
					int y = (points[k][1] - points[i][1]) * (points[j][0] - points[i][0]);
					if (x == y) {
						// If the slopes are equal, point k is on the same line as point i and point j
						temp++;
					}
				}
				// Update the maximum number of points on a line if necessary
				if (temp > ans) {
					ans = temp;
				}
			}
		}
		// Return the maximum number of points on a line
		return ans;
	}
}
