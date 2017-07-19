package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collector;

public class SortCharactersByFrequency {
    public class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            List<Character>[] buckets = new List[s.length() + 1];

            for (Character c : map.keySet()) {
                int freq = map.get(c);
                if (buckets[freq] == null) {
                    buckets[freq] = new ArrayList<>();
                }
                buckets[freq].add(c);
            }

            StringBuilder b = new StringBuilder();

            for (int i = s.length(); i >= 0; i--) {
                if (buckets[i] != null) {
                    for (Character c : buckets[i]) {
                        for ( int j = 0 ; j < i ; j++) {
                            b.append(c);
                        }
                    }
                }
            }

            return b.toString();
        }
    }
}
