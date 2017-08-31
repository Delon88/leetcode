package LC.SOL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for (List<Integer> w : wall) {
                int len = 0;
                for (int i = 0; i < w.size() - 1; i++) {
                    len += w.get(i);
                    map.put(len, map.getOrDefault(len, 0) + 1);
                    count = Math.max(map.get(len), count);
                }
            }
            return wall.size() - count;
        }
    }
}
