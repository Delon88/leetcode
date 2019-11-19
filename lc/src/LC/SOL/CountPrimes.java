package LC.SOL;

public class CountPrimes {
    class Solution {
        public int countPrimes(int n) {
            int count = 0;
            boolean[] notPrime = new boolean[n + 1];
            for ( int i = 2 ;i * i <= n ; i ++) {
                if ( !notPrime[i]) {
                    int j = i * i;
                    while ( j < n ) {
                        notPrime[j] = true;
                        j += i;
                    }
                }
            }
            for ( int i = 2 ;i  <= n  ;i++) {
                if ( !notPrime[i]) count++;
            }
            return count;
         }
    }
}
