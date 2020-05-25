package miscconcepts;


public class Equilibrium {	
	public static int equilibrium(int[] A){
		int sum = 0;
		int leftsum = 0;
		int i;
		
		for(i = 0;i<A.length;i++){
			sum += A[i];
		}
		
		for(i = 0; i<A.length;i++){
			sum -= A[i];
			if(leftsum == sum){
				return i;
			}
			leftsum += A[i];
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] A = {-7,1,5,2,-4,3,0};
		System.out.print(equilibrium(A));	// Would Print 3
	}
}