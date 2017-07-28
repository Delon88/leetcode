package LC.SOL;

public class MaxConsecutiveOnesII {
    public class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int max = 0;
            int left = 0;
            int right = 0;
            for (int i = 0; i < nums.length; i++) {
                right++;
                if (nums[i] == 0) {
                    left = right;
                    right = 0;
                }
                max = Math.max(max, left + right);
            }
            return max;
        }
    }
}
