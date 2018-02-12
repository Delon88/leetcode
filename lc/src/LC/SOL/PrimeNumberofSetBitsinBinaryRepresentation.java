package LC.SOL;

public class PrimeNumberofSetBitsinBinaryRepresentation {
    class Solution {
        public int countPrimeSetBits(int L, int R) {
            int ret = 0;
            for (int i = L; i <= R; i++) {
                if ( isPrime(numberOf1Bits(i))) ret++;
            }
            return ret;
        }

        boolean isPrime(int n ) {
            if ( n == 1) return false;
            for ( int i = 2 ; i <= ( n / 2) ; i++) {
                if ( n % i == 0 ) return false;
            }
            return true;
        }

        int numberOf1Bits(int n) {
            int count = 0;
            while (n != 0) {
                n = n & (n - 1);
                count++;
            }
            return count;
        }
    }
}
