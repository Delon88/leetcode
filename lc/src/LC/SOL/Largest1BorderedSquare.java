package LC.SOL;

public class Largest1BorderedSquare {
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] ver = new int[m][n], hor = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        hor[i][j] = j == 0 ? 1 : hor[i][j - 1] + 1;
                        ver[i][j] = i == 0 ? 1 : ver[i - 1][j] + 1;
                    }
                }
            }
            int max = 0;
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int len = Math.min(ver[i][j] , hor[i][j]);
                    while ( len > max ) {
                        if ( ver[i][j - len + 1] >= len && hor[i - len  +1][j] >= len) {
                            max = len; break;
                        }
                        len--;
                    }
                }
            }
            return max * max;
        }
    }
}
