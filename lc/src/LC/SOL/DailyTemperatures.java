package LC.SOL;

import java.util.*;

public class DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> stack = new Stack<>();
            int n = temperatures.length;
            int[] ret = new int[n];
            for (int i = 0; i < temperatures.length; i++) {
                if (stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]) {
                    stack.push(i);
                } else {
                    while ( !stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                        int index = stack.pop();
                        ret[index] = i - index;
                    }
                    stack.push(i);
                }
            }
            return ret;
        }
    }
}
