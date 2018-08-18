package LC.SOL;

public class LongestPalindromicSubstring {

    int maxLen;
    int start;

    public String longestPalindrome(String s) {
        if ( s.length() < 2 ) return s;
        maxLen = 0;
        start = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            getLPS(s, i, i);
            getLPS(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }

    void getLPS(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > maxLen) {
            maxLen = right - left - 1;
            start = left + 1;
        }
    }
}
