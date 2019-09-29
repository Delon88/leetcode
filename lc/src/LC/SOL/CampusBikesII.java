package LC.SOL;

import java.util.Arrays;

public class CampusBikesII {
    class Solution {
        public int assignBikes(int[][] workers, int[][] bikes) {
            int n = workers.length, m = bikes.length;
            int[][] dp = new int[n + 1][1 << m];
            for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE / 2);
            dp[0][0] = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                for (int s = 0; s < (1 << m); s++) {
                    // calculate dp[i , s ]= min( dp[i,s] , dp[i - 1, p] + Mahattan(i , j))  p = s - ( 1 <<j )
                    for (int j = 0; j < m; j++) {
                        if ((s & (1 << j)) == 0) continue;
                        int p = s - ( 1 << j);
                        dp[i][s] = Math.min(dp[i][s], dp[i - 1][p] + dist(workers[i -1], bikes[j]));
                        if ( i == n ) {
                            min = Math.min(min, dp[i][s]);
                        }
                    }
                }
            }
            return min;
        }

        int dist(int[] w, int[] b) {
            return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
        }
    }
}
