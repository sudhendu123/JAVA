package com.sample.java.conversion;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class BitSetToHex {

	public static void main(String[] args) {

		String hex = Integer.toHexString(120);
		BitSet bits = BitSet.valueOf(hex.getBytes());
		int decimal = Integer.parseInt(hex, 16);
		System.out.println(hex);
		System.out.println(bits);
		System.out.println(decimal);
		byte b = 127;
		System.out.println(byteToHex(b));

		String hexString = new BigInteger("01110", 2).toString(16);
		System.out.println(hexString);
		
		Map<Integer, Integer> values=new HashMap<Integer, Integer>();
		values.put(131, 1);
				
		String updatedBits = updateFeatureBit("021C001029A27EBFAFC050C0051D8431",values );
		System.out.println(" updatedBits :"+updatedBits);
		
	}

	public static String byteToHex(byte num) {
		char[] hexDigits = new char[2];
		hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
		hexDigits[1] = Character.forDigit((num & 0xF), 16);
		return new String(hexDigits);
	}

	public static String updateFeatureBit(String featureset, Map<Integer, Integer> values) {
		BitSet bit = convertHexStringToBitSet(featureset);
		for (Map.Entry<Integer, Integer> n1 : values.entrySet()) {
			bit.set(n1.getKey(), n1.getValue() == 1 ? true : false);

		}
		String result = convertBitSetToHexString(bit);
		return result;

	}

	public static BitSet convertHexStringToBitSet(String hexString) {
		String bin = new BigInteger(hexString, 16).toString(2);
		BitSet bitSet = new BitSet(bin.length());
		for (int i = 0; i < bin.length(); i++) {
			boolean value = bin.charAt(i) == '1' ? true : false;
			bitSet.set(bin.length() - 1 - i, value);
		}

		return bitSet;

	}

	public static String convertBitSetToHexString(BitSet bitSet) {
		String hexString = new BigInteger(convertBitSetToBinString(bitSet), 2).toString(16).toUpperCase();
		return hexString;
	}

	public static String convertBitSetToBinString(BitSet bitSet) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < bitSet.size(); i++) {
			if (bitSet.get(i)) {
				buffer.append("1");
			} else {
				buffer.append("0");
			}
		}
		String binString = buffer.reverse().toString();
		return binString;
	}

}
