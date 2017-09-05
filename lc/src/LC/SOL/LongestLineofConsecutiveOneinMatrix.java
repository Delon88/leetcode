package LC.SOL;

import java.util.Arrays;

public class LongestLineofConsecutiveOneinMatrix {
    class Solution {
        public int longestLine(int[][] M) {
            if ( M.length == 0) return 0;
            int m = M.length, n = M[0].length, max = 0;
            int[][][] dp = new int[m][n][4];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (M[i][j] == 0) continue;
                    Arrays.fill(dp[i][j], 1);
                    if (j > 0) dp[i][j][0] += dp[i][j - 1][0];
                    if (i > 0 && j > 0) dp[i][j][1] += dp[i - 1][j - 1][1];
                    if (i > 0) dp[i][j][2] += dp[i - 1][j][2];
                    if (j < n - 1 && i > 0) dp[i][j][3] += dp[i - 1][j + 1][3];
                    max = Math.max(max , Math.max(dp[i][j][0] , dp[i][j][1]));
                    max = Math.max(max , Math.max(dp[i][j][2] , dp[i][j][3]));
                }
            }
            return max;
        }
    }
}
