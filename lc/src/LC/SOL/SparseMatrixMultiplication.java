package LC.SOL;

public class SparseMatrixMultiplication {
    class Solution {

        public int[][] multiply(int[][] A, int[][] B) {
            int m = A.length, q = A[0].length, n = B[0].length;
            int[][] ret = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int k = 0; k < q; k++) {
                    if (A[i][k] != 0) {
                        for (int j = 0; j < n; j++) {
                            ret[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
            return ret;
        }
    }

    class Solution1 {

        public int[][] multiply(int[][] A, int[][] B) {
            int m = A.length, q = A[0].length, n = B[0].length;
            int[][] ret = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < q; k++) {
                        ret[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            return ret;
        }
    }


}
