package LC.SOL;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class RelativeRanks {
    public class Solution {
        public String[] findRelativeRanks(int[] nums) {
            TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            int i = 0;
            String[] medal = {"Gold Medal", "Silver Medal", "Bronze Medal"};
            String[] ret = new String[nums.length];
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (i < 3) {
                    ret[e.getValue()] = medal[i];
                } else {
                    ret[e.getValue()] = Integer.toString(i + 1);
                }
                i++;
            }
            return ret;
        }
    }
}
