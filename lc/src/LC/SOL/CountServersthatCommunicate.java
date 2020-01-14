package LC.SOL;

public class CountServersthatCommunicate {
    class Solution {
        public int countServers(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[] row = new int[m], col = new int[n];
            for ( int i = 0 ; i < m  ; i++) {
                for ( int j = 0 ; j < n ; j++) {
                    if ( grid[i][j] == 1)  {
                        row[i]++;col[j]++;
                    }
                }
            }
            int ret = 0;
            for ( int i = 0 ; i < m ; i++) {
                for ( int j = 0 ; j < n ; j++) {
                    if ( grid[i][j] == 1 && ( row[i] > 1 || col[j] > 1 ) ) ret++;
                }
            }
            return ret;
        }
    }
}
