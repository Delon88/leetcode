package LC.SOL;

public class ValidPalindromeII {
    class Solution {
        public boolean validPalindrome(String s) {
            int start = 0, end = s.length() - 1;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) return isValid(s , start + 1, end) || isValid(s, start , end -1);
                start++; end--;
            }
            return true;
        }

        boolean isValid(String s, int start, int end) {
            while ( start < end ) {
                if ( s.charAt(start) != s.charAt(end)) return false;
                start++; end--;
            }
            return true;
        }
    }
}
