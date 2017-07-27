package LC.SOL;

public class MaxConsecutiveOnes {
    public class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            if (nums == null || nums.length == 0) return max;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    int count = 0;
                    while (i < nums.length && nums[i] == 1) {
                        i++;
                        count++;
                    }
                    max = Math.max(max, count);
                }
            }
            return max;
        }
    }
}
