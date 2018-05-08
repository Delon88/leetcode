package LC.SOL;

public class HouseRobberII {
    class Solution {
        public int rob(int[] nums) {
            if ( nums == null || nums.length == 0 ) return 0;
            if ( nums.length == 1) return nums[0];
            return Math.max(solve(nums, 0 , nums.length - 2), solve(nums, 1 , nums.length - 1));
        }

        public int solve(int[] nums, int start, int end) {
            int rob = 0, noRob = 0;
            for ( int i = start ; i <= end ; i++) {
                int tmp = rob;
                rob = noRob + nums[i];
                noRob = Math.max(noRob, tmp);
            }
            return Math.max(rob, noRob);
        }
    }
}
