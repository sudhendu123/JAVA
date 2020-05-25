


package dynamicprogramming;

public class RecursiveFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(recursiveFibonacci(5));
	}
    public static int recursiveFibonacci(int n) {
		if(n == 0) 
			return 0;
		if(n == 1) 
			return 1;
		return recursiveFibonacci(n -1) + recursiveFibonacci(n -2);
    }

}
