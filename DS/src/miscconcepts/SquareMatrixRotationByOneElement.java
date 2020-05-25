


package miscconcepts;

public class SquareMatrixRotationByOneElement {
	int[][] rotateByOneElementClockwise(int[][] matrix) {

        final int n = matrix.length;
        int[][] roataedMatrix = new int[n][n];
        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < n; j++) {
                if(i+j<n-1 && i<=j) {
                    // move right
                    roataedMatrix[i][j+1] = matrix[i][j];
                } else if(i+j>n-1 && i>=j) {
                    // move left
                    roataedMatrix[i][j-1] = matrix[i][j];
                } else if(i+j<=n-1 && i>j){
                    // move up
                    roataedMatrix[i-1][j] = matrix[i][j];
                } else if(i+j>=n-1 && i<j) {
                    // move down
                    roataedMatrix[i+1][j] = matrix[i][j];
                } else {
                    roataedMatrix[i][j] = matrix[i][j];
                }
            }
        }
        return roataedMatrix;
    }
}