package LC.SOL;

public class PartitionEqualSubsetSum {
    public class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for ( int n : nums ) {
                sum += n;
            }
            if ( ( sum & 1) != 0 ) return false;
            sum = sum / 2;
            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;
            for ( int n : nums ) {
                for ( int i = sum; i > 0 ; i--) {
                    if ( i >= n ) {
                        dp[i] |= dp[i - n];
                    }
                }
            }
            return dp[sum];
        }
    }
}
