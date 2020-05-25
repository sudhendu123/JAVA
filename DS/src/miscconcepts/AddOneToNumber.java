


package miscconcepts;

public class AddOneToNumber {
	public int[] addOneToNumber(int[] digits) {
		int[] result = new int[digits.length];
		int one = 1;
		
		for(int i = digits.length-1;i>=0;i--){
			result[i] = (digits[i]+one) % 10;
			one = (digits[i]+one) / 10;
		}
		
		if(one!=0){
			int[] more = new int[digits.length+1];
			more[0] = one;
			System.arraycopy(result, 0, more, 1, result.length);
			result = more;
		}
		return result;		
	}
}