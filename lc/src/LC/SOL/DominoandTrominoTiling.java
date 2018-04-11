package LC.SOL;

public class DominoandTrominoTiling {
    class Solution {
        public int numTilings(int N) {
            long[] dp = new long[N + 1 > 3 ? N + 1 : 4];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 5;
            if ( N <= 3) return (int) dp[N];
            int mod = ((int) 1e9) + 7;
            for ( int i = 4 ; i <= N ; i++ ) {
                dp[i] = 2 * dp[i - 1]  + dp[i - 3];
                dp[i] %= mod;
            }
            return (int) dp[N];
        }
    }
}
