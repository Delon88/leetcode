package LC.SOL;

public class JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            int i = 0;
            int max = 0;
            for ( ; i < nums.length && max >= i ; i++) {
                max = Math.max(max, nums[i] + i );
            }
            return i == nums.length;
        }
    }
}
