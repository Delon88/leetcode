package LC.SOL;

import LC.DS.Interval;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by nanhong on 7/15/2017.
 */
public class FindRightInterval {
    public class Solution {
        public int[] findRightInterval(Interval[] intervals) {
            int len = intervals.length;
            int[] ret = new int[intervals.length];
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < len; i++) {
                map.put(intervals[i].start, i);
            }

            for (int i = 0; i < intervals.length; i++) {
                Map.Entry<Integer, Integer> ceil = map.ceilingEntry(intervals[i].end);
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
