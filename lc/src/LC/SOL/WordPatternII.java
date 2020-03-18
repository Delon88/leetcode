package LC.SOL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII {
    class Solution {
        public boolean wordPatternMatch(String pattern, String str) {
            return dfs(pattern , 0 , str, 0 , new HashMap<>(), new HashSet<>());
        }

        boolean dfs(String p,int i,String s, int j, Map<Character,String> forward, Set<String> backward) {
            if ( i == p.length() && j == s.length()) return true;
            if ( i == p.length() || j == s.length()) return false;
            char c = p.charAt(i);
            if ( forward.containsKey(c)) {
                String w = forward.get(c);
                if ( !s.startsWith(w, j) ) return false;
                else return dfs(p , i + 1 , s , j + w.length(), forward, backward);
            } else {
                for ( int k = j ; k < s.length() ; k++) {
                    String w = s.substring(j , k + 1);
                    if ( backward.add(w)) {
                        forward.put(c , w);
                        if ( dfs(p , i + 1 , s , j + w.length(), forward, backward) ) return true;
                        forward.remove(c);
                        backward.remove(w);
                    }
                }
            }
            return false;
        }
    }
}
