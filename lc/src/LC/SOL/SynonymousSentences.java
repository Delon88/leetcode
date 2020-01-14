package LC.SOL;

import java.util.*;

public class SynonymousSentences {
    class Solution {
        Map<String,Set<String>> g;
        public List<String> generateSentences(List<List<String>> synonyms, String text) {
            g = new HashMap<>();
            for  ( List<String> s : synonyms) {
                g.putIfAbsent(s.get(0), new HashSet<>());g.putIfAbsent(s.get(1), new HashSet<>());
                g.get(s.get(0)).add(s.get(1)); g.get(s.get(1)).add(s.get(0));
            }
            List<String> ret = new ArrayList<>();
            dfs(text.split(" "), new ArrayList<>(), ret , 0);
            Collections.sort(ret);
            return ret;
        }

        void dfs(String[] words, List<String> tmp, List<String> ret, int i) {
            if ( i == words.length) {
                ret.add(String.join(" ", tmp));
                return;
            }
            if ( g.containsKey(words[i])) {
                for ( String s : g.get(words[i])) {
                    tmp.add(s);
                    dfs(words, tmp , ret , i + 1);
                    tmp.remove(tmp.size()- 1);
                }
            }
            tmp.add(words[i]);
            dfs(words, tmp, ret , i + 1);
            tmp.remove(tmp.size() - 1);
        }

    }
}
