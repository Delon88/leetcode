package LC.SOL;

public class SingleElementinaSortedArray {
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) return -1;
            int n = nums[0];
            for (int i = 1; i < nums.length; i++) {
                n ^= nums[i];
            }
            return n;
        }
    }
}
