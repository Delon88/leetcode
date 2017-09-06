package LC.SOL;

public class ReshapetheMatrix {
    class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int m = nums.length, n = nums[0].length;
            if (m * n != r * c) return nums;
            if (m == 0) return nums;
            int[][] ret = new int[r][c];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int nth = i * n + j ;
                    int row = nth / c;
                    int col = nth % c;
                    ret[row][col] = nums[i][j];
                }
            }
            return ret;
        }
    }
}
