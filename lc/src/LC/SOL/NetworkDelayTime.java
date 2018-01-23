package LC.SOL;

import java.util.Arrays;

public class NetworkDelayTime {
    class Solution {
        public int networkDelayTime(int[][] times, int N, int K) {
            long[] dp = new long[N + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[K] = 0;
            for (int i = 1; i <= N - 1; i++) {
                for (int[] e : times) {
                    int u = e[0] , v = e[1] , w = e[2];
                    if (dp[u] + w < dp[v]) {
                        dp[v] = dp[u] + w;
                    }
                }
            }
            int max = 0;
            for (int i = 1; i <= N; i++) {
                if (i != K) {
                    if (dp[i] == Integer.MAX_VALUE) {
                        return -1;
                    } else {
                        max = Math.max((int) dp[i], max);
                    }
                }
            }
            return max;
        }
    }
}
