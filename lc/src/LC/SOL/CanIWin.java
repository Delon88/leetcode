package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {
    class Solution {

        boolean[] used;
        Map<Integer, Boolean> map;

        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
            if (sum < desiredTotal) return false;
            if(desiredTotal <= 0) return true;
            used = new boolean[maxChoosableInteger + 1];
            map = new HashMap<>();
            return dfs(desiredTotal);
        }

        boolean dfs(int desire) {
            if (desire <= 0) return false;
            int key = format();
            if (!map.containsKey(key)) {
                for (int i = 1; i < used.length; i++) {
                    if (!used[i]) {
                        used[i] = true;
                        if (!dfs(desire - i)) {
                            map.put(key, true);
                            used[i] = false;
                            return true;
                        }
                        used[i] = false;
                    }
                }
                map.put(key, false);
            }
            return map.get(key);
        }


        int format() {
            int ret = 0;
            for (boolean b : used) {
                ret <<= 1;
                if (b) ret |= 1;
            }
            return ret;
        }
    }
}
