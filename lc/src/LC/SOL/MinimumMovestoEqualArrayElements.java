package LC.SOL;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElements {
    public class Solution {
        public int minMoves(int[] nums) {
            if ( nums.length <= 1 ) return 0;
            Arrays.sort(nums);
            int move = 0 ;
            for ( int i = 1 ; i < nums.length ; i++) {
                move += ( nums[i] - nums[i - 1]);
            }

            return move;
        }
    }
}
