package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class PrefixandSuffixSearch {
    class WordFilter {

        Map<String, Integer> map = new HashMap<>();

        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; i++) {
                for (int m = 0; m <= words[i].length(); m++) {
                    for (int n = 0; n <= words[i].length(); n++) {
                        map.put(words[i].substring(0, m) + "#" + words[i].substring(words[i].length() - n, words[i].length()), i);
                    }
                }
            }
        }

        public int f(String prefix, String suffix) {
            return map.containsKey(prefix + "#" + suffix) ? map.get(prefix + "#" + suffix) : -1;
        }
    }

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
}
