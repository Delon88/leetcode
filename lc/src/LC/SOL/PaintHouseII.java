package LC.SOL;

import java.util.Arrays;

public class PaintHouseII {
    class Solution {
        public int minCostII(int[][] costs) {
            if ( costs == null || costs.length == 0 ) return 0;
            int k = costs[0].length , n = costs.length;
            int[] dp = costs[0].clone();
            int[] tmp = new int[k];
            for ( int i = 1 ;i < n ; i++) {
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

    class Solution1 {
        public int minCostII(int[][] costs) {
            if (costs == null || costs.length == 0) return 0;
            int n = costs.length, k = costs[0].length;
            int min1 = 0, min2 = 0, minIndex = -1;
            for (int i = 0; i < n; i++) {
                int curMin1 = Integer.MAX_VALUE, curMin2 = Integer.MAX_VALUE, curMinIndex = 0;
                for (int j = 0; j < k; j++) {
                    int cost = costs[i][j] + (j == minIndex ? min2 : min1);
                    if (cost < curMin1) {
                        curMin2 = curMin1;
                        curMin1 = cost;
                        curMinIndex = j;
                    }
                    else if (cost < curMin2) curMin2 = cost;
                }
                min1 = curMin1;
                min2 = curMin2;
                minIndex = curMinIndex;
            }
            return min1;
        }
    }
}
