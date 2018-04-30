package LC.SOL;

public class DivideTwoIntegers {
    class Solution {
        public int divide(int dividend, int divisor) {
            if (divisor == 0 ) return Integer.MAX_VALUE;
            int sign = (dividend > 0) ^ ( divisor > 0) ? -1: 1;
            long dend = Math.abs((long) dividend);
            long div = Math.abs((long) divisor);
            int adv = 0;
            while ( (div << adv) <= dend ) {
                adv++;
            }
            long quo = 0;
            for ( ; adv >= 0 ; adv--) {
                if ( dend >= (div << adv )) {
                    dend -= ( div << adv);
                    quo |= (long) 1 << adv;
                }
            }
            quo = quo * sign;
            if ( quo > Integer.MAX_VALUE || quo < Integer.MIN_VALUE ) return Integer.MAX_VALUE;
            return (int) quo;
        }
    }
}
