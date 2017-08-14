package LC.SOL;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class LongestWordinDictionarythroughDeleting {
    public class Solution {
        public String findLongestWord(String s, List<String> d) {
            String longest = "";
            int maxLen = 0;
            for (String w : d) {
                if (isSubSeq(w, s)) {
                    if (w.length() > maxLen) {
                        maxLen = w.length();
                        longest = w;
                    } else if (w.length() == maxLen) {
                        if (longest.compareTo(w) > 0) {
                            longest = w;
                        }
                    }
                }
            }
            return longest;
        }

        public boolean isSubSeq(String s1, String s2) {
            int i = 0, m = s1.length(), n = s2.length();
            for (int j = 0; i < m && j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) i++;
            }
            return i == m;
        }
    }
}
