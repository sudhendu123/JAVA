


package introduction;

public class SquareRootNComplexity {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		System.out.println(squareRootN(n));
	}
	public static int squareRootN(int n){
		int i=1;
		int sum = 0;
		while(sum<n){
			sum = sum + i;
			i++;
		}
		return i-1;
	}
}
