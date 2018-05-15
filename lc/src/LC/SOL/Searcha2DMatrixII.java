package LC.SOL;

public class Searcha2DMatrixII {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if ( matrix == null || matrix.length == 0 ) return false;
            int m = matrix.length, n = matrix[0].length;
            int row = 0, col = n - 1;
            while ( col >= 0 && row < m ) {
                if ( matrix[row][col] < target ) {
                    row++;
                } else if ( matrix[row][col] > target  ) {
                    col--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
