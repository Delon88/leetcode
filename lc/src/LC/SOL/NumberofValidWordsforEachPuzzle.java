package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberofValidWordsforEachPuzzle {
    class Solution {
        public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
            Map<Integer, Integer> wm = new HashMap<>();
            for (String w : words) {
                int mask = 0;
                for (char c : w.toCharArray()) mask |= 1 << (c - 'a');
                wm.put(mask, wm.getOrDefault(mask, 0) + 1);
            }
            List<Integer> ret = new ArrayList<>();
            for (String p : puzzles) {
                int mask = 0;
                for (char c : p.toCharArray()) mask |= 1 << (c - 'a');
                int sub = mask;
                int count = 0;
                int first = 1 << ( p.charAt(0) - 'a');
                while ( sub != 0 ) {
                    if ( ( sub & first) > 0 && wm.containsKey(sub)) {
                        count += wm.get(sub);
                    }
                    sub = ( sub -1 ) & mask;
                }
                ret.add(count);
            }
            return ret;
        }
    }
}
