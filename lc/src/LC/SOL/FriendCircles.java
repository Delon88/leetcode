package LC.SOL;

import java.util.Arrays;

public class FriendCircles {
    class Solution {
        public int findCircleNum(int[][] M) {
            int n = M.length;
            UnionFind uf = new UnionFind(n);

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (M[i][j] == 1) uf.union(i, j);
                }
            }
            return uf.count;
        }

        class UnionFind {
            int[] idx;

            int[] sz;

            int count;

            public UnionFind(int size) {
                count = size;
                idx = new int[size];
                for (int i = 0; i < size; i++) {
                    idx[i] = i;
                }
                sz = new int[size];
                Arrays.fill(sz, 1);
            }

            public int root(int i) {
                while (i != idx[i]) {
                    idx[i] = idx[idx[i]];
                    i = idx[i];
                }
                return i;
            }

            public boolean find(int p, int q) {
                return root(p) == root(q);
            }

            public void union(int p, int q) {
                int i = root(p);
                int j = root(q);
                if (i == j) return;
                if (sz[i] < sz[j]) {
                    idx[i] = j;
                    sz[j] += sz[i];
                } else {
                    idx[j] = i;
                    sz[i] += sz[j];
                }
                count--;
            }
        }
    }
}
