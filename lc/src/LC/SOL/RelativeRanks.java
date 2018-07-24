package LC.SOL;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class RelativeRanks {
    public class Solution {
        public String[] findRelativeRanks(int[] nums) {
            int n = nums.length;
            int[][] copy = new int[n][2];
            for (int i = 0; i < n; i++) {
                copy[i][0] = nums[i];
                copy[i][1] = i;
            }
            Arrays.sort(copy, (c1, c2) -> c2[0] - c1[0]);
            String[] ret = new String[n];
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    ret[copy[i][1]] = "Gold Medal";
                } else if (i == 1) {
                    ret[copy[i][1]] = "Silver Medal";
                } else if (i == 2) {
                    ret[copy[i][1]] = "Bronze Medal";
                } else {
                    ret[copy[i][1]] = Integer.toString(i + 1);
                }
            }
            return ret;
        }
    }
}
