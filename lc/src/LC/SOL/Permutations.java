package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            if ( nums.length == 0 ) return ret;
            permute(nums, new boolean[nums.length], new ArrayList<>(), ret);
            return ret;
        }

        void permute(int[] nums, boolean[] used, List<Integer> tmp, List<List<Integer>> ret) {
            if (tmp.size() == nums.length) {
                ret.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    tmp.add(nums[i]);
                    permute(nums, used, tmp, ret);
                    tmp.remove(tmp.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
}
