package LC.SOL;

import LC.DS.Interval;

import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval {
    public class Solution {
        public int[] findRightInterval(int[][] intervals) {
            int len = intervals.length;
            int[] ret = new int[intervals.length];
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < len; i++) {
                map.put(intervals[i][0], i);
            }

            for (int i = 0; i < intervals.length; i++) {
                Map.Entry<Integer, Integer> ceil = map.ceilingEntry(intervals[i][1]);
                if (ceil != null) {
                    ret[i] = ceil.getValue();
                } else {
                    ret[i] = -1;
                }
            }
            return ret;
        }
    }
}
