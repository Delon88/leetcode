package LC.SOL;

public class StrangePrinter {
    class Solution {
        // aba

        public int strangePrinter(String s) {
            int n = s.length();
            if ( n == 0  ) return 0;
            int[][] dp = new int[n][n];
            for ( int i = 0 ; i < n ; i++) {
                dp[i][i] = 1;
            }
            for ( int l = 1 ; l < n ; l++) {
                for ( int i = 0 ; i < n - l ; i++) {
                    int j = i + l;
                    dp[i][j] = l + 1;
                    for ( int k = i + 1 ; k <= j ; k++) {
                        int tmp = dp[i][k - 1] + dp[k][j];
                        if ( s.charAt(k - 1) == s.charAt(j)) tmp--;
                        dp[i][j] = Math.min(tmp , dp[i][j]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}
