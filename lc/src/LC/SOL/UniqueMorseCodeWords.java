package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    class Solution {
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        public int uniqueMorseRepresentations(String[] words) {
            Set<String> set = new HashSet<>();
            for ( String w : words) {
                StringBuilder b = new StringBuilder();
                for ( int i = 0 ; i < w.length() ; i++) {
                    b.append(morse[w.charAt(i) - 'a']);
                }
                set.add(b.toString());
            }
            return set.size();
        }
    }
}
