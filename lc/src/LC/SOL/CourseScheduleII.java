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

    class BFSSolution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] inDegree = new int[numCourses];
            List<Integer>[] graph = new ArrayList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] pair : prerequisites) {
                inDegree[pair[0]]++;
                graph[pair[1]].add(pair[0]);
            }
            Queue<Integer> toVisit = new ArrayDeque<>();
            // base course who don't have prerequisites
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    toVisit.offer(i);
                }
            }
            int[] order = new int[numCourses];
            int visited = 0;
            while (!toVisit.isEmpty()) {
                int from = toVisit.poll();
                order[visited++] = from;
                for (int to : graph[from]) {
                    inDegree[to]--;
                    if (inDegree[to] == 0) {
                        toVisit.offer(to);
                    }
                }
            }
            return visited == numCourses ? order : new int[0];
        }
    }
}
