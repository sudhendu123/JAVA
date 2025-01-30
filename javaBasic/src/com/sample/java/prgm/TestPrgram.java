package com.sample.java.prgm;

import java.util.List;

import com.sample.java.array.ArrayTest;

public class TestPrgram {

	public static void main(String[] args) {
		generics("abc", 3);
	}

	public static void generics(String com, int sal) {
		int i=1;
		while(i<4) {
			System.out.println(" com " + com + " : sal :" + sal);

			if (sal == 3) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//genericsLoop(com,sal);
					i++;
				}
		}
				
	}
	
	public static void genericsLoop(String com, int sal) {
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println(" com " + com + " : sal :" + sal);

			
	}

}
