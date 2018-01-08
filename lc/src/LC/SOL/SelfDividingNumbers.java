package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> ret = new ArrayList<>();
            for ( int i = left ; i <= right ; i++) {
                if ( isSelfD(i)) {
                    ret.add(i);
                }
            }
            return ret;
        }

        boolean isSelfD(int num) {
            int n = num;
            while ( n > 0 ) {
                int d = n % 10;
                if ( d == 0 || num % d != 0 ) return false;
                n /= 10;
            }
            return true;
        }
    }
}
