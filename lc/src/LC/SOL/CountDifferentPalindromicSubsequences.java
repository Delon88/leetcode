package LC.SOL;

public class CountDifferentPalindromicSubsequences {
    class Solution {
        public int countPalindromicSubsequences(String S) {
            int n = S.length();
            char[] s = S.toCharArray();
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }

            for (int d = 1; d < n; d++) {
                for (int i = 0; i < n - d; i++) {
                    int j = i + d;
                    // dp[i][j] = dp[i + 1][j] + dp[i][j -1] - dp[i + 1][j - 1]
                    if (s[i] != s[j]) {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    } else {
                        int low = i + 1;
                        int high = j - 1;
                        while (low <= high && s[low] != s[j]) {
                            low++;
                        }
                        while (low <= high && s[high] != s[j]) {
                            high--;
                        }
                        if (low > high) {
                            // consider the string from i to j is "a...a" "a...a"... where there is no character 'a' inside the leftmost and rightmost 'a'
                         /* eg:  "aba" while i = 0 and j = 2:  dp[1][1] = 1 records the palindrome{"b"},
                         the reason why dp[i + 1][j  - 1] * 2 counted is that we count dp[i + 1][j - 1] one time as {"b"},
                         and additional time as {"aba"}. The reason why 2 counted is that we also count {"a", "aa"}.
                         So totally dp[i][j] record the palindrome: {"a", "b", "aa", "aba"}.
                         */
                            dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                        } else if (low == high) {
                            // consider the string from i to j is "a...a" "a...a"... where there is no character 'a' inside the leftmost and rightmost 'a'
                         /* eg:  "aba" while i = 0 and j = 2:  dp[1][1] = 1 records the palindrome{"b"},
                         the reason why dp[i + 1][j  - 1] * 2 counted is that we count dp[i + 1][j - 1] one time as {"b"},
                         and additional time as {"aba"}. The reason why 2 counted is that we also count {"a", "aa"}.
                         So totally dp[i][j] record the palindrome: {"a", "b", "aa", "aba"}.
                         */

                            dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                        } else {
                            // a[..a..a..]a
                            dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1];
                        }
                    }
                    dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
                }
            }
            return dp[0][n - 1];
        }
    }
}
