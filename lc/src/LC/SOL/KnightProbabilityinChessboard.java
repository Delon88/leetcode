package LC.SOL;

public class KnightProbabilityinChessboard {
    class Solution {
        int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

        public double knightProbability(int N, int K, int r, int c) {
            int[][] dp0 = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp0[i][j] = 1;
                }
            }

            for (int i = 0; i < K; i++) {
                int[][] dp1 = new int[N][N];
                for (int[] m : moves) {
                    int nextRow =
                }
            }
        }

    }
}
