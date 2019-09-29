package LC.SOL;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class HighFive {
    class Solution {
        public int[][] highFive(int[][] items) {
            TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
            for ( int[] t : items) {
                map.putIfAbsent(t[0], new PriorityQueue<>());
                PriorityQueue<Integer> q = map.get(t[0]);
                q.offer(t[1]);
                if ( q.size() > 5) q.poll();
            }
            int[][] ret = new int[map.size()][2];
            int i = 0;
            for (Map.Entry<Integer,PriorityQueue<Integer>> e : map.entrySet()) {
                int sum = 0, size = e.getValue().size() ; while ( !e.getValue().isEmpty()) sum += e.getValue().poll();
                ret[i++] = new int[]{e.getKey() , sum / size};
            }
            return ret;
        }
    }
}
