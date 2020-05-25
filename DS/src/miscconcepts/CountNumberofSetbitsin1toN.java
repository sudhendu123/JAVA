


package miscconcepts;

public class CountNumberofSetbitsin1toN {
	public int countNumberofSetbitsin1toN(int n) {
		long i = 0, j, count = 0; 
		for (i = 1; i<=n; i++){
			j = i;
			while(j>0) {
			     count++;
			     j = j & (j - 1); 
			}
		}
		return (int) count;		
	}
}