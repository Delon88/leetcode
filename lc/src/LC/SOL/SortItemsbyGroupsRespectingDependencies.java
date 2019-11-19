package LC.SOL;

import java.util.*;

public class SortItemsbyGroupsRespectingDependencies {
    class Solution {
        public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
            // build graph
            Map<Integer, Set<Integer>> itemG = new HashMap<>();
            Map<Integer, Integer> itemDegree = new HashMap<>();
            for (int i = 0; i < n; i++) itemG.put(i, new HashSet<>());
            Map<Integer, Set<Integer>> groupG = new HashMap<>();
            Map<Integer, Integer> groupDegree = new HashMap<>();
            for (int i : group) groupG.put(i, new HashSet<>());
            // build graph
            for (int i = 0; i < beforeItems.size(); i++) {
                List<Integer> l = beforeItems.get(i);
                for ( int j : l ) {
                    itemG.get(j).add(i);
                    itemDegree.put(i, itemDegree.getOrDefault(i , 0) + 1);
                    int g1 = group[j], g2 = group[i];
                    if ( g1 != g2 && groupG.get(g1).add(g2)) groupDegree.put(g2, groupDegree.getOrDefault(g2 , 0) + 1);
                }
            }

            List<Integer> itemOrder = topoSort(itemG, itemDegree, n);
            List<Integer> groupOrder = topoSort(groupG, groupDegree, groupG.size());
            if ( itemOrder.size() == 0 || groupOrder.size() == 0) return new int[0];
            Map<Integer,List<Integer>> map = new HashMap<>();
            for ( int i : itemOrder) {
                int g = group[i];
                map.putIfAbsent(g , new ArrayList<>());
                map.get(g).add(i);
            }

            int[] ret = new int[n]; int i = 0;
            for ( int g : groupOrder) {
                for ( int item : map.get(g)) {
                    ret[i++] = item;
                }
            }
            return ret;
        }

        public List<Integer> topoSort(Map<Integer, Set<Integer>> g, Map<Integer, Integer> indegree, int count) {
            Queue<Integer> q = new LinkedList<>();
            List<Integer> ret = new ArrayList<>();
            for (int key : g.keySet()) {
                if (indegree.getOrDefault(key, 0) == 0) q.add(key);
            }
            while (!q.isEmpty()) {
                int node = q.poll();
                count--;
                ret.add(node);
                for (int nei : g.get(node)) {
                    indegree.put(nei, indegree.get(nei) - 1);
                    if (indegree.get(nei) == 0) q.offer(nei);
                }
            }
            return count == 0 ? ret : new ArrayList<>();
        }
    }
}
