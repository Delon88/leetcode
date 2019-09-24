package LC.SOL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllPathsfromSourceLeadtoDestination {
    class Solution {
        public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
            // build graph
            Map<Integer, Set<Integer>> g = new HashMap<>();
            for (int i = 0; i < n; i++) g.put(i, new HashSet<>());
            for (int[] e : edges) {
                g.get(e[0]).add(e[1]);
            }
            return dfs(g , source, new int[n], destination);
        }

        boolean dfs(Map<Integer, Set<Integer>> g, int node, int[] v, int dest) {
            if (v[node] != 0) return v[node] == 2;
            if (g.get(node).isEmpty()) return dest == node;
            v[node] = 1;
            for (int nei : g.get(node)) {
                if (!dfs(g, nei, v, dest)) return false;
            }
            v[node] = 2;
            return true;
        }
    }
}
