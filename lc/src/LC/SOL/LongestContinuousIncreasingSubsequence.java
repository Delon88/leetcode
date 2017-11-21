package LC.SOL;

public class LongestContinuousIncreasingSubsequence {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (nums.length == 0) return 0;
            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                int count = 1;
                while (i < nums.length && nums[i] > nums[i - 1]) {
                    i++;
                    count++;
                }
                max = Math.max(max, count);
            }
            return max;
        }
    }
}
