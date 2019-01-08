package LC.SOL;

public class StoneGame {
    class Solution {
        public boolean stoneGame(int[] piles) {
            int n = piles.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) dp[i][i] = 1;
            for (int l = 1; l < n; l++) {
                for ( int i = 0  ; i < n - l ; i++) {
                    int j = i + l ;
                    dp[i][j] = Math.max(dp[i][j - 1] + piles[j] , dp[i + 1][j] + piles[i]);
                }
            }
            return dp[0][n -1] > 0;
        }
    }
}
