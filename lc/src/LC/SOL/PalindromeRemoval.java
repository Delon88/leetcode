package LC.SOL;

import java.util.Arrays;

public class PalindromeRemoval {
    class Solution {
        public int minimumMoves(int[] arr) {
            int n = arr.length;
            int[][] dp = new int[n][n];
            for( int[] d : dp) Arrays.fill(d , Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) dp[i][i] = 1;
            for (int i = 0; i < n - 1; i++) dp[i][i + 1] = arr[i] == arr[i + 1] ? 1 : 2;
            for (int l = 2; l < n; l++) {
                for ( int i = 0, j = i + l ; j < n ; i++, j++) {
                    if ( arr[i] == arr[j]) dp[i][j] = dp[i + 1][j - 1];
                    for ( int k = i ; k < j ; k++) {
                        dp[i][j] = Math.min(dp[i][j] , dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}
