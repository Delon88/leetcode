package LC.SOL;

import java.util.Arrays;

public class LastSubstringinLexicographicalOrder {
    class Solution {
        public String lastSubstring(String s) {
            int i = 0, j = 1, k = 0, n = s.length();
            while (j + k < n) {
                if (s.charAt(i + k) == s.charAt(j + k)) {
                    k++;
                    continue;
                } else if (s.charAt(i + k) > s.charAt(j + k)) {
                    j = j + k + 1;
                } else {
                    i = i + k + 1;
                    j = i + 1;
                }
                k = 0;
            }
            return s.substring(i);
        }
    }
}
