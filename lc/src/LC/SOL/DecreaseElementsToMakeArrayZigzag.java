package LC.SOL;

public class DecreaseElementsToMakeArrayZigzag {
    class Solution {
        public int movesToMakeZigzag(int[] nums) {
            int[] ret = new int[2];
            int n = nums.length, left, right;
            for (int i = 0; i < n; i++) {
                left = i == 0 ? 1001 : nums[i - 1];
                right = i >= n  - 1? 1001 : nums[i + 1];
                ret[i % 2] += Math.max(0, nums[i] - Math.min(left, right) + 1);
            }
            return Math.min(ret[0], ret[1]);
        }
    }
}
