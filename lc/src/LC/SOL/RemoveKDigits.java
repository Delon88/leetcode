package LC.SOL;

/**
 * Created by nanhong on 1/14/2017.
 */
public class RemoveKDigits {
    public class Solution {
        // Input: num = "1432219", k = 3
        // Output: "1219"
        // Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
        public String removeKdigits(String num, int k) {
            int digits = num.length() - k;
            if (k >= num.length()) return "0";
            char[] str = new char[num.length()];
            int top = 0;
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                while (top > 0 && str[top - 1] > c && k > 0) {
                    k--;
                    top--;
                }
                str[top++] = c;
            }
            int i = 0;
            while (i < digits && str[i] == '0') i++;
            return i == digits ? "0" : new String(str, i, digits - i);
        }
    }
}
