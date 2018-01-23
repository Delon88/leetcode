package LC.SOL;

public class LargestNumberAtLeastTwiceofOthers {
    class Solution {
        public int dominantIndex(int[] nums) {
            int max = -1, max2 = -1;
            int maxIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    if (max != -1) {
                        max2 = max;
                    }
                    maxIndex = i;
                    max = nums[i];
                } else if (nums[i] > max2) {
                    max2 = nums[i];
                }
            }
            if (max >= 2 * max2) {
                return maxIndex;
            } else {
                return -1;
            }
        }
    }
}
