package LC.SOL;

public class SuperUglyNumber {
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int m = primes.length;
            int[] index = new int[m];
            int[] dp = new int[n];
            dp[0] = 1;
            for ( int i = 1; i < n ; i++) {
                dp[i] = Integer.MAX_VALUE;
                for ( int j = 0 ; j < m ; j++ ) {
                    dp[i] = Math.min(dp[i], primes[j] * dp[index[j]]);
                }
                for ( int j = 0 ; j < m; j++) {
                    if ( primes[j] * dp[index[j]] == dp[i]) {
                        index[j]++;
                    }
                }
            }
            return dp[n - 1];
        }
    }
}
