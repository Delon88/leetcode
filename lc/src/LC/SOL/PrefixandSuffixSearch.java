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
                        map.put(words[i].substring(0, m) + "#" + words[i].substring(words[i].length() - n), i);
                    }
                }
            }
        }

        public int f(String prefix, String suffix) {
            return map.containsKey(prefix + "#" + suffix) ? map.get(prefix + "#" + suffix) : -1;
        }
    }

}
