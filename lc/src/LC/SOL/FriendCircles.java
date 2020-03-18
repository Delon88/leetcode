package LC.SOL;

import java.util.Arrays;

public class FriendCircles {
    class Solution {
        public void dfs(int[][] M, int[] visited, int i) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && visited[j] == 0) {
                    visited[j] = 1;
                    dfs(M, visited, j);
                }
            }
        }

        public int findCircleNum(int[][] M) {
            int[] visited = new int[M.length];
            int count = 0;
            for (int i = 0; i < M.length; i++) {
                if (visited[i] == 0) {
                    dfs(M, visited, i);
                    count++;
                }
            }
            return count;
        }
    }

    class Solution1 {
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
