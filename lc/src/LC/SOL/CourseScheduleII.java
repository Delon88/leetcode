package LC.SOL;

import java.util.*;

public class CourseScheduleII {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for (int i = 0; i < numCourses; i++) {
                graph.put(i, new HashSet<>());
            }
            for (int[] p : prerequisites) {
                graph.get(p[1]).add(p[0]);
            }
            int[] v = new int[numCourses];
            LinkedList<Integer> sol = new LinkedList<>();
            for ( int i = 0 ;i < numCourses; i++) {
                if ( v[i] == 0 && !dfs(graph, v, sol, i)) return new int[0];
            }
            int[] ret = new int[numCourses];
            int i = 0;
            for ( Integer c : sol) {
                ret[i++] = c;
            }
            return ret;
        }

        boolean dfs(Map<Integer, Set<Integer>> graph, int[] v, LinkedList<Integer> sol, int node) {
            if (v[node] == 2) return true;
            if (v[node] == 1) return false;
            v[node] = 1;
            for ( Integer nei: graph.get(node)) {
                if ( !dfs(graph, v, sol, nei)) return false;
            }
            v[node] = 2;
            sol.addFirst(node);
            return true;
        }
    }
}
