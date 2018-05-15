package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    class Solution {
        public List<List<Integer>> getFactors(int n) {
            List<List<Integer>> ret = new ArrayList<>();
            if ( n <= 3) return ret;
            dfs( 2, n , new ArrayList<>(), ret);
            return ret;
        }

        void dfs(int start, int end, List<Integer> tmp, List<List<Integer>> ret) {
            if ( end <= 1 ) {
                if ( tmp.size() > 1 ) {
                    ret.add(new ArrayList<>(tmp));
                }
                return;
            }
            for ( int i = start ; i <= end ;i++) {
                if ( end % i == 0 ) {
                    tmp.add(i);
                    dfs(i , end / i , tmp, ret);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}
