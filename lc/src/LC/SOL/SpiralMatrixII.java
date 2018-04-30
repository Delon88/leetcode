package LC.SOL;

public class SpiralMatrixII {
    class Solution {
        public int[][] generateMatrix(int n) {
            if ( n < 1) return new int[0][0];
            int rowStart = 0, rowEnd = n - 1;
            int colStart = 0, colEnd = n - 1;
            int k = 1;
            int[][] m = new int[n][n];
            while ( rowStart <= rowEnd && colStart <= colEnd) {
                // left -> right;
                for ( int i = colStart; i <= colEnd;  i++ ) {
                    m[rowStart][i] = k++;
                }
                // top -> down
                rowStart++;
                for ( int i = rowStart ; i <= rowEnd ; i++ ) {
                    m[i][colEnd] = k++;
                }
                colEnd--;
                if ( rowStart <= rowEnd) {
                    for ( int i = colEnd ; i >= colStart; i--) {
                        m[rowEnd][i] = k++;
                    }
                }
                rowEnd--;
                if ( colStart <= colEnd ) {
                    for ( int i = rowEnd ;  i >= rowStart ; i--) {
                        m[i][colStart] = k++;
                    }
                }
                colStart++;
            }
            return m;
        }
    }
}
