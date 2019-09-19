package LC.SOL;

public class ColoringABorder {
    class Solution {
        public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
            dfs(grid, new boolean[grid.length][grid[0].length], r0, c0, grid[r0][c0]);
            for ( int i = 0 ; i < grid.length; i++ ) for (int j = 0; j < grid[0].length; j++){
                grid[i][j] = grid[i][j] < 0 ? color : grid[i][j];
            }
            return grid;
        }

        void dfs(int[][] grid, boolean[][] v, int x, int y, int oriColor) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != oriColor || v[x][y]) return;
            grid[x][y] = -oriColor;
            v[x][y] = true;
            dfs(grid, v, x + 1, y, oriColor);
            dfs(grid, v, x, y + 1, oriColor);
            dfs(grid, v, x - 1, y, oriColor);
            dfs(grid, v, x, y - 1, oriColor);
            if ( x > 0 && x < grid.length - 1 && y > 0 && y < grid[0].length - 1 &&
            Math.abs(grid[x + 1][y]) == oriColor && Math.abs(grid[x][y + 1]) == oriColor && Math.abs(grid[x - 1][y]) == oriColor
            && Math.abs(grid[x][y - 1]) == oriColor) {
                grid[x][y] = oriColor;
            }
        }
    }
}
