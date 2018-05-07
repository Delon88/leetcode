package LC.SOL;

import java.util.*;

public class CourseSchedule {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for ( int i = 0 ;i < numCourses; i++) {
                graph.put(i, new HashSet<>());
            }
            for (int[] p : prerequisites) {
                graph.get(p[1]).add(p[0]);
            }
            int[] v = new int[numCourses];

            for (int i = 0; i < numCourses; i++) {
                if (v[i] == 0 && !dfs(graph, v, i)) return false;
            }
            return true;
        }

        boolean dfs(Map<Integer, Set<Integer>> graph, int[] v, int node) {
            if (v[node] == 2) return true;
            if (v[node] == 1) return false;
            v[node] = 1;
            for (Integer nei : graph.get(node)) {
                if (!dfs(graph, v, nei)) return false;
            }
            v[node] = 2;
            return true;
        }
    }
}
