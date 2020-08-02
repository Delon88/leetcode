package LC.SOL;

import java.util.Arrays;

public class VideoStitching {
    class Solution {
        public int videoStitching(int[][] clips, int T) {
            int ret = 0;
            Arrays.sort(clips, (a, b) -> a[0] - b[0]);
            for (int i = 0, end = 0, nEnd = 0; end < T; end = nEnd, ret++) {
                for (; i < clips.length && clips[i][0] <= end; i++) {
                    nEnd = Math.max(nEnd, clips[i][1]);
                }
                if (nEnd <= end)
                    return -1;
            }
            return ret;
        }
    }

    class Solution2 {
        public int videoStitching(int[][] clips, int T) {
            int[] dp = new int[T + 1];
            Arrays.fill(dp, T + 1);
            dp[0] = 0;
            for (int i = 1; i <= T && dp[i - 1] < T; i++) {
                for (int[] c : clips) {
                    if (c[0] <= i && i <= c[1]) {
                        dp[i] = Math.min(dp[i], dp[c[0]] + 1);
                    }
                }
            }
            return dp[T] == T + 1 ? -1 : dp[T];
        }
    }
}
