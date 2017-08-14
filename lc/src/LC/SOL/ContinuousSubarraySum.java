package LC.SOL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0) return false;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int n = nums.length;
            int curSum = 0;
            for (int i = 0; i < n; i++) {
                curSum += nums[i];
                if (k != 0) curSum %= k;
                Integer prevIndex = map.get(curSum);
                if (prevIndex != null) {
                    if (i - prevIndex > 1) return true;
                } else {
                    map.put(curSum, i);
                }
            }
            return false;
        }
    }
}
