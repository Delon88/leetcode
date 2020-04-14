package LC.SOL;

public class NumberofOperationstoMakeNetworkConnected {
    class Solution {
        public int makeConnected(int n, int[][] connections) {
            if ( connections.length < n - 1 ) return -1;
            int[] id = new int[n];
            for ( int i = 0 ; i < n ; i++) id[i] = i;
            int coms = n;
            for ( int[] c : connections) {
                int r1 = root(c[0], id), r2 = root(c[1], id);
                if ( r1 != r2 ) {
                    coms--; id[r1] = r2;
                }
            }
            return coms - 1;
        }

        int root(int i, int[] id ) {
            while ( i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
    }
}
