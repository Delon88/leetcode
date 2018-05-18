package LC.SOL;

import java.math.BigInteger;

public class AdditiveNumber {


//    Additive number is a string whose digits can form additive sequence.
//
//    A valid additive sequence should contain at least three numbers.
//    Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
//
//    For example:
//            "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
//
//            1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
//            "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
//            1 + 99 = 100, 99 + 100 = 199
//    Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
//
//    Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
//
//    Follow up:
//    How would you handle overflow for very large input integers?
//
//    Credits:
//    Special thanks to @jeantimex for adding this problem and creating all test cases.


    class Solution {
        public boolean isAdditiveNumber(String num) {
            int n = num.length();
            for (int i = 0; i <= n / 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    String op1 = num.substring(0 , i + 1);
                    String op2 = num.substring(i + 1, j + 1);
                    if ( dfs(op1, op2, num.substring(j + 1))) return true;
                }
            }
            return false;
        }

        boolean dfs(String op1, String op2, String num) {
            if ( num.length() == 0 ) return true;
            if ((op1.length() > 1 && op1.charAt(0) == '0') || (op2.length() > 1 && op2.charAt(0) == '0')) return false;
            String next = Long.toString(Long.parseLong(op1) + Long.parseLong(op2));
            if (!num.startsWith(next)) return false;
            return dfs(op2, next, num.substring(next.length()));
        }
    }
}
