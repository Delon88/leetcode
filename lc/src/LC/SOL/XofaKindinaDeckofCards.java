package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class XofaKindinaDeckofCards {
    class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            Map<Integer,Integer> map = new HashMap<>();
            int ret = 0;
            for (int d : deck) map.put(d, map.getOrDefault(d , 0) + 1);
            for (int v : map.values()) ret = gcd( v , ret);
            return ret > 1;
        }

        int gcd(int a , int b ) {
            if ( b == 0 ) return a;
            return gcd(b , a % b);
        }
    }
}
