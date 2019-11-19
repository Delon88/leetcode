package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingScheduler {
    class Solution {
        public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
            PriorityQueue<int[]> q = new PriorityQueue<>((a , b) -> a[0] - b[0]);
            for ( int[] s : slots1) if ( s[1] - s[0] >= duration) q.offer(s);
            for ( int[] s : slots2) if ( s[1] - s[0] >= duration) q.offer(s);
            while ( q.size() >  1 ) {
                int[] s1 = q.poll(), s2 = q.peek();
                if ( s1[1] >= s2[0] + duration ) return Arrays.asList(s2[0], s2[0] + duration);
            }
            return new ArrayList<>();
        }
    }

    class Solution1 {
        public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
            Arrays.sort(slots1, (a,b)->a[0]-b[0]); // sort increasing by start time
            Arrays.sort(slots2, (a,b)->a[0]-b[0]); // sort increasing by start time

            int i = 0, j = 0;
            int n1 = slots1.length, n2 = slots2.length;
            while (i < n1 && j < n2) {
                // Find intersect between slots1[i] and slots2[j]
                int intersectStart = Math.max(slots1[i][0], slots2[j][0]);
                int intersectEnd = Math.min(slots1[i][1], slots2[j][1]);

                if (intersectStart + duration <= intersectEnd) // Found the result
                    return Arrays.asList(intersectStart, intersectStart + duration);
                else if (slots1[i][1] < slots2[j][1])
                    i++;
                else
                    j++;
            }
            return new ArrayList<>();
        }
    }
}
