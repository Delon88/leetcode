package LC.SOL;

public class RedundantConnectionII {
    class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            int[] parents = new int[edges.length + 1];
            int[] cand1 = null;
            int[] cand2 = null;
            // find the node with two parents
            for (int[] e : edges) {
                if (parents[e[1]] == 0) {
                    parents[e[1]] = e[0];
                } else {
                    // already have a parent
                    cand1 = new int[]{parents[e[1]], e[1]};
                    cand2 = new int[]{e[0], e[1]};
                    e[1] = -1;
                }
            }

            // union find for cycle
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }

            for (int[] e : edges) {
                if (e[1] == -1) continue;
                if (root(parents, e[0]) == e[1]) {
                    if (cand1 == null) {
                        return e;
                    } else {
                        return cand1;
                    }
                }
                parents[e[1]] = e[0];
            }
            return cand2;
        }

        int root(int[] parents, int i) {
            while (i != parents[i]) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }
    }
}
