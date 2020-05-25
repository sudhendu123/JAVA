


package introduction;

public class NComplexity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 19;
		System.out.println(orderN(n));
	}
	public static int orderN(int n){
		int count = 0;
		for (int i = 1; i<n;){
			count ++;
			i = i+1;
		}
		return count;
	}
}
