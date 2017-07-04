package LC.SOL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by nanhong on 1/15/2017.
 */
public class FrogJump {
    public class Solution {
        public boolean canCross(int[] stones) {
            if (stones.length == 0) return true;
            Map<Integer, Set<Integer>> map = new HashMap<>();
            map.put(0, new HashSet<>());
            map.get(0).add(1);
            for (int i = 1; i < stones.length; i++) {
                map.put(stones[i], new HashSet<>());
            }

            for (int i = 0; i < stones.length - 1; i++) {
                int stone = stones[i];
                for (int next : map.get(stone)) {
                    int reach = next + stone;
                    if ( reach == stones[stones.length - 1]) {
                        return true;
                    }
                    Set<Integer> set = map.get(reach);
                    if ( set != null) {
                        set.add(next);
                        if ( next - 1 > 0 ) set.add(next - 1);
                        set.add(next + 1);
                    }
                }
            }
            return false;
        }
    }
}
