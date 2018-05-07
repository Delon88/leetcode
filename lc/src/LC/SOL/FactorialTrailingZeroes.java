package LC.SOL;

public class FactorialTrailingZeroes {
    class Solution {
        public int trailingZeroes(int n) {
            int ret = 0;
            for ( int i = n ;  i >= 5 ; i /= 5) {
                ret += ( i / 5);
            }
            return ret;
        }
    }
}
