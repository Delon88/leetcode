package LC.SOL;

import java.util.Arrays;

public class MinimumNumberofTapstoOpentoWateraGarden {
    static class Solution {
        public int minTaps(int n, int[] ranges) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, n + 2);
            dp[0] = 0;
            for (int i = 0; i <= n; i++) {
                for (int j = Math.max(0, i - ranges[i]); j <= Math.min(i + ranges[i], n); j++) {
                    dp[j] =  Math.min(dp[j], dp[Math.max(0, i - ranges[i])] + 1);
                }
            }
            return dp[n] == n + 2 ? -1 : dp[n];
        }
    }

    public static void main(String[] args) {
        Solution m = new Solution();
        int[] a = { 3, 4, 1, 1, 0, 0 };

        System.out.println(m.minTaps(5, a));
    }
}
