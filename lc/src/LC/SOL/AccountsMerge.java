package LC.SOL;

import java.util.*;

public class AccountsMerge {
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String,Set<String>> graph = new HashMap<>();
            Map<String,String> emailToAct = new HashMap<>();
            for ( List<String> act : accounts) {
                String actName = act.get(0);
                for ( int i = 1 ; i < act.size() ; i++) {
                    if ( !graph.containsKey(act.get(i))) {
                        graph.put(act.get(i) , new HashSet<>());
                    }
                    emailToAct.put(act.get(i), actName);
                    if ( i == 1 ) continue;
                    graph.get(act.get(i)).add(act.get(i - 1));
                    graph.get(act.get(i - 1)).add(act.get(i));
                }
            }
            Set<String> v = new HashSet<>();
            List<List<String>> ret = new LinkedList<>();
            for ( String email : emailToAct.keySet()) {
                if ( v.add(email)) {
                    List<String> merge = new LinkedList<>();
                    dfs(graph, v,   email, merge);
                    Collections.sort(merge);
                    merge.add(0, emailToAct.get(email));
                    ret.add(merge);
                }
            }
            return ret;
        }

        void dfs(Map<String,Set<String>> graph, Set<String> v, String email, List<String> list) {
            list.add(email);
            for ( String nei : graph.get(email)) {
                if ( v.add(nei) ) {
                    dfs(graph, v , nei, list);
                }
            }
        }
    }
}
