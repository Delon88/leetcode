package LC.SOL;

import LC.DS.Interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    class Solution {
        public int minMeetingRooms(Interval[] intervals) {
            if ( intervals == null || intervals.length == 0) return 0;
            Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
            PriorityQueue<Integer> q = new PriorityQueue<>();
            q.offer(intervals[0].end);
            for ( int i = 1 ; i < intervals.length ;i++) {
                if ( q.peek() <= intervals[i].start) {
                    q.poll();
                }
                q.offer(intervals[i].end);
            }
            return q.size();
        }
    }
}
