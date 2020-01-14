package LC.SOL;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a , b) -> a[0] - b[0]);
            int[] in = intervals[0];
            int ret = 0;
            for (int i = 1; i < intervals.length; i++) {
                int[] tmp = intervals[i];
                if (in[0] <= tmp[0] && in[1] >= tmp[1]) ret++;
                else in = tmp;
            }
            return intervals.length - ret;
        }
    }
}
