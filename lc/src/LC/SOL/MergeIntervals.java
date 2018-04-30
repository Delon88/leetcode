package LC.SOL;

import LC.DS.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
    class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            List<Interval> ret = new ArrayList<>();
            if (intervals.size() == 0) return ret;
            Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);

            Interval tmp = intervals.get(0);

            for (int i = 1; i < intervals.size(); i++) {
                Interval in = intervals.get(i);
                if ( in.start > tmp.end ) {
                    ret.add(new Interval(tmp.start , tmp.end));
                    tmp = in;
                } else {
                    tmp.end = Math.max(in.end, tmp.end);
                }
            }
            ret.add(tmp);
            return ret;
        }
    }
}
