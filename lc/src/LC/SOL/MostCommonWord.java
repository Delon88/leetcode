package LC.SOL;

import java.util.*;

public class MostCommonWord {
    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            Set<String> ban = new HashSet<>(Arrays.asList(banned));
            Map<String, Integer> count = new HashMap<>();
            String[] words = paragraph.replaceAll("\\p{all}", " ").toLowerCase().split("\\s+");
            for (String w : words) {
                if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
            }
            String ret = "";
            int max = 0;
            for ( Map.Entry<String,Integer> e : count.entrySet()) {
                if ( e.getValue() > max ) {
                    ret = e.getKey();
                    max = e.getValue();
                }
            }
            return ret;
        }
    }
}
