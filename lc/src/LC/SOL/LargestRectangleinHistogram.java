package LC.SOL;

import java.util.Stack;

public class LargestRectangleinHistogram {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            for ( int i = 0  ;i <= heights.length ;) {
                int h = i == heights.length ? 0: heights[i];
                if ( stack.isEmpty() || h >= heights[stack.peek()]) {stack.push(i); i++;}
                else {
                    int j = stack.pop();
                    max = Math.max(max, heights[j] * ( stack.isEmpty() ? i : i - stack.peek() - 1) );
                }
            }
            return max;
        }
    }
}
