

package introduction;

public class LogNComplexityUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 19;
		System.out.println(logNUp(n));
	}
	
	public static int logNUp(int n){
		int count = 0;
		for (int i = 1; i<n;){
			count ++;
			i = i *2;
		}
		return count;
	}
}
