package LC.SOL;

public class DivideTwoIntegers {
    class Solution {
        public int divide(int dividend, int divisor) {
            if ( divisor == 0 || ( dividend == Integer.MIN_VALUE && divisor == - 1)) return Integer.MAX_VALUE;
            int a = Math.abs(dividend), b = Math.abs(divisor), ret = 0;
            for ( int i = 31 ; i >= 0 ; i--) {
                if (  ( a >>> i) - b >= 0 ) {
                    ret |= ( 1 << i);
                    a -= ( b << i );
                }
            }
            return ( dividend > 0 ) ^ ( divisor > 0 ) ? -ret : ret;
        }
    }
}
