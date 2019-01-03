package LC.SOL;

public class PrimePalindrome {
    class Solution {
        public int primePalindrome(int N) {
            if ( 8 <= N && N <= 11) return 11;
            for ( int i = 1 ; i < 100000; i++) {
                String s = Integer.toString(i), r = new StringBuilder(s).reverse().toString().substring(1);
                int num = Integer.parseInt(s + r);
                if ( isPrime(num) && num >= N ) return num;
            }
            return -1;
        }

        boolean isPrime(int N ){
            if ( N < 2 || N % 2 == 0 ) return N == 2;
            for ( int i = 3  ; i * i <= N ; i+=2) {
                if ( N % i == 0 ) return false;
            }
            return true;
        }
    }
}
