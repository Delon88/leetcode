package LC.SOL;

import java.util.Arrays;

public class PaintHouse {
    class Solution {
        public int minCost(int[][] costs) {
            if (costs.length == 0) return 0;
            int[] dp = Arrays.copyOf(costs[0], 3);
            int[] tmp = new int[3];
            for (int i = 1; i < costs.length; i++) {
                int zero = Math.min(dp[1], dp[2]) + costs[i][0];
                int one = Math.min(dp[0], dp[2]) + costs[i][1];
                int two = Math.min(dp[0], dp[1]) + costs[i][2];
                dp[0] = zero; dp[1] = one; dp[2] = two;
            }
            return Math.min(Math.min(dp[0], dp[1]), dp[2]);
        }
    }
}
