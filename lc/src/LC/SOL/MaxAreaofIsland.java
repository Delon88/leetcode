package LC.SOL;

public class MaxAreaofIsland {
    class Solution {

        int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            boolean[][] v = new boolean[m][n];
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!v[i][j] && grid[i][j] == 1) {
                        int[] count = {0};
                        dfs(i, j, v, grid, count);
                        max = Math.max(count[0], max);
                    }
                }
            }
            return max;
        }

        void dfs(int x, int y, boolean[][] v, int[][] grid, int[] count) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || v[x][y]) return;
            v[x][y] = true;
            count[0]++;
            for (int[] d : dirs) {
                dfs(x + d[0], y + d[1], v, grid, count);
            }
        }
    }
}
