package LC.SOL;

public class MatrixBlockSum {
    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int K) {
            int m = mat.length, n = mat[0].length;
            if (m == 0) return new int[0][0];
            int[][] prefix = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    prefix[i + 1][j + 1] = prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j] + mat[i][j];
                }
            }

            int[][] ret = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int x1 = i - K < 0 ? 0 : i - K, y1 =  j - K < 0 ? 0: j - K;
                    int x2 = i + K >= m ? m - 1 : i + K, y2 = j + K >= n ? n - 1: j + K;
                    ret[i][j] = prefix[x2 + 1][y2 + 1] - ( prefix[x2 + 1][y1] + prefix[x1][y2 + 1]) + prefix[x1][y1];
                }
            }
            return ret;
        }
    }
}
