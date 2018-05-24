package LC.SOL;

public class NumberofConnectedComponentsinanUndirectedGraph {
    class Solution {
        public int countComponents(int n, int[][] edges) {
            int[] id = new int[n];
            for ( int i = 0 ;i < n ; i++) {id[i] = i;}
            for ( int[] edge : edges) {
                int rootI = root(id, edge[0]);
                int rootJ = root(id, edge[1]);
                if ( rootI != rootJ) {
                    id[rootI] = rootJ;
                    n--;
                }
            }
            return n;
        }

        int root(int[] id, int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
    }
}
