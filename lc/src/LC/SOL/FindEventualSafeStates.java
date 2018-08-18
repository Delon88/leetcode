package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int[] v = new int[graph.length];
            List<Integer> ret = new ArrayList<>();
            for (int i = 0; i < graph.length; i++) {
                if ( dfs(graph, v , i)) ret.add(i);
            }
            return ret;
        }

        boolean dfs(int[][] graph, int[] v, int node) {
            if (v[node] == 1) return false;
            else if (v[node] == 2) return true;
            v[node] = 1;
            for ( int nei : graph[node]) {
                if ( !dfs(graph, v , nei)) return false;
            }
            v[node] = 2;
            return true;
        }
    }
}
