package LC.SOL;

import java.util.*;

public class ReconstructItinerary {
    class Solution {

        Map<String, PriorityQueue<String>> map;
        LinkedList<String> list;

        public List<String> findItinerary(List<List<String>> tickets) {
            map = new HashMap<>();
            list = new LinkedList<>();
            for (List<String> t : tickets) {
                map.putIfAbsent(t.get(0), new PriorityQueue<>());
                map.get(t.get(0)).offer(t.get(1));
            }
            dfs("JFK");
            return list;
        }

        void dfs(String depart) {
            PriorityQueue<String> arrivals = map.get(depart);
            if (arrivals != null) {
                while (!arrivals.isEmpty()) {
                    dfs(arrivals.poll());
                }
            }
            list.addFirst(depart);
        }
    }
}
