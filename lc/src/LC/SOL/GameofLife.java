package LC.SOL;

public class GameofLife {
    class Solution {
        // 0 dead
        // 1 live
        // 2 from live to dead
        // 3 from dead to live
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        public void gameOfLife(int[][] board) {
            int m = board.length, n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int live = 0;
                    for ( int[] d : dirs) {
                        int x =  i + d[0];
                        int y =  j + d[1];
                        if ( x >= 0 && x < m && y >= 0 && y < n ) {
                            if ( board[x][y] == 1 || board[x][y] == 2) live++;
                        }
                    }
                    // live state
                    if ( board[i][j] == 1 || board[i][j] == 2) {
                        if ( live < 2 ) { board[i][j] = 2;}
                        else if ( live <= 3) { board[i][j] = 1;}
                        else {board[i][j] = 2;}
                    } else {
                        if ( live == 3 ) board[i][j] = 3;
                    }
                }
            }

            for ( int i = 0 ; i < m ;i++) {
                for ( int j = 0 ; j < n ; j++) {
                    if ( board[i][j] == 2) { board[i][j] = 0;}
                    else if ( board[i][j] == 3) {board[i][j] = 1;}
                }
            }
        }
    }
}
