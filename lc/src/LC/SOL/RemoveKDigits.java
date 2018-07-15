package LC.SOL;

public class RemoveKDigits {
    public class Solution {
        // Input: num = "1432219", k = 3
        // Output: "1219"
        // Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
        public String removeKdigits(String num, int k) {
            int dLen = num.length() - k ;
            char[] stk = new char[num.length()];
            int top = 0;
            for ( int i = 0 ; i < num.length() ; i++) {
                char c = num.charAt(i);
                while ( top > 0 && stk[top - 1]  > c && k > 0  ) {
                    top--;
                    k--;
                }
                stk[top++] = c;
            }
            int i = 0 ;
            while ( i < dLen && stk[i] == '0' ) i++;
            return i == dLen ? "0" : new String(stk, i, dLen - i);
        }
    }
}
