package LC.SOL;

public class UglyNumber {
    class Solution {
        public boolean isUgly(int num) {
            if ( num < 1 ) return false;
            int[] factors = {2, 3, 5};
            for ( int f : factors) {
                while ( num % f == 0  ) num /= f;
            }
            return num == 1;
        }
    }
}
