package LC.SOL;


public class MinimumMovestoEqualArrayElements {
    public class Solution {
        public int minMoves(int[] nums) {
            if ( nums.length <= 1 ) return 0;
            int min = nums[0];
            int sum =0;
            for ( int n : nums) {
                sum+= n;
                min = Math.min(n , min);
            }
            return sum - min * nums.length;
        }
    }
}
