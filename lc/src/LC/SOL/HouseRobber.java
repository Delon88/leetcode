package LC.SOL;

public class HouseRobber {
    class Solution {
        public int rob(int[] nums) {
            if ( nums == null || nums.length == 0) return 0;
            if ( nums.length == 1) return nums[0];
            int rob = 0, noRop = 0;
            for ( int i = 0 ; i < nums.length; i++) {
                int tmp = rob;
                rob = noRop + nums[i];
                noRop = Math.max( noRop , tmp);
            }
            return Math.max(rob, noRop);
        }
    }
}
