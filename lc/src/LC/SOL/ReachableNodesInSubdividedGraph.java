package LC.SOL;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ReachableNodesInSubdividedGraph {
    class Solution {
        public int reachableNodes(int[][] edges, int M, int N) {
            int[][] graph = new int[N][N];
            for ( int[] g : graph) {
                Arrays.fill(g , -1);
            }
            for ( int[] e : edges) {
                graph[e[0]][e[1]] = e[2]; graph[e[1]][e[0]] = e[2];
            }
            PriorityQueue<int[]> q = new PriorityQueue<>(( a , b) -> b[1] - a[1]);
            boolean[] v = new boolean[N];
            q.offer(new int[]{0 , M});
            int ret = 0;
            while ( !q.isEmpty()) {
                int[] cur = q.poll();
                int start = cur[0] , move = cur[1];
                if ( v[start]) continue;
                v[start] = true;
                ret++;
                for ( int i = 0 ; i < N ; i++) {
                    if ( graph[start][i] != -1 ) {
                        if ( move > graph[start][i] && !v[i] ) {
                            q.offer(new int[]{i , move - graph[start][i] - 1});
                        }
                        int diff = Math.min(move, graph[start][i]);
                        graph[i][start] -= diff; ret += diff;
                    }
                }
            }
            return ret;
        }
    }
}
