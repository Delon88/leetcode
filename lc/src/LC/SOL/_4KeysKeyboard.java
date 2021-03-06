package LC.SOL;

public class _4KeysKeyboard {
    class Solution {
        public int maxA(int N) {
            if ( N == 1) return 1;
            int[] dp = new int[N + 1];
            for ( int i = 1 ; i <= N ; i++) {
                dp[i] = i;
                for ( int j = 1 ; j <= i - 3; j++) {
                    dp[i] = Math.max(dp[i] , ( i - j - 1) * dp[j]);
                }
            }
            return dp[N];
        }
    }
}
