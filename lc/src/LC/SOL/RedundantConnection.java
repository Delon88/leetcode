package LC.SOL;

public class RedundantConnection {
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            int[] idx = new int[2001];
            for (int i = 1; i <= 2000; i++) idx[i] = i;
            for (int[] e : edges) {
                int s = e[0], d = e[1];
                if (root(s, idx) == root(d, idx)) return e;
                else // union
                {
                   idx[root(s, idx)] = root(d , idx);
                }
            }
            return new int[2];
        }

        int root(int p, int[] idx) {
            while (p != idx[p]) {
                idx[p] = idx[idx[p]];
                p = idx[p];
            }
            return p;
        }
    }
}
