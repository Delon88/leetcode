package LC.SOL;

public class MinimumDominoRotationsForEqualRow {
    class Solution {
        public int minDominoRotations(int[] A, int[] B) {
            if ( A.length != B.length ) return -1;
            int[] cA = new int[7], cB = new int[7], same = new int[7];
            for ( int i = 0 ; i < A.length ; i++) {
                cA[A[i]]++; cB[B[i]]++; if ( A[i] == B[i]) same[A[i]]++;
            }
            int ret = Integer.MAX_VALUE;
            for ( int i = 1 ; i <= 6 ; i++) {
                if ( cA[i] + cB[i] - same[i] == A.length) ret = Math.min(ret, Math.min(cA[i], cB[i]) - same[i]);
            }
            return ret == Integer.MAX_VALUE ? -1: ret;
        }
    }
}
