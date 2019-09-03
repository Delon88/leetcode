package LC.SOL;

public class DeleteColumnstoMakeSortedII {
    class Solution {
        public int minDeletionSize(String[] A) {
            int m = A.length, n = A[0].length(), i, j;
            boolean[] sorted = new boolean[m - 1];
            int ret = 0;
            for (i = 0; i < n; i++) {
                for (j = 0; j < m - 1; j++) {
                    if (!sorted[j] && A[j].charAt(i) > A[j + 1].charAt(i)) {
                        ret++;
                        break;
                    }
                }
                if (j < m - 1) continue;
                for (j = 0; j < m - 1; j++) {
                    sorted[j] |= ( A[j].charAt(i) < A[j + 1].charAt(i));
                }
            }
            return ret;
        }
    }
}
