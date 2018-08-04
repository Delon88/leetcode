package LC.SOL;

import java.util.Arrays;

public class MaximumVacationDays {
    static class Solution {
        int[][] dp;
        public int maxVacationDays(int[][] flights, int[][] days) {
            int N = flights.length;
            int K = days[0].length;
            dp = new int[K][N];
            return dfs(flights, days, 0 , 0);
        }

        int dfs(int[][] f, int[][] d, int k, int n) {
            int N = f.length, K = d[0].length;
            if ( k == K ) return 0;
            if ( dp[k][n] > 0 ) return dp[k][n];
            int max = 0;
            for ( int j = 0 ; j < N ; j++) {
                if ( f[n][j] == 1 || n == j ) {
                    max = Math.max(max, dfs(f , d , k + 1, j) + d[j][k]);
                }
            }
            dp[k][n] = max;
            return max;
        }
    }

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}};
        int[][] vac = {{1, 3, 1}, {6, 0, 3}, {3, 3, 3}};
        System.out.println(new Solution().maxVacationDays(flights, vac));
    }

}
