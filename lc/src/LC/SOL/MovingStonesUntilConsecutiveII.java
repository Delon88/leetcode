package LC.SOL;

import java.util.Arrays;

public class MovingStonesUntilConsecutiveII {
    static class Solution {
        public int[] numMovesStonesII(int[] A) {
            Arrays.sort(A);
            int i = 0, n = A.length, low = n;
            int high = Math.max(A[n - 1] - n + 2 - A[1], A[n - 2] - A[0] - n + 2);
            for (int j = 0; j < n; ++j) {
                while (A[j] - A[i] >= n) i++;
                int stored = j - i + 1;
                if (stored == n - 1 && A[j] - A[i] == n - 2) {
                    low = 2;
                } else {
                    low = Math.min(low, n - stored);
                }
            }
            return new int[]{low, high};
        }
    }

    public static void main(String[] args) {
        int[] in = {1, 10, 30, 50, 100};
        int[] ret = new Solution().numMovesStonesII(in);
        System.out.println(Arrays.toString(ret));
    }

}
