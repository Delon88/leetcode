package LC.SOL;

public class AddBinary {
    class Solution {
        public String addBinary(String a, String b) {
            if ( a.length() > b.length() ) return addBinary(b , a);
            int i = a.length() - 1, j = b.length() - 1;
            StringBuilder bu = new StringBuilder();
            int carry = 0;
            while ( i >= 0 && j >= 0 ) {
                int sum = ( a.charAt(i) - '0')  + (b.charAt(j) - '0') + carry;
                bu.append(sum % 2);
                carry = sum / 2;
                i--;j--;
            }
            while ( j >= 0 ) {
                int sum = ( b.charAt(j) - '0') + carry;
                bu.append(sum % 2 );
                carry = sum / 2;
                j--;
            }
            if ( carry != 0 ) bu.append(carry);
            return bu.reverse().toString();
        }
    }
}
