package LC.SOL;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SetIntersectionSizeAtLeastTwo {
//    An integer interval [a, b] (for integers a < b) is a set of all consecutive integers from a to b, including a and b.
//
//    Find the minimum size of a set S such that for every integer interval A in intervals, the intersection of S with A has size at least 2.
//    Example 1:
//
//    Input: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
//    Output: 3
//    Explanation:
//    Consider the set S = {2, 3, 4}.  For each interval, there are at least 2 elements from S in the interval.
//    Also, there isn't a smaller size set that fulfills the above condition.
//    Thus, we output the size of this set, which is 3.

    class Solution {
        public int intersectionSizeTwo(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                else return a[1] - b[1];
            });
            PriorityQueue<Integer> q = new PriorityQueue<>();
            q.offer(intervals[0][1]);
            for (int i = 1; i < intervals.length; i++) {

            }
        }
    }
}
