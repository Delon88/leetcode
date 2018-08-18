package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {
    class Solution {

        public int expressiveWords(String S, String[] words) {
            int ret = 0;
            for ( String w : words ) {
                if ( check(S, w)) ret++;
            }
            return ret;
        }

        boolean check(String s, String w) {
            int i = 0, j = 0;
            for ( ; i < s.length() ; i++) {
                if ( j < w.length() && s.charAt(i) == w.charAt(j)) j++;
                else if ( i > 1 && s.charAt(i) == s.charAt(i - 2) && s.charAt(i) == s.charAt(i - 1));
                else if ( i > 0 && i < s.length() - 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i + 1));
                else return false;
            }
            return j == w.length();
        }
    }
}
