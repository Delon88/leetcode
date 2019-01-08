package LC.SOL;

import java.util.*;

public class PossibleBipartition {
    class Solution {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            int[] color = new int[N];
            List<List<Integer>> graph = new ArrayList<>();
            for ( int i = 0 ; i < N ; i++) graph.add(new ArrayList<>());
            for ( int[] d : dislikes) {
                graph.get(d[0] -1).add(d[1] - 1); graph.get(d[1] - 1).add(d[0] - 1);
            }
            for ( int i = 0 ;i < graph.size() ; i++) {
                if ( color[i] == 0 ) {
                    if ( !bfs(graph, color, i)) return false;
                }
            }
            return true;
        }

        boolean bfs(List<List<Integer>> graph, int[] color, int start) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(start);
            color[start] = 1;
            while ( !q.isEmpty()) {
                int node = q.poll();
                for ( int nei : graph.get(node)) {
                    if ( color[nei] == 0 ) {
                        color[nei] = color[node] == 1 ? 2 : 1;
                        q.offer(nei);
                    } else if ( color[nei] == color[node]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
