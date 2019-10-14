package LC.SOL;

import java.util.*;

public class SmallestStringWithSwaps {
    class Solution {
        int[] id;
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            id = new int[s.length()]; int n = s.length();
            for ( int i = 0 ;i < n ; i++ ) id[i] = i;
            for ( List<Integer> p : pairs) {
                int r1 = find(p.get(0)) , r2 = find(p.get(1));
                id[r1] = r2;
            }
            Map<Integer,List<Character>> m = new HashMap<>();
            for ( int i = 0  ;i < n ; i++) {
                int r = find(i);
                m.putIfAbsent(r , new LinkedList<>());
                m.get(r).add(s.charAt(i));
            }
            for ( List<Character> l : m.values()) {
                Collections.sort(l);
            }
            StringBuilder b = new StringBuilder();
            for ( int i = 0 ; i < n ; i++) {
                int r = find(i);
                b.append(m.get(r).remove(0));
            }
            return b.toString();
        }

        int find(int i ) {
            while ( i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
    }
}
