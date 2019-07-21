package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    class Solution {
        public int totalFruit(int[] tree) {
            Map<Integer, Integer> count = new HashMap<>();
            int start = 0, end = 0;
            int max = 0;
            for (; end < tree.length; end++) {
                count.put(tree[end], count.getOrDefault(tree[end], 0) + 1);
                while (count.size() > 2) {
                    count.put(tree[start], count.get(tree[start]) - 1);
                    if (count.get(tree[start]) <= 0) count.remove(tree[start]);
                    start++;
                }
                max = Math.max(end - start + 1, max);
            }
            return max;
        }
    }
}
