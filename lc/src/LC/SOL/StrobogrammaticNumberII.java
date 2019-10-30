package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumberII {
    class Solution {
        Map<Character, Character> map = new HashMap<Character, Character>();
        {
            map.put('1', '1');
            map.put('6', '9');
            map.put('9', '6');
            map.put('8', '8');
            map.put('0', '0');
        }

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
            for ( Map.Entry<Character,Character> e : map.entrySet()) {
                tmp[start] = e.getKey();
                tmp[end] = e.getValue();
                if ( e.getKey() == e.getValue() || start < end) {
                    dfs(tmp, start + 1 ,end - 1, ret);
                }
            }
        }
    }
}
