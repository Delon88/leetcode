package LC.SOL;

import java.util.*;

public class ReconstructItinerary {
    class Solution {

        Map<String,PriorityQueue<String>> map;
        LinkedList<String> list;

        public List<String> findItinerary(String[][] tickets) {
            map = new HashMap<>();
            list = new LinkedList<>();
            for ( String[] t : tickets) {
                if ( !map.containsKey(t[0])) {map.put(t[0], new PriorityQueue<>());}
                map.get(t[0]).add(t[1]);
            }
            dfs("JFK");
            return list;
        }

        void dfs(String depart) {
            PriorityQueue<String> arrivals = map.get(depart);
            if ( arrivals != null ) {
                while ( !arrivals.isEmpty()) {
                    dfs(arrivals.poll());
                }
            }
            list.addFirst(depart);
        }
    }
}
