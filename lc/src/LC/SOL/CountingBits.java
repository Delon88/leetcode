package LC.SOL;

public class CountingBits {
    class Solution {
        public int[] countBits(int num) {
            int[] ret = new int[num + 1];
            for ( int i = 1 ; i <= num; i++) {
                ret[i] = ret[i >> 1] + ( i & 1);
            }
            return ret;
        }
    }
}
