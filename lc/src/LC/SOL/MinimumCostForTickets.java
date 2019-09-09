package LC.SOL;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumCostForTickets {
    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int[] dp = new int[366];
            boolean[] dayInclude = new boolean[366];
            for (int d : days) dayInclude[d] = true;
            for (int d = 1; d < 366; d++) {
                if (!dayInclude[d]) {
                    dp[d] = dp[d - 1];
                    continue;
                }
                dp[d] = dp[d - 1] + costs[0];
                dp[d] = Math.min(dp[d], dp[Math.max(0, d - 7)] + costs[1]);
                dp[d] = Math.min(dp[d], dp[Math.max(0, d - 30)] + costs[2]);
            }
            return dp[365];
        }
    }

    class Solution1 {

        public int mincostTickets(int[] days, int[] costs) {
            Queue<int[]> d7 = new LinkedList<>(), d30 = new LinkedList<>();
            int minCost = 0;
            for (int d : days) {
                while (!d7.isEmpty() && d7.peek()[0] + 7 <= d) d7.poll();
                while (!d30.isEmpty() && d30.peek()[0] + 30 <= d) d30.poll();
                d7.offer(new int[]{d, minCost + costs[1]});
                d30.offer(new int[]{d, minCost + costs[2]});
                minCost = Math.min(minCost + costs[0], Math.min(d7.peek()[1], d30.peek()[1]));
            }
            return minCost;
        }
    }
}
