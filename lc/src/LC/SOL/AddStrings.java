package LC.SOL;

public class AddStrings {
    public class Solution {
        public String addStrings(String num1, String num2) {
            if (num1.length() < num2.length()) return addStrings(num2, num1);
            int i = num1.length() - 1, j = num2.length() - 1;
            int carry = 0;
            StringBuilder builder = new StringBuilder();
            while (i >= 0 || j >= 0) {
                int d1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int d2 = j >= 0 ? num2.charAt(j) - '0' : 0;
                int sum = d1 + d2 + carry;
                builder.append(sum % 10);
                carry = sum / 10;
                i--;j--;
            }

            if ( carry != 0 ) builder.append(carry);
            builder.reverse();
            return builder.toString();
        }
    }
}
