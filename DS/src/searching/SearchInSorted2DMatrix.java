

package searching;

public class SearchInSorted2DMatrix {
    public boolean searchMatrix(int[][] A, int target) {
        int length = A.length;
        int width = A[0].length;
        int start = 0; 
        int end = width * length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            int x = mid / width;
            int y = mid % width;
            if(A[x][y] == target)
                return true;
            else if(A[x][y] > target)
                end = mid - 1;
            else 
                start = mid + 1;
        }
        return false;
    }
}
