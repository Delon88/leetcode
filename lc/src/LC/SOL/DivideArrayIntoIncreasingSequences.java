package LC.SOL;

public class DivideArrayIntoIncreasingSequences {
    class Solution {
        public boolean canDivideIntoSubsequences(int[] nums, int K) {
            int groups = 1 , cur  = 1 , n = nums.length;
            for ( int i = 1 ; i < nums.length; i++) {
                cur = nums[i] == nums[i - 1] ? cur + 1 : 1;
                groups = Math.max(groups, cur);
            }
            return n >= K * groups;
        }
    }
}
