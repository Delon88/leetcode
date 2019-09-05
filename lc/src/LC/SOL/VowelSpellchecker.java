package LC.SOL;

import java.util.*;

public class VowelSpellchecker {
    class Solution {
        public String[] spellchecker(String[] wordlist, String[] queries) {
            Set<String> words = new HashSet<>(Arrays.asList(wordlist));
            Map<String, String> cap = new HashMap<>();
            Map<String, String> vow = new HashMap<>();
            for (String w : wordlist) {
                String lower = w.toLowerCase(), devow = lower.replaceAll("[aeiou]", "#");
                cap.putIfAbsent(lower, w);
                vow.putIfAbsent(devow, w);
            }
            for (int i = 0; i < queries.length; i++) {
                if ( words.contains(queries[i])) continue;
                String lower = queries[i].toLowerCase(), devow = lower.replaceAll("[aeiou]", "#");
                if ( cap.containsKey(lower)) {
                    queries[i] = cap.get(lower);
                } else if ( vow.containsKey(devow)) {
                    queries[i] = vow.get(devow);
                } else {
                    queries[i] = "";
                }
            }
            return queries;
        }
    }
}
