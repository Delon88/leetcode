package LC.SOL;

public class ReshapetheMatrix {
    class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int m = nums.length, n = nums[0].length;
            if ( m * n != r * c ) return nums;
            int[][] ret = new int[r][c];
            for ( int i = 0 ; i < m * n ; i++) {
                ret[i / c][i % c] = nums[i / n][i % n];
            }
            return ret;
        }
    }
}
