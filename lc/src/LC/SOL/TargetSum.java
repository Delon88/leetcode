package LC.SOL;

public class TargetSum {
    public class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for (int n : nums) {
                sum += n;
            }
            if ((S + sum) % 2 != 0 || sum < S) return 0;
            return subset(nums, (sum + S) >>> 1);
        }

        public int subset(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int n : nums) {
                for (int i = target; i >= n; i--) {
                    dp[i] += dp[i - n];
                }
            }
            return dp[target];
        }
    }
}

