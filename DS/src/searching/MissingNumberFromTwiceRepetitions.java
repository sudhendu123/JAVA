

package searching;

public class MissingNumberFromTwiceRepetitions {
	public int singleMissingNumber(int[] A){
	    int missingNum = A[0];
	    for(int i = 1; i < A.length; i++){
		missingNum ^= A[i];
	    }
	    return missingNum;
	}
}
