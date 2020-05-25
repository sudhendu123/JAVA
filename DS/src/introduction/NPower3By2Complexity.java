

package introduction;

public class NPower3By2Complexity {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		System.out.println(nPower3By2(n));
	}
	public static int nPower3By2(int n){
		int i=1, j;
		int count = 0;
		int sum = 0;
		for (i = 0; i <n; i++){
			j = 0;
			while(sum<i){
				sum = sum + j;
				j++;
				count++;
			}			
		}
		return count;
	}
}
