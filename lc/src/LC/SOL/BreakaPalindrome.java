package LC.SOL;

public class BreakaPalindrome {
    static class Solution {
        public String breakPalindrome(String palindrome) {
            char[] a = palindrome.toCharArray();
            int n = a.length;
            for ( int i = 0 ; i < n / 2 ; i++) {
                if ( a[i] != 'a') {
                    a[i] = 'a';
                    return new String(a);
                }
            }
            a[n -1] = 'b';
            return n < 2 ? "" : new String(a);
        }
    }
}