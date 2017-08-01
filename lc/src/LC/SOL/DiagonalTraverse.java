package LC.SOL;

public class DiagonalTraverse {
    public class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) return new int[0];
            int m = matrix.length, n = matrix[0].length;

            int[] ret = new int[m * n];
            int[][] dir = {{-1, 1}, {1, -1}};
            int d = 0;
            int row = 0, col = 0;
            for (int i = 0; i < ret.length; i++) {
                ret[i] = matrix[row][col];
                row += dir[d][0];
                col += dir[d][1];
                if ( row >= m ) { row = m - 1; col += 2; d = 1 -d ;}
                if ( col >= n ) { col = n - 1 ; row += 2 ; d = 1 -d ;}
                if ( row < 0 )  { row = 0 ; d = 1 - d;}
                if ( col < 0 )  { col = 0 ; d = 1 - d;}
            }
            return ret;
        }
    }
}


