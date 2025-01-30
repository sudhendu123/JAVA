package com.prac.ds.math;

/**
 * 
 * A = "10", B = "01" Output: 11 Explanation: 10 + 01 11
 *
 *
 * Input: A = "1101", B = "111" Output: 10100 Explanation: 1101 + 111 10100
 * 
 * 0+1=1, 1+0=1 , 1+1=0 carry(1), 0+0=0
 * 48,30=0 , 49,31=1
 * 
 * 0%2=0, 1%2=1, 2%2=0, 3%2=1
 * carry= 0/2=0, 1/2=0 , 2/2=1 , 3/2=1
 * 
 * 1-'0'=1 0-'0'=0
 * A.charAt(a)=1= converted to int is 49(ascii), - '0' to convert to int of 49 =1 
 */
public class AddBinaryStrings67 {

	public static void main(String[] args) {
		//System.out.println("out :" + addBinary("10", "01"));
		System.out.println("out :" + addBinary("1101", "111")); //10100
	}

	public static String addBinary(String A, String B) {
		int a = A.length() - 1; //1101=A.length()=4 
		int b = B.length() - 1; //111=B.length()=3
		int carry = 0;

		int sum = 0;
		StringBuilder sb = new StringBuilder();
		while (a >= 0 || b >= 0 || carry == 1) {
			sum = carry;
			if (a >= 0)
				sum = sum + A.charAt(a) - '0';
			if (b >= 0)
				sum = sum + B.charAt(b) - '0';
			sb.append((char) (sum % 2 + '0'));
			carry = sum / 2;
			a--;
			b--;

		}

		sb.reverse();
		int s = 0;
		boolean flag = false;
		while (sb.charAt(s) == '0') {
			flag = true;
			s++;
		}

		if (flag)
			sb.delete(0, s);
		return sb.toString();

	}

	public static String addBinary1(String A, String B) {
		// code here
		java.math.BigInteger x = new java.math.BigInteger(A, 2);
		java.math.BigInteger y = new java.math.BigInteger(B, 2);
		java.math.BigInteger z = x.add(y);

		String str = z.toString(2);
		return str;
	}

}
