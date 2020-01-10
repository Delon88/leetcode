package LC.SOL;

public class GasStation {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int totalDiff = 0, curDiff = 0, start = 0;
            for (int i = 0; i < gas.length; i++) {
                int diff = gas[i] - cost[i];
                totalDiff += diff;
                if ( curDiff + diff < 0  ) {
                    start = i + 1;
                    curDiff = 0;
                } else {
                    curDiff += diff;
                }
            }
            return totalDiff >= 0 ? start : -1;
        }
    }
}
