package LC.SOL;

import java.util.*;

public class TopKFrequentWords {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();
            for (String w : words) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }

            PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>(
                    (p1, p2) -> p1.getValue() == p2.getValue() ? p2.getKey().compareTo(p1.getKey()) : p1.getValue() - p2.getValue());
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                q.offer(e);
                if (q.size() > k) {
                    q.poll();
                }
            }

            List<String> ret = new LinkedList<>();
            while (!q.isEmpty()) {
                ret.add(0, q.poll().getKey());
            }
            return ret;
        }
    }
}
