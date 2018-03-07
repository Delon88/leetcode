package LC.SOL;


public class FreedomTrail {
    class Solution {
        public int findRotateSteps(String ring, String key) {
            int m = key.length();
            int n = ring.length();
            int[][] dp = new int[m + 1][n];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    // move backward from m + 1 to m
                    for (int k = 0; k < n; k++) {
                        if (ring.charAt(k) == key.charAt(i)) {
                            int dist = Math.abs(j - k);
                            dist = Math.min(dist, Math.abs(n - dist);
                            dp[i][j] = Math.min(dp[i][j], dist + dp[i + 1][k]);
                        }
                    }
                }
            }
            return dp[0][0] + m;
        }
    }
}
