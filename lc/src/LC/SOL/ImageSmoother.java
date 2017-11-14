package LC.SOL;

public class ImageSmoother {
    class Solution {

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

        public int[][] imageSmoother(int[][] M) {
            int m = M.length, n = M[0].length;
            if (m == 0) return new int[][]{};
            int[][] ret = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ret[i][j] = (int) Math.floor(scale(M, i ,j));
                }
            }
            return ret;
        }

        double scale(int[][] M, int i, int j) {
            double sum = M[i][j];
            int cell = 1;
            for (int[] d : dirs) {
                int dx = i + d[0];
                int dy = j + d[1];
                if (dx >= 0 && dx < M.length && dy >= 0 && dy < M[0].length) {
                    cell++;
                    sum += M[dx][dy];
                }
            }
            return sum / cell;
        }
    }
}
