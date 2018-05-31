package LC.SOL;

import java.util.Arrays;

public class RussianDollEnvelopes {
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (a , b) -> {
                if ( a[0] != b[0]) return Integer.valueOf(a[0]).compareTo(b[0]);
                else return Integer.valueOf(b[1]).compareTo(a[1]);});
            return lis(envelopes);
        }

        int lis(int[][] ens) {
            int[] dp = new int[ens.length];
            Arrays.fill(dp, 1);
            for ( int i = 1 ; i < ens.length ; i++) {
                for ( int j = 0 ; j < i ; j++) {
                    if ( ens[i][1] > ens[j][1] && dp[i] < dp[j] + 1 ) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            int max = 0;
            for ( int i = 0 ; i < dp.length ; i++) {
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
