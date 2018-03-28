package LC.SOL;

import java.util.*;

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
//    [1, 3] [3 ,5]
    class Solution {
        public int intersectionSizeTwo(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                else return b[1] - a[1];
            });
            Stack<int[]> stack = new Stack<>();
            for (int[] in : intervals) {
                while (!stack.isEmpty() && stack.peek()[1] >= in[1]) stack.pop();
                stack.push(in);
            }
            int[][] ins = new int[stack.size()][2];
            for (int i = stack.size() - 1; i >= 0; i--) {
                ins[i] = stack.pop();
            }
            int ret = 2;
            int p1 = ins[0][1] - 1, p2 = ins[0][1];
            for (int i = 1; i < ins.length; i++) {
                int overlap= 0 ;
                if ( p1 >= ins[i][0] && p1 <= ins[i][1]) overlap++;
                if ( p2 >= ins[i][0] && p2 <= ins[i][1]) overlap++;
                if ( overlap >= 2) {continue;}
                else if ( overlap == 1) { ret+=1; p1 = p2;p2 = ins[i][1];}
                else if ( overlap == 0) { ret+=2; p1 = ins[i][1] - 1; p2 = ins[i][1];}
            }
            return ret;
        }
    }
}
