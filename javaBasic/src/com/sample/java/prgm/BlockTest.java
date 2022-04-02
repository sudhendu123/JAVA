package com.sample.java.prgm;

public class BlockTest {

	public static void main(String args[]) {

		Boolean b = 21 >= 21;
		block4: {

			block1: {
				block2: {
					block3: {
						if (b)
							break block2;

						System.out.println("block 3");
					}
					System.out.println("block 2");

				}
				System.out.println("block 1");
			}
		}
		System.out.println("block 4");
	}

}
