package LC.SOL;

public class NumberofIslands {
    class Solution {

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int numIslands(char[][] grid) {
            int count = 0;
            if (grid == null || grid.length == 0) return 0;
            int m = grid.length, n = grid[0].length;
            boolean[][] v = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        void dfs(char[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1' ) return;
            grid[x][y] = '2';
            for (int[] d : dirs) {
                int nextX = x + d[0], nextY = y + d[1];
                dfs(grid,  nextX, nextY);
            }
        }
    }
}
