package LC.SOL;

import java.util.Arrays;

public class KnightDialer {
    class Solution {
        int[][] dirs = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

        public int knightDialer(int N) {
            long[][] dp = new long[4][3];
            for (int i = 0; i < 4; i++) Arrays.fill(dp[i], 1);
            int mod = (int) Math.pow(10, 9) + 7;
            for (int k = 1; k < N; k++) {
                long[][] cp = new long[4][3];
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 3; j++) {
                        for (int[] d : dirs) {
                            int x = i + d[0], y = j + d[1];
                            if (x >= 0 && x < 4 && y >= 0 && y < 3 && !(x == 3 && (y == 0 || y == 2))) {
                                cp[i][j] = (cp[i][j] + dp[x][y]) % mod;
                            }
                        }
                    }
                }
                dp = cp;
            }
            long ret = 0;
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 3; j++) {
                    if (!(i == 3 && (j == 0 || j == 2))) {
                        ret = (ret + dp[i][j]) % mod;
                    }
                }
            return (int) ret;
        }
    }
}
