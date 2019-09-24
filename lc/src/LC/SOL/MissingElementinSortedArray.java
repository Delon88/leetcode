package LC.SOL;

public class MissingElementinSortedArray {
    class Solution {
        public int missingElement(int[] nums, int k) {
            int start = 0, end = nums.length;
            while (start < end) {
                int m = start + (end - start) / 2;
                if (nums[m] >= nums[0] + k + m) {
                    end = m;
                } else {
                    start = m + 1;
                }
            }
            return nums[0] + start + k - 1;
        }
    }
}
