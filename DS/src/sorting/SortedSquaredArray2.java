
 
package sorting;
 
class SortedSquaredArray2 {
  public int[] sortedSquaredArray(int[] A) {
      int n = A.length;
      int j = 0;
      // Find the last index of the negative numbers
      while (j < n && A[j] < 0)
          j++;
      // i points to the last index of negative numbers
      int i = j-1;

      int[] result = new int[n];
      int t = 0;
      // j points to the first index of the positive numbers
      while (i >= 0 && j < n) {
          if (A[i] * A[i] < A[j] * A[j]) {
              result[t++] = A[i] * A[i];
              i--;
          } else {
              result[t++] = A[j] * A[j];
              j++;
          }
      }
      // add the remaining negative numbers squares to result
      while (i >= 0) {
          result[t++] = A[i] * A[i];
          i--;
      }

      // add the remaining positive numbers squares to result
      while (j < n) {
          result[t++] = A[j] * A[j];
          j++;
      }

      return result;
  }
}
