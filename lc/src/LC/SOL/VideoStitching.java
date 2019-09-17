package LC.SOL;

import java.util.Arrays;

public class VideoStitching {
    class Solution {
        public int videoStitching(int[][] clips, int T) {
            int ret = 0;
            Arrays.sort(clips, (a, b) -> a[0] - b[0]);
            for (int i = 0, st = 0, end = 0; st < T; st = end, ++ret) {
                for (; i < clips.length && clips[i][0] <= st; i++) {
                    end = Math.max(clips[i][1], end);
                }
                if ( st == end ) return -1;
            }
            return ret;
        }
    }
}
