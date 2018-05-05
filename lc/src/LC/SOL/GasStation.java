package LC.SOL;

public class GasStation {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int totalDiff = 0 ;
            int cur = 0;
            int start = 0;
            for ( int i = 0 ; i < gas.length ; i++) {
                int diff = gas[i] - cost[i];
                totalDiff += diff;
                if ( cur + diff < 0 ) {
                    start = i + 1;
                    cur = 0;
                } else {
                    cur = cur + diff;
                }
            }
            return totalDiff >= 0 ? start : -1;
        }
    }
}
