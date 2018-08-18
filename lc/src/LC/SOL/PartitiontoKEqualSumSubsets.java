package LC.SOL;

public class PartitiontoKEqualSumSubsets {
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for ( int num : nums ) {
                sum += num;
            }
            if ( sum % k  != 0 ) return false;
            boolean[] used = new boolean[nums.length];
            return dfs(nums, used, 0 , k , 0 , sum / k  );
        }

        boolean dfs(int[] nums, boolean[] used, int start, int k, int curSum, int target) {
            if ( k == 1 ) return true;
            if ( curSum == target ) { return dfs(nums, used, 0,  k -1, 0, target );}
            for ( int i = start ; i < nums.length; i++ ) {
                if ( !used[i] ) {
                    used[i] = true;
                    if ( dfs( nums, used, i + 1 , k , curSum + nums[i], target)) return true;
                    used[i] = false;
                }
            }
            return false;
        }
    }
}
