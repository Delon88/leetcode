package LC.SOL;

import java.util.Arrays;

public class MinimumDifficultyofaJobSchedule {
    class Solution {
        public int minDifficulty(int[] jobDifficulty, int d) {
            int n = jobDifficulty.length;
            if ( n < d) return -1;
            int[][] dp = new int[n][d + 1];
            for (int[] row : dp) Arrays.fill(row, -1);

            return dfs(d , 0 , jobDifficulty, dp);
        }

        private int dfs(int d, int start, int[] jobDifficulty, int[][] dp) {
            int n = jobDifficulty.length;
            if ( d == 0 && start == n ) return 0;
            if ( d == 0 || start == n ) return Integer.MAX_VALUE;
            if ( dp[start][d] != -1) return dp[start][d];

            int max = jobDifficulty[start];
            int min = Integer.MAX_VALUE;
            for ( int sched = start ; sched < n ; sched++) {
                max = Math.max(max, jobDifficulty[sched]);
                int rest = dfs(  d - 1 , sched + 1 , jobDifficulty, dp);
                if ( rest != Integer.MAX_VALUE) {
                    min = Math.min(min, max + rest);
                }
            }
            dp[start][d] = min;
            return min;
        }
    }
}
