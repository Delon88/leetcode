package LC.SOL;

public class DeleteandEarn {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            if ( nums == null || nums.length == 0) return 0;
            int range = 10000;
            int[] dp = new int[range + 1];
            for ( int n : nums ) dp[n] += n;
            for ( int i = 2 ; i <= range ; i++) {
                dp[i] = Math.max(dp[i - 1] , dp[i - 2] + dp[i]);
            }
            return dp[range];
        }
    }
}
