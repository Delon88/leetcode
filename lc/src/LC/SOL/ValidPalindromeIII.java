package LC.SOL;

public class ValidPalindromeIII {
    class Solution {
        public boolean isValidPalindrome(String s, int k) {
            int n = s.length();
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) dp[i][i] = 1;
            int max = 0;
            for (int l = 1; l < n; l++) {
                for (int i = 0; i + l < n; i++) {
                    int j = i + l;
                    if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                    else dp[i][j] = Math.max(dp[i + 1][j] , dp[i][j - 1]);
                    max = Math.max(max , dp[i][j]);
                }
            }
            return max >= n - k;
        }
    }
}
