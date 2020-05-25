

package searching;

public class BinarySearchRotatedIterative {
    public boolean search(int[] A, int data) {
        int left = 0;
        int right = A.length - 1;
        while(left <= right){
            // Avoid overflow
            int mid = left + (right - left) / 2;
            if(A[mid] == data)
                return true;
            
            // the bottom half is sorted;
            if(A[left] < A[mid]){
                if(A[left] <= data && data < A[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            
            // the upper half is sorted;
            else if(A[left] > A[mid]){
                if(A[mid] < data && data <= A[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }else{
                // skip duplicate one, A[start] == A[mid];
                left++;
            }
        }
        return false;
    }
}
