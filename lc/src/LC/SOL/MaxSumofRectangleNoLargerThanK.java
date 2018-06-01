package LC.SOL;

import java.util.TreeSet;


public class MaxSumofRectangleNoLargerThanK {


//    Given matrix = [
//            [1,  0, 1],
//            [0, -2, 3]
//            ]
//    k = 2

    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int target) {
            if ( matrix == null  || matrix.length == 0 ) return 0;
            int row = matrix.length;
            int col = matrix[0].length;
            int m = Math.min(row, col);
            int n = Math.max(row, col);
            boolean isColBigger = col > row;
            int ret = Integer.MIN_VALUE;
            for ( int i = 0 ; i < m; i++) {
                int[] sums = new int[n];
                // sum from row j to i;
                for ( int j = i ; j >= 0 ; j-- ) {
                    int tmp = 0 ;
                    TreeSet<Integer> set = new TreeSet<>();
                    set.add(0);
                    for ( int k = 0 ; k < n ; k++ ) {
                        sums[k] += isColBigger ? matrix[j][k] : matrix[k][j];
                        tmp += sums[k];
                        Integer ceil = set.ceiling(tmp - target );
                        if ( ceil != null ) {
                            ret = Math.max(ret, tmp - ceil);
                        }
                        set.add(tmp);
                    }
                }
            }
            return ret;
        }
    }
}
