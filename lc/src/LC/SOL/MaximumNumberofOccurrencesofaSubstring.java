package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberofOccurrencesofaSubstring {
    class Solution {
        public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
            Map<String, Integer> map = new HashMap<>();
            int ret = 0;
            int[] ch = new int[128];
            int l = 0, r = 0, letter = 0;
            for (; r < s.length(); r++) {
                if ( ch[s.charAt(r)]++ == 0) letter++;
                while ( letter > maxLetters || ( r - l + 1) > minSize) {
                    if ( --ch[s.charAt(l++)] == 0 ) letter--;
                }
                if ( r  - l + 1 == minSize ) {
                    String tmp = s.substring(l , r + 1);
                    map.put(tmp, map.getOrDefault(tmp , 0) + 1);
                    ret = Math.max(ret , map.get(tmp));
                }
            }
            return ret;
        }
    }
}
