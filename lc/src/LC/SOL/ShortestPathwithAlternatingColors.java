package LC.SOL;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathwithAlternatingColors {
    class Solution {
        public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
            Set<Integer>[][] g = new Set[n][2];
            for ( int i = 0 ; i < n ; i++) {
                g[i][0] = new HashSet<>(); g[i][1] = new HashSet<>();
            }
            for ( int[] r : red_edges) g[r[0]][0].add(r[1]);
            for ( int[] b : blue_edges) g[b[0]][1].add(b[1]);
            int[][] ret = new int[n][2];
            for ( int i = 1 ; i < n ; i++) ret[i][0] = ret[i][1] = n * 2;
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{0, 0}); q.offer(new int[]{0 , 1});
            while ( !q.isEmpty()) {
                int[] cur = q.poll();
                int index = cur[0], color = cur[1];
                for ( int next : g[index][1 - color]) {
                    if ( ret[next][1 - color] == 2 * n) {
                        ret[next][1 - color] = ret[index][color] + 1;
                        q.offer(new int[]{next , 1 - color});
                    }
                }
            }
            int[] ans = new int[n];
            for ( int i = 0 ; i < n ; i++) {
                int min = Math.min(ret[i][0], ret[i][1]);
                ans[i] = min == n * 2? -1: min;
            }
            return ans;
        }
    }
}
