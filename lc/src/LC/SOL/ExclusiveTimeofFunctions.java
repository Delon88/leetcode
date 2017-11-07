package LC.SOL;

import java.util.*;

public class ExclusiveTimeofFunctions {
    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            Stack<int[]> stack = new Stack<>();
            Map<Integer, Integer> excluMap = new HashMap<>();
            TreeMap<Integer, Integer> incluMap = new TreeMap<>();
            for (int i = 0; i < logs.size(); i++) {
                String cur = logs.get(i);
                if (cur.contains("start")) {
                    stack.push(getIdAndStart(cur));
                } else {
                    int[] start = stack.pop();
                    int[] end = getIdAndStart(cur);
                    if (!stack.isEmpty()) {
                        excluMap.put(stack.peek()[0], excluMap.getOrDefault(stack.peek()[0], 0) + end[1] - start[1] + 1);
                    }
                    incluMap.put(start[0], incluMap.getOrDefault(start[0], 0) + end[1] - start[1] + 1);
                }
            }

            for (Map.Entry<Integer, Integer> e : excluMap.entrySet()) {
                incluMap.put(e.getKey(), incluMap.getOrDefault(e.getKey(), 0) - e.getValue());
            }

            int[] ret = new int[n];
            int i = 0;
            for (Map.Entry<Integer, Integer> e : incluMap.entrySet()) {
                ret[i++] = e.getValue();
            }
            return ret;
        }

        int[] getIdAndStart(String s) {
            String[] arr = s.split(":");
            return new int[]{Integer.parseInt(arr[0]), Integer.parseInt(arr[2])};
        }

        public int[] exclusiveTime1(int n, List<String> logs) {
            int[] ret = new int[n];
            Stack<Integer> stack = new Stack<>();
            int prev = 0;
            for (String log : logs) {
                String[] parts = log.split(":");
                if (parts[1].equals("start")) {

                } else {

                }
            }
            return ret;
        }
    }
}
