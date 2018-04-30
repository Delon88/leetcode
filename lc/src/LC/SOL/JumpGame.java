package LC.SOL;

public class JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            int i = 0;
            int reach = 0;
            for ( ; i < nums.length && i <= reach ; i++) {
                reach = Math.max(reach, nums[i] + i );
            }
            return i == nums.length;
        }
    }
}
