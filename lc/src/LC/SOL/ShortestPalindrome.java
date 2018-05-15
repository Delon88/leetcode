package LC.SOL;

public class ShortestPalindrome {
    class Solution {
        public String shortestPalindrome(String s) {
            int start = 0, end = s.length() -1;
            for ( ; end >= 0 ; end--) {
                if ( s.charAt(start) == s.charAt(end)) start++;
            }
            if ( start == s.length()) return s;
            String suffix = s.substring(start);
            return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, start)) + suffix;
        }
    }
}
