package LC.SOL;


public class SquaresofaSortedArray {
    class Solution {
        public int[] sortedSquares(int[] A) {
            int i = 0, j = A.length - 1, n = A.length;
            int[] ret = new int[n];
            for (int p = n - 1; p >= 0; p--) {
                if (Math.abs(A[i]) > Math.abs(A[j])) {
                    ret[p] = A[i] * A[i];
                    i++;
                } else {
                    ret[p] = A[j] * A[j];
                    j--;
                }
            }
            return ret;
        }
    }
}
