package LC.SOL;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String longest = "";
        for ( int i = 0 ; i < s.length() ; i++) {
            String tmp = getLPS(s, i , i );
            if ( tmp.length() > longest.length()) {
                longest = tmp;
            }
            if ( i != s.length()  - 1) {
                tmp = getLPS(s , i , i + 1);
                if ( tmp.length() > longest.length()) {
                    longest = tmp;
                }
            }
        }
        return longest;
    }

    String getLPS(String s, int left, int right) {
        while ( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;right++;
        }
        return s.substring(left + 1, right);
    }
}
