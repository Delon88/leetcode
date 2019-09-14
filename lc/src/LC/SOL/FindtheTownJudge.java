package LC.SOL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindtheTownJudge {
    class Solution {

        Map<Integer, Set<Integer>> tmap;

        public int findJudge(int N, int[][] trust) {
            tmap = new HashMap<>();
            for ( int i = 1 ; i <= N ; i++) tmap.put(i , new HashSet<>());
            for (int[] t : trust) {
                tmap.get(t[0]).add(t[1]);
            }
            int cand = 1;
            for (int i = 2; i <= N; i++) {
                if (tmap.get(cand).contains(i)) {
                    cand = i;
                }
            }
            for (int i = 1; i <= N; i++) {
                if ( i != cand && (tmap.get(cand).contains(i) || !tmap.get(i).contains(cand))) return -1;
            }
            return cand;
        }
    }

    class Solution1 {
        public int findJudge(int N, int[][] trust) {
            int[] indegree = new int[N + 1];
            for ( int[] t : trust) {
                indegree[t[0]]--;
                indegree[t[1]]++;
            }
            for ( int i = 1 ; i <= N ; i++) {
                if ( indegree[i] == N - 1 ) return i;
            }
            return -1;
        }
    }
}
