package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ret = new ArrayList<>();
            if (candidates == null || candidates.length == 0) return ret;
            Arrays.sort(candidates);
            dfs(candidates, target, 0, new ArrayList<>(), ret);
            return ret;
        }

        void dfs(int[] cands, int sum, int start, List<Integer> tmp, List<List<Integer>> ret) {
            if (sum < 0) return;
            if (0 == sum) {
                ret.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = start; i < cands.length; i++) {
                tmp.add(cands[i]);
                dfs(cands, sum - cands[i], i + 1, tmp, ret);
                tmp.remove(tmp.size() - 1);
                while (i < cands.length - 1 && cands[i] == cands[i + 1]) {
                    i++;
                }
            }
        }
    }
}
