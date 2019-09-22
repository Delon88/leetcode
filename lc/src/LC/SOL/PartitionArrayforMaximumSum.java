package LC.SOL;

public class PartitionArrayforMaximumSum {
    class Solution {
        public int maxSumAfterPartitioning(int[] A, int K) {
            int n = A.length;
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                int max = Integer.MIN_VALUE;
                for (int j = 1; j <= K && i - j + 1 >= 0; j++) {
                    max = Math.max(max, A[i - j + 1]);
                    dp[i] = Math.max(dp[i], (i >= j ? dp[i - j] : 0) + max * j);
                }
            }
            return dp[n - 1];
        }
    }
}
