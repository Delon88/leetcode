package LC.SOL;

public class MinimumWindowSubstring {
    class Solution {
        public String minWindow(String s, String t) {
            if ( s == null || t == null || s.length() < t.length()) return "";
            int[] hash = new int[128];
            for ( int i = 0 ; i < t.length() ; i++) hash[t.charAt(i)]++;
            int count = 0, index = 0, minLen = s.length() + 1;
            for ( int start = 0 , end = 0 ; end < s.length() ; end++) {
                char c = s.charAt(end);
                hash[c]--;
                if ( hash[c] >= 0 ) count++;
                while ( count == t.length()) {
                    if ( minLen > end - start + 1) {
                        minLen = end - start + 1;
                        index = start;
                    }
                    char pre = s.charAt(start);
                    hash[pre]++;
                    if ( hash[pre] > 0 ) count--;
                    start++;
                }
            }
            return minLen == s.length() + 1 ? "" : s.substring(index, index + minLen);
        }
    }
}
