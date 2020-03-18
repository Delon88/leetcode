package LC.SOL;

public class MinimumWindowSubstring {
    class Solution {
        public String minWindow(String s, String t) {
            int[] hash = new int[256];
            for ( int i = 0 ;i < t.length(); i++) hash[t.charAt(i)]++;
            int start = 0, minLen = s.length() + 1, match = 0;
            for ( int i = 0, j = 0 ; j < s.length(); j++) {
                char c = s.charAt(j);
                if ( --hash[c] >= 0 ) match++;
                while ( match == t.length()) {
                    if ( j - i + 1 < minLen ) {
                        start = i; minLen = j - i + 1;
                    }
                    if ( ++hash[s.charAt(i++)] > 0 ) match--;
                }
            }
            return minLen == s.length() + 1 ? "" : s.substring(start , start + minLen);
        }
    }
}
