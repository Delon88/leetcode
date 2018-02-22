package LC.SOL;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    class Solution {
        public String reorganizeString(String S) {
            Map<Character,Integer> map = new HashMap<>();
            for ( int i = 0 ; i < S.length() ; i++) {
                char c = S.charAt(i);
                if ( !map.containsKey(c)) map.put(c, 1);
                else map.put(c ,map.get(c) + 1);
                if ( map.get(c) > (S.length() + 1) / 2) return "";
            }

            PriorityQueue<int[]> q = new PriorityQueue<>(26, (a , b) -> b[1] - a[1]);
            for ( Map.Entry<Character,Integer> e : map.entrySet()) {
                q.add(new int[]{e.getKey(), e.getValue()});
            }

            StringBuilder b = new StringBuilder();
            while ( !q.isEmpty()) {
                int[] first = q.poll();
                if ( b.length() == 0 || b.charAt(b.length() - 1) != first[0]) {
                    b.append((char) first[0]);
                    first[1]--;
                    if ( first[1] > 0) {
                        q.add(first);
                    }
                } else {
                    int[] second = q.poll();
                    b.append((char) second[0]);
                    second[1]--;
                    if ( second[1] > 0) {
                        q.add(second);
                    }
                    q.add(first);
                }
            }
            return b.toString();
        }
    }
}
