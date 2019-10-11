package LC.SOL;

public class PrimeArrangements {
    class Solution {
        public int numPrimeArrangements(int n) {
            int c = countPrime(n);
            int MOD = (int) (1e9 + 7);
            long ret = 1;
            for ( int i = 2; i <= c ; i++) ret = ( ret * i ) % MOD;
            for ( int i = 2; i <= n - c ; i++) ret = ( ret * i ) % MOD;
            return (int) ret;
        }

        int countPrime(int n ) {
            boolean[] notprime = new boolean[n + 1];
            notprime[0] = true;
            notprime[1] = true;
            for (int i = 2; i * i <= n; i++) {
                if (!notprime[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        notprime[j] = true;
                    }
                }
            }
            int count = 0;
            for ( int i = 2 ; i <= n  ;i++) {
                if ( !notprime[i]) count++;
            }
            return count;
        }
    }
}
