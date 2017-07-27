package LC.SOL;

public class MaxConsecutiveOnesII {
    public class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int prevLastOneIndex = -1;
            int prevCount = -1;
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    int count = 0;
                    int start = i;
                    while (i < nums.length && nums[i] == 1) {
                        count++;
                        i++;
                    }

                    if (prevLastOneIndex != -1 && start - prevLastOneIndex == 2) {
                        max = Math.max(max, prevCount + 1 + count);
                    } else {
                        max = Math.max(max, count);
                    }
                    prevCount = count;
                    prevLastOneIndex = i - 1;
                }
            }
            return max == 0 ? 1 : max;
        }
    }
}
