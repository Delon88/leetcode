package LC.SOL;

import java.util.Arrays;

public class VideoStitching {
    class Solution {
        public int videoStitching(int[][] clips, int T) {
            int ret = 0;
            Arrays.sort(clips, (a, b) -> a[0] - b[0]);
            for (int i = 0, start = 0, end = 0; start < T; start = end, ++ret) {
                for (; i < clips.length && clips[i][0] <= start; i++) {
                    end = Math.max(end, clips[i][1]);
                }
                if ( start == end ) return -1;
            }
            return ret;
        }
    }

    class Solution2 {
        public int videoStitching(int[][] clips, int T) {
            
        }
    }
}
