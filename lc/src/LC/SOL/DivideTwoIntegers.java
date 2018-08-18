package LC.SOL;

public class DivideTwoIntegers {
    class Solution {
        public int divide(int dividend, int divisor) {
            if ( divisor == 0 || ( dividend == Integer.MIN_VALUE && divisor == -1) ) return Integer.MAX_VALUE;
            int sign = ( dividend > 0) ^ ( divisor > 0) ? -1 : 1;
            long dvd = Math.abs((long) dividend);
            long div = Math.abs((long) divisor);
            int adv = 0 ;
            while ( ( div << adv ) <= dvd ) {
                adv++;
            }
            adv--;
            long quo = 0;
            for ( ; adv >= 0; adv--) {
                if ( dvd >= ( div << adv)) {
                    dvd -= ( div << adv);
                    quo |= ((long) 1 << adv);
                }
            }
            return (int) quo * sign;
        }
    }
}
