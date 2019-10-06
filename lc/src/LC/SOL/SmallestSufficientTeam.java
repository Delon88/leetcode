package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestSufficientTeam {
    class Solution {
        public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
            int ns = req_skills.length, np = people.size();
            Map<String, Integer> index = new HashMap<>();
            for (int i = 0; i < ns; i++) index.put(req_skills[i], i);
            List<Integer>[] dp = new List[1 << ns];
            dp[0] = new ArrayList<>();
            for (int i = 0; i < np; i++) {
                int skill = 0;
                for ( String s : people.get(i)) skill |= (1 << index.get(s));
                for (int j = 0; j < dp.length; j++) {
                    if ( dp[j] == null) continue;
                    int comb = skill | j;
                    if ( dp[comb] == null || dp[j].size() + 1 < dp[comb].size()) {
                        dp[comb] = new ArrayList<>(dp[j]);
                        dp[comb].add(i);
                    }
                }
            }
            List<Integer> l = dp[(1 << ns) - 1];
            int[] ret = new int[l.size()];
            for ( int i = 0 ; i < ret.length ; i++) ret[i] = l.get(i);
            return ret;
        }
    }
}
