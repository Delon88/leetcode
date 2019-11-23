package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class TreeDiameter {
    class Solution {
        int dia;

        public int treeDiameter(int[][] edges) {
            int n = edges.length + 1;
            List<Integer>[] g = new ArrayList[n];
            for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
            for (int[] e : edges) {
                g[e[0]].add(e[1]);
                g[e[1]].add(e[0]);
            }
            dia = 0;
            dfs( g , -1 , 0);
            return dia;
        }

        int dfs(List<Integer>[] g, int parent, int cur) {
            int maxD1 = 0, maxD2 = 0;
            for (int c : g[cur]) {
                if ( c == parent) continue;
                int depth = dfs(g , cur , c );
                if ( depth > maxD1) {
                    maxD2 = maxD1;
                    maxD1 = depth;
                } else if ( depth > maxD2) {
                    maxD2 = depth;
                }
            }
            dia = Math.max(dia, maxD1 + maxD2);
            return maxD1 + 1;
        }
    }
}
