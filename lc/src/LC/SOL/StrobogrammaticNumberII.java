package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumberII {
    class Solution {
        char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

        public List<String> findStrobogrammatic(int n) {
            List<String> ret = new ArrayList<>();
            char[] tmp = new char[n];
            dfs(tmp, 0 , n - 1 , ret);
            return ret;
        }

        void dfs(char[] tmp, int start, int end, List<String> ret) {
            if ( start > end ) {
                if ( tmp.length == 1 || tmp[0] != '0') {
                    ret.add(new String(tmp));
                }
                return;
            }
            for ( char[] p  :pairs) {
                tmp[start] = p[0];
                tmp[end] = p[1];
                if ( p[0] == p[1] || start < end) {
                    dfs(tmp, start + 1 ,end - 1, ret);
                }
            }
        }
    }
}
