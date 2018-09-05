package LC.SOL;

public class New21Game {
    class Solution {
        // dp[i]: probability of
        public double new21Game(int N, int K, int W) {
            if (K == 0 || N >= K + W) return 1;
            double[] dp = new double[N + 1];
            dp[0] = 1;
            double pSum = 1, ret = 0;
            for ( int i = 1 ; i <= N ; i++) {
                dp[i] = pSum / W;
                if ( i < K ) pSum += dp[i]; else ret += dp[i];
                if ( i >= W ) pSum -= dp[i - W];
            }
            return ret;
        }
    }
}
