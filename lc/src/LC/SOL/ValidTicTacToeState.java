package LC.SOL;

public class ValidTicTacToeState {
    class Solution {
        public boolean validTicTacToe(String[] board) {
            int x = 0, o = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i].charAt(j) == 'X') x++;
                    else if (board[i].charAt(j) == 'O') o++;
                }
            }
            if (!(x == o || x - 1 == o)) return false;
            boolean xWin = checkWin('X', board);
            boolean oWin = checkWin('O', board);
            if ( xWin && oWin) return false;
            if ( xWin && o == x) return false;
            if ( oWin && x - 1 == o) return false;
            return true;
        }

        boolean checkWin(char c, String[] board) {
            for (int i = 0; i < board.length; i++) {
                if (board[i].equals("" + c + c + c)) return true;
                if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) return true;
            }
            if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) return true;
            if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) return true;
            return false;
        }
    }
}
