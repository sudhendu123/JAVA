package com.sample.java.prgm;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// abcd... = an + bn + cn + dn + ...
		// 3*3*3 + 7*7*7 + 0*0*0 = 27 + 343 + 0 = 370
		// 4*4*4 + 0*0*0 + 7*7*7 = 64 + 0 + 343 = 407
		armStrongWhile1(153);
		armStrongFor1(153);
		armStrongWhile(370);
		armStrongFor(407);
		armStrongFor(507);
		armStrongRange();

	}

	public static void armStrongWhile1(int num) {
		int originalNum, remainder, result = 0;
		originalNum = num;
		while (originalNum > 0) {
			remainder = originalNum % 10;
			result = result + (remainder * remainder * remainder);
			// quotient
			originalNum = originalNum / 10;
		}
		if (result == num)
			System.out.println(num + " is an Armstrong number.");
		else
			System.out.println(num + " is not an Armstrong number.");
	}

	public static void armStrongFor1(int num) {
		int originalNum, remainder, result = 0;
		for (originalNum = num; originalNum > 0; originalNum = originalNum / 10) {
			remainder = originalNum % 10;
			result = result + (remainder * remainder * remainder);
		}
		if (result == num)
			System.out.println(num + " is an Armstrong number.");
		else
			System.out.println(num + " is not an Armstrong number.");
	}

	public static void armStrongWhile(int num) {
		int originalNum, remainder, result = 0;
		originalNum = num;
		while (originalNum != 0) {
			remainder = originalNum % 10;
			// result = (int) (result+Math.pow(remainder, 3));
			result += Math.pow(remainder, 3);
			originalNum /= 10;
		}
		if (result == num)
			System.out.println(num + " is an Armstrong number.");
		else
			System.out.println(num + " is not an Armstrong number.");
	}

	public static void armStrongFor(int number) {

		int originalNumber, remainder, result = 0, n = 0;
		originalNumber = number;
		for (; originalNumber != 0; originalNumber /= 10) {
			n++;
		}
		originalNumber = number;
		for (; originalNumber != 0; originalNumber /= 10) {
			remainder = originalNumber % 10;
			result += Math.pow(remainder, n);
		}
		if (result == number)
			System.out.println(number + " is an Armstrong number.");
		else
			System.out.println(number + " is not an Armstrong number.");
	}

	public static void armStrongRange() {

		int Number, Sum;
		int Minimum = 1, Maximum = 10000;
		for (Number = Minimum; Number <= Maximum; Number++) {
			Sum = amstrongCheck(Number);

			if (Number == Sum)
				System.out.print(Number + "\t");
		}

	}

	static int amstrongCheck(int Number) {
		int Temp, Reminder, Times = 0, Sum = 0;

		Temp = Number;

		while (Temp != 0) {
			Times = Times + 1;
			Temp = Temp / 10;
		}

		for (Temp = Number; Temp > 0; Temp = Temp / 10) {
			Reminder = Temp % 10;
			Sum = (int) (Sum + Math.pow(Reminder, Times));
		}

		return Sum;
	}
}
