package LC.SOL;

public class MinimumSwapsToMakeSequencesIncreasing {
    class Solution {
        public int minSwap(int[] A, int[] B) {
            int swap = 1, noswap = 0;
            for (int i = 1; i < A.length; i++) {
                if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) {
                    swap++;
                } else if ( A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
                    int tmp = swap;
                    swap = noswap + 1;
                    noswap = tmp;
                } else {
                    int min = Math.min(noswap, swap);
                    noswap = min;
                    swap = min + 1;
                }
            }
            return Math.min(noswap, swap);
        }
    }
}
