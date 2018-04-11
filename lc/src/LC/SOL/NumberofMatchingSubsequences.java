package LC.SOL;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NumberofMatchingSubsequences {
    class Solution {
        public int numMatchingSubseq(String S, String[] words) {
            Map<Character, LinkedList<String>> map = new HashMap<>();
            for (String w : words) {
                if (!map.containsKey(w.charAt(0))) {
                    map.put(w.charAt(0), new LinkedList<>());
                }
                map.get(w.charAt(0)).add(w);
            }

            int count = 0;
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if (map.containsKey(c)) {
                    int size = map.get(c).size();
                    for (int k = 0; k < size; k++) {
                        String w = map.get(c).poll();
                        if (w.length() == 1) {
                            count++;
                        } else {
                            if ( !map.containsKey(w.charAt(1))) {
                                map.put(w.charAt(1), new LinkedList<>());
                            }
                            map.get(w.charAt(1)).add(w.substring(1));
                        }
                    }
                }
            }
            return count++;
        }
    }
}
