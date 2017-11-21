package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementMagicDictionary {
    class MagicDictionary {

        Map<String, List<int[]>> map;

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {
            map = new HashMap<>();
        }

        /**
         * Build a dictionary through a list of words
         */
        public void buildDict(String[] dict) {
            for (String word : dict) {
                for (int i = 0; i < word.length(); i++) {
                    String sub = word.substring(0, i) + word.substring(i + 1);
                    List<int[]> list = map.getOrDefault(sub, new ArrayList<>());
                    list.add(new int[]{i, word.charAt(i)});
                    map.put(sub, list);
                }
            }
        }

        /**
         * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
         */
        public boolean search(String word) {
            for (int i = 0; i < word.length(); i++) {
                String sub = word.substring(0, i) + word.substring(i + 1);
                if (map.containsKey(sub)) {
                    for (int[] e : map.get(sub)) {
                        if (e[0] == i && word.charAt(i) != e[1]) return true;
                    }
                }
            }
            return false;
        }
    }

}
