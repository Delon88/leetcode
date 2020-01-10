package LC.SOL;

public class NumberofWaystoStayintheSamePlaceAfterSomeSteps {
    class Solution {
        private final int MOD = 1000000007;

        public int numWays(int steps, int arrLen) {
            int maxPos = Math.min(steps, arrLen);
            long[][] dp = new long[steps + 1][maxPos + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= steps; i++) {
                for (int j = 0; j < maxPos; j++) {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1] + (j >= 1 ? dp[i - 1][j - 1] : 0)) % MOD;
                }
            }
            return (int) dp[steps][0];
        }
    }

    class Solution1 {
        private final int MOD = 1000000007;

        public int numWays(int steps, int arrLen) {
            int maxPos = Math.min(steps, arrLen);
            long[] dp = new long[maxPos + 1];
            dp[0] = 1;
            for (int i = 1; i <= steps; i++) {
                long[] cur = new long[maxPos + 1];
                for (int j = 0; j < maxPos; j++) {
                    cur[j] = (dp[j] + dp[j + 1] + (j >= 1 ? dp[j - 1] : 0)) % MOD;
                }
                dp = cur;
            }
            return (int) dp[0];
        }
    }
}
