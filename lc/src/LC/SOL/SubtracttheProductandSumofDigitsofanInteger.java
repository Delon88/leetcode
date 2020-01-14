package LC.SOL;

public class SubtracttheProductandSumofDigitsofanInteger {
    class Solution {
        public int subtractProductAndSum(int n) {
            if ( n == 0 ) return 0;
            int sum = 0 , mul = 1;
            while ( n != 0 ) {
                int d = n % 10;
                sum+= d; mul *= d;
                n /= 10;
            }
            return mul - sum;
        }
    }
}
