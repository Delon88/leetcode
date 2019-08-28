package LC.SOL;

import java.util.*;

public class MostStonesRemovedwithSameRoworColumn {
    class Solution {
        int count;

        public int removeStones(int[][] stones) {
            Map<String, String> pa = new HashMap<>();
            count = stones.length;
            for (int[] st : stones) {
                String s = st[0] + "," + st[1];
                pa.put(s, s);
            }

            for (int i = 0; i < stones.length; i++) {
                for (int j = i + 1; j < stones.length; j++) {
                    int[] s1 = stones[i], s2 = stones[j];
                    if (!Arrays.equals(s1, s2) && s1[0] == s2[0] || s1[1] == s2[1]) {
                        String ss1 = s1[0] + "," + s1[1];
                        String ss2 = s2[0] + "," + s2[1];
                        String r1 = find(pa, ss1), r2 = find(pa, ss2);
                        pa.put(r1, r2);
                        if (!r1.equals(r2)) count--;
                    }
                }
            }
            return stones.length - count;
        }

        String find(Map<String, String> pa, String s) {
            while (!pa.get(s).equals(s)) {
                pa.put(s, pa.get(pa.get(s)));
                s = pa.get(s);
            }
            return pa.get(s);
        }
    }

    class Solution2 {
        public int removeStones(int[][] stones) {
            Set<int[]> v = new HashSet<>();
            int ret = 0;
            for ( int[] s : stones) {
                if ( !v.contains(s)) {
                    dfs(v , stones, s);
                    ret++;
                }
            }
            return stones.length - ret;
        }

        void dfs(Set<int[]> v, int[][] stones, int[] cur) {
            v.add(cur);
            for (int[] s1 : stones) {
                if (!v.contains(s1)) {
                    if (s1[0] == cur[0] || s1[1] == cur[1]) {
                        dfs(v, stones, s1);
                    }
                }
            }
        }
    }
}
