package LC.SOL;

public class PlusOne {
    class Solution {
        public int[] plusOne(int[] digits) {
            int carry = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int sum = carry + digits[i];
                digits[i] = sum % 10;
                carry = sum / 10;
            }
            if (carry == 0) {
                return digits;
            } else {
                int[] ret = new int[digits.length + 1];
                System.arraycopy(digits, 0, ret, 1, digits.length);
                ret[0] = 1;
                return ret;
            }
        }
    }
}
