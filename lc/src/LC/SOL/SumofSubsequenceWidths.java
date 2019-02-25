package LC.SOL;

import java.util.Arrays;

public class SumofSubsequenceWidths {
    class Solution {
        public int sumSubseqWidths(int[] A) {
            Arrays.sort(A);
            long c = 1 , ret = 0, mod = (long) 1e9 + 7;
            for ( int i = 0 ; i < A.length ; i++ , c = ( c << 1) % mod) {
                ret = ( ret + A[i] * c - A[A.length - i - 1] * c ) % mod;
            }
            return (int) (( ret + mod) % mod);
        }
    }
}
