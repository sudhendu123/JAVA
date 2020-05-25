

package dynamicprogramming;

public class FibonacciWithDP {
	private static int[] fib;	

	public static int fibonacciWithDP(int n) {
	   int[] fib = new int[n + 1];
	   for (int i = 0; i < fib.length; i++) {
	      if (i == 0) {
	         fib[i] = 0;
	      } else if (i == 1) {
	         fib[i] = 1;
	      } else {
	         fib[i] = fib[i - 2] + fib[i - 1];
	      }
	   }
	   return fib[n];
	}
	public static int fibonacciWithDP2(int n) {
      if (n == 0) {
         return fib[n] = 0;
      } else if (n == 1) {
    	 return fib [n] = 1;
      } else {
    	  return fib[n] = fibonacciWithDP2(n - 2) + fibonacciWithDP2(n - 1);
      }
	}
	public static void main(String[] args) {
		int n = 5;
		fib = new int[n + 1];
		System.out.println(fibonacciWithDP2(5));
	}
}
