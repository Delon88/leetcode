package LC.SOL;

public class RotateImage {
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int layer = 0; layer < n / 2; layer++) {
                int last = n - layer - 1;
                for ( int i = layer ; i < last ; i++) {
                    int top = matrix[layer][i];
                    // left to top
                    matrix[layer][i] = matrix[n - 1 - i][layer];
                    // bot to left
                    matrix[n - i - 1][layer] = matrix[last][n - i - 1];
                    // right to bot
                    matrix[last][ n - i - 1] = matrix[i][last];
                    // top to right;
                    matrix[i][last] = top;
                }
            }
        }
    }
}
