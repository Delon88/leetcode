package LC.SOL;

public class ValidPalindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            int i = 0 , j = s.length() - 1;
            while ( i < j ) {
                while ( i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                    i++;
                }
                char left = s.charAt(i);
                while ( i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                    j--;
                }
                char right = s.charAt(j);
                if ( Character.toLowerCase(left) != Character.toLowerCase(right)) {return false;}
                i++;
                j--;
            }
            return true;
        }
    }
}
