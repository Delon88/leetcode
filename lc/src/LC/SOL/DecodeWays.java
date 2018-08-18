package LC.SOL;

public class DecodeWays {
    class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            int[] dp = new int[n + 1];
            dp[n] = 1;
            dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
            for (int i = n - 2; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == '0') {
                    dp[i] = 0;
                } else {
                    dp[i] += dp[i + 1];
                    if ( c == '1' || ( c == '2' && s.charAt(i + 1) <= '6')) {
                        dp[i] += dp[i + 2];
                    }
                }
            }
            return dp[0];
        }
    }

    class SolutionO1 {
        public int numDecodings(String s) {
            int f0 = 1, f1 = 0, f2 = 0;
            for ( int i = 0 ; i < s.length() ; i++) {
                char c = s.charAt(i);
                int e0 = ( c == '0' ? 0 : f0) + f1 + ( c >= '0' && c <= '6' ? f2 : 0);
                int e1 = ( c == '1' ? f0 : 0);
                int e2 = ( c == '2' ? f0 : 0);
                f0 = e0; f1 = e1; f2 = e2;
            }
            return f0;
        }
    }
}
