package LC.SOL;

public class SingleNumberIII {
    class Solution {
        public int[] singleNumber(int[] nums) {
            int diff = 0;
            for ( int i : nums) {
                diff ^= i;
            }
            // get last set bit
            diff = ( diff ) & (-diff);
            int[] ret = {0, 0};
            for ( int n : nums ) {
                if ( ( n & diff ) == 0 ) {
                    ret[0] ^= n;
                } else {
                    ret[1] ^= n;
                }
            }
            return ret;
        }
    }
}
