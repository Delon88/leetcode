package LC.SOL;

import java.util.Arrays;

public class PaintHouse {
    class Solution {
        public int minCost(int[][] costs) {
            if (costs.length == 0) return 0;
            int[] dp = costs[0].clone();
            for (int i = 1; i < costs.length; i++) {
                int c1 = Math.min(dp[1], dp[2]) + costs[i][0];
                int c2 = Math.min(dp[0], dp[2]) + costs[i][1];
                int c3 = Math.min(dp[0], dp[1]) + costs[i][2];
                dp[0] = c1; dp[1] = c2; dp[2] = c3;
            }
            return Math.min(Math.min(dp[0], dp[1]), dp[2]);
        }
    }
}
