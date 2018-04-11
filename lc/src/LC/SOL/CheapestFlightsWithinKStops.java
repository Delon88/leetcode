package LC.SOL;


import java.util.Arrays;

public class CheapestFlightsWithinKStops {
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            long[] ds = new long[n];
            Arrays.fill(ds, Integer.MAX_VALUE);
            ds[src] = 0;
            for ( int i = 0 ; i <= K ; i++) {
                long[] temp = Arrays.copyOf(ds, n);
                for ( int[] e : flights) {
                    if ( ds[e[0]] + e[2] < temp[e[1]]) {
                        temp[e[1]] = ds[e[0]] + e[2];
                    }
                }
                ds = temp;
            }
            return (int) (ds[dst] == Integer.MAX_VALUE ? -1: ds[dst]);
        }
    }
}
