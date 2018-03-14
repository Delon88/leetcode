package LC.SOL;

public class DecodeWaysII {
    class Solution {
        // Input: "1*"
        // Output: 9 + 9 = 18

        public int numDecodings(String s) {
            long e0 = 1, e1 = 0, e2 = 0, f0 , f1 , f2;
            for ( int i = 0 ; i < s.length() ; i++) {
                char c = s.charAt(i);
                if ( c == '*' ) {
                    f0 = e0 * 9 + e1 * 9 + e2 * 6;
                    f1 = e0;
                    f2 = e0;
                } else {
                    f0 = (c != '0' ? e0 : 0) + e1  + ( c <= '6' ? e2 : 0);
                    f1 = ( c == '1' ? e0 : 0);
                    f2 = ( c == '2' ? e0 : 0);
                }
                e0 = f0 % 1000000007;
                e1 = f1;
                e2 = f2;
            }
            return (int) e0;
        }
    }
}
