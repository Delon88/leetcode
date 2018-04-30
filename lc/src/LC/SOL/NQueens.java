package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> ret = new ArrayList<>();
            solve(0 , new int[n], ret);
            return ret;
        }

        void solve(int row, int[] pos, List<List<String>> ret) {
            if ( row == pos.length ) { ret.add(posToString(pos));return;}
            for ( int i = 0 ; i < pos.length ; i++ ) {
                if ( isValid(pos, row , i)) {
                    pos[row] = i;
                    solve(row + 1 , pos, ret);
                }
            }
        }

        boolean isValid(int[] pos, int row, int col) {
            for ( int i = 0 ; i < row ; i++) {
                // check vertical
                if ( pos[i] == col ) return false;
                // check diagonal
                if ( row - i == Math.abs(pos[i] - col)) return false;
            }
            return true;
        }


        List<String> posToString(int[] pos) {
            int n = pos.length;
            List<String> ret = new ArrayList<>();
            for ( int i = 0 ; i < n ;i++) {
                StringBuilder b = new StringBuilder();
                for ( int j = 0 ; j < n; j++) {
                    if ( pos[i] == j ) b.append('QQ');
                    else b.append('.');
                }
                ret.add(b.toString());
            }
            return ret;
        }

    }
}
