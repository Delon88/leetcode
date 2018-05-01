package LC.SOL;

public class SurroundedRegions {
    class Solution {

        int[][] dirs = {{0 , 1}, {1, 0}, {-1, 0}, {0 ,-1}};
        public void solve(char[][] board) {
            if ( board.length == 0 || board[0].length == 0 ) return;
            int m = board.length, n = board[0].length;
            for ( int i = 0 ; i < m; i++) {
                dfs(board, i, 0);
                dfs(board, i, n - 1);
            }
            for ( int i = 0 ; i < n ; i++) {
                dfs(board, 0, i );
                dfs(board, m - 1, i);
            }
            for ( int i = 0 ; i < m; i++ ) {
                for ( int j = 0 ; j < n ; j++) {
                    if ( board[i][j] == 'Z' ) {
                        board[i][j] = 'O';
                    } else {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        void dfs(char[][] board, int x, int y) {
            if ( x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') return;
            board[x][y] = 'Z';
            for ( int[] d : dirs) {
                int nextX = x + d[0];
                int nextY = y + d[1];
                dfs(board, nextX, nextY);
            }
        }
    }
}
