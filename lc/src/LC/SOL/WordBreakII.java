package LC.SOL;

import java.util.*;

public class WordBreakII {
    class Solution {

        Map<String,List<String>> memo;
        public List<String> wordBreak(String s, List<String> wordDict) {
            memo = new HashMap<>();
            return dfs(s , new HashSet<>(wordDict));
        }

        List<String> dfs( String s, Set<String> wordDict) {
            if ( memo.containsKey(s)) return memo.get(s);
            List<String> ret = new ArrayList<>();
            if ( wordDict.contains(s)) {
                ret.add(s);
            }
            int n = s.length();
            for ( int i = 1 ; i <= s.length() ; i++) {
                String cur = s.substring(0 , i);
                String next = s.substring(i);
                if ( wordDict.contains(cur)) {
                    List<String> breaks = dfs(next, wordDict);
                    if ( !breaks.isEmpty()) {
                        for ( String b : breaks) {
                            ret.add(cur + " " + b);
                        }
                    }
                }
            }
            memo.put(s, ret);
            return ret;
        }
    }
}
