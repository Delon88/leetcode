package LC.SOL;

import java.util.*;

public class IncreasingSubsequences {
    public class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            Set<List<Integer>> set = new HashSet<>();
            dfs(nums, 0, new ArrayList<Integer>(), set);
            return new ArrayList<List<Integer>>(set);
        }

        void dfs(int[] nums, int index, List<Integer> holder, Set<List<Integer>> set) {
            if (holder.size() >= 2) {
                set.add(new ArrayList<Integer>(holder));
            }

            for (int i = index; i < nums.length; i++) {
                if (holder.isEmpty() || nums[i] >= holder.get(holder.size() - 1)) {
                    holder.add(nums[i]);
                    dfs(nums, i + 1, holder, set);
                    holder.remove(holder.size() - 1);
                }
            }
        }
    }
}
