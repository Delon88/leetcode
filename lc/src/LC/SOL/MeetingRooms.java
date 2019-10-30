package LC.SOL;

import LC.DS.Interval;

import java.util.Arrays;

public class MeetingRooms {
    class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            if ( intervals.length <= 1) return true;
            Arrays.sort(intervals, ( i1, i2) -> i1[0] - i2[0]);
            for ( int i= 1 ; i < intervals.length ; i++) {
                if ( intervals[i - 1][1] > intervals[i][0] ) return false;
            }
            return true;
        }
    }
}
