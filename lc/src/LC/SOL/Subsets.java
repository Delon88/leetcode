package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            ret.add(new ArrayList<>());
            dfs(nums, new ArrayList<>(), 0, ret);
            return ret;
        }

        void dfs(int[] nums, List<Integer> tmp, int start, List<List<Integer>> ret) {
            for (int i = start; i < nums.length; i++) {
                tmp.add(nums[i]);
                ret.add(new ArrayList<>(tmp));
                dfs(nums, tmp, i + 1, ret);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
