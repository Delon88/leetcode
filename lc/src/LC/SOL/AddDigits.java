package LC.SOL;

public class AddDigits {
    class Solution {
        public int addDigits(int num) {
            if ( num < 10 ) return num;
            while ( num >= 10 ) {
                int sum = 0;
                while ( num > 0  ) {
                    sum += ( num % 10 ) ;
                    num /= 10;
                }
                num = sum;
            }
            return num;
        }

        public int addDigits1(int num) {
            return 1 + (num - 1) % 9;
        }
    }
}
