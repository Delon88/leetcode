package LC.SOL;

import java.util.Arrays;

public class DistinctSubsequencesII {
    class Solution {
        public int distinctSubseqII(String S) {
            long[] end = new long[26];long mod = (long) 1e9 + 7;
            for ( char c : S.toCharArray()) {
                end[ c- 'a'] = ( Arrays.stream(end).sum() + 1 ) % mod;
            }
            return (int) ( Arrays.stream(end).sum() % mod);
        }
    }
}
