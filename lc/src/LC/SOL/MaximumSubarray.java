package LC.SOL;

public class MaximumSubarray {
    class Solution {
        public int maxSubArray(int[] nums) {
            if ( nums.length == 0) return 0;
            int localMax = nums[0], globalMax = nums[0];
            for ( int i = 1 ; i < nums.length ; i++) {
                localMax = Math.max(nums[i], localMax + nums[i]);
                globalMax = Math.max(localMax, globalMax);
            }
            return globalMax;
        }
    }
}
