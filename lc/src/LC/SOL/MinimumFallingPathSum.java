package LC.SOL;

import java.util.Arrays;

public class MinimumFallingPathSum {
    class Solution {
        public int minFallingPathSum(int[][] A) {
            int n = A.length;
            int[] dp = new int[n + 2];
            dp[0] = Integer.MAX_VALUE;  dp[n + 1] = Integer.MAX_VALUE;
            for ( int i = 1 ; i <= n ; i++) dp[i] = A[0][i - 1];
            for (int i = 1; i < n; i++) {
                int[] copy = new int[n + 2];
                Arrays.fill(copy, Integer.MAX_VALUE);
                for (int j = 0; j < n; j++) {
                    copy[j + 1] = Math.min(Math.min(dp[j], dp[j + 1]), dp[j + 2]) + A[i][j];
                }
                dp = copy;
            }
            int ret = Integer.MAX_VALUE;
            for ( int i = 1 ; i <= n ; i++) {
                ret = Math.min(ret , dp[i]);
            }
            return ret;
        }
    }
}
