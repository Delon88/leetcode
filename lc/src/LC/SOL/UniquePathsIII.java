package LC.SOL;

public class UniquePathsIII {
    class Solution {
        int ret, empty, sx, sy, ex, ey;

        public int uniquePathsIII(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            empty = 1;
            ret = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) empty++;
                    else if (grid[i][j] == 1) {
                        sx = i;
                        sy = j;
                    } else if (grid[i][j] == 2) {
                        ex = i;
                        ey = j;
                    }
                }
            }
            dfs(grid, sx , sy);
            return ret;
        }

        void dfs(int[][] grid, int x, int y) {
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] >= 0) {
                if ( x == ex && y == ey && empty == 0 ) {
                    ret++; return;
                }
                grid[x][y] = -2;
                empty--;
                dfs(grid, x + 1, y);
                dfs(grid, x , y + 1);
                dfs(grid, x - 1, y );
                dfs(grid, x , y - 1);
                grid[x][y] = 0;
                empty++;
            }
        }
    }
}
