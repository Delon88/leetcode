package LC.SOL;

import java.util.*;

public class ExclusiveTimeofFunctions {
    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] ret = new int[n];
            Stack<int[]> stack = new Stack<>();
            for (String log : logs) {
                String[] parts = log.split(":");
                int id = Integer.parseInt(parts[0]);
                int time = Integer.parseInt(parts[2]);
                if (parts[1].equals("start")) {
                    stack.push(new int[]{id, time});
                } else {
                    int[] idAndTime = stack.pop();
                    ret[idAndTime[0]] += time - idAndTime[1] + 1;
                    if (!stack.isEmpty()) {
                        ret[stack.peek()[0]] -= time - idAndTime[1] + 1;
                    }
                }
            }
            return ret;
        }
    }
}
