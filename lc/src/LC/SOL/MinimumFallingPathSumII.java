package LC.SOL;

import java.util.Arrays;

public class MinimumFallingPathSumII {
    class Solution {
        public int minFallingPathSum(int[][] arr) {
            int n = arr.length;
            int[] dp = arr[0].clone();
            for (int i = 1; i < n; i++) {
                int[] next = new int[n];
                Arrays.fill(next, Integer.MAX_VALUE);
                for (int j = 0; j < n; j++) {
                    for ( int k = 0 ; k < n ; k++) {
                        if ( k != j ) next[j] = Math.min(dp[k] + arr[i][j], next[j]);
                    }
                }
                dp = next;
            }
            int ret = Integer.MAX_VALUE;
            for ( int d : dp) ret = Math.min(ret , d);
            return ret;
        }
    }
}
