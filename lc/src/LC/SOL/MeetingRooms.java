package LC.SOL;

import LC.DS.Interval;

import java.util.Arrays;

public class MeetingRooms {
    class Solution {
        public boolean canAttendMeetings(Interval[] intervals) {
            if ( intervals.length <= 1) return true;
            Arrays.sort(intervals, ( i1, i2) -> i1.start - i2.start);
            Interval tmp = new Interval(intervals[0].start, intervals[0].end);
            for ( int i= 1 ; i < intervals.length ; i++) {
                Interval in = intervals[i];
                if ( in.start < tmp.end ) return false;
                tmp = in;
            }
            return true;
        }
    }
}
