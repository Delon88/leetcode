package LC.SOL;

public class StoneGameII {
    class Solution {

        int[][] dp;
        int[] sums;

        public int stoneGameII(int[] piles) {
            if (piles == null || piles.length == 0) return 0;
            int n = piles.length;
            sums = new int[n];
            dp = new int[n][n];
            sums[n - 1] = piles[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                sums[i] = sums[i + 1] + piles[i];
            }
            return dfs(piles, 0 , 1);
        }

        int dfs(int[] piles, int i, int m) {
            if (i >= piles.length) return 0;
            if (2 * m >= piles.length - i) return sums[i];
            if (dp[i][m] != 0) return dp[i][m];
            int min = Integer.MAX_VALUE;
            for (int x = 1; x <= 2 * m; x++) {
                min = Math.min(min, dfs(piles, i + x, Math.max(m, x)));
            }
            dp[i][m] = sums[i] - min;
            return dp[i][m];
        }
    }
}
