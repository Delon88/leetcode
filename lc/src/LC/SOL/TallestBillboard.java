package LC.SOL;

public class TallestBillboard {
    class Solution {
        public int tallestBillboard(int[] rods) {
            int[] dp = new int[5001];
            for (int d = 1; d < 5001; d++) dp[d] = Integer.MIN_VALUE;
            for (int r : rods) {
                int[] cur = dp.clone();
                for (int d = 0; d + r < 5001; d++) {
                    dp[d + r] = Math.max(dp[d + r], cur[d]);
                    if (d >= r) dp[d - r] = Math.max(dp[d - r], cur[d] + r);
                    else if (d < r) dp[r - d] = Math.max(dp[r - d], cur[d] + d);
                }
            }
            return dp[0];
        }
    }
}
