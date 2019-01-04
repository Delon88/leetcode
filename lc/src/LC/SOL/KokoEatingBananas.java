package LC.SOL;

public class KokoEatingBananas {
    class Solution {
        public int minEatingSpeed(int[] piles, int H) {
            int l = 1, r = 1000000000;
            while ( l < r ) {
                int m = ( l + r) / 2, count = 0;
                for ( int p : piles) {
                    count += ( p + m - 1) / m;
                }
                if ( count <= H ) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return l;
        }

    }
}
