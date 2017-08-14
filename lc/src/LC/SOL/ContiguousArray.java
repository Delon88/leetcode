package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public class Solution {
        public int findMaxLength(int[] nums) {
            int zeros = 0, ones = 0, maxLen = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zeros++;
                } else {
                    ones++;
                }
                if (map.containsKey(zeros - ones)) {
                    maxLen = Math.max(maxLen, i - map.get(zeros - ones));
                } else {
                    map.put(zeros - ones, i);
                }
            }
            return maxLen;
        }
    }
}
