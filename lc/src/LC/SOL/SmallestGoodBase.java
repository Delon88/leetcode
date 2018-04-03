package LC.SOL;

import java.math.BigInteger;

public class SmallestGoodBase {
    //
//    For an integer n, we call k>=2 a good base of n, if all digits of n base k are 1.
//
//    Now given a string representing n, you should return the smallest good base of n in string format.
//
//            Example 1:
//
//    Input: "13"
//    Output: "3"
//    Explanation: 13 base 3 is 111.
//
//    Example 2:
//
//    Input: "4681"
//    Output: "8"
//    Explanation: 4681 base 8 is 11111.
//
//    Example 3:
//
//    Input: "1000000000000000000"
//    Output: "999999999999999999"
//    Explanation: 1000000000000000000 base 999999999999999999 is 11.
//
//    Note:
//
//    The range of n is [3, 10^18].
//    The string representing n is always valid and will not have leading zeros.
//   n =  1 + 1 * k ^ 1 + 1 * k ^ 2 ... 1 * k ^ m
//   n - 1 =  1 * k ^ 1 + 1 * k ^ 2 ... 1 * k ^ m
//   n -1 = k ( 1 + k^ 1 + ... k^ m -1)
//   n - k ^ m = 1 + ... k ^m - 1
//   (n -1)/ k = n - k^m
//   n - 1 = kn - k ^ m + 1
//   k^m +1  - 1 = n( k - 1);
//   k^(m+1) -1 / k - 1 = n;  1)
//    n > k^m 1)
//    n < ( k + 1) ^ m
//    m th square root of n > k
//    k + 1 > m th square root of n > k
    class Solution {
        public String smallestGoodBase(String n) {
            Long num = Long.parseLong(n);
            BigInteger bn = BigInteger.valueOf(num);
            int maxBase = (int) (Math.log(num) / (long) Math.log(2));
            for (int b =maxBase; b >= 2; b--) {
                BigInteger k = BigInteger.valueOf((long) Math.pow(num , 1.0d/ b ));
                BigInteger left = k.pow(b + 1).subtract(BigInteger.ONE);
                BigInteger right = bn.multiply(k.subtract(BigInteger.ONE));
            }
        }
    }
}
