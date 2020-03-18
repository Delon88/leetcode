package LC.SOL;

import java.util.*;

public class TopKFrequentWords {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String w: words) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
            List<String>[] bucket = new ArrayList[words.length + 1];
            for (String key: map.keySet()) {
                int fre = map.get(key);
                if (bucket[fre] == null) {
                    bucket[fre] = new ArrayList<>();
                }
                bucket[fre].add(key);
            }
            List<String> res = new ArrayList<>();
            for (int i = words.length; i > 0 && res.size() < k; i--) {
                if (bucket[i] != null) {
                    Collections.sort(bucket[i]);
                    res.addAll(bucket[i]);
                }
            }
            return res.subList(0, k);
        }
    }
}
