package LC.SOL;

import java.util.Arrays;

public class MinimumWindowSubsequence {
    class Solution {
        public String minWindow(String S, String T) {
            // dp[i][j] =  starting index of k in S with shortest subString such that T[0.j] is a subsequence of it
            // update rule:
            // 1) when S[i] == T[j], dp[i][j] = Max(dp[k][j - 1]) for k < i
            int m = T.length(), n = S.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= n; i++) {
                dp[0][i] = i + 1;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (T.charAt(i - 1) == S.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }

            int len = n + 1, start = 0;
            for (int j = 1; j <= n; j++) {
                if (dp[m][j] != 0 && j - (dp[m][j] - 1) < len) {
                    start = dp[m][j] - 1;
                    len = j - (dp[m][j] - 1);
                }
            }
            return len == n + 1 ? "" : S.substring(start, start + len);
        }
    }
}
