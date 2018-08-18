package LC.SOL;

public class RedundantConnection {
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            int[] id = new int[2001];
            for ( int i = 1 ; i < id.length ;i++) id[i] = i;
            for ( int[] e : edges) {
                int s = root(e[0] , id), d = root(e[1] , id);
                if ( s == d) return e;
                else id[s] = d;
            }
            return new int[2];
        }

        int root(int i , int[] id) {
            while ( i != id[i]) {
                id[i] = id[id[i]];
                i  = id[i];
            }
            return i;
        }
    }
}
