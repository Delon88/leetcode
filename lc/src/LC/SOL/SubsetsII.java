package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ret = new ArrayList<>();
            ret.add(new ArrayList<>());
            dfs(nums, 0 , new ArrayList<>(), ret);
            return ret;
        }

        void dfs(int[] nums, int level, List<Integer> tmp, List<List<Integer>> ret) {
            for ( int i = level ; i < nums.length ; i++) {
                tmp.add( nums[i]);
                ret.add(new ArrayList<>(tmp));
                dfs(nums, i + 1 , tmp, ret);
                tmp.remove(tmp.size() - 1);
                while ( i < nums.length - 1 && nums[i] == nums[i +1 ]) {
                    i++;
                }
            }
        }
    }
}
