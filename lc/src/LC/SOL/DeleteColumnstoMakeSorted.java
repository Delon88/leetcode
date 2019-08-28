package LC.SOL;

public class DeleteColumnstoMakeSorted {
    class Solution {
        public int minDeletionSize(String[] A) {
            int m = A.length, n = A[0].length();
            boolean[] del = new boolean[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m - 1; j++) {
                    if ( A[j].charAt(i) > A[j+1].charAt(i)) {
                        del[i] = true;
                        break;
                    }
                }
            }
            int ret = 0;
            for ( int i = 0  ;i < n ; i++) {
                if ( del[i] ) ret++;
            }
            return ret;
        }
    }
}
