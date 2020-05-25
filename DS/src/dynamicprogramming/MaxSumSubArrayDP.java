

package dynamicprogramming;

public class MaxSumSubArrayDP {
    public int maxSubArray(int[] A) {
        int maxSum = A[0], sum = 0;
        for(int i = 0; i < A.length; ++i){
            sum = Math.max(sum + A[i], A[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
