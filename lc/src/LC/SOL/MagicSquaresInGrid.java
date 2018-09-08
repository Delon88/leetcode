package LC.SOL;

public class MagicSquaresInGrid {
    class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int ret = 0;
            for ( int i = 0 ; i < grid.length  - 2; i++) {
                for ( int j = 0 ; j < grid[0].length - 2; j++) {
                    if ( isValid(i, j , grid)) ret++;
                }
            }
            return ret;
        }

        boolean isValid(int x, int y, int[][] grid) {
            if ( grid[x + 1][y + 1] != 5) return false;
            int[] hash = new int[16];
            for ( int i = 0 ; i < 3 ; i++) {
                for ( int j = 0 ; j < 3 ; j++) {
                    hash[grid[x + i][y + j]]++;
                }
            }
            for ( int i = 1 ; i <= 9 ; i++) {
                if ( hash[i] != 1) return false;
            }
            // check each row col and diag
            if ( (grid[x][y] + grid[x][y + 1] + grid[x][y + 2]) != 15
                 || (grid[x +2][y] + grid[x + 2][y + 1] + grid[x + 2][y + 2]) != 15
                 || (grid[x][y] + grid[x + 1][y] + grid[x + 2][y]) != 15
                 || (grid[x][y + 2] + grid[x + 1][y + 2] + grid[x + 2][y + 2]) != 15
                 || (grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2]) != 15
                 || (grid[x + 2][y] + grid[x + 1][y + 1] + grid[x][y + 2]) != 15
                    ) return false;
            return true;
        }
    }
}
