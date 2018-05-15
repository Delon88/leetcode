package LC.SOL;

import java.util.Arrays;

public class ValidAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if ( s.length() != t .length() ) return false;
            char[] a1 = s.toCharArray();
            char[] a2 = t.toCharArray();
            Arrays.sort(a1);Arrays.sort(a2);
            return new String(a1).equals(new String(a2));
        }
    }
}
