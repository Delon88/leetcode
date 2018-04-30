package LC.SOL;

public class ValidSudoku {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                boolean[] row = new boolean[10];
                boolean[] col = new boolean[10];
                boolean[] box = new boolean[10];
                for (int j = 0; j < 9; j++) {
                    // vertically
                    if (board[i][j] != '.') {
                        if (row[board[i][j] - '0']) return false;
                        row[board[i][j] - '0'] = true;
                    }
                    // horizontally
                    if (board[j][i] != '.') {
                        if (col[board[j][i] - '0']) return false;
                        col[board[j][i] - '0'] = true;
                    }
                    // box
                    int boxRow = 3 * (i / 3);
                    int boxCol = 3 * (i % 3);
                    char boxChar = board[boxRow + j / 3][boxCol + j % 3];
                    if ( boxChar != '.') {
                        if ( box[boxChar - '0']) return false;
                        box[boxChar - '0'] = true;
                    }
                }
            }
            return true;
        }
    }
}
