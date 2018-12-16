package LC.SOL;

public class LongestMountaininArray {
    class Solution {
        public int longestMountain(int[] A) {
            int n = A.length;
            int[] down = new int[n]; int[] up = new int[n];
            int ret = 0;
            for ( int i = n - 2 ; i >= 0 ; i--) {
                if (A[i] > A[i + 1]) {
                    down[i] = down[i + 1] + 1;
                }
            }
            for ( int i = 0 ; i < n ; i ++) {
                 if ( i > 0 && A[i] > A[i - 1]) up[i] = up[i - 1] + 1;
                 if ( up[i] > 0 && down[i] > 0 ) ret = Math.max(ret, up[i] + down[i] + 1);
            }
            return ret;
        }
    }
}
