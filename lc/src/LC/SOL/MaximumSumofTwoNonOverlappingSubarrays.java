package LC.SOL;

public class MaximumSumofTwoNonOverlappingSubarrays {
    class Solution {
        public int maxSumTwoNoOverlap(int[] A, int L, int M) {
            for (int i = 1; i < A.length; i++) {
                A[i] += A[i - 1];
            }
            int ret = A[L + M - 1], Lmax = A[L - 1], Mmax = A[M - 1];
            for (int i = L + M; i < A.length; i++) {
                Lmax = Math.max(Lmax, A[i - M] - A[i - M - L]);
                Mmax = Math.max(Mmax, A[i - L] - A[i - L - M]);
                ret = Math.max(ret, Math.max(Lmax + A[i] - A[i - M], Mmax + A[i] - A[i - L]));
            }
            return ret;
        }
    }
}
