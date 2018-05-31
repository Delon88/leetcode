package LC.SOL;

public class CountNumberswithUniqueDigits {
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if ( n == 0 ) return 1;
            if ( n > 10 ) return 0;
            int ret = 10;
            int availNumber = 9;
            int uniqDigitNumber = 9;
            for ( int i = 2 ; i <= n ; i++) {
                uniqDigitNumber *= availNumber;
                ret += uniqDigitNumber;
                availNumber--;
            }
            return ret;
        }
    }
}
