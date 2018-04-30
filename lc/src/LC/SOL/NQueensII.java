package LC.SOL;

public class NQueensII {
    class Solution {
        int count = 0;
        public int totalNQueens(int n) {
            count = 0;
            solve( 0 , new int[n]);
            return count;
        }

        void solve(int row, int[] pos) {
            if ( pos.length == row ) {count++;return;}
            for ( int i = 0 ;i < pos.length ; i++) {
                if ( isValid(pos, row, i)) {
                    pos[row] = i;
                    solve(row + 1, pos );
                }
            }
        }

        boolean isValid(int[] pos, int row, int col) {
            for ( int i = 0 ; i < row ; i++) {
                // check vertically
                if ( pos[i] == col ) return false;
                // diagonal
                if ( row - i == Math.abs(pos[i] - col)) return false;
            }
            return true;
        }

    }
}
