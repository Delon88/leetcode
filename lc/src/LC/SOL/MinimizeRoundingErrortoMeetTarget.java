package LC.SOL;

import java.util.PriorityQueue;

public class MinimizeRoundingErrortoMeetTarget {
    class Solution {
        public String minimizeError(String[] prices, int target) {
            float ret = 0;
            PriorityQueue<Double> pq = new PriorityQueue<>();

            for (String p : prices) {
                double pv = Double.valueOf(p);
                double low = Math.floor(pv);
                double high = Math.ceil(pv);
                if (low != high) {
                    pq.offer((high - pv) - (pv - low));
                }
                ret += pv - low;
                target -= low;
            }

            if (target < 0 || target > pq.size()) return "-1";
            while (target-- > 0) {
                ret += pq.poll();
            }
            return String.format("%.3f", ret);
        }
    }
}
