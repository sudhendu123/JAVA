package com.sample.java.prgm.string;

public class StringPadding {
	public static void main(String[] args) {

		String str = "JAVARocks";
		char ch = '#';
		int L = 15;

		System.out.println(leftPadding(str, ch, L));
		System.out.println(rightPadding(str, ch, L));
	}

	// Function to perform left padding
	public static String leftPadding(String input, char ch, int L) {

		String result = String

				// First left pad the string
				// with space up to length L
				.format("%" + L + "s", input)

				// Then replace all the spaces
				// with the given character ch
				.replace(' ', ch);

		// Return the resultant string
		return result;
	}

	// Function to perform right padding
	public static String rightPadding(String input, char ch, int L) {

		String result = String

				// First right pad the string
				// with space up to length L
				.format("%" + (-L) + "s", input)

				// Then replace all the spaces
				// with the given character ch
				.replace(' ', ch);

		// Return the resultant string
		return result;
	}

}
