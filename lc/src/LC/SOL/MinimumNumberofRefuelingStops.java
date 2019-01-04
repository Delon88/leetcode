package LC.SOL;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumNumberofRefuelingStops {
    class Solution {
        public int minRefuelStops(int target, int startFuel, int[][] stations) {
            long[] dp = new long[stations.length + 1];
            dp[0] = startFuel;
            for ( int i = 0 ; i < stations.length ; i++) {
                for ( int t = i ; t >= 0 && dp[t] >= stations[i][0] ; t--) {
                    dp[t + 1] = Math.max(dp[t + 1] , dp[t] + stations[i][1]);
                }
            }

            for ( int t = 0 ; t < dp.length ; ++t) {
                if ( dp[t] >= target) return t;
            }
            return -1;
        }
    }

    class SolutionOlogN {
        public int minRefuelStops(int target, int startFuel, int[][] s) {
            int i = 0 , re = 0;
            int cur = startFuel;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for ( ; cur < target ; re++) {
                while ( i < s.length && cur >= s[i][0] ) {
                    pq.offer(s[i++][1]);
                }
                if ( pq.isEmpty()) return -1;
                cur += pq.poll();
             }
            return re;
        }
    }
}
