package LC.SOL;

import java.util.Arrays;

public class UniqueLetterString {
    class Solution {
        public int uniqueLetterString(String S) {
            int[][] last = new int[26][2];
            for ( int i = 0 ;i < 26 ; i++) Arrays.fill(last[i], -1);
            // A (X A X X A
            int ret = 0, mod = (int) Math.pow(10, 9) + 7, n = S.length();
            for (int i = 0; i < S.length(); i++) {
                int c = S.charAt(i) - 'A';
                ret = (ret + (i - last[c][1]) * (last[c][1] - last[c][0]) % mod) % mod;
                last[c][0] = last[c][1];
                last[c][1] = i;
            }
            for (int i = 0; i < 26; i++) {
                ret = (ret + (n - last[i][1]) * (last[i][1] - last[i][0]) % mod) % mod;
            }
            return ret;
        }
    }
}
