package LC.SOL;


import java.util.ArrayList;
import java.util.List;

public class MinimumFactorization {
    class Solution {
        class Solution {
            public int smallestFactorization(int a) {
                if ( a < 10 ) return a;
                StringBuilder b = new StringBuilder();
                for ( int i = 9 ; i >= 2 ; i--) {
                    while ( a % i == 0 ) {
                        a /= i;
                        b.append(i);
                    }
                }
                if ( a != 1 ) return 0;
                try {
                    return Integer.parseInt(b.reverse().toString());
                } catch( NumberFormatException e) {
                    return 0;
                }
            }
        }
    }
}
