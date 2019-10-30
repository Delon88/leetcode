package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            int i = 0, n = nums.length;
            List<String> ret = new ArrayList<>();
            while (i < n) {
                int j = i;
                while (i < n - 1 && (nums[i] == nums[i + 1] - 1 || nums[i] == nums[i + 1])) {
                    i++;
                }
                ret.add(getRange(nums, j, i));
                i++;
            }
            return ret;
        }

        String getRange(int[] nums, int i, int j) {
            if (i == j) return Integer.toString(nums[i]);
            else return nums[i] + "->" + nums[j];
        }
    }
}
