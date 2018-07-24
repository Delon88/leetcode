package LC.SOL;

import java.util.*;

public class WordAbbreviation {
    class Solution {
        public List<String> wordsAbbreviation(List<String> dict) {
            Map<String,List<Integer>> map = new HashMap<>();
            int[] sIndexes = new int[dict.size()];
            String[] ret = new String[dict.size()];
            for ( int i = 0 ; i < dict.size(); i++) {
                sIndexes[i] = 1;
                ret[i] = getAb(dict.get(i), 1);
                if ( !map.containsKey(ret[i])) {
                    map.put(ret[i], new ArrayList<>());
                }
                map.get(ret[i]).add(i);
            }
            while( !map.isEmpty()) {
                Map<String,List<Integer>> next = new HashMap<>();
                for ( Map.Entry<String,List<Integer>> e : map.entrySet()) {
                    if ( e.getValue().size() > 1 ) {
                        for ( int i : e.getValue()) {
                            sIndexes[i]++;
                            String ab = getAb(dict.get(i), sIndexes[i]);
                            ret[i] = ab;
                            if ( !next.containsKey(ab)) {next.put(ab, new ArrayList<>());}
                            next.get(ab).add(i);
                        }
                    }
                }
                map = next;
            }
            return Arrays.asList(ret);
        }

        String getAb(String w, int start) {
            if ( start >= w.length() - 2) return w;
            return w.substring(0 , start) + ( w.length() - start - 1) + w.substring(w.length() - 1);
        }
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("interval");list.add("interval");list.add("like");
    }
}
