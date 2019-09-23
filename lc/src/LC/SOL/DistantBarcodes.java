package LC.SOL;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistantBarcodes {
    class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int b : barcodes) map.put(b, map.getOrDefault(b, 0) + 1);
            PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
            q.addAll(map.keySet());
            int i = 0;
            int[] ret = new int[barcodes.length];
            while (!q.isEmpty()) {
                int bar = q.poll(), count = map.get(bar);
                while ( count-- > 0) {
                    if ( i >= barcodes.length) {i = 1;}
                    ret[i] = bar; i+= 2;
                }
            }
            return ret;
        }
    }
}
