package LC.SOL;

public class RedundantConnectionII {
    class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            int[] parents = new int[2001];
            int[] cand1 = { -1 ,-1};
            int[] cand2 = { -1 , 1};
            for ( int[] e : edges) {
                int p = e[0] , c = e[1];
                if ( parents[c] == 0 ) { parents[c] = p;}
                else {
                    
                }
            }
        }
    }
}
