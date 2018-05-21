package LC.SOL;

import java.util.*;

public class MinimumHeightTrees {
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if ( n == 1 ) return Collections.singletonList(0);
            List<Set<Integer>> adj = new ArrayList<>();
            for ( int i = 0 ;i < n ; i++) { adj.add(new HashSet<>());}
            for ( int[] e : edges) {
                adj.get(e[0]).add(e[1]);
                adj.get(e[1]).add(e[0]);
            }
            Queue<Integer> q = new LinkedList<>();
            for ( int i = 0 ; i < n ; i++) {
                if ( adj.get(i).size() == 1) q.offer(i);
            }

            while ( n > 2 ) {
                int size = q.size();
                n -= size ;
                for ( int i = 0 ; i < size; i++ ) {
                    int leave = q.poll();
                    int parent = adj.get(leave).iterator().next();
                    adj.get(parent).remove(leave);
                    if ( adj.get(parent).size() == 1) q.offer(parent);
                }
            }
            List<Integer> ret = new ArrayList<>();
            for ( Integer i : q) {
                ret.add(i);
            }
            return ret;
        }
    }
}
