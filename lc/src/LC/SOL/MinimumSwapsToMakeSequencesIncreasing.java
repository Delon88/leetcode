package LC.SOL;

public class MinimumSwapsToMakeSequencesIncreasing {
    class Solution {
        public int minSwap(int[] A, int[] B) {
            int n = A.length;
            int[] swap = new int[n];
            int[] noswap = new int[n];
            swap[0] = 1;
            for ( int i = 1 ; i < n ; i++) {
                swap[i] = noswap[i] = Integer.MAX_VALUE;
                if ( A[i] > A[i - 1] && B[i] > B[i - 1] ) {
                    noswap[i] = Math.min(noswap[i -1], noswap[i]);
                    swap[i] = Math.min(swap[i - 1] + 1, swap[i]);
                }
                if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                    noswap[i] = Math.min(swap[i - 1], noswap[i]);
                    swap[i] = Math.min(noswap[i - 1] + 1, swap[i]);
                }
            }
            return Math.min(swap[n - 1] , noswap [n -1]);
        }
    }
}
