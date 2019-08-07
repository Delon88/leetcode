package LC.SOL;

public class SortArrayByParityII {
    class Solution {
        public int[] sortArrayByParityII(int[] A) {
            int i = 0, j = 1, n = A.length;
            while (i < n && j < n) {
                while (i < n && A[i] % 2 == 0) {
                    i += 2;
                }
                while (j < n && A[j] % 2 == 1) {
                    j += 2;
                }
                if (i < n && j < n) {
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }
            return A;
        }
    }

    class SolutionExtraSpace {
        public int[] sortArrayByParityII(int[] A) {
            int i = 0, j = 1, n = A.length;
            int[] ret = new int[n];
            for (int k = 0; k < n; k++) {
                if (A[k] % 2 == 0) {
                    ret[i] = A[k];
                    i += 2;
                } else {
                    ret[j] = A[k];
                    j += 2;
                }
            }
            return ret;
        }
    }
}
