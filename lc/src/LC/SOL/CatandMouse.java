package LC.SOL;

import java.util.Arrays;

public class CatandMouse {
    class Solution {
        public int catMouseGame(int[][] graph) {
            int n = graph.length;
            int[][] dp = new int[n][n];
            for (int[] d : dp) {
                Arrays.fill(d, -1);
            }
            for (int i = 1; i < n; i++) {
                dp[0][i] = 1;
                dp[i][i] = 1;
            }

        }

        int dfs(int[][] dp, int mouse, int cat, int[][] graph) {
            if ( dp[mouse][cat] != -1) {
                return dp[mouse][cat];
            }
            dp[mouse][cat] = 0;

        }
    }
}
