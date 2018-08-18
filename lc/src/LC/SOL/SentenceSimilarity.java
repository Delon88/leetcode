package LC.SOL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarity {
    class Solution {
        public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
            if (words1.length != words2.length) return false;
            Map<String, Set<String>> map = new HashMap<>();
            for (String[] pair : pairs) {
                put(pair[0], pair[1], map);
                put(pair[1], pair[0], map);
            }

            for (int i = 0; i < words1.length; i++) {
                if (!(words1[i].equals(words2[i])
                        || (map.containsKey(words1[i]) && map.get(words1[i]).contains(words2[i]))
                        || (map.containsKey(words2[i]) && map.get(words2[i]).contains(words1[i])))) {
                    return false;
                }
            }
            return true;
        }

        void put(String k, String v, Map<String, Set<String>> map) {
            if (!map.containsKey(k)) {
                map.put(k, new HashSet<>());
            }
            map.get(k).add(v);
        }
    }
}
