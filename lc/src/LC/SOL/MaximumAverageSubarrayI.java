package LC.SOL;

public class MaximumAverageSubarrayI {
    public class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int curSum = 0;
            int i = 0;
            for ( ; i < k && i < nums.length; i++) {
                curSum += nums[i];
            }
            if (i == nums.length) return ((double) curSum) / nums.length;
            int max = curSum;
            for (; i < nums.length; i++) {
                curSum = curSum - nums[i - k] + nums[i];
                max = Math.max( curSum , max);
            }
            return ((double) max )/ k;
        }
    }
}
