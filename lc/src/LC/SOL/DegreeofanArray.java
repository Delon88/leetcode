package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeofanArray {
    class Solution {
        public int findShortestSubArray(int[] nums) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            int maxSize = 0;
            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(nums[i], list);
                } else {
                    map.get(nums[i]).add(i);
                }
                maxSize = Math.max(maxSize, map.get(nums[i]).size());
            }

            int minLen = nums.length;
            for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
                if (e.getValue().size() == maxSize) {
                    List<Integer> idx = e.getValue();
                    minLen = Math.min(idx.get(idx.size() - 1) - idx.get(0) + 1, minLen);
                }
            }
            return minLen;
        }
    }
}
