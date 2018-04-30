package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ret = new ArrayList<>();
            if ( k <= 0 || n <= 0 ) return ret;
            dfs(n , k , 1 , new ArrayList<>(), ret);
            return ret;
        }

        void dfs(int n , int k , int start, List<Integer> tmp, List<List<Integer>> ret) {
            if ( k == tmp.size() ) {ret.add(new ArrayList<>(tmp)); return;}
            for( int i = start ; i <= n ; i++) {
                tmp.add(i);
                dfs(n , k , i + 1 , tmp, ret);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
