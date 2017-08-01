package LC.SOL;

import java.util.List;

public class MaximumDistanceinArrays {
    public class Solution {
        public int maxDistance(List<List<Integer>> arrays) {
            List<Integer> a1 = arrays.get(0);
            int min = a1.get(0);
            int max = a1.get(a1.size() - 1);

            int ret = 0;
            for (int i = 1; i < arrays.size(); i++) {
                int curMin = arrays.get(i).get(0);
                int curMax = arrays.get(i).get(arrays.get(i).size() - 1);
                ret = Math.max(ret, Math.abs(max - curMin));
                ret = Math.max(ret, Math.abs(min - curMax));
                max = Math.max(curMax, max);
                min = Math.min(curMin, min);
            }
            return ret;
        }
    }
}
