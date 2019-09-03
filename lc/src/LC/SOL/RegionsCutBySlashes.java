package LC.SOL;

public class RegionsCutBySlashes {
    class Solution {
        public int regionsBySlashes(String[] grid) {
            int N = grid.length;
            int[][] m = new int[3 * N][3 * N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i].charAt(j) == '/')
                        m[i * 3 + 2][j * 3] = m[i * 3 + 1][j * 3 + 1] = m[i * 3][j * 3 + 2] = 1;
                    else if (grid[i].charAt(j) == '\\')
                        m[i * 3][j * 3] = m[i * 3 + 1][j * 3 + 1] = m[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
            int count = 0;
            for (int i = 0; i < 3 * N; i++) {
                for (int j = 0; j < 3 * N; j++) {
                    if (m[i][j] == 0) {
                        dfs(m, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        void dfs(int[][] grid, int i, int j) {
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 0) {
                grid[i][j] = 2;
                dfs(grid, i + 1, j);
                dfs(grid, i, j + 1);
                dfs(grid, i - 1, j);
                dfs(grid, i, j - 1);
            }
        }
    }
}
