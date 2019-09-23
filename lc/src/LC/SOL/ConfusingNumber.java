package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumber {
    class Solution {
        public boolean confusingNumber(int N) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(6, 9);
            map.put(9, 6);
            map.put(0, 0);
            map.put(1, 1);
            map.put(8, 8);
            int x = N, ret = 0;
            while ( x > 0 ) {
                int rem = x % 10;
                if ( !map.containsKey(rem)) return false;
                if ( ret  > Integer.MAX_VALUE / 10) return false;
                ret = ret * 10 + map.get(rem);
                x /= 10;
            }
            return N == ret ? false: true;
        }
    }
}
