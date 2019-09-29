package LC.SOL;

public class SumofDigitsintheMinimumNumber {
    class Solution {
        public int sumOfDigits(int[] A) {
            int min = A[0];
            for ( int i = 0 ; i < A.length; i++) min = Math.min(min, A[i]);
            int sum = 0;
            while ( min > 0 ){
                sum += min % 10;
                min /= 10;
            }
            return sum % 2 == 0 ? 1 : 0;
        }
    }
}
