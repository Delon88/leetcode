package LC.SOL;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreedomTrail {
    class Solution {
        public int findRotateSteps(String ring, String key) {
            Map<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < ring.length(); i++) {
                char c = ring.charAt(i);
                if (!map.containsKey(c)) {
                    map.put(c, new ArrayList<>());
                }
                map.get(c).add(i);
            }
            int index = 0;
            int ret = 0 ;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                int min = Integer.MAX_VALUE;
                int nextIndex = -1;
                for ( int next : map.get(c)) {
                    if ( Math.abs(index - next) < min ) {
                        nextIndex = next;
                        min = Math.abs(index - next);
                    }
                    if ( Math.abs(index + key.length() - next) < min) {
                        nextIndex = next;
                        min = Math.abs(index + key.length() - next);
                    }
                    index = nextIndex;
                }
                ret += ( min + 1);
            }
            return ret;
        }
    }
}
