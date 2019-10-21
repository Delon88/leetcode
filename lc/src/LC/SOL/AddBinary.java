package LC.SOL;

public class AddBinary {
    class Solution {
        public String addBinary(String a, String b) {
            int i = a.length() - 1, j = b.length() - 1;
            StringBuilder bu = new StringBuilder();
            int carry = 0;
            while (i >= 0 || j >= 0) {
                int sum = carry;
                if (i >= 0) sum += (a.charAt(i) - '0');
                if (j >= 0) sum += (b.charAt(j) - '0');
                bu.append(sum % 2);
                carry = sum / 2;
                i--;
                j--;
            }
            if (carry != 0) bu.append(carry);
            return bu.reverse().toString();
        }
    }
}
