package LC.SOL;


import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {
    class Solution {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, (c1 , c2) -> c1[1] - c2[1]);
            PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
            long time = 0l;
            for ( int[] c : courses) {
                time += c[0];
                q.add(c[0]);
                while ( time > c[1] && !q.isEmpty()) time -= q.poll();
            }
            return q.size();
        }
    }
}
