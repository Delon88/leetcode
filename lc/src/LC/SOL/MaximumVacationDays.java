package LC.SOL;

import java.util.Arrays;

public class MaximumVacationDays {
    static class Solution {
        public int maxVacationDays(int[][] flights, int[][] days) {
            // dp[i][j] , ith city, jth day max vacation
            // max of dp[i - 1][k]  k = 0... n where there is an flight
            // [[0,1,1],[1,0,1],[1,1,0]], days = [[1,3,1],[6,0,3],[3,3,3]]
            //
            int n = flights.length;
            int k = days[0].length;
            int[][] dp = new int[n][k];
            for (int i = 0; i < n; i++) {
                dp[i][k - 1] = days[i][k - 1];
            }

            for (int j = k - 2; j >= 0; j--) {
                for (int i = 0; i < n; i++) {
                    for (int m = 0; m < n; m++) {
                        if (m == i || flights[i][m] == 1) {
                            dp[i][j] = Math.max(dp[m][j + 1] + days[i][j], dp[i][j]);
                        }
                    }
                }
            }
            int ret = 0;
            for (int i = 0; i < n; i++) {
                if (flights[0][i] == 1 || i == 0) {
                    ret = Math.max(dp[i][0], ret);
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}};
        int[][] vac = {{1, 3, 1}, {6, 0, 3}, {3, 3, 3}};
        System.out.println(new Solution().maxVacationDays(flights, vac));
    }

}
