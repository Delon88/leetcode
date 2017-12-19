package LC.SOL;

import java.util.*;

public class AccountsMerge {
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, List<Integer>> reverse = new HashMap<>();
            for (int i = 0; i < accounts.size(); i++) {
                List<String> a = accounts.get(i);
                for (int j = 1; j < a.size(); j++) {
                    String email = a.get(j);
                    if (!reverse.containsKey(email)) {
                        reverse.put(email, new ArrayList<>());
                    }
                    reverse.get(email).add(i);
                }
            }
            boolean[] v = new boolean[accounts.size()];

            List<List<String>> ret = new ArrayList<>();
            for ( int i = 0 ; i < accounts.size(); i++) {
                if ( !v[i] ) {
                    TreeSet set = new TreeSet();
                    dfs(i, accounts, reverse,v , set);
                    List<String> r = new ArrayList<>();
                    r.add(accounts.get(i).get(0));
                    r.addAll(set);
                    ret.add(r);
                }
            }
            return ret;
        }

        void dfs(int act, List<List<String>> forward, Map<String, List<Integer>> reverse,
                 boolean[] v, TreeSet<String> set) {
            if (v[act]) return;
            v[act] = true;
            for (int i = 1; i < forward.get(act).size(); i++) {
                String email = forward.get(act).get(i);
                set.add(email);
                for (Integer a : reverse.get(email)) {
                    if (forward.get(act).get(0).equals(forward.get(a).get(0))) {
                        dfs(a, forward, reverse, v, set);
                    }
                }
            }
        }
    }
}
