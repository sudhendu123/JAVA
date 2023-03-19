package com.prac.ds.math;

/**
 * 
 * Given a positive integer N, return its corresponding column title as it would
 * appear in an Excel sheet. For N =1 we have column A, for 27 we have AA and so
 * on.
 * 
 * 1-26=A-z(26) 27-702(26x26)=AA-ZZ 703-AAA-zzz(26x26x26)
 * 
 * Example 1:
 * 
 * Input: N = 51 Output: AY
 * 
 * Example 2: Input: columnNumber = 1 Output: "A"
 * 
 * Example 3: Input: columnNumber = 28 Output: "AB"
 * 
 * Example 4: Input: columnNumber = 701 Output: "ZY"
 *
 */
public class ExcelSheetColumnTitle168 {

	public static void main(String[] args) {
		System.out.println("convert 51:" + convertToTitle(51));
		System.out.println("convert 28:" + convertToTitle(28));
		System.out.println("convert 1:" + convertToTitle(1));
		System.out.println("convert 701:" + convertToTitle1(701));
	}

	/**
	 * 
	 * N=701
	 * =
	 * 
	 */
	public static String convertToTitle1(int N) {
		// Your code here
		String ans = "";

		while (N > 0) {
			int rem = N % 26;
			if (rem == 0) {
				//for handling z case where 26%26=0
				ans = "Z" + ans;
				N = N / 26 - 1;
			} else {
				//rem=1=A
				//rem=2=B
				//rem=10=J
				//int c = 65 + (rem - 1);
				//char cc = (char) c;
				char cc=(char) ('A'+(rem-1));
				N = N/26;
				ans = cc + ans;
			}
		}
		return ans;

	}

	public static String convertToTitle(int columnNumber) {
		String ans = "";
		while (columnNumber > 0) {
			columnNumber--;
			ans = (char) ('A' + (columnNumber % 26)) + ans;
			columnNumber = columnNumber / 26;
		}
		return ans;
	}

}
