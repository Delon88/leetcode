package LC.SOL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberofSquarefulArrays {
    class Solution {
        Map<Integer, Integer> count;
        Map<Integer, Set<Integer>> sqMap;
        int ret;

        public int numSquarefulPerms(int[] A) {
            ret = 0;
            count = new HashMap<>();
            sqMap = new HashMap<>();
            for (int a : A) {
                count.put(a, count.getOrDefault(a, 0) + 1);
                sqMap.putIfAbsent(a, new HashSet<>());
            }
            for (int i : count.keySet()) {
                for (int j : count.keySet()) {
                    double s = Math.sqrt(i + j);
                    if (Math.floor(s) == s) {
                        sqMap.get(i).add(j);
                        sqMap.get(j).add(i);
                    }
                }
            }
            for (int i : count.keySet()) {
                dfs(i , A.length - 1);
            }
            return ret;
        }

        void dfs(int node, int left) {
            count.put(node, count.get(node) - 1);
            if (left == 0) ret++;
            else {
                for (int next : sqMap.get(node)) {
                    if (count.get(next) > 0) {
                        dfs(next, left - 1);
                    }
                }
            }
            count.put(node, count.get(node) + 1);
        }
    }
}
