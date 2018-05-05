package LC.SOL;

public class MaximumProductSubarray {
    class Solution {
        public int maxProduct(int[] nums) {
            if ( nums == null || nums.length == 0 ) return 0;
            int localMax = nums[0];
            int localMin = nums[0];
            int globalMax = nums[0];
            for ( int i = 1 ; i < nums.length ; i++) {
                int tmp = localMax;
                localMax = Math.max( nums[i] , Math.max(nums[i] * localMax , nums[i] * localMin));
                localMin = Math.min( nums[i], Math.min( nums[i] * tmp, nums[i] * localMin) );
                globalMax = Math.max(localMax, globalMax);
            }
            return globalMax;
        }
    }
}
