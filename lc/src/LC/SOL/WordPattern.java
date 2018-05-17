package LC.SOL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    class Solution {
        public boolean wordPattern(String pattern, String str) {
            String[] words = str.split("\\s+");
            if (words.length != pattern.length()) return false;
            Map<Character, String> forward = new HashMap<>();
            Set<String> backward = new HashSet<>();
            for (int i = 0; i < words.length; i++) {
                char c = pattern.charAt(i);
                String word = words[i];
                if (!forward.containsKey(c)) {
                    if (backward.contains(word)) {
                        return false;
                    } else {
                        forward.put(c , word);
                        backward.add(word);
                    }
                } else {
                    if ( !forward.get(c).equals(word) ) return false;
                }
            }
            return true;
        }
    }
}
