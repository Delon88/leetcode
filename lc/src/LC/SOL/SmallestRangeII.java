package LC.SOL;

import java.util.Arrays;

public class SmallestRangeII {
    class Solution {
        //
        public int smallestRangeII(int[] A, int K) {
            Arrays.sort(A);
            int n = A.length;
            int ret = A[n - 1] - A[0];
            int left = A[0] + K , right = A[n - 1] - K;
            for (int i = 0; i < A.length - 1; i++) {
                int max = Math.max(A[i] + K, right), min = Math.min(left, A[i + 1] - K);
                ret = Math.min( max - min, ret);
            }
            return ret;
        }
    }
}
