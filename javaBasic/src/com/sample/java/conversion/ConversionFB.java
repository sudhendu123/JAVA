package com.sample.java.conversion;

import java.math.BigInteger;
import java.util.BitSet;

public class ConversionFB {

	public static void main(String[] args) {
		
		BitSet out = convertLongToBitSet(4610841387338815359L);
		System.out.println("out :"+out);
		BitSet clientFS_BitSet = convertHexStringToBitSet("FC3DC301729B23EFBEC2050C04FFD8C33");
		BitSet subsFS_BiSet = convertHexStringToBitSet("3FC23CFBF12FFFFFFFBFDDFFDF6FFFD57F");
		BitSet opsFS_BiSet = convertHexStringToBitSet("3FFEFC07FCEDFFFFFFFFE77FDFBD1FDFFF");
		BitSet confFS_BitSet = convertHexStringToBitSet("3FFEFC07FCEDFFFFFFFFE77FDFBD1FDFFF");
		BitSet license_BitSet = convertBinStringToBitSet(
				"11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		// BitSet license_BitSet =
		// convertBinStringToBitSet("0b11111111111110111111000000011111111100111011011111111111111111111111111111111111100111011111111101111110111101000111111101111111111111");
		// BitSet license_BitSet
		// =convertHexStringToBitSet("3FFEFC07FCEDFFFFFFFFE77FDFBD1FDFFF");
		System.out.println(" license_BitSet :" + license_BitSet);
		BitSet xdmsFS_BiSet = convertHexStringToBitSet("3FFFFFFFFFEFFFFFFFFFFFFFDFF7FFDFF7");

		BitSet activeFS_BitSet = new BitSet(Long.SIZE);
		activeFS_BitSet.or(license_BitSet);
		activeFS_BitSet.and(clientFS_BitSet);
		activeFS_BitSet.and(subsFS_BiSet);
		activeFS_BitSet.and(confFS_BitSet);
		activeFS_BitSet.and(opsFS_BiSet);
		activeFS_BitSet.and(xdmsFS_BiSet);
		

		BitSet corpFS_BitSet = convertHexStringToBitSet("383EFC07FCEFFFFFFFFFFFFFDFFFFFDFFF");
		activeFS_BitSet.and(corpFS_BitSet);
		BitSet corpAdminFS_BitSet = convertHexStringToBitSet("383FFCFFFFEFEFFFBFFFFFFFDFFFFFDFFF");
		activeFS_BitSet.and(corpAdminFS_BitSet);
		BitSet userProfileFS_BiSet = convertHexStringToBitSet("3FFFFCFFFFEFFFFFFFFFFFFFDFFFFFDFFF");
		activeFS_BitSet.and(userProfileFS_BiSet);

		BitSet clientCapabilityOverrideFS_BiSet = convertHexStringToBitSet("3FFFFFFFFFEFFFFFFFFFE7FFDF7FFFDFFF");
		activeFS_BitSet.and(clientCapabilityOverrideFS_BiSet);
		
		//activeFS_BitSet.or(license_BitSet);
		
		System.out.println("activeFS_BitSet 1" + activeFS_BitSet);
		String activeFeatureSet = convertBitSetToHexString(activeFS_BitSet);

		System.out.println("activeFeatureSet 1" + activeFeatureSet);

	}

	public static BitSet convertBinStringToBitSet(String value) {
		String methodName = "convertBinStringToBitSet(String)";
		BitSet bitSet = new BitSet(value.length());
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) == '1') {
				bitSet.set(i);
			}
		}
		return bitSet;
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
	
	 public static BitSet convertLongToBitSet(long longValue) {
	        String methodName = "convertLongToBitSet(long)";
	        
	        long value = longValue;
	        BitSet bitSet = new BitSet(Long.SIZE);
	        int index = 0;
	        while (value != 0) {
	            if (value % 2L != 0) {
	                bitSet.set(index);
	            }
	            ++index;
	            value = value >>> 1;
	        }
	        
	        return bitSet;
	    }
}
