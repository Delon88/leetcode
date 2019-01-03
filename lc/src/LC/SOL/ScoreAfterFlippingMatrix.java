package LC.SOL;

public class ScoreAfterFlippingMatrix {
    class Solution {
        public int matrixScore(int[][] A) {
            int m = A.length, n = A[0].length, ret = ( 1 << ( n - 1)) * m;
            for ( int col = 1 ; col < n ; col++) {
                int cur = 0;
                for ( int row = 0 ; row < m ; row++) cur += ( A[row][col] == A[row][0] ? 1 : 0);
                // toggle col if there is more zeros;
                ret += Math.max(cur , m - cur) * (  1 << ( n - col - 1)) ;
            }
            return ret;
        }
    }
}
