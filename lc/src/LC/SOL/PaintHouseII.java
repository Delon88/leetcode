package LC.SOL;

import java.util.Arrays;

public class PaintHouseII {
    class Solution {
        public int minCostII(int[][] costs) {
            if ( costs == null || costs.length == 0 ) return 0;
            int k = costs[0].length , n = costs.length;
            int[] dp = Arrays.copyOf(costs[0], k);
            int[] tmp = new int[k];
            for ( int i = 1 ;i < costs.length ; i++) {
                Arrays.fill(tmp, Integer.MAX_VALUE);
                for ( int j = 0 ; j < k ; j++) {
                    for ( int m = 0 ; m < k ; m++) {
                        if ( j != m ){
                            tmp[j] = Math.min(tmp[j], dp[m] + costs[i][j]);
                        }
                    }
                }
                System.arraycopy(tmp, 0 , dp, 0 , k);
            }
            int min = Integer.MAX_VALUE;
            for ( int i = 0 ; i < k ; i++) {
                min = Math.min(dp[i], min);
            }
            return min;
        }
    }
}
