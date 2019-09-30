package LC.SOL;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LargestValuesFromLabels {
    class Solution {
        public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
            Map<Integer,Integer> labelMap = new HashMap<>();
            PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> b[0] - a[0]);
            for ( int i = 0 ;i < values.length; i++) q.offer(new int[]{values[i], labels[i]});
            int ret =0;
            while ( num_wanted > 0 && !q.isEmpty()) {
                int[] p = q.poll();
                if ( labelMap.getOrDefault(p[1], 0) >= use_limit) continue;
                ret += p[0];
                labelMap.put(p[1], labelMap.getOrDefault(p[1], 0) + 1);
                num_wanted--;
            }
            return ret;
        }
    }
}
