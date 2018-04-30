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
            if ( level == 4 && s.length() == 0) {ret.add("".join(".", tmp)); return;}
            for ( int i = 1 ; i < 4 && i <= s.length(); i++) {
                String ip = s.substring(0 , i);
                if ( ip.charAt(0) == '0' && ip.length() != 1) continue;
                int ipNum = Integer.parseInt(ip);
                if ( ipNum >= 0 && ipNum <= 255) {
                    tmp.add(ip);
                    dfs(s.substring(i), tmp, level + 1 , ret);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}
