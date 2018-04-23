package LC.SOL;

public class ZigZagConversion {
    class Solution {
        public String convert(String s, int numRows) {
            char[] c = s.toCharArray();
            StringBuilder[] buf = new StringBuilder[numRows];
            for ( int i = 0 ; i < buf.length ; i++) {
                buf[i] = new StringBuilder();
            }
            int i = 0 ;
            while ( i < c.length ) {
                // vertically
                for ( int j = 0 ; j < numRows && i < c.length; j++) {
                    buf[j].append(c[i++]);
                }
                // diagonal up
                for ( int j = numRows - 2 ; j > 0 && i < c.length ; j--) {
                    buf[j].append(c[i++]);
                }
            }
            StringBuilder ret = new StringBuilder();
            for ( StringBuilder b : buf) {
                ret.append(b);
            }
            return ret.toString();
        }
    }
}
