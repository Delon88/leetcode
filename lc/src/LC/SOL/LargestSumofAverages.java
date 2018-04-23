package LC.SOL;

public class LargestSumofAverages {
    class Solution {
        // A = [9,1,2,3,9]
        // K = 3
        // 9 + (1 + 2 + 3) / 3 + 9 = 20
        // DP[i , j]   [0 , i]  and j sub array
        double[][] dp;

        public double largestSumOfAverages(int[] A, int K) {
            int n = A.length;
            dp = new double[n + 1][n + 1];
            double sum = 0d;
            for (int i = 0; i < n; i++) {
                sum += A[i];
                dp[i + 1][1] = sum / (i + 1);
            }
            return solve(n, K, A);
        }

        double solve(int n, int k, int[] A) {
            if (dp[n][k] > 0) return dp[n][k];
            double sum = 0d;
            for (int i = n - 1; i > 0; i--) {
                sum += A[i];
                dp[n][k] = Math.max(dp[n][k], solve( i , k - 1, A) + sum / (n - i));
            }
            return dp[n][k];
        }
    }
}
