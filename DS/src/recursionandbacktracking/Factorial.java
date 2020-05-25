

package recursionandbacktracking;

public class Factorial {	
	public int factorial(int n) {	
		// base cases: fact of 0 is 1
		if(n == 0) 
			return 1;
		// recursive case: multiply n by (n-1) factorial
		else 
			return n*factorial(n-1);
	}
}

