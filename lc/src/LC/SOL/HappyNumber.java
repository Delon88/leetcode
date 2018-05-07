package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    class Solution {
        public boolean isHappy(int n) {
            if ( n <= 0) return false;
            if ( n == 1) return true;
            Set<Integer> set = new HashSet<>();
            set.add(n);
            while ( n != 1 ) {
                int next = 0;
                int tmp = n ;
                while ( tmp > 0 ) {
                    int e = tmp % 10 ;
                    next += e * e;
                    tmp /= 10;
                }
                if ( !set.add(next)) return false;
                n = next;
            }
            return true;
        }
    }
}
