package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> ret = new ArrayList<>();
            solve(k, n, 1, new ArrayList<>(), ret);
            return ret;
        }

        void solve(int k, int n, int start, List<Integer> tmp, List<List<Integer>> ret) {
            if (tmp.size() == k) {
                if (0 == n) {
                    ret.add(new ArrayList<>(tmp));
                }
                return;
            }
            for (int i = start; i <= 9; i++) {
                tmp.add(i);
                solve(k, n - i, i + 1, tmp, ret);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
