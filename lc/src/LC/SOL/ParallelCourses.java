package LC.SOL;

import java.util.*;

public class ParallelCourses {
    class Solution {
        public int minimumSemesters(int N, int[][] relations) {
            Map<Integer, List<Integer>> g = new HashMap<>();
            int[] indegree = new int[N + 1];
            for (int[] r : relations) {
                indegree[r[1]]++;
                g.putIfAbsent(r[0], new ArrayList<>());
                g.get(r[0]).add(r[1]);
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= N; i++) if (indegree[i] == 0) q.offer(i);
            int seme = 0;
            while (!q.isEmpty()) {
                for (int sz = q.size(); sz > 0; sz--) {
                    int c = q.poll();
                    N--;
                    if (!g.containsKey(c)) continue;
                    for (int nei : g.remove(c)) {
                        if (--indegree[nei] == 0) q.offer(nei);
                    }
                }
                seme++;
            }
            return N == 0 ? seme : -1;
        }
    }
}
