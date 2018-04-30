package LC.SOL;

public class ImplementstrStr {
    class Solution {
        public int strStr(String haystack, String needle) {
            if ( needle.length() > haystack.length()) return -1;
            if ( haystack.length() == 0 ) return 0;

            for ( int i = 0 ; i < haystack.length()  - needle.length() + 1 ; i++) {
                int j = 0;
                for ( j = 0 ; j < needle.length(); j++) {
                    if ( haystack.charAt(i + j) != needle.charAt(j) ) break;
                }
                if ( j == needle.length()) return i;
            }
            return -1;
        }
    }
}
