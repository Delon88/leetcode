package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            if (nums == null || nums.length == 0) return ret;
            Arrays.sort(nums);
            permu(nums, new boolean[nums.length], new ArrayList<>(), ret);
            return ret;
        }

        void permu(int[] nums, boolean[] used, List<Integer> tmp, List<List<Integer>> ret) {
            if (tmp.size() == nums.length) {
                ret.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    tmp.add(nums[i]);
                    used[i] = true;
                    permu(nums, used, tmp, ret);
                    used[i] = false;
                    tmp.remove(tmp.size() - 1);
                    while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                        i++;
                    }
                }
            }
        }
    }
}
