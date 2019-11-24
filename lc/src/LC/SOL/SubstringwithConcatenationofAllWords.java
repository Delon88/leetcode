package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            Map<String, Integer> count = new HashMap<>();
            for (String w : words) count.put(w, count.getOrDefault(w, 0) + 1);
            List<Integer> ret = new ArrayList<>();
            if ( words.length == 0 ) return ret;
            int n = s.length(), wLen = words[0].length(), len = words.length;
            for (int i = 0; i < n - wLen * len + 1; i++) {
                Map<String, Integer> seen = new HashMap<>();
                int j = 0;
                while (j < len) {
                    String w = s.substring(i + j * wLen, i + (j + 1) * wLen);
                    if ( count.containsKey(w)) {
                        seen.put(w , seen.getOrDefault(w, 0) + 1);
                        if ( seen.get(w) > count.get(w)) break;
                    } else {
                        break;
                    }
                    j++;
                }
                if ( j == len) ret.add(i);
            }
            return ret;
        }
    }
}
