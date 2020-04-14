package LC.SOL;

public class MinimumFlipstoMakeaORbEqualtoc {
    class Solution {
        public int minFlips(int a, int b, int c) {
            int count = 0;
            while ( a > 0 || b > 0 || c > 0 ) {
                int cBit = c & 1 , aBit = a & 1, bBit = b & 1;
                if ( cBit == 1 ) { count += ( aBit == 0 && bBit == 0) ? 1 : 0;}
                else {
                    if ( aBit == 1 && bBit == 1) count += 2;
                    else if ( aBit == 1 || bBit == 1) count += 1;
                }
                a >>= 1; b >>= 1; c >>= 1;
            }
            return count;
        }
    }
}
