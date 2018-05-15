package LC.SOL;

import java.util.Arrays;

public class PaintFence {
    class Solution {
        public int numWays(int n, int k) {
            if ( n == 0 ) return 0;
            if ( n == 1 ) return k;
            int sameColor = k;
            int diffColor = k * ( k - 1);
            for ( int i = 2 ; i < n ; i++) {
                int tmp = diffColor;
                
            }
        }
    }
}
