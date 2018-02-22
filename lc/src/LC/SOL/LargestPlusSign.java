package LC.SOL;

import java.util.Arrays;

public class LargestPlusSign {
    class Solution {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int orderOfLargestPlusSign(int N, int[][] mines) {
            int[][] m = new int[N][N];
            for ( int[] row : m) {
                Arrays.fill(row, 1);
            }
            for ( int[] mine : mines) {
                m[mine[0]][mine[1]] = 0;
            }

            int[][][] dp = new int[N + 2][N + 2][4];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (m[i][j] != 0) {
                        dp[i + 1][j + 1][0] = dp[i][j + 1][0] + 1;
                        dp[i + 1][j + 1][1] = dp[i + 1][j][1] + 1;
                    }
                }
            }

            for (int i = N - 1; i >= 0; i--) {
                for (int j = N - 1; j >= 0; j--) {
                    if (m[i][j] != 0) {
                        dp[i + 1][j + 1][2] = dp[i + 2][j + 1][2] + 1;
                        dp[i + 1][j + 1][3] = dp[i + 1][j + 2][3] + 1;
                    }
                }
            }
            int order = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int[] d = dp[i + 1][j + 1];
                    order = Math.max(order, Math.min(d[0] , Math.min(d[1] , Math.min(d[2] , d[3]))));
                }
            }
            return order;
        }

    }
}
