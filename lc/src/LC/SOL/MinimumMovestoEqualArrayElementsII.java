package LC.SOL;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII {
    class Solution {
        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            if (nums.length <= 1) return 0;
            int sum = 0, n = nums.length;

            int median = 0;
            if (n % 2 == 0) {
                median = (nums[n / 2 - 1] + nums[n / 2]) / 2;
            } else {
                median = nums[n / 2];
            }
            int ret = 0;
            for ( int i : nums) {
                ret+= Math.abs(i - median);
            }
            return ret;
        }
    }
}
