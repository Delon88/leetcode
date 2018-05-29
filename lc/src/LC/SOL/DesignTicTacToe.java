package LC.SOL;

public class DesignTicTacToe {
    class TicTacToe {

        int[] ROW , COL;

        int n;
        int diag, antiDiag;
        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            ROW = new int[n];
            COL = new int[n];
            diag = 0;
            antiDiag = 0;
            this.n = n;
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            int toAdd = player == 1 ? 1 : -1;
            ROW[row] += toAdd;
            COL[col] += toAdd;
            int n = ROW.length;
            if ( row == col  ) { diag+= toAdd;}
            if ( row == n - col - 1) { antiDiag += toAdd;}
            if ( Math.abs(ROW[row]) == n || Math.abs(COL[col]) == n || Math.abs(diag) == n || Math.abs(antiDiag) == n ) {
                return player;
            }
            return 0;
        }
    }
}
