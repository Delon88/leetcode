package LC.SOL;

import java.util.TreeMap;

public class ArrayofDoubledPairs {
    class Solution {
        public boolean canReorderDoubled(int[] A) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int a : A) map.put(a, map.getOrDefault(a, 0) + 1);
            for (int a : map.keySet()) {
                if (map.get(a) == 0) continue;
                int want = a < 0 ? a / 2 : a * 2;
                if ((a < 0 && a % 2 != 0) || map.getOrDefault(want, 0) < map.get(a)) return false;
                map.put(want, map.get(want) - map.get(a));
            }
            return true;
        }
    }
}
