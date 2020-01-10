package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ret = new ArrayList<>();
            if (candidates == null || candidates.length == 0) return ret;
            Arrays.sort(candidates);
            dfs(candidates, 0, target, new ArrayList<>(), ret);
            return ret;
        }

        void dfs(int[] cands, int level, int sum, List<Integer> tmp, List<List<Integer>> ret) {
            if (sum < 0) return;
            if (sum == 0) {
                ret.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = level; i < cands.length; i++) {
                tmp.add(cands[i]);
                dfs(cands, i, sum - cands[i], tmp, ret);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
