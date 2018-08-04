package LC.SOL;

public class OutofBoundaryPaths {
    class Solution {
        public int findPaths(int m, int n, int N, int i, int j) {
            if ( N <= 0 ) return 0;
            int mod = 1000000007;
            int[][] dp = new int[m][n];
            dp[i][j] = 1;

            int[][] dirs = {{1, 0},{0,1},{-1,0},{0,-1}};
            int ret = 0;
            for ( int k = 0 ; k < N ; k++) {
                int[][] next = new int[m][n];
                // update next
                for ( int r = 0 ;  r < m ; r++) {
                    for ( int c = 0 ; c < n ; c++) {
                        for ( int[] d : dirs) {
                            int nR = r + d[0], nC = c + d[1];
                            if ( nR < 0 || nR >= m || nC < 0 || nC >= n ) {
                                ret = ( ret + dp[r][c]) % mod;
                            } else {
                                next[nR][nC] = ( next[nR][nC] + dp[r][c] ) % mod;
                            }
                        }
                    }
                }
                dp = next;
            }
            return ret;
        }
    }
}
