package LC.SOL;

public class SumofEvenNumbersAfterQueries {
    class Solution {
        public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
            int even = 0;
            for ( int i = 0 ; i < A.length ; i++) {
                if ( A[i] % 2 == 0) even += A[i];
            }
            int[] ret = new int[queries.length];
            int i = 0;
            for ( int[] q : queries) {
                if ( A[q[1]] % 2 == 0 ) even -= A[q[1]];
                A[q[1]] += q[0];
                if ( A[q[1]] % 2 == 0 ) even += A[q[1]];
                ret[i++] = even;
            }
            return ret;
        }
    }
}
