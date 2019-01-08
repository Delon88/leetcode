package LC.SOL;

public class ProfitableSchemes {
    class Solution {
        public int profitableSchemes(int G, int P, int[] group, int[] profit) {
            int[][] dp = new int[P + 1][G + 1];
            dp[0][0] = 1;
            int ret = 0, mod = (int) 1e9 + 7;
            for (int k = 0; k < group.length; k++) {
                int p = profit[k], g = group[k];
                for (int i = P; i >= 0; i--) {
                    for (int j = G - g; j >= 0; j--) {
                        if ( i + p < P ) {
                            dp[i + p][j + g] += dp[i][j];
                            dp[i + p][j + g] %= mod;
                        } else {
                            dp[P][j + g] += dp[i][j];
                            dp[P][j + g] %= mod;
                        }
                    }
                }
            }
            for ( int i : dp[P]) ret = ( ret + i) % mod;
            return ret;
        }
    }
}
