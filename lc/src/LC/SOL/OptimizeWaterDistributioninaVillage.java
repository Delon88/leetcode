package LC.SOL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OptimizeWaterDistributioninaVillage {
    class Solution {

        int[] id;
        public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
            id = new int[n + 1];
            List<int[]> edges = new ArrayList<>();
            for ( int i = 0 ; i < n ; i++) {
                id[i + 1] = i + 1;
                edges.add( new int[]{0 , i + 1, wells[i]});
            }
            for ( int[] p : pipes) edges.add(p);
            Collections.sort(edges, (e1, e2) -> e1[2] - e2[2]);
            int ret = 0;
            for ( int[] e : edges) {
                int r1 = find(e[0]), r2 = find(e[1]);
                if ( r1 == r2 ) continue;
                ret += e[2];
                id[r1] = r2;
            }
            return ret;
        }

        int find(int i) {
            while ( i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
    }
}
