package LC.SOL;

import java.util.Arrays;

public class DeleteColumnstoMakeSortedIII {
    class Solution {
        public int minDeletionSize(String[] A) {
            int m = A.length, n = A[0].length(), ret = n - 1, k = 0;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    for (k = 0; k < m; k++) {
                        if (A[k].charAt(j) > A[k].charAt(i)) break;
                    }
                    if (k == m && dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
                ret = Math.min(ret, n - dp[i]);
            }
            return ret;
        }
    }
}
