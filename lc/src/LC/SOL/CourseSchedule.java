package LC.SOL;

import java.util.*;

public class CourseSchedule {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for (int i = 0; i < numCourses; i++) {
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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] neigh = new LinkedList[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];
        int count = 0;
        for (int i = 0; i < numCourses; i++) neigh[i] = new LinkedList<>();
        for (int[] pair : prerequisites) {
            neigh[pair[1]].add(pair[0]);
            indegree[pair[0]]++;
        }
        for (int i = 0; i < indegree.length; i++)
            if (indegree[i] == 0) queue.offer(i);
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int adj : neigh[course])
                if (--indegree[adj] == 0) queue.offer(adj);
        }
        return count == numCourses;
    }

}
