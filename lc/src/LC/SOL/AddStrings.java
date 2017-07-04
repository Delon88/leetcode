package LC.SOL;

/**
 * Created by nanhong on 1/15/2017.
 */
public class AddStrings {
    public class Solution {
        public String addStrings(String num1, String num2) {
            if (num1.length() < num2.length()) return addStrings(num2, num1);
            int i = num1.length() - 1, j = num2.length() - 1;
            int carry = 0;
            StringBuilder builder = new StringBuilder();
            while (i >= 0 && j >= 0) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                int sum = d1 + d2 + carry;
                builder.append(sum % 10);
                carry = sum / 10;
                i--;j--;
            }

            while ( i >= 0 ) {
                int d1 = (int) num1.charAt(i) - '0';
                int sum = d1 + carry;
                builder.append(sum % 10);
                carry = sum / 10;
                i--;
            }

            if ( carry != 0 ) builder.append(carry);
            builder.reverse();
            return builder.toString();
        }
    }
}
