package com.sample.java.basic;

public class ControlFlow {

	public static void main(String[] args) {
		switch1(20);
		switch1(40);
		switchVowel('a');
		switchVowel('z');
		switchNoBreak(10);
		switchNoBreak(1);
		nestedSwitch(2, "CSE");
		switchEnum();
		switchChar('1');
		switchChar('2');
		
	}

	public static void switch1(int number) {

		switch (number) {
		// Case statements
		case 10:
			System.out.println("10");
			break;
		case 20:
			System.out.println("20");
			break;
		case 30:
			System.out.println("30");
			break;
		// Default case statement
		default:
			System.out.println("Not in 10, 20 or 30");
		}
	}

	public static void switchChar(char ch) {

		switch (ch) {
		case '1':
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
		case 3:
			System.out.println("3");
		default:
			System.out.println("default");
		}
	}

	public static void switchVowel(char ch) {

		switch (ch) {
		case 'a':
			System.out.println("Vowel");
			break;
		case 'e':
			System.out.println("Vowel");
			break;
		case 'i':
			System.out.println("Vowel");
			break;
		case 'o':
			System.out.println("Vowel");
			break;
		case 'u':
			System.out.println("Vowel");
			break;
		case 'A':
			System.out.println("Vowel");
			break;
		case 'E':
			System.out.println("Vowel");
			break;
		case 'I':
			System.out.println("Vowel");
			break;
		case 'O':
			System.out.println("Vowel");
			break;
		case 'U':
			System.out.println("Vowel");
			break;
		default:
			System.out.println("Consonant");
		}
	}

	public static void switchNoBreak(int number) {

		switch (number) {
		// switch cases without break statements
		case 10:
			System.out.println("10");
		case 20:
			System.out.println("20");
		case 30:
			System.out.println("30");
		default:
			System.out.println("Not in 10, 20 or 30");
		}
	}

	public static void nestedSwitch(int year, String branch) {
		switch (year) {
		case 1:
			System.out.println("elective courses : Advance english, Algebra");
			break;
		case 2:
			switch (branch) // nested switch
			{
			case "CSE":
			case "CCE":
				System.out.println("elective courses : Machine Learning, Big Data");
				break;

			case "ECE":
				System.out.println("elective courses : Antenna Engineering");
				break;

			default:
				System.out.println("Elective courses : Optimization");
			}
		}
	}

	public enum day {
		Sun, Mon, Tue, Wed, Thu, Fri, Sat
	}

	public static void switchEnum() {

		switch (day.Fri) {
		case Sun:
			System.out.println("Sunday");
			break;
		case Mon:
			System.out.println("Monday");
			break;
		case Tue:
			System.out.println("Tuesday");
			break;
		case Wed:
			System.out.println("Wednesday");
			break;
		case Thu:
			System.out.println("Thursday");
			break;
		case Fri:
			System.out.println("Friday");
			break;
		case Sat:
			System.out.println("Saturday");
			break;
		}
	}
}
