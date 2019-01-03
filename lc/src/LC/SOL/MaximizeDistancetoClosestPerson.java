package LC.SOL;

public class MaximizeDistancetoClosestPerson {
    class Solution {
        public int maxDistToClosest(int[] seats) {
            int i = 0 , j = 0, ret = 0, n = seats.length;
            for ( ; j < n  ; j++) {
                if ( seats[j] == 1 ) {
                    if ( i == 0 ) ret = Math.max(ret, j - i);
                    else ret = Math.max(ret , ( j - i + 1)  /2 ) ;
                    i = j + 1;
                }
            }
            ret = Math.max(ret, j - i );
            return ret;
        }
    }

}
