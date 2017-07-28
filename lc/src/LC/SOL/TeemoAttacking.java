package LC.SOL;

import java.util.TreeSet;

public class TeemoAttacking {
    public class Solution {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            if (timeSeries == null || timeSeries.length == 0 || duration <= 0) return 0;
            int start = timeSeries[0];
            int end = start + duration;
            int total = 0;
            for (int i = 1; i < timeSeries.length; i++) {
                if (end < timeSeries[i]) {
                    total += (end - start);
                    start = timeSeries[i];
                    end = start + duration;
                } else {
                    end = timeSeries[i] + duration;
                }
            }
            total += (end - start);
            return total;
        }
    }
}
