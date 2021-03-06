package LC.SOL;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if ( matrix == null || matrix.length == 0) return 0;
            int m = matrix.length, n = matrix[0].length;
            int[][] aux = new int[m][n];
            for ( int i = 0 ;  i < m ; i++) {
                for ( int j = 0 ; j < n ; j++) {
                    if ( matrix[i][j] == '1') {
                        if ( i == 0) aux[i][j] = 1;
                        else aux[i][j] = aux[i - 1][j] + 1;
                    } else {
                        aux[i][j] = 0;
                    }
                }
            }
            int max = 0;
            for ( int i = 0 ; i < m ;i++) {
                max = Math.max(largestRectangleArea(aux[i]) , max);
            }
            return max;
        }

        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            for ( int i = 0  ;i <= heights.length ;) {
                int h = i == heights.length ? 0: heights[i];
                if ( stack.isEmpty() || h >= heights[stack.peek()]) {stack.push(i); i++;}
                else {
                    int j = stack.pop();
                    max = Math.max(max, heights[j] * ( stack.isEmpty() ? i : i - stack.peek() - 1) );
                }
            }
            return max;
        }
    }
}
