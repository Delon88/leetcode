package LC.SOL;

import java.util.*;

public class FindandReplacePattern {
    class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            int[] p = encode(pattern);
            List<String> ret = new ArrayList<>();
            for ( String w : words ) {
                if (Arrays.equals(encode(w), p)) ret.add(w);
            }
            return ret;
        }

        int[] encode(String word) {
            Map<Character, Integer> map = new HashMap<>();
            int[] f = new int[word.length()];
            for ( int i = 0; i < word.length() ; i++) {
                char c= word.charAt(i);
                map.putIfAbsent(c , i);
                f[i] = map.get(c);
            }
            return f;
        }
    }
}
