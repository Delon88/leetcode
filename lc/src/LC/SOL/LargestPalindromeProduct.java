package LC.SOL;

public class LargestPalindromeProduct {
    public class Solution {
        public int largestPalindrome(int n) {
            if (n == 1) return 9;

            int upperBound = (int) Math.pow(10, n) - 1, lowerBound = upperBound / 10;
            long maxNumber = (long) upperBound * (long) upperBound;

            // represents the first half of the maximum assumed palindrom.
            // e.g. if n = 3 then maxNumber = 999 x 999 = 998001 so firstHalf = 998
            int firstHalf = (int) (maxNumber / (long) Math.pow(10, n));

            boolean found = false;

            long palindrome = 0;

            while (!found) {
                palindrome = createPalindrome(firstHalf);

                for (long i = upperBound; upperBound > lowerBound; i--) {
                    if (palindrome / i > upperBound || i * i < palindrome) {
                        break;
                    }
                    if (palindrome % i == 0) {
                        found = true;
                        break;
                    }
                }
                firstHalf--;
            }
            return (int) (palindrome % 1337);
        }

        long createPalindrome(long num) {
            String str = num + new StringBuilder().append(num).reverse().toString();
            return Long.parseLong(str);
        }
    }
}
