package LC.SOL;


public class NumberofLongestIncreasingSubsequence {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int[] count = new int[n];
            int maxLen = 0;
            int ret = 0;
            for (int i = 0; i < n; i++) {
                dp[i] = count[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (dp[i] == dp[j] + 1) count[i] += count[j];
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1;
                            count[i] = count[j];
                        }
                    }
                }
                if (maxLen == dp[i]) ret += count[i];
                if (maxLen < dp[i]) {
                    maxLen = dp[i];
                    ret = count[i];
                }
            }
            return ret;
        }
    }
}
