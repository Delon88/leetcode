package LC.SOL;

public class Searcha2DMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) return false;
            int m = matrix.length;
            int n = matrix[0].length;
            int l = 0, r = m * n - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (matrix[mid / n][mid % n] >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return matrix[l / n][l % n] == target;
        }
    }
}
