package LC.SOL;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleinHistogram {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int[] h = Arrays.copyOf(heights, heights.length + 1);
            int i = 0 ;
            int max = 0;
            while ( i < h.length ) {
                if ( stack.isEmpty() || h[stack.peek()] <= h[i]) {
                    stack.push(i);
                    i++;
                } else {
                    int j = stack.pop();
                    max = Math.max(max, h[j] * (stack.isEmpty()  ? i : i - stack.peek() - 1));
                }
            }
            return max;
        }
    }
}
