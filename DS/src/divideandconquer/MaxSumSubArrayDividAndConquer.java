

package divideandconquer;

public class MaxSumSubArrayDividAndConquer {
    public int maxSumSubArray(int[] A) {
		if (A.length == 0)
			return 0;
		return maxSumSubArray(A, 0, A.length - 1);
	}
	// overloading...
	public int maxSumSubArray(int[] A, int low, int high) {
		int leftMidSum = Integer.MIN_VALUE, rightMidSum = Integer.MIN_VALUE, sum = 0;
		if (low == high)
			return A[low];
		int mid = low + (high - low) / 2;
		int maxLeftSum = maxSumSubArray(A, low, mid);
		int maxRightSum = maxSumSubArray(A, mid + 1, high);
		// across sum
		for (int i = mid; i >= low; i--) {
			sum += A[i];
			leftMidSum = (sum > leftMidSum) ? sum : leftMidSum;
		}
		// reset sum as 0
		sum = 0;
		for (int i = mid + 1; i <= high; i++) {
			sum += A[i];
			rightMidSum = (sum > rightMidSum) ? sum : rightMidSum;
		}
		return max3(maxLeftSum, maxRightSum, (leftMidSum + rightMidSum));
	}
 
	public int max3(int a, int b, int c) {
		return a > b ? (a > c ? a : c) : (b > c ? b : c);
	}
}
