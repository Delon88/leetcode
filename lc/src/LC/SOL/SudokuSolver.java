package LC.SOL;

public class SudokuSolver {
    class Solution {
        public void solveSudoku(char[][] board) {
            solve(board, 0 , 0);
        }

        boolean solve(char[][] board, int row, int col) {
            if ( row >= 9  ) return true;
            if ( col >= 9 ) { return solve(board, row + 1, 0);}

            // try every char
            if ( board[row][col] == '.') {
                for ( char c = '1' ; c <= '9' ; c++) {
                    if ( isValid(board, row, col, c)) {
                        board[row][col] = c;
                        if ( solve(board, row, col + 1)) return true;
                        board[row][col] = '.';
                    }
                }
            } else {
                return solve(board, row, col + 1);
            }
            return false;
        }

        public boolean isValid(char[][] board, int row, int col, char val) {

            int boxRow = (row / 3) * 3;
            int boxCol = (col / 3) * 3;

            for (int i = 0; i < 9; i++) {
                if ( board[i][col] == val ) return false;
                if ( board[row][i] == val ) return false;

                if ( board[boxRow + i / 3][boxCol + i % 3] == val) return false;
            }
            return true;
        }
    }
}
