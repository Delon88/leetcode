package LC.SOL;

import java.util.Arrays;

public class TwoCityScheduling {
    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
            int ret = 0;
            for ( int i = 0 ; i < costs.length / 2 ; i++) {
                ret += costs[i][0] + costs[i + costs.length / 2][1];
            }
            return ret;
        }
    }
}
