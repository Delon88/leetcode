package LC.SOL;

import java.util.*;

public class BusRoutes {
    static class Solution {
        public int numBusesToDestination(int[][] routes, int S, int T) {
            if (S == T) return 0;
            Map<Integer, List<Integer>> stopToBus = new HashMap<>();
            for (int i = 0; i < routes.length; i++) {
                for (int stop : routes[i]) {
                    if (!stopToBus.containsKey(stop)) stopToBus.put(stop, new ArrayList<>());
                    stopToBus.get(stop).add(i);
                }
            }
            Queue<Integer> q = new LinkedList<>();
            Set<Integer> v = new HashSet<>();
            q.offer(S);
            int ret = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                ret++;
                for (int i = 0; i < size; i++) {
                    List<Integer> buses = stopToBus.get(q.poll());
                    for ( int bus : buses) {
                        if ( v.contains(bus)) continue;
                        v.add(bus);
                        for ( int stop : routes[bus]) {
                            if ( stop == T ) return ret;
                            q.offer(stop);
                        }
                    }
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            int[][] nums = {{1, 2, 7}, {3, 6, 7}};
            new Solution().numBusesToDestination(nums, 1, 6);
        }
    }
