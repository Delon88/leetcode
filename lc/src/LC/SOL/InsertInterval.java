package LC.SOL;

import LC.DS.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int i = 0, n = intervals.length;
            List<int[]> l = new ArrayList<>();
            while (i < n && intervals[i][1] < newInterval[0]) {
                l.add(intervals[i++]);
            }
            // merge
            while (i < n && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            l.add(newInterval);
            while ( i < n ) l.add(intervals[i++]);
            int[][] ret = new int[l.size()][2];
            for ( int j = 0 ; j < ret.length ; j++) ret[j] = l.get(j);
            return ret;
        }
    }
}
