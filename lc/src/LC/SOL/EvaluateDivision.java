package LC.SOL;


import java.util.*;

public class EvaluateDivision {
    public class Solution {
        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            Map<String, Map<String, Double>> map = new HashMap<>();
            Map<String, Set<String>> graph = new HashMap<>();
            for (int i = 0; i < equations.length; i++) {
                put(map, equations[i][0], equations[i][1], values[i]);
                put(map, equations[i][0], equations[i][0], 1.0d);
                put(map, equations[i][1], equations[i][1], 1.0d);
                putNode(graph, equations[i][0], equations[i][1]);
            }

            for (Map.Entry<String, Set<String>> k : graph.entrySet()) {
                for (Map.Entry<String, Set<String>> i : graph.entrySet()) {
                    for (Map.Entry<String, Set<String>> j : graph.entrySet()) {
                            if (map.containsKey(i.getKey()) && map.get(i.getKey()).containsKey(k.getKey())
                                    && map.containsKey(k.getKey()) && map.get(k.getKey()).containsKey(j.getKey())) {
                                map.get(i.getKey()).put(j.getKey(), map.get(i.getKey()).get(k.getKey()) * map.get(k.getKey()).get(j.getKey()));
                            }
                    }
                }
            }

            double[] ret = new double[queries.length];
            for ( int i = 0 ; i < queries.length ; i++) {
                String[] q = queries[i];
                if (map.containsKey(q[0]) && map.get(q[0]).containsKey(q[1])) {
                    ret[i] = map.get(q[0]).get(q[1]);
                } else {
                    ret[i] = -1.0d;
                }
            }
            return ret;
        }

        void putNode(Map<String, Set<String>> graph, String e1, String e2) {
            if (!graph.containsKey(e1)) {
                graph.put(e1, new HashSet<>());
            }
            graph.get(e1).add(e2);
            if (!graph.containsKey(e2)) {
                graph.put(e2, new HashSet<>());
            }
            graph.get(e2).add(e1);
        }

        void put(Map<String, Map<String, Double>> map, String e1, String e2, double value) {
            if (!map.containsKey(e1)) {
                map.put(e1, new HashMap<>());
            }
            map.get(e1).put(e2, value);
            if (!map.containsKey(e2)) {
                map.put(e2, new HashMap<>());
            }
            map.get(e2).put(e1, 1.0d / value);
        }
    }
}
