package LC.SOL;

import java.util.Arrays;

public class PerfectSquares {
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, n);
            dp[0] = 0;
            for ( int i = 1 ; i <= n ; i++) {
                for ( int j = 0 ; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
                }
            }
            return dp[n];
        }
    }
}
