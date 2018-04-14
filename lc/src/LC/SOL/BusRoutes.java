package LC.SOL;

import java.util.*;

public class BusRoutes {
    static class Solution {
        public int numBusesToDestination(int[][] routes, int S, int T) {
            if ( S == T) return 0;
            Map<Integer, List<Integer>> stopToRoute = new HashMap<>();
            Map<Integer, Set<Integer>> routeToStops = new HashMap<>();
            for (int i = 0; i < routes.length; i++) {
                routeToStops.put(i, new HashSet<>());
                for (int r : routes[i]) {
                    if (!stopToRoute.containsKey(r)) {
                        stopToRoute.put(r, new ArrayList<>());
                    }
                    stopToRoute.get(r).add(i);
                    routeToStops.get(i).add(r);
                }
            }

            boolean[] v = new boolean[routes.length];
            Queue<Integer> q = new LinkedList<>();
            for ( int route:stopToRoute.get(S)) {
                q.offer(route);
            }
            int count = 1;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int route = q.poll();
                    v[route] = true;
                    if (routeToStops.get(route).contains(T)) return count;
                    for ( int stop : routeToStops.get(route) ) {
                        for ( int nextRoute : stopToRoute.get(stop)) {
                            if ( !v[nextRoute] ) {
                                q.offer(nextRoute);
                            }
                        }
                    }
                }
                count++;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 7}, {3, 6, 7}};
        new Solution().numBusesToDestination(nums, 1 , 6);
    }
}
