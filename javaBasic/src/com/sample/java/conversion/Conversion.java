package com.sample.java.conversion;

import java.util.BitSet;

public class Conversion {

	public static void main(String[] args) {
		//System.out.println("out= "+getRecordDataForGroup("3", true, false, false));
		
		int nxtGenCatAccess =0;
		int corp=0;
		int nxtGenCatAccess_FAN_BAN=0;
		int nxtGenCatAccess1 = (nxtGenCatAccess==1) ? 1 : (nxtGenCatAccess_FAN_BAN==1) ? 1 : (corp==1) ? 1 :0;
		System.out.println(nxtGenCatAccess1);
		
		System.out.println(convertLongToBitSet(281471754558974L));
	}
	
	private static BitSet convertLongToBitSet(long longValue) {
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
	

	public static Integer getRecordDataForGroup(String groupRecordingFs, boolean mcsPttRecordingFlag,
			boolean mcsDataRecordingFlag, boolean mcsVideoRecordingFlag) {

		if (groupRecordingFs == null || groupRecordingFs.isEmpty()) {
			return null;
		}
		if (!mcsPttRecordingFlag && !mcsDataRecordingFlag && !mcsVideoRecordingFlag) {
			return 0;
		}

		String bitPosition = getBitFromDecimalRecord(groupRecordingFs); // 000 , 001, 010

		if (!mcsPttRecordingFlag) {
			bitPosition.replace(bitPosition.charAt(2), '0');
		}
		if (!mcsDataRecordingFlag) {
			bitPosition.replace(bitPosition.charAt(1), '0');
		}
		if (!mcsVideoRecordingFlag) {
			bitPosition.replace(bitPosition.charAt(0), '0');
		}
		return getDecimalRecordFromBit(bitPosition);
	}

	public static String getBitFromDecimalRecord(String groupRecordingFs) {
		return String.format("%3s", Integer.toBinaryString(Integer.parseInt(groupRecordingFs))).replace(" ", "0");
	}

	private static int getDecimalRecordFromBit(String bitPosition) {
		return Integer.parseInt(bitPosition, 2);
	}
}
