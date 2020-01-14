package LC.SOL;

public class NumberofClosedIslands {
    class Solution {
        int[][] dirs = {{1, 0}, {0 , 1}, {-1 , 0}, {0 , -1}};
        public int closedIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            for ( int i = 0 ; i < m ; i++) {
                dfs(grid, i , 0); dfs(grid, i , n -1 );
            }
            for ( int i = 0 ; i < n  ; i++) {
                dfs(grid, 0 , i ); dfs(grid, m -1 , i);
            }
            int count = 0;
            for (int i = 0 ; i < m ; i++) {
                for ( int j = 0 ; j < n ; j++) {
                    if ( grid[i][j] == 0 ) {
                        dfs(grid, i , j ); count++;
                    }
                }
            }
            return count;
        }

        void dfs(int[][] grid, int x ,int y) {
            if ( x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 0) return;
            grid[x][y] = 1;
            for ( int[] d  :dirs) {
                int nx = x + d[0], ny = y + d[1];
                dfs(grid, nx , ny);
            }
        }
    }
}
