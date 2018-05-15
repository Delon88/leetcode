package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceIII {
    class Solution {
        public int shortestWordDistance(String[] words, String word1, String word2) {
            Map<String,List<Integer>> map = new HashMap<>();
            for ( int i = 0 ;  i < words.length ; i++) {
                String w = words[i];
                if ( !map.containsKey(w)) map.put(w, new ArrayList<>());
                map.get(w).add(i);
            }
            int min = Integer.MAX_VALUE;
            if ( word1.equals(word2)) {
                List<Integer> l = map.get(word1);
                for ( int i = 0 ; i < l.size() - 1; i++) {
                    min = Math.min(min, l.get(i + 1) - l.get(i));
                }
                return min;
            } else {
                int i1 = 0, i2 = 0;

                while (i1 < map.get(word1).size() && i2 < map.get(word2).size()) {
                    int index1 = map.get(word1).get(i1), index2 = map.get(word2).get(i2);
                    min = Math.min(Math.abs(index1 - index2), min);
                    if (map.get(word1).get(i1) < map.get(word2).get(i2)) {
                        i1++;
                    } else {
                        i2++;
                    }
                }
                return min;
            }
        }
    }
}
