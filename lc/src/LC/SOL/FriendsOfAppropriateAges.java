package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class FriendsOfAppropriateAges {
    class Solution {
        public int numFriendRequests(int[] ages) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int a : ages) {
                count.put(a, count.getOrDefault(a, 0) + 1);
            }

            int ret = 0;
            for (Integer a : count.keySet()) {
                for (Integer b : count.keySet()) {
                    if (request(a, b)) {
                        ret += count.get(a) * (count.get(b) - (a == b ? 1 : 0));
                    }
                }
            }
            return ret;
        }

        boolean request(int a, int b) {
            return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
        }
    }
}
