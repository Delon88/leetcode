package LC.SOL;

import java.util.*;

public class FlowerPlantingWithNoAdjacent {
    class Solution {
        public int[] gardenNoAdj(int N, int[][] paths) {
            Map<Integer,Set<Integer>> graph = new HashMap<>();
            for ( int i = 1 ; i <= N ; i++) graph.put(i, new HashSet<>());
            for ( int[] p : paths) { graph.get(p[0]).add(p[1]); graph.get(p[1]).add(p[0]); }
            int[] ret = new int[N];
            for ( int i = 1 ; i <= N ; i++) {
                int[] used = new int[5];
                for ( int nei : graph.get(i)) {
                    used[ret[nei - 1]] = 1;
                }
                for ( int c = 4 ; c > 0 ; c--) {
                    if ( used[c] == 0) ret[i - 1] = c;
                }
            }
            return ret;
        }
    }
}
