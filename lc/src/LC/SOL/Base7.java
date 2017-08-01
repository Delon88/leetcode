package LC.SOL;

public class Base7 {
    public class Solution {
        public String convertToBase7(int num) {
            if ( num == 0 ) return "0";
            StringBuilder b = new StringBuilder();
            boolean neg = num < 0 ? true : false;
            if ( neg ) {
                num = -num;
            }
            while ( num > 0 ) {
                b.append(num % 7);
                num /= 7;
            }
            if ( neg) b.append('-');
            return b.reverse().toString();
        }
    }
}
