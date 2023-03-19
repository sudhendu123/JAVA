package com.prac.ds.math;

import java.util.Stack;

/**
 * 
 * Given a string s representing a valid expression, implement a basic
 * calculator to evaluate it, and return the result of the evaluation.
 *
 * Example 1:
 * 
 * Input: s = "1 + 1" Output: 2 Example 2:
 * 
 * Input: s = " 2-1 + 2 " Output: 3 Example 3:
 * 
 * Input: s = "(1+(4+5+2)-3)+(6+8)" Output: 23
 */
public class BasicCalculator224 {
	public static void main(String[] args) {
		
		System.out.println("cal result:"+calculate("2+2"));
		System.out.println("cal result:"+calculate("12+24"));

	}

	public static int calculate(String s) {
		int sign = 1;
		int sum = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				int num = 0;
				while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				sum += num * sign;
				i--;
			} else if (s.charAt(i) == '+')
				sign = 1;
			else if (s.charAt(i) == '-')
				sign = -1;
			else if (s.charAt(i) == '(') {
				stack.push(sum);
				stack.push(sign);
				sum = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				sum = stack.pop() * sum;
				sum += stack.pop();
			}
		}
		return sum;
	}

}
