package LC.SOL;

public class PreviousPermutationWithOneSwap {
    class Solution {
        public int[] prevPermOpt1(int[] A) {
            int n = A.length;
            for (int i = n - 1; i > 0; i--) {
                if ( A[i - 1] > A[i]) {
                    // find the number less than A[i - 1]
                    int j = n - 1;
                    for (; j > i - 1; j--) {
                        if (A[j] < A[i - 1]) break;
                    }
                    while (j > i && A[j] == A[j - 1]) j--;
                    // swap
                    int tmp = A[i - 1];
                    A[i - 1] = A[j];
                    A[j] = tmp;
                    return A;
                }
            }
            return A;
        }
    }
}
