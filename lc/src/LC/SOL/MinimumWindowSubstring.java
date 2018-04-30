package LC.SOL;

public class MinimumWindowSubstring {
    class Solution {
        public String minWindow(String s, String t) {
            int[] need = new int[256];
            for ( int i = 0 ; i < t.length(); i++) {
                need[t.charAt(i)]++;
            }
            int[] hasFound = new int[256];
            int count = 0;
            int minLen = Integer.MAX_VALUE;
            int minIndex = 0;
            for ( int start = 0 , end = 0; end < s.length() ; end++) {
                char c = s.charAt(end);
                if ( need[c] == 0) continue;
                if ( hasFound[c] < need[c]) {
                    count++;
                }
                hasFound[c]++;
                if ( count == t.length()) {
                    // move left until breaks
                    while ( start <= end ) {
                        char sc = s.charAt(start);
                        if ( need[sc] == 0 || hasFound[sc] > need[sc]) {
                            hasFound[sc]--;
                            start++;
                        } else {
                            break;
                        }
                    }
                    int len = end - start + 1;
                    if ( len < minLen ) {
                        minLen = len;
                        minIndex = start;
                    }
                }
            }
            if ( count != t.length()) return "";
            return s.substring(minIndex, minIndex + minLen);
        }
    }
}
