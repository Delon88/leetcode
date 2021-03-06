package LC.SOL;

public class MinimumSizeSubarraySum {
    class Solution {
        // [1, 2, 3 , 4, 5]
        public int minSubArrayLen(int s, int[] nums) {
            int sum = 0;
            int start = 0, end = 0, n = nums.length;
            int min = Integer.MAX_VALUE;
            while (end < n) {
                sum += nums[end++];
                while (sum >= s) {
                    sum -= nums[start++];
                }
                min = Math.min(end - start + 1, min);
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }
}
