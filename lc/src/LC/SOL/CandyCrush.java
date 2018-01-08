package LC.SOL;


import java.util.HashSet;
import java.util.Set;

public class CandyCrush {
    class Solution {
        public int[][] candyCrush(int[][] board) {
            Set<Pair> set = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    int cur = board[i][j];
                    if (cur == 0) continue;
                    if ((i >= 2 && board[i - 2][j] == cur && board[i - 1][j] == cur) ||

                            (i >= 1 && i < board.length - 1 && board[i - 1][j] == cur && board[i + 1][j] == cur) ||

                            (i < board.length - 2 && board[i + 1][j] == cur && board[i + 2][j] == cur) ||

                            (j >= 2 && board[i][j - 2] == cur && board[i][j - 1] == cur) ||

                            (j >= 1 && j < board[0].length - 1 && board[i][j - 1] == cur && board[i][j + 1] == cur) ||

                            (j < board[0].length - 2 && board[i][j + 1] == cur && board[i][j + 2] == cur)) {
                        set.add(new Pair(i ,j));
                    }
                }
            }
            if ( set.isEmpty()) return board;
            for ( Pair p : set) {
                board[p.i][p.j] = 0;
            }
            drop(board);
            return candyCrush(board);
        }

        void drop(int[][] board) {
            for ( int j = 0 ; j < board[0].length ; j++) {
                int bot = board.length - 1;
                // find bot 0
                while ( bot >= 0 && board[bot][j] != 0) {
                    bot--;
                }
                if ( bot < 0 ) continue;
                int top  = bot;
                for ( int i = bot ;i >= 0 ; i--) {
                    if ( board[i][j] != 0 ) {
                        board[top--][j] = board[i][j];
                    }
                }
                for ( int i = top; i >= 0 ; i--) {
                    board[i][j] = 0;
                }
            }
        }

        class Pair {
            int i, j;

            public Pair(int i, int j) {
                this.i = i;
                this.j = j;
            }

            @Override
            public int hashCode() {
                return i * 31 + j;
            }
        }
    }
}
