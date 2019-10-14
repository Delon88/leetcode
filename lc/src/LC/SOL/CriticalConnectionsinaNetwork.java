package LC.SOL;

import java.util.*;

public class CriticalConnectionsinaNetwork {
    class Solution {

        int[] time;
        int[] low;
        boolean[] v;
        int timer;

        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            time = new int[n];
            low = new int[n];
            v = new boolean[n];
            Arrays.fill(time, -1);
            List<Integer>[] g = new ArrayList[n];
            List<List<Integer>> ret = new ArrayList<>();
            for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
            for (List<Integer> c : connections) {
                g[c.get(0)].add(c.get(1));
                g[c.get(1)].add(c.get(0));
            }
            for (int i = 0; i < n; i++) {
                if (time[i] == -1) dfs(g, i, i, ret);
            }
            return ret;
        }

        void dfs(List<Integer>[] g, int pre, int node, List<List<Integer>> ret) {
            v[node] = true;
            low[node] = time[node] = timer++;
            for (int to : g[node]) {
                if (to == pre) continue;
                if (v[to]) {
                    low[node] = Math.min(low[node], time[to]);
                } else {
                    dfs(g, node, to, ret);
                    low[node] = Math.min(low[node], low[to]);
                    if (low[to] > time[node]) {
                        ret.add(Arrays.asList(node, to));
                    }
                }
            }
        }
    }

}
