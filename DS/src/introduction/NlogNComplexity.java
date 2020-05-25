


package introduction;

public class NlogNComplexity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 19;
		System.out.println(nLogN(n));
	}
	public static int nLogN(int n){
		int count = 0;
		for (int i = 1; i<n;i = i *2){
			for (int j = 1; j<n;j++){
				count ++;
			}
		}
		return count;
	}
}

