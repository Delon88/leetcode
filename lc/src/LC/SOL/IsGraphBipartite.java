package LC.SOL;


import java.util.*;

public class IsGraphBipartite {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int[] color = new int[graph.length];

            for (int i = 0; i < graph.length; i++) {
                if (color[i] == 0) {
                    if (!bfs(graph, color, i)) return false;
                }
            }
            return true;
        }

        boolean bfs(int[][] graph, int[] color, int start) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(start);
            color[start] = 1;
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int nei : graph[node]) {
                    if (color[nei] == 0) {
                        color[nei] = color[node] == 1 ? 2 : 1;
                        q.offer(nei);
                    } else if (color[nei] == color[node]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
