package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public class Solution {
        public List<int[]> pacificAtlantic(int[][] matrix) {
            List<int[]> ret = new ArrayList<>();
            if (matrix == null || matrix.length == 0) return ret;
            int m = matrix.length, n = matrix[0].length;
            boolean[][] pac = new boolean[m][n];
            boolean[][] atl = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                dfs(matrix, pac, matrix[i][0], i, 0);
                dfs(matrix, atl, matrix[i][n - 1], i, n - 1);
            }
            for (int i = 0; i < n; i++) {
                dfs(matrix, pac, matrix[0][i], 0, i);
                dfs(matrix, atl, matrix[m - 1][i], m - 1, i);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (pac[i][j] && atl[i][j]) ret.add(new int[]{i, j});
                }
            }
            return ret;
        }

        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        private void dfs(int[][] matrix, boolean[][] v, int height, int x, int y) {
            int m = matrix.length, n = matrix[0].length;
            if (x < 0 || x >= m || y < 0 || y >= n || v[x][y] || matrix[x][y] < height) return;
            v[x][y] = true;
            for (int[] d : dir) {
                dfs(matrix, v, matrix[x][y], x + d[0], y + d[1]);
            }
        }
    }
}
