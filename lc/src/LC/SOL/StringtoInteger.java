package LC.SOL;

public class StringtoInteger {
    class Solution {
        public int myAtoi(String str) {
            if ( str.length() == 0) return 0;
            int i = 0, sign = 1;
            // skip whitespace
            while ( i < str.length() && str.charAt(i) == ' ') {i++;}
            if ( str.charAt(i) == '-' || str.charAt(i) == '+' ) {sign = (str.charAt(i++) == '-' ? -1 : 1);}
            long num = 0;
            while ( i < str.length() && Character.isDigit(str.charAt(i))) {
                num = num * 10 + ( str.charAt(i) - '0');
                if ( num > Integer.MAX_VALUE  || num < Integer.MIN_VALUE  ) return (sign == 1) ? Integer.MAX_VALUE: Integer.MIN_VALUE;
                i++;
            }

            return sign * (int) num;
        }
    }
}
