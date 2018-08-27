package LC.SOL;

import java.util.*;

public class SumofDistancesinTree {
    class Solution {
        int[] dist, count;
        List<Set<Integer>> tree;
        int n;

        public int[] sumOfDistancesInTree(int N, int[][] edges) {
            this.n = N;
            dist = new int[N];
            count = new int[N];
            tree = new ArrayList<>();
            for (int i = 0; i < n; i++) tree.add(new HashSet<>());
            for (int[] e : edges) {
                tree.get(e[0]).add(e[1]);
                tree.get(e[1]).add(e[0]);
            }
            dfs(0 , new HashSet<>());
            pre(0 , new HashSet<>());
            return dist;
        }

        void dfs(int root, Set<Integer> v) {
            v.add(root);
            for (int i : tree.get(root)) {
                if (!v.contains(i)) {
                    dfs(i, v);
                    count[root] += count[i];
                    dist[root] += dist[i] + count[i];
                }
            }
            count[root]++;
        }

        void pre(int root, Set<Integer> v) {
            v.add(root);
            for (int i : tree.get(root)) {
                if (!v.contains(i)) {
                    dist[i] = dist[root] - count[i] + n - count[i];
                    pre(i, v);
                }
            }
        }
    }
}
