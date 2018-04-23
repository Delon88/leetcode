package LC.SOL;

public class PalindromeNumber {
    class Solution {
        public boolean isPalindrome(int x) {
            if ( x < 0 ) return false;
            int ret = 0;
            int copy = x;
            while ( x != 0 ) {
                ret = ret * 10 + (  x % 10);
                x /= 10;
            }
            return ret == copy;
        }
    }
}
