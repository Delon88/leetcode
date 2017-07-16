package LC.SOL;

import LC.DS.Interval;

import java.util.Arrays;


public class NonOverlappingIntervals {
    public class Solution {
        public int eraseOverlapIntervals(Interval[] intervals) {
            if (intervals.length == 0) return 0;
            Arrays.sort(intervals, (a, b) -> a.end - b.end);
            int end = intervals[0].end;
            int count = 1;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i].start >= end) {
                    end = intervals[i].end;
                    count++;
                }
            }
            return intervals.length - count;
        }
    }
}
