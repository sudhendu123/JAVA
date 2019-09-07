package com.sample.java.uuid;

import java.util.UUID;
//A UUID is made of up of hex digits  (4 chars each) along with 4 “-” symbols which make its length equal to 36 characters.
public class uuidTest {

	public static void main(String[] args) {
		getClockSeq();
		getLeastSignBit();
		getMostSignBit();
		namedUUIDFromBytes();
		getLongNode();
		getRandomUUID();
		getTimeStamp();
	}
	
	
	private static void getClockSeq() {
		UUID gfg = UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"); 
        
        // checking clock sequence 
        System.out.println(gfg.clockSequence()); 
	}
	
	private static void getLeastSignBit() {
		UUID gfg = UUID.randomUUID(); 
        
        // checking the least significatnt bit 
        System.out.println("Least significant bit " +  
                gfg.getLeastSignificantBits()); 
	}
	
	private static void getMostSignBit() {
		UUID gfg = UUID.randomUUID(); 
        
        // checking the most significatnt bit 
        System.out.println("Most significant bit " +  
                gfg.getMostSignificantBits()); 
	}
	
	private static void namedUUIDFromBytes() {
		// creating byte array 
        byte[] b = {10, 23, 45}; 
          
        // creating UUID from array 
        UUID gfg = UUID.nameUUIDFromBytes(b); 
          
        // checking UUID 
        System.out.println("namedUUIDFromBytes: "+gfg); 
	}
	
	private static void getLongNode() {
		UUID gfg = UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"); 
        
        // checking node value for this UUID 
        System.out.println("Node value: "
          + gfg.node()); 
	}
	private static void getRandomUUID() {
		UUID gfg = UUID.randomUUID(); 
        
        // checking  this UUID 
        System.out.println("UUID: "
          + gfg); 
	}
	
	private static void getTimeStamp() {
		UUID gfg = UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"); 
        
        // checking time satmp for this UUID 
        System.out.println("time stamp: "
          + gfg.timestamp()); 
	}
}
