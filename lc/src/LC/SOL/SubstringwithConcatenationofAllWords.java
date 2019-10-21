package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> ret = new ArrayList<>();
            if (s.length() == 0 || words.length == 0 || words[0].length() == 0 || s.length() < words.length * words[0].length())
                return ret;
            Map<String, Integer> wordMap = new HashMap<>();
            for (String w : words) {
                wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
            }
            Map<String, Integer> cur = new HashMap<>();

            int sLen = s.length(), wLen = words[0].length(), L = words.length;
            for (int i = 0; i < wLen; i++) {
                int count = 0;
                for (int l = i, r = i; r + wLen <= sLen; r += wLen) {
                    String word = s.substring(r, r + wLen);
                    if (wordMap.containsKey(word)) {
                        cur.put(word, cur.getOrDefault(word, 0) + 1);
                        if (cur.get(word) <= wordMap.get(word)) count++;
                        /// get rid of extra word
                        while (cur.get(word) > wordMap.get(word)) {
                            String prev = s.substring(l, l + wLen);
                            cur.put(prev, cur.get(prev) - 1);
                            if (cur.get(prev) < wordMap.get(prev)) count--;
                            l += wLen;
                        }
                        if (count == L) {
                            ret.add(l);
                            String prev = s.substring(l, l + wLen);
                            cur.put(prev, cur.get(prev) - 1);
                            l += wLen;
                            count--;
                        }
                    } else {
                        count = 0;
                        cur.clear();
                        l = r + wLen;
                    }
                }
                cur.clear();
            }
            return ret;
        }
    }

    class Solution1 {
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
