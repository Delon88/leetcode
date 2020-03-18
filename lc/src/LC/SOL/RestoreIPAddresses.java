package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> ret = new ArrayList<>();
            if ( s.length() < 4 || s.length() > 12) return ret;
            dfs(s , new ArrayList<>(), 0 , ret);
            return ret;
        }

        void dfs(String s, List<String> tmp, int level, List<String> ret) {
            if ( level == 4 && s.length() == 0 ) {ret.add(String.join(".", tmp)); return;}
            for ( int i = 1 ; i < 4 &&  i <= s.length() ; i++) {
                String next = s.substring(0 , i );
                if ( next.length() > 1 && next.charAt(0) == '0') continue;
                int ip = Integer.parseInt(next);
                if ( ip >= 0 && ip <= 255) {
                    tmp.add(next);
                    dfs(s.substring(i), tmp, level + 1 , ret );
                    tmp.remove(tmp.size()  - 1);
                }
            }

        }
    }
}
