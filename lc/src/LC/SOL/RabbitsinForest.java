package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class RabbitsinForest {
    class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : answers) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            int ret = 0;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getKey() == 0) {
                    ret += e.getValue();
                } else {
                    ret += (e.getKey() + 1) * (e.getValue() / (e.getKey() + 1));
                    ret += (e.getValue() % (e.getKey() + 1) == 0 ? 0 : e.getKey() + 1);
                }
            }
            return ret;
        }
    }
}
