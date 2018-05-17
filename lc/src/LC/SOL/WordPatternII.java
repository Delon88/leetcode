package LC.SOL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII {
    class Solution {
        public boolean wordPatternMatch(String pattern, String str) {
            return dfs(pattern, 0 , str , 0 , new HashMap<>(), new HashSet<>());
        }

        boolean dfs(String pattern, int i , String str, int j, Map<Character,String> forward, Set<String> backward) {
            if ( i == pattern.length() && j == str.length()) return true;
            if ( i == pattern.length() || j == str.length()) return false;

            char c = pattern.charAt(i);
            if ( forward.containsKey(c)) {
                String word = forward.get(c);
                if ( !str.startsWith(word, j)) return false;
                else return dfs(pattern, i + 1 , str , j + word.length(), forward, backward);
            } else {
                for ( int k = j ; k < str.length() ; k++) {
                    String nextWord = str.substring(j , k + 1);
                    if ( backward.contains(nextWord)) {
                        continue;
                    }
                    forward.put(c , nextWord);
                    backward.add(nextWord);
                    if ( dfs(pattern, i + 1 , str, j + nextWord.length(), forward, backward)) return true;
                    forward.remove(c);
                    backward.remove(nextWord);
                }
            }
            return false;
        }
    }
}
