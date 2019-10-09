package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class NumberofDiceRollsWithTargetSum {
    class Solution {

        Map<String,Integer> map = new HashMap<>();
        public int numRollsToTarget(int d, int f, int target) {
            if (d == 0 && target == 0) return 1;
            if (d == 0 || target <= 0) return 0;
            String key = d + "," + target;
            if ( map.containsKey(key)) return map.get(key);
            int ret =0;
            for ( int i = 1 ; i <= f ; i++) {
                ret = ( ret + numRollsToTarget(d - 1 , f , target - i )) % 1000000007;
            }
            map.put(key, ret);
            return ret;
        }
    }
}
