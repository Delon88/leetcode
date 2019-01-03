package LC.SOL;

import java.util.*;

public class LoudandRich {
    class Solution {
        int[] dp;
        Map<Integer,List<Integer>> graph;
        public int[] loudAndRich(int[][] richer, int[] quiet) {
            int n = quiet.length;
            dp = new int[n];
            graph = new HashMap<>();
            for ( int i = 0 ; i < n ; i++) graph.put(i, new ArrayList<>());
            for ( int[] r : richer) graph.get(r[1]).add(r[0]);
            Arrays.fill(dp , -1);
            for ( int i = 0 ; i < n ; i++) dfs(i , quiet);
            return dp;
        }

        int dfs(int i, int[] quiet) {
            if ( dp[i] != -1) return dp[i];
            dp[i] = i;
            for ( int nei : graph.get(i)) {
                if ( quiet[dp[i]] > quiet[dfs(nei, quiet)] ) dp[i] = dp[nei];
            }
            return dp[i];
        }
    }
}
