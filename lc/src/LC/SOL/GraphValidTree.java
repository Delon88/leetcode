package LC.SOL;

public class GraphValidTree {
    class Solution {
        public boolean validTree(int n, int[][] edges) {
            if ( n - 1 != edges.length ) return false;
            int[] id = new int[n];
            for ( int i = 0 ; i < n ;i++) {
                id[i] = i;
            }
            for ( int[] e : edges) {
                int l = root(id, e[0]);
                int r = root(id, e[1]);
                if ( l == r ) return false;
            }
            return true;
        }

        int root(int[] id, int i) {
            while ( i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
    }
}
