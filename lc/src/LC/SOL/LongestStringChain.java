package LC.SOL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    class Solution {
        public int longestStrChain(String[] words) {
            Map<String, Integer> map = new HashMap<>();
            Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
            int ret = 0;
            for (String w : words) {
                int max = 0 ;
                for (int i = 0; i < w.length(); i++) {
                    String prev = w.substring(0, i) + w.substring(i + 1);
                    max = Math.max(max, map.getOrDefault(prev, 0) + 1);
                }
                map.put(w , max);
                ret = Math.max( max , ret);
            }
            return ret;
        }
    }
}
