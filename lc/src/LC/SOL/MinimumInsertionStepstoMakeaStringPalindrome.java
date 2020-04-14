package LC.SOL;

public class MinimumInsertionStepstoMakeaStringPalindrome {
    class Solution {
        public int minInsertions(String s) {
            if ( s.length() == 0 ) return 0;
            int n = s.length();
            int[][] dp = new int[n][n];
            for ( int i = 0 ; i <n ; i++) dp[i][i] = 1;
            for ( int l = 1 ; l < n ; l++) {
                for ( int i = 0 ; i < n - l ; i++) {
                    int j = i + l;
                    if ( s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j  - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return n - dp[0][n - 1];
        }
    }
}
