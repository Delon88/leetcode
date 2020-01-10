package LC.SOL;


import java.util.*;

public class EvaluateDivision {

    public class DFSSolution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String,Map<String,Double>> map = new HashMap<>();
            for ( int i = 0 ; i < equations.size(); i++) {
                List<String> e = equations.get(i);
                map.putIfAbsent(e.get(0) , new HashMap<>());
                map.putIfAbsent(e.get(1) , new HashMap<>());
                map.get(e.get(0)).put(e.get(1), values[i]);
                map.get(e.get(1)).put(e.get(0), 1.0d / values[i]);
            }
            double[] ret = new double[queries.size()];
            for ( int i = 0; i < queries.size() ; i++) {
                List<String> q = queries.get(i);
                ret[i] = dfs(q.get(0), q.get(1), 1, map, new HashSet<>());
            }
            return ret;
        }

        double dfs(String s, String t, double r, Map<String,Map<String,Double>> map, Set<String> v ) {
            if ( !map.containsKey(s) || !v.add(s) ) return -1;

            if ( s.equals(t)) return r;
            Map<String,Double> next = map.get(s);
            for ( String key : next.keySet()) {
                double nextR = dfs(key, t, r * next.get(key), map, v);
                if ( nextR != -1) return nextR;
            }
            return -1;
        }
    }

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
