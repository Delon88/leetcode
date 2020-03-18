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
                boolean[] used = new boolean[5];
                for ( int nei : graph.get(i)) {
                    used[ret[nei - 1]] = true;
                }
                for ( int c = 1 ; c <= 4 ; c++) {
                    if ( !used[c]) ret[i - 1] = c;
                }
            }
            return ret;
        }
    }
}
