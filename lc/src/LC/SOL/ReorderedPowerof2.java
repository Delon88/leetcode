package LC.SOL;

public class ReorderedPowerof2 {
    class Solution {
        public boolean reorderedPowerOf2(int N) {
            long c = counter(N);
            for ( int i = 0 ; i < 32 ; i++) {
                if ( counter(1 << i) == c ) return true;
            }
            return false;
        }

        long counter(int N ) {
            long ret = 0;
            for ( ; N > 0 ; N /= 10) ret += (int) Math.pow(10, N % 10);
            return ret;
        }
    }
}
