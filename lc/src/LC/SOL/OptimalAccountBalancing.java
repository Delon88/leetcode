package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing {
    class Solution {
        public int minTransfers(int[][] transactions) {
            Map<Integer, Long> map = new HashMap<>();
            for (int[] t : transactions) {
                map.put(t[0], map.getOrDefault(t[0], 0l) + t[2]);
                map.put(t[1], map.getOrDefault(t[1], 0l) - t[2]);
            }
            List<Long> list = new ArrayList<>();
            for (Map.Entry<Integer, Long> e : map.entrySet()) {
                if (e.getValue() != 0) list.add(e.getValue());
            }
            long[] debts = new long[list.size()];
            for ( int i= 0 ;i < debts.length; i++) {
                debts[i] = list.get(i);
            }
            return dfs(debts, 0, 0);
        }

        int dfs(long[] debts, int level, int count) {
            while ( level < debts.length && debts[level] == 0 ) level++;
            if ( level == debts.length) {
                return count;
            }
            int ret = Integer.MAX_VALUE;
            for ( int i = level + 1; i < debts.length ; i++) {
                if ( debts[level] * debts[i] < 0 ) {
                    debts[i] += debts[level];
                    ret = Math.min(ret, dfs(debts, level + 1, count + 1));
                    debts[i] -= debts[level];
                }
            }
            return ret;
        }
    }
}
