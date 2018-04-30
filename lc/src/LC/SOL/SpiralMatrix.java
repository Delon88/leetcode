package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ret = new ArrayList<>();
            if (matrix.length == 0) return ret;
            int rowStart = 0, rowEnd = matrix.length - 1;
            int colStart = 0, colEnd = matrix[0].length - 1;
            while (rowStart <= rowEnd && colStart <= colEnd) {
                // left -> right
                for ( int i = colStart ; i <= colEnd ; i++) {
                    ret.add(matrix[rowStart][i]);
                }
                rowStart++;
                // top -> down
                for ( int i = rowStart; i <= rowEnd ; i++) {
                    ret.add(matrix[i][colEnd]);
                }
                colEnd--;
                // right -> left
                if ( rowStart <= rowEnd ) {
                    for ( int i = colEnd ; i >= colStart ; i--) {
                        ret.add(matrix[rowEnd][i]);
                    }
                }
                rowEnd--;
                // down -> top
                if ( colStart <= colEnd ) {
                    for ( int i = rowEnd; i >= rowStart ; i--) {
                        ret.add(matrix[i][colStart]);
                    }
                }
                colStart++;
            }
            return ret;
        }
    }
}
