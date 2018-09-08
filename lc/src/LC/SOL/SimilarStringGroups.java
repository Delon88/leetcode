package LC.SOL;

public class SimilarStringGroups {
    class Solution {
        public int numSimilarGroups(String[] A) {
            int n = A.length;
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ( isSim(A[i] , A[j])) uf.union(i , j);
                }
            }
            return uf.count;
        }

        boolean isSim(String A, String B) {
            int diff = 0;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    diff++;
                    if (diff > 2) return false;
                }
            }
            return true;
        }

        class UnionFind {
            int[] p, rank;
            public int count;

            public UnionFind(int n) {
                p = new int[n];
                for (int i = 0; i < n; i++) p[i] = i;
                count = n;
                rank = new int[n];
            }

            int root(int i) {
                while (i != p[i]) {
                    p[i] = p[p[i]];
                    i = p[i];
                }
                return i;
            }

            void union(int i, int j) {
                int rI = root(i);
                int rJ = root(j);
                if (rI == rJ) return;
                if (rank[rI] > rank[rJ]) {
                    p[rJ] = rI;
                } else if (rank[rI] < rank[rJ]) {
                    p[rI] = rJ;
                } else {
                    p[rI] = rJ;
                    rank[rJ]++;
                }
                count--;
            }
        }
    }
}
