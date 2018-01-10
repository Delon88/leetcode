package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class SentenceSimilarityII {
    class Solution {

        Map<String, String> map;

        public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
            if (words1.length != words2.length) return false;
            map = new HashMap<>();

            for (String[] p : pairs) {
                union(p[0], p[1]);
            }
            for (int i = 0; i < words1.length; i++) {
                if (!words1[i].equals(words2[i]) && !find(words1[i], words2[i])) return false;
            }
            return true;
        }

        void union(String w1, String w2) {
            String r1 = root(w1);
            String r2 = root(w2);
            map.put(r1, r2);
        }

        boolean find(String w1, String w2) {
            return root(w1).equals(root(w2));
        }

        String root(String word) {
            if ( !map.containsKey(word) ) {map.put(word, word); return word;}
            while (map.containsKey(word) && !map.get(word).equals(word)) {
                // compression
                map.put(word, map.get(map.get(word)));
                word = map.get(word);
            }
            return word;
        }
    }
}
