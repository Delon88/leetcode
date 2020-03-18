package LC.SOL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
                Set<Integer> steps = map.get(stones[i]);
                for ( int step : steps) {
                    int next = step + stones[i];
                    if ( next == stones[stones.length - 1]) return true;
                    Set<Integer> nextStep = map.get(next);
                    if ( nextStep != null ) {
                        if ( step - 1 > 0 ) nextStep.add(step - 1);
                        nextStep.add(step);
                        nextStep.add(step + 1);
                    }
                }
            }
            return false;
        }
    }
}
