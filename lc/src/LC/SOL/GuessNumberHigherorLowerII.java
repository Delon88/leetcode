package LC.SOL;

public class GuessNumberHigherorLowerII {
    static class Solution {
        public int getMoneyAmount(int n) {
            int[][] table = new int[n + 1][n + 1];
            for (int j = 2; j <= n; j++) {
                for (int i = j - 1; i > 0; i--) {
                    int globalMin = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; k++) {
                        int localMax = k + Math.max(table[i][k - 1], table[k + 1][j]);
                        globalMin = Math.min(globalMin, localMax);
                    }
                    table[i][j] = i + 1 == j ? i : globalMin;
                }
            }
            return table[1][n];
        }

        public int getMoneyAmount1(int n) {
            int[][] dp = new int[n + 1][n + 1];
            return solve(1 , n , dp);
        }

        int solve(int start , int end , int[][] dp ) {
            if ( start >= end ) return 0;
            if ( dp[start][end] != 0  ) return dp[start][end];
            int minCost = Integer.MAX_VALUE;
            for ( int k = start ; k <= end ; k++) {
                int cost = k + Math.max(solve(start, k - 1, dp) , solve(k + 1, end, dp));
                minCost = Math.min(minCost, cost);
            }
            dp[start][end] = minCost;
            return dp[start][end];
        }
    }
}
