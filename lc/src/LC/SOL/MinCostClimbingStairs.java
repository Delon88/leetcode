package LC.SOL;

public class MinCostClimbingStairs {
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int s1 = 0, s2 = 0;
            for (int i = 0; i < cost.length; i++) {
                int min = Math.min(s1, s2) + cost[i];
                s2 = s1;
                s1 = min;
            }
            return Math.min(s1, s2);
        }
    }
}
