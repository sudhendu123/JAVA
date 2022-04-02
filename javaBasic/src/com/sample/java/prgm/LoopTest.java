package com.sample.java.prgm;

public class LoopTest {

	public static void main(String[] args) {
		
		breakTest();
		System.out.println("---------------------------nestedBreakLoop----------------------");
		nestedBreakLoop();
		System.out.println("---------------------------continue----------------------");
		continueTest();
		System.out.println("---------------------------outer----------------------");
		outerLoop();
	}

	public static void breakTest() {
		/**
		 * the break statement is used to break the current flow of the program and
		 *  transfer the control to the next statement outside a loop or switch statement.
		 *   However, it breaks only the inner loop in the case of the nested loop.
		 *   
		 *   The break statement cannot be used independently in the Java program, i.e., 
		 *   it can only be written inside the loop or switch statement.
		 */
		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
			if (i == 6) {
				break;
			}
		}
	}
	
	/**
	 * Unlike break statement, the continue statement doesn't break the loop, 
	 * whereas, it skips the specific part of the loop and jumps to the next iteration of the loop immediately.
	 */
	public static void continueTest() {
		for (int i = 0; i <= 2; i++) {

			for (int j = i; j <= 5; j++) {

				if (j == 4) {
					continue;
				}
				System.out.println(j);
			}
		}

	}
	
	public static void outerLoop() {
		a: 
			for (int i = 0; i <= 10; i++) {
			b: 
				for (int j = 0; j <= 15; j++) {
				c: 
					for (int k = 0; k <= 20; k++) {
					System.out.println(k);
					if (k == 5) {
						break a;
					}
				}
			}
		}
	}
	
	public static void nestedBreakLoop() {
		 
			
				for (int j = 0; j <= 2; j++) {
			
					for (int k = 0; k <= 4; k++) {
					System.out.println(k);
					if (k == 2) {
						break;
					}
				}
			}
	}
}
