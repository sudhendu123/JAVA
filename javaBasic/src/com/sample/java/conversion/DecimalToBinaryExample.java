package com.sample.java.conversion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DecimalToBinaryExample {
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(10));
		System.out.println(Integer.toBinaryString(21));

		System.out.println("Decimal of 10 is: ");
		toBinary(10);
	}

	public static void toBinary(int decimal) {
		List<Integer> list = new ArrayList<>();
		while (decimal > 0) {
			list.add(decimal % 2);
			decimal = decimal / 2;
		}
		Collections.reverse(list);
		System.out.println(list);
	}
}
