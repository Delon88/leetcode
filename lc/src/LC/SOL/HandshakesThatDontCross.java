package LC.SOL;

public class HandshakesThatDontCross {
    class Solution {
        public int numberOfWays(int n) {
            long mod = (long) 1e9 + 7;
            long[] dp = new long[n / 2 + 1];
            dp[0] = 1;
            for (int i = 1; i <= n / 2; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] = ( dp[i] + dp[j] * dp[i - j - 1] ) % mod;
                }
            }
            return (int) dp[n / 2];
        }
    }
}
