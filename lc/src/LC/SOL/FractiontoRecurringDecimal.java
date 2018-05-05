package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            // calcuate integral part
            if ( numerator == 0 ) return "0";
            StringBuilder b = new StringBuilder();
            b.append((numerator > 0) ^ (denominator > 0 ) ? "-" : "");
            long n = Math.abs((long) numerator);
            long d = Math.abs((long) denominator);
            b.append(n / d);
            long rmd = n % d;
            if ( rmd == 0 ) return b.toString();
            // calculate fraction part
            b.append(".");
            Map<Long,Integer> map = new HashMap<>();
            StringBuilder frac = new StringBuilder();
            while ( rmd != 0) {
                if ( map.containsKey(rmd)) {
                    int start = map.get(rmd);
                    String repeat = frac.substring(start);
                    String nonRepeat = frac.substring(0 , start);
                    b.append(nonRepeat).append('(').append(repeat).append(')');
                    return b.toString();
                }
                map.put(rmd, frac.length());
                rmd *= 10;
                frac.append(rmd / d);
                rmd %= d;
            }
            return b.append(frac).toString();
        }
    }
}
