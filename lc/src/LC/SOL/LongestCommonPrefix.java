package LC.SOL;

import java.util.Arrays;

public class LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if ( strs.length == 0) return "";
            Arrays.sort(strs, (s1, s2) -> s1.length() - s2.length());
            String prefix = strs[0];
            for ( int i = 0 ;i < strs.length; i++) {
                int j = 0;
                for ( ; j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j) ; j++) {

                }
                prefix = prefix.substring(0 , j);
                if ( prefix.length() == 0) return "";
            }
            return prefix;
        }
    }
}
