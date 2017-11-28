package LC.SOL;

import java.util.Arrays;

public class KnightProbabilityinChessboard {
    class Solution {
        int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

        public double knightProbability(int N, int K, int r, int c) {
            double[][] dp0 = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp0[i][j] = 1;
                }
            }

            for (int k = 0; k < K; k++) {
                double[][] dp1 = new double[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        for (int[] m : moves) {
                            int row = i + m[0];
                            int col = j + m[1];
                            if (isLegal(row, col, N)) dp1[i][j] += dp0[row][col];
                        }
                    }
                }
                dp0 = dp1;
            }
            return dp0[r][c] / Math.pow(8, K);
        }


        private boolean isLegal(int r, int c, int len) {
            return r >= 0 && r < len && c >= 0 && c < len;
        }

    }
}
