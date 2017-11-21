package LC.SOL;

public class ValidParenthesisString {
    class Solution {
        public boolean checkValidString(String s) {
            int lower = 0, upper = 0;
            for ( int i = 0 ; i < s.length() ; i++) {
                char c = s.charAt(i);
                if ( c == '(') {
                    lower++; upper++;
                } else if ( c == ')') {
                    if ( lower > 0 ) {lower--;}
                    upper--;
                } else {
                    if ( lower > 0) {lower--;}
                    upper++;
                }

                if ( upper < 0 ) return false;
            }
            return lower == 0;
        }
    }
}
