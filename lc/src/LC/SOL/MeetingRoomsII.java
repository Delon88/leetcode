package LC.SOL;


import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            if ( intervals == null || intervals.length == 0) return 0;
            Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
            PriorityQueue<Integer> q = new PriorityQueue<>();
            q.offer(intervals[0][1]);
            for ( int i = 1 ; i < intervals.length ;i++) {
                if ( q.peek() <= intervals[i][0]) {
                    q.poll();
                }
                q.offer(intervals[i][1]);
            }
            return q.size();
        }
    }
}
