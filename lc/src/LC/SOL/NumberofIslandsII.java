package LC.SOL;

import java.util.List;

public class NumberofIslandsII {
    class Solution {
        public List<Integer> numIslands2(int m, int n, int[][] positions) {

        }

        class UnionFind {
            int[] id;

            public UnionFind(int n) {
                id = new int[n];
                for (int i = 0; i < n; i++) {
                    id[i] = i;
                }
            }

            int root(int i) {
                while (i != id[i]) {
                    id[i] = id[id[i]];
                    i = id[i];
                }
                return i;
            }

            void union(int i, int j) {
                int rI = root(i);
                int rJ = root(j);
                id[rI] = rJ;
            }
        }
    }

}
