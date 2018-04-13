package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget {
    class Solution {

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> ret = new ArrayList<>();
            dfs(new boolean[graph.length], graph, 0 , new ArrayList<>(), ret );
            return ret;
        }

        void dfs(boolean[] v, int[][] graph, int node, List<Integer> list, List<List<Integer>> ret) {
            v[node] = true;
            list.add(node);
            if ( node == v.length - 1) {
                ret.add( new ArrayList<>(list));
            } else {
                for ( int nei : graph[node]) {
                    if ( !v[nei] ) {
                        dfs(v , graph , nei, list, ret);
                    }
                }
            }

            list.remove(list.size() - 1);
            v[node] = false;
        }
    }
}
