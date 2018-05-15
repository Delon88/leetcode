package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance {
    class Solution {
        public int shortestDistance(String[] words, String word1, String word2) {
            Map<String,List<Integer>> map = new HashMap<>();
            for ( int i = 0 ;  i < words.length ; i++) {
                String w = words[i];
                if ( !map.containsKey(w)) map.put(w, new ArrayList<>());
                map.get(w).add(i);
            }
            int i1 = 0 , i2 = 0;
            int min = Integer.MAX_VALUE;
            while ( i1 < map.get(word1).size() && i2 < map.get(word2).size() ) {
                int index1 = map.get(word1).get(i1), index2 = map.get(word2).get(i2);
                min = Math.min(Math.abs(index1 - index2) , min);
                if ( map.get(word1).get(i1) < map.get(word2).get(i2) ) {
                    i1++;
                } else {
                    i2++;
                }
            }
            return min;
        }
    }
}
