package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {
    class WordDistance {

        Map<String,List<Integer>> map;
        public WordDistance(String[] words) {
            map = new HashMap<>();
            for ( int i = 0  ;i < words.length ; i++) {
                String w = words[i];
                map.putIfAbsent(w , new ArrayList<>());
                map.get(w).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            int i1 = 0, i2 = 0;
            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);
            int min = Integer.MAX_VALUE;
            while ( i1 < l1.size() && i2 < l2.size()) {
                int index1 = l1.get(i1), index2 = l2.get(i2);
                min = Math.min(min , Math.abs(index1 - index2));
                if ( index1 < index2 ) {
                    i1++;
                } else {
                    i2++;
                }
            }
            return min;
        }
    }
}
