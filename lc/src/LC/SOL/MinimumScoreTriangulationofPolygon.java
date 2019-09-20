package LC.SOL;

public class MinimumScoreTriangulationofPolygon {
    class Solution {
        public int minScoreTriangulation(int[] A) {
            int n = A.length;
            int[][] dp = new int[n][n];
            for (int d = 2; d < n; d++) {
                for (int i = 0; i + d < n; i++) {
                    int j = i + d;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[k] * A[j]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}
