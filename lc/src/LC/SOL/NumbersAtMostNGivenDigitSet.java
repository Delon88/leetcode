package LC.SOL;

public class NumbersAtMostNGivenDigitSet {
    class Solution {
        // dp[i] = Math.max(
        public int atMostNGivenDigitSet(String[] D, int N) {
            String S = Integer.toString(N);
            int K = S.length();
            int[] dp = new int[K + 1];
            dp[K] = 1;
            for (int i = K - 1; i >= 0; i--) {
                int curD = S.charAt(i) - '0';
                for (String d : D) {
                    int digit = Integer.valueOf(d);
                    if ( curD > digit) {
                        dp[i] += Math.pow(D.length, K - i - 1);
                    } else if ( curD == digit) {
                        dp[i] += dp[i + 1];
                    }
                }
            }
            int ret = dp[0];
            for ( int i = 1 ; i < K ; i++) {
                ret+= Math.pow(D.length, i);
            }
            return ret;
        }
    }
}
