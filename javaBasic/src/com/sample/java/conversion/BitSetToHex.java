package com.sample.java.conversion;

import java.math.BigInteger;
import java.util.BitSet;

public class BitSetToHex {

	public static void main(String[] args) {
		
		String hex = Integer.toHexString(120);
		BitSet bits = BitSet.valueOf(hex.getBytes());
		int decimal = Integer.parseInt(hex, 16);
		System.out.println(hex);
		System.out.println(bits);
		System.out.println(decimal);
		byte b=127;
		System.out.println(byteToHex(b));
		
		String hexString = new BigInteger("01110", 2).toString(16);
		System.out.println(hexString);
	}
	
	public static String byteToHex(byte num) {
	    char[] hexDigits = new char[2];
	    hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
	    hexDigits[1] = Character.forDigit((num & 0xF), 16);
	    return new String(hexDigits);
	}
	
	
}
