package LC.SOL;

import LC.DS.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    class Solution {
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            List<Interval> ret = new ArrayList<>();
            int i = 0 ;
            while ( i < intervals.size() && intervals.get(i).end < newInterval.start) {
                ret.add(intervals.get(i));
                i++;
            }
            while ( i < intervals.size() && intervals.get(i).start <= newInterval.end ) {
                newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
                newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
                i++;
            }
            ret.add(newInterval);
            while ( i < intervals.size()) ret.add(intervals.get(i++));

            return ret;
        }
    }
}
