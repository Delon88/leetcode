package LC.SOL;

import LC.DS.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) return new int[0][];
            Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
            int[] tmp = intervals[0];
            List<int[]> l = new ArrayList<>();
            for (int i = 1; i < intervals.length; i++) {
                int[] in = intervals[i];
                if (in[0] > tmp[1]) {
                    l.add(tmp);
                    tmp = in;
                } else {
                    tmp[1] = Math.max(tmp[1], in[1]);
                }
            }
            l.add(tmp);
            int[][] ret = new int[l.size()][2];
            for (int i = 0; i < ret.length; i++) ret[i] = l.get(i);
            return ret;
        }
    }
}
